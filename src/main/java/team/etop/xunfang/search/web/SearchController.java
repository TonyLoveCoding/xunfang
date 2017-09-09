package team.etop.xunfang.search.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @version V1.0
 * @Description:
 * @author: TingFeng Zhang
 * @date: 2017/8/9 8:46
 */
@Controller
@RequestMapping("/home")
public class SearchController {

    @RequestMapping("/search")
    public ModelAndView welcome(){
        return new ModelAndView("/home/search");
    }


}
