package team.etop.xunfang.login.web;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by ZYZ on 2017/9/1
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/login")
    public ModelAndView login(@RequestParam(value = "account")String account,
                              @RequestParam(value = "password")String password){
        ModelAndView modelAndView=new ModelAndView();
        System.out.println(account+","+password);

        UsernamePasswordToken token=new UsernamePasswordToken(account,password);

        Subject currentUser= SecurityUtils.getSubject();
        try{
            currentUser.login(token);
            modelAndView.setViewName("/main/index");
        }catch (Exception e){
            e.printStackTrace();
        }

        return modelAndView;
    }
}
