package team.etop.xunfang.home.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import team.etop.xunfang.home.dto.HomeDto;

/**
 * @version V1.0
 * @Description:
 * @author: TingFeng Zhang
 * @date: 2017/8/15 18:49
 */
@Controller
@RequestMapping("")
public class HomeController {

 @RequestMapping
 public HomeDto home(){
    return new HomeDto();
 }
    @RequestMapping
    public ModelAndView home2(){
        return new ModelAndView();
    }
}