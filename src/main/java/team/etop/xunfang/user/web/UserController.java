package team.etop.xunfang.user.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import team.etop.xunfang.common.bean.Msg;
import team.etop.xunfang.common.bean.PageInfo;
import team.etop.xunfang.modules.po.User;
import team.etop.xunfang.user.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

/**
 * @version V1.0
 * @Description:
 * @author: TingFeng Zhang
 * @date: 2017/8/8 18:15
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Value("${userPage.PageSize}")
    private Long PageSize;
    @Value("${userPage.countindex}")
    private Long countindex;
    @Value("${userPage.visiblePages}")
    private Long visiblePages;

    //使用AJAX交互的话统一使用Msg返回，可以放入tip作为返回信息
    @RequestMapping("/query")
    public ModelAndView queryUser(@RequestParam(value = "pn",defaultValue ="1")Integer pageNum,
                                  @RequestParam(value = "keyWord",defaultValue ="")String keyWord) throws Exception{
        ModelAndView modelAndView = new ModelAndView("user/query");
        //PageSize * visiblePages所有数据总数
        PageInfo pageInfo = new PageInfo(PageSize, countindex, visiblePages, PageSize * visiblePages, 1L);
        //数据库查询数据
        List<User> userList=new ArrayList<>();
        for(long i=PageSize*(pageNum-1);i<PageSize*(pageNum);i++){
            User user = new User();
            user.setAccount("etop"+i);
            user.setUsername("机器人"+i+"号");
            user.setPassword("etop"+i);
            userList.add(user);
        }
        modelAndView.addObject("userList",userList);
        modelAndView.addObject("pageInfo",pageInfo);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/add")
    public Msg addUser(UserDto userDto) throws Exception{
        //这里进行表单校验 可能采用JSR303或手动正则匹配

        boolean isExit=false;
        //下面判断是否存在同名帐号
        if(isExit){
            //帐户名存在
            return Msg.fail("账号名已经存在！");
        }

        //添加进数据库
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping("/delete")
    public Msg updateUser(@RequestParam("id") Long id)throws Exception{

        boolean isUsing=false;
        //下面判断是否当前账户
        if(isUsing){
            //帐户名存在
            return Msg.fail("无法删除当前用户！");
        }

        //数据库更新
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping("/update")
    public Msg deleteUser(@RequestParam("id") Long id)throws Exception{
        //这里进行表单校验 可能采用JSR303或手动正则匹配

        boolean isExit=false;
        //下面判断是否存在同名帐号
        if(isExit){
            //帐户名存在
            return Msg.fail("账号名已经存在！");
        }

        //数据库更新
        return Msg.success();
    }

}
