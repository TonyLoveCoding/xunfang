package team.etop.xunfang.permission.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import team.etop.xunfang.common.bean.PermissionJson;
import team.etop.xunfang.common.bean.PermissionTree;
import team.etop.xunfang.common.bean.Result;
import team.etop.xunfang.modules.po.Permission;
import team.etop.xunfang.modules.po.Role;
import team.etop.xunfang.modules.service.PermissionServiceGenerate;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ZYZ on 2017/8/14
 */

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionServiceGenerate permissionServiceGenerate;


    @RequiresPermissions("permission/permissionList")
    @RequestMapping("/permissionList")
    public ModelAndView getPermissionList(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        Result result=new Result();
        List<PermissionTree> ztree=permissionServiceGenerate.getAllZtree();
        if(ztree.size()!=0){
            result.setSuccess(true);
            result.setMsg("成功");
            result.add("ztreeMsg",ztree);

            }else{
            result.setMsg("暂无权限可分配");
            result.setSuccess(false);
        }


//        modelAndView.addObject("result",result);
        modelAndView.setViewName("/permission/permissionList");

        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/deletePermission")
    @RequiresPermissions("permission/deletePermission")
    public Result deletePermission(@RequestParam(value="ID")Long ID){
        Result result=new Result();
        System.out.println("删除的ID:"+ID);
        permissionServiceGenerate.deleteById(ID);
        result.setSuccess(true);
        result.setMsg("删除权限成功");
        return  result;
    }
    @ResponseBody
    @RequestMapping("/updatePermissionName")
    @RequiresPermissions("permission/updatePermissionName")
    public Result permissionReName (@RequestParam(value = "ID")List<String> ID)throws Exception{
        Result result=new Result();

       Permission permission=permissionServiceGenerate.selectById(ID.get(0));

        permission.setName(ID.get(2));
        permission.setParentId(Long.parseLong(ID.get(1)));
        if(permissionServiceGenerate.updateById(permission)){
            result.setSuccess(true);
            result.setMsg("修改权限名称成功");

        }else{
            result.setSuccess(false);
            result.setMsg("修改权限名称失败");
        }


        return  result;
    }
    @ResponseBody
    @RequestMapping("/getNewNodeId")
    public Result getNewNodeId(){
        Result result=new Result();
        Permission permission=new Permission();
        permission.setName("NewNode");
        permission.setStatus(1);
        Date date=new Date();
        permission.setCreatetime(date);
        permission.setDescription("null");
        /*
        可以注释部分
         */
        permission.setIsMenu(0);
        permission.setIco("1");
        permission.setParentId(Long.parseLong("0"));
        permission.setDescription("0");
        permission.setUrl("aa");


        permissionServiceGenerate.insert(permission);

        String item=String.valueOf(permission.getId());
        result.add("item", item);
        result.setSuccess(true);
        result.setMsg("获取新ID");
        return result;

    }
    @ResponseBody
    @RequestMapping("/getPermissionMsg")
    @RequiresPermissions("permission/getPermissionMsg")
    public Result getPermissionMsg(@RequestParam(value = "ID")Long ID){
        Result result=new Result();
        Permission permission1=permissionServiceGenerate.selectById(ID);
        PermissionJson permission=new PermissionJson(permission1);


        result.setSuccess(true);
        result.setMsg("成功");
        result.add("item",permission);
        return  result;
    }
    @RequestMapping("/updatePermission")
    @RequiresPermissions("permission/updatePermission")
    public ModelAndView updatePermission(@RequestParam(value="permissionId")Long Id,
                                         @RequestParam(value="name")String name,
                                         @RequestParam(value="description")String description,
                                         @RequestParam(value="url")String url){
        ModelAndView modelAndView=new ModelAndView();
        Permission permission=permissionServiceGenerate.selectById(Id);
        permission.setName(name);
        permission.setDescription(description);
        permission.setUrl(url);
        permissionServiceGenerate.updateById(permission);
        modelAndView.setViewName("/permission/permissionList");
        return modelAndView;

    }

}
