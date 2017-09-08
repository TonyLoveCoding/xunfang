package team.etop.xunfang.permission.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZYZ on 2017/8/14
 */

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionServiceGenerate permissionServiceGenerate;

    @RequestMapping("/permissionList")
    public ModelAndView getPermissionList(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        Result result=new Result();
        List<PermissionTree> ztree=permissionServiceGenerate.getAllZtree();
        if(ztree.size()!=0){
            result.setSuccess(true);
            result.setMsg("成功");
            result.add("ztreeMsg",ztree);
            for (PermissionTree permissionTree:ztree){
                System.out.println(permissionTree.toString());
            }}else{
            result.setMsg("暂无权限可分配");
            result.setSuccess(false);
        }


        modelAndView.addObject("result",result);
        modelAndView.setViewName("/permission/permissionList");

        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/deletePermission")
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
    public Result permissionReName (@RequestParam(value = "ID")List<String> ID)throws Exception{
        Result result=new Result();
       for(int i=0;i<ID.size();i++){
           System.out.println(ID.get(i));
       }
        System.out.println(ID.get(0));
       Permission permission=permissionServiceGenerate.selectById(ID.get(0));
        System.out.println(ID.get(0));

        System.out.println(permission.toString());
        permission.setName(ID.get(2));
        permission.setParentId(Long.parseLong(ID.get(1)));
        System.out.println(permission.toString());
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
        /*
        可以注释部分
         */
        permission.setIsMenu(0);
        permission.setIco("1");
        permission.setParentId(Long.parseLong("0"));
        permission.setDescription("0");
        permission.setUrl("aa");


        permissionServiceGenerate.insert(permission);
        System.out.println(permission.getId());

        String item=String.valueOf(permission.getId());
//        Long item=permission.getId();
        System.out.println("测试" + item);
        result.add("item", item);
        System.out.println(result.getMap().get("item"));
        result.setSuccess(true);
        result.setMsg("获取新ID");
        return result;

    }
    @ResponseBody
    @RequestMapping("/getPermissionMsg")
    public Result getPermissionMsg(@RequestParam(value = "ID")Long ID){
        Result result=new Result();
        Permission permission1=permissionServiceGenerate.selectById(ID);
        System.out.println(permission1.toString());
        PermissionJson permission=new PermissionJson(permission1);
        result.setSuccess(true);
        result.setMsg("成功");
        result.add("item",permission);
        return  result;
    }
    @RequestMapping("/updatePermission")
    public ModelAndView updatePermission(@RequestParam(value="permissionId")Long Id,
                                         @RequestParam(value="name")String name,
                                         @RequestParam(value="description")String description,
                                         @RequestParam(value="url")String url){
        System.out.println("update");
        System.out.println("permissionID"+Id);
        ModelAndView modelAndView=new ModelAndView();
        Permission permission=permissionServiceGenerate.selectById(Id);
        System.out.println(permission.toString());
        permission.setName(name);
        permission.setDescription(description);
        permission.setUrl(url);
        System.out.println(permission.toString());
        permissionServiceGenerate.updateById(permission);
        modelAndView.setViewName("/permission/permissionList");
        return modelAndView;

    }

}
