package team.etop.xunfang.user.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
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

    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView("/user/userList");
        User user=new User();
        user.setId(Long.parseLong("1"));
        user.setAccount("admin");
        user.setUsername("测试1");
        user.setEstatesRelevance("楼盘1");
        user.setRolesRelevance("管理员");
        user.setCreatetime(new Date(2015,3,4,9,10,2));
        user.setCreatetime(new Date(2015,3,4,9,10,2));
        user.setStatus(0);
        List<User> list=new ArrayList<>();
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);list.add(user);
        list.add(user);
        list.add(user);

       for(int i=0;i<list.size();i++){
           System.out.println(list.get(i).getAccount());
       }

        modelAndView.addObject("list",list);
        return modelAndView;
    }
}
