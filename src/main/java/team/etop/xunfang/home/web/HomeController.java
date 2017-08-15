package team.etop.xunfang.home.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Tony Yao on 2017/8/12.
 */
//前端访客的控制器
@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping
    public ModelAndView initIndex(){
        return new ModelAndView("/home/index");
    }

    @RequestMapping("/details")
    public ModelAndView initDetails(){
        return new ModelAndView("/home/details");
    }

}
