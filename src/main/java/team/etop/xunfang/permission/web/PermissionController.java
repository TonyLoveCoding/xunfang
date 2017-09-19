package team.etop.xunfang.permission.web;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import team.etop.xunfang.modules.po.Permission;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZYZ on 2017/8/14
 */

@Controller
@RequestMapping("/user")
public class PermissionController {

    @RequestMapping("/permissionList")
    public ModelAndView getPermissionList(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        Permission permission=new Permission();
        permission.setId(Long.parseLong("1"));
        permission.setName("权限测试");
        permission.setDescription("权限测试1");
        permission.setIsMenu(0);

        List<Permission> list=new ArrayList<>();
        list.add(permission);
        list.add(permission);

        modelAndView.addObject("list",list);
        modelAndView.setViewName("/user/permissionList");

        return modelAndView;
    }
}
