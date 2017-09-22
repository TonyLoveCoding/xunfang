package team.etop.xunfang.role.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import team.etop.xunfang.common.bean.*;

import team.etop.xunfang.modules.po.Role;

import team.etop.xunfang.modules.service.*;

import java.util.*;

/**
 * Created by ZYZ on 2017/8/14
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleServiceGenerate roleServiceGenerate;
    @Autowired
    private PermissionServiceGenerate permissionServiceGenerate;


    @RequiresPermissions("role/roleList")
    @RequestMapping("/roleList")
    public ModelAndView getRoleList(@RequestParam(value = "pn", defaultValue = "1") int pageNum,
                                    @RequestParam(value = "status", defaultValue = "1") Integer status) {
        ModelAndView modelAndView = new ModelAndView();
        EntityWrapper<Role> wrapper = new EntityWrapper<>();
        wrapper.eq("status", 1);
        Page<Role> rolePage = new Page<>();
        rolePage.setCurrent(pageNum);
        rolePage.setSize(8);
        rolePage.setAsc(false);
        rolePage.setOrderByField("updateTime");
        Page<Role> page = roleServiceGenerate.selectPage(rolePage, wrapper);

        PageInfo pageInfo = new PageInfo();
        pageInfo.setCurrentPage((long) (pageNum));
        pageInfo.setTotal((long) (page.getPages()));
        modelAndView.addObject("pageInfo", pageInfo);


        List<Role> list2 = page.getRecords();
        List<RoleJsonForShow> list=new ArrayList<>();
        for(int i=0;i<list2.size();i++){
            RoleJsonForShow roleJsonForShow=new RoleJsonForShow(list2.get(i));
            list.add(roleJsonForShow);
        }



        modelAndView.addObject("list", list);
        modelAndView.setViewName("/role/roleList");
        return modelAndView;

    }

    private ModelAndView getModelAndView() {
        ModelAndView modelAndView = new ModelAndView();
        EntityWrapper<Role> wrapper = new EntityWrapper<>();
        wrapper.eq("status", 1);
        Page<Role> rolePage = new Page<>();
        rolePage.setCurrent(1);
        rolePage.setSize(8);
        rolePage.setAsc(false);
        rolePage.setOrderByField("updateTime");
        Page<Role> page = roleServiceGenerate.selectPage(rolePage, wrapper);

        PageInfo pageInfo = new PageInfo();
        pageInfo.setCurrentPage((long) (1));
        pageInfo.setTotal((long) (page.getPages()));
        modelAndView.addObject("pageInfo", pageInfo);


        List<Role> list2 = page.getRecords();
        List<RoleJsonForShow> list=new ArrayList<>();
        for(int i=0;i<list2.size();i++){
            RoleJsonForShow roleJsonForShow=new RoleJsonForShow(list2.get(i));
            list.add(roleJsonForShow);
        }

        modelAndView.addObject("list", list);
        return modelAndView;
    }

    @RequiresPermissions("role/addRole")
    @RequestMapping("/addRole")
    public ModelAndView addUser(@RequestParam(value = "name") String name,
                                @RequestParam(value = "description") String description

    ) {

        Result result = new Result();
        Role role = new Role();
        role.setRoleName(name);
        role.setDescription(description);
        role.setStatus(1);
        Date date=new Date();
        role.setCreatetime(date);
        roleServiceGenerate.insert(role);

        result.setSuccess(true);
        result.setMsg("添加角色成功");


        ModelAndView modelAndView = getModelAndView();
        modelAndView.addObject("result", result);

        modelAndView.setViewName("/role/roleList");
        return modelAndView;
    }

    @RequiresPermissions("role/deleteRole")
    @RequestMapping("/deleteRole")
    public ModelAndView deleteRole(@RequestParam(value = "roleId") Long roleId) {
        Result result = new Result();
        Role role = roleServiceGenerate.selectById(roleId);
        role.setStatus(0);
        roleServiceGenerate.updateById(role);

        result.setSuccess(true);
        result.setMsg("删除成功");
        ModelAndView modelAndView = getModelAndView();
        modelAndView.addObject("result", result);
        modelAndView.setViewName("/role/roleList");

        return modelAndView;
    }

    @RequiresPermissions("role/findRole")
    @RequestMapping("/findRoleByName")
    public ModelAndView findUser(@RequestParam(value = "pn", defaultValue = "1") int pageNum,
                                 @RequestParam(value = "name") String name
    ) {

        ModelAndView modelAndView = new ModelAndView();
        EntityWrapper<Role> wrapper = new EntityWrapper<>();


        wrapper.like("roleName", "%" + name + "%");

        Page<Role> rolePage = new Page<>();
        rolePage.setCurrent(pageNum);
        rolePage.setSize(8);
        rolePage.setAsc(false);
        rolePage.setOrderByField("updateTime");
        Page<Role> page = roleServiceGenerate.selectPage(rolePage, wrapper);

        PageInfo pageInfo = new PageInfo();
        pageInfo.setCurrentPage((long) (pageNum));
        pageInfo.setTotal((long) (page.getPages()));
        modelAndView.addObject("pageInfo", pageInfo);


        List<Role> list = page.getRecords();


        modelAndView.addObject("list", list);
        modelAndView.setViewName("/role/roleList");
        return modelAndView;


    }
    @RequiresPermissions("role/updateRole")
    @RequestMapping("/updateRole")
    public ModelAndView updateUser(@RequestParam(value = "roleId") Long roleId,
                                   @RequestParam(value = "name")String name,
                                   @RequestParam(value ="description")String description ) {
        Result result = new Result();
        Role role2;
        EntityWrapper<Role> wrapper=new EntityWrapper<>();
        wrapper.eq("role_Name",name);
        role2=roleServiceGenerate.selectOne(wrapper);
        if(role2!=null){
            result.setMsg("修改失败，该用户已存在");
            result.setSuccess(false);
        }else {

            Role role = roleServiceGenerate.selectById(roleId);
            role.setRoleName(name);
            role.setDescription(description);
            role.setStatus(1);
            role.setUpdatetime(null);
            roleServiceGenerate.updateById(role);
            result.setSuccess(true);
            result.setMsg("修改成功");
        }

        ModelAndView modelAndView = getModelAndView();
        modelAndView.addObject("result", result);
        modelAndView.setViewName("/role/roleList");
        return modelAndView;

    }
    @ResponseBody
    @RequestMapping("/roleCheck")
    public Map accountCheck(@RequestParam(value = "name")String name){

        Map<String,Object> json=new HashMap<>();
        Role role;
        EntityWrapper<Role> wrapper=new EntityWrapper<>();
        wrapper.eq("role_Name",name);
        role=roleServiceGenerate.selectOne(wrapper);
        boolean isExist=false;
        if(role==null){
            isExist=true;

            //如果存在则说明不能被注册,如果不存在才能注册

        }
        json.put("valid",isExist);
        System.out.println(json.get("valid"));
        return json;

    }


    @ResponseBody
    @RequestMapping("/getTree")
    public Result getTree(){

        Result result=new Result();
        List<PermissionTree> ztree=permissionServiceGenerate.getAllZtree();
        if(ztree.size()!=0){
            result.setSuccess(true);
        result.setMsg("Ztree成功");
        result.add("ztreeMsg",ztree);

        }else{
            result.setMsg("暂无权限可分配");
            result.setSuccess(false);
        }
        return result;
    }
    @ResponseBody
    @RequestMapping("/getRoleTree")
    @RequiresPermissions("role/getRoleTree")
    public Result getRoleTree(@RequestParam(value = "ID")Long ID){
        Result result=new Result();
        List<PermissionTree> ztree=permissionServiceGenerate.getTreeByRoleId(ID);
        if(ztree.size()!=0){
            result.setSuccess(true);
        result.setMsg("Ztree成功");
        result.add("ztreeMsg",ztree);
        }else{
            result.setMsg("该角色无任何权限");
            result.setSuccess(false);
        }
        return result;

    }

    @ResponseBody
    @RequestMapping("/updateTreeById")
    @RequiresPermissions("role/updateRolePermission")
    public Result updateTreeById(@RequestParam (value = "checkedTree")List<Long> checkedTree ){
        Result result=new Result();
        Role role=roleServiceGenerate.selectById(checkedTree.get(0));
        String permissions="";
        for(int i=1;i<checkedTree.size()-1;i++){
            permissions+=String.valueOf(checkedTree.get(i))+",";
        }
        permissions+=String.valueOf(checkedTree.get(checkedTree.size()-1));
        role.setPermissions(permissions);
        roleServiceGenerate.updateById(role);
        result.setSuccess(true);
        result.setMsg("分配权限成功");
        return result;
    }
    @ResponseBody
    @RequestMapping("/findRoleOne")
    public Result findRoleOne(@RequestParam(value = "ID")Long ID) throws Exception{
        Result result=new Result();
        Role role=roleServiceGenerate.selectById(ID);
        RoleJsonForShow roleJsonForShow=new RoleJsonForShow(role);
        result.add("role",roleJsonForShow);
        result.setSuccess(true);
        result.setMsg("成功");
        return result;
    }
}
