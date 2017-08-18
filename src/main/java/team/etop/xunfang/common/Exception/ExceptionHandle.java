package team.etop.xunfang.common.Exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @version V1.0
 * @Description:
 * @author: TingFeng Zhang
 * @date: 2017/8/17 9:44
 */
@Controller
public class ExceptionHandle {
    @RequestMapping(value ="/ConnectException", produces = "text/html;charset=UTF-8")
    public ModelAndView ConnectException() {
        return new ModelAndView("/Exception/Exception");
    }
}
