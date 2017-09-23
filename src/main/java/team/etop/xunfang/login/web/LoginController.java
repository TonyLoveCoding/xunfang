package team.etop.xunfang.login.web;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import team.etop.xunfang.modules.po.User;


/**
 * Created by ZYZ on 2017/9/1
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping()
    public ModelAndView loginIndex(){
        return new ModelAndView("/login/login");
    }


    @RequestMapping(value="login")
    public ModelAndView login(@RequestParam(value = "account")String account,
                              @RequestParam(value = "password")String password){
        ModelAndView modelAndView=new ModelAndView();

        UsernamePasswordToken token=new UsernamePasswordToken(account,new Md5Hash(password,account).toString());

        Subject currentUser= SecurityUtils.getSubject();
        try{
            currentUser.login(token);
            modelAndView.setViewName("/main/index");
            User user = (User) currentUser.getSession().getAttribute("currentUser");
            modelAndView.addObject("account",user.getAccount());
        }catch (Exception e){
            modelAndView.setViewName("/login/login");
            e.printStackTrace();
        }


        return modelAndView;
    }
    @RequestMapping("/logout")
    public ModelAndView logout(){
        ModelAndView modelAndView=new ModelAndView();
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        modelAndView.setViewName("/login/login");
        return modelAndView;
    }
}
