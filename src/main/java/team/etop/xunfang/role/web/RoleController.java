package team.etop.xunfang.role.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import team.etop.xunfang.modules.po.Role;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZYZ on 2017/8/14
 */
@Controller
@RequestMapping("/user")
public class RoleController {

    @RequestMapping("/roleList")
    public ModelAndView getRoleList(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        Role role=new Role();
        role.setId(Long.parseLong("1"));
        role.setRoleName("角色测试");
        role.setDescription("测试角色");
        role.setStatus(0);

        List<Role> list=new ArrayList<>();
        list.add(role);
        list.add(role);

        modelAndView.addObject("list",list);
        modelAndView.setViewName("/user/roleList");
        return modelAndView;
    }
}
