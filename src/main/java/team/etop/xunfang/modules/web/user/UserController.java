package team.etop.xunfang.modules.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import team.etop.xunfang.modules.model.User;
import team.etop.xunfang.modules.service.IUserService;
import team.etop.xunfang.modules.web.BaseController;

import java.util.List;

/**
 * @version V1.0
 * @Description:
 * @author: TingFeng Zhang
 * @date: 2017/8/3 16:25
 */
@Controller
@RequestMapping("/user")
public class UserController  extends BaseController {
    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }
    @RequestMapping("/showBtn")
    public ModelAndView showBtn() {
        return new ModelAndView("/content/test");
    }
    @RequestMapping("/getUsers")
    public ModelAndView index() {
        List<User> users = userService.selectAll();
        ModelAndView modelAndView = new ModelAndView("/content/test");
        modelAndView.addObject("users",users);
        return modelAndView;
    }

}
