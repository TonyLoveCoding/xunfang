package team.etop.xunfang.user.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import team.etop.xunfang.common.bean.Result;
import team.etop.xunfang.common.bean.RoleJson;
import team.etop.xunfang.modules.po.Role;

import team.etop.xunfang.modules.po.User;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ZYZ on 2017/8/11
 */
@Controller
@RequestMapping("/user")
public class UserController {



    @RequestMapping("/userList")
    public ModelAndView login(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        User user=new User();
        user.setId(Long.parseLong("1"));
        user.setAccount("admin");
        user.setUsername("测试1");
        user.setEstatesRelevance("楼盘1");
        user.setRolesRelevance("管理员");
        user.setCreatetime(new Date(2015,3,4,9,10,2));
        user.setCreatetime(new Date(2015,3,4,9,10,2));
        user.setStatus(0);
        User user2=new User();
        user2.setId(Long.parseLong("2"));
        user2.setAccount("admin2");
        user2.setUsername("测试2");
        user2.setEstatesRelevance("楼盘2");
        user2.setRolesRelevance("管理员2");
        user2.setCreatetime(new Date(2015,3,4,9,10,2));
        user2.setCreatetime(new Date(2015,3,4,9,10,2));
        user2.setStatus(1);

        User user3=new User();
        user3.setId(Long.parseLong("3"));
        user3.setAccount("测试3");
        List<User> list=new ArrayList<>();
        list.add(user);
        list.add(user2);
        list.add(user3);

       for(int i=0;i<list.size();i++){
           System.out.println(list.get(i).getAccount());
       }

        modelAndView.addObject("list",list);
        modelAndView.setViewName("/user/userList");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/getRoleJson")
    public Result getRoleJson(@RequestParam(value = "ID") String ID) throws Exception{
        System.out.println("測試");
        List<RoleJson> roleJsonList=new ArrayList<>();
        Role role=new Role();
        role.setId(Long.parseLong("1"));
        role.setRoleName("角色1");
        RoleJson roleJson=new RoleJson();
        roleJson.setRole(role);
        Role role2=new Role();
        role2.setId(Long.parseLong("2"));
        role2.setRoleName("角色2");
        RoleJson roleJson2=new RoleJson();
        roleJson2.setRole(role2);
        Role role3=new Role();
        role3.setId(Long.parseLong("3"));
        role3.setRoleName("角色3");
        RoleJson roleJson3=new RoleJson();
        roleJson3.setRole(role3);



        roleJsonList.add(roleJson);
        roleJsonList.add(roleJson2);
        roleJsonList.add(roleJson3);
        Result result=new Result();
        result.setSuccess(true);
        System.out.println("測試");
        result.add("roleJsonList",roleJsonList);
        for(int i=0;i<roleJsonList.size();i++){
            System.out.println(roleJsonList.get(i).getRole().getId());
        }
        return result;
    }

    @RequestMapping("/updateUserRole")
    public void updateUserRole(HttpServletRequest request){
        System.out.println("进入");
        System.out.println(request.getParameter("roleId"));
//        System.out.println("获取的角色ID: "+roleId);
//        System.out.println(request.getParameter("type"));
        String[] permissions=request.getParameterValues("type");
        for(int i=0;i<permissions.length;i++){
            System.out.println("获取的角色ID: "+permissions[i]);
        }
    }



}
