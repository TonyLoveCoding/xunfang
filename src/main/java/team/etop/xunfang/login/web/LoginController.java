package team.etop.xunfang.login.web;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by ZYZ on 2017/9/1
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(value="/login")
    public ModelAndView login(@RequestParam(value = "account")String account,
                              @RequestParam(value = "password")String password){
        ModelAndView modelAndView=new ModelAndView();
        System.out.printf("a");
        System.out.println(account+","+password);

        UsernamePasswordToken token=new UsernamePasswordToken(account,password);
        System.out.println(token.getPassword());

        Subject currentUser= SecurityUtils.getSubject();
        try{
            currentUser.login(token);
            modelAndView.setViewName("/main/index");
        }catch (Exception e){
            modelAndView.setViewName("/login/login");
            e.printStackTrace();
        }


        return modelAndView;
    }
}
