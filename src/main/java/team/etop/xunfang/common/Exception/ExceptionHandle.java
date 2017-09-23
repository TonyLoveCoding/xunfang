package team.etop.xunfang.common.Exception;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import team.etop.xunfang.common.bean.Msg;
import team.etop.xunfang.common.bean.Result;

/**
 * @version V1.0
 * @Description:异常处理
 * @author: TingFeng Zhang
 * @date: 2017/8/17 9:44
 */
@ControllerAdvice
public class ExceptionHandle {



    @ExceptionHandler({UnauthorizedException.class})
    @ResponseBody
    public Result JsonUnauthorizedException() {
        Result result=new Result();

        result.setSuccess(false);
        result.setMsg("你没有获得该权限");
        return result;
    }

    @ExceptionHandler({Exception.class})
    public ModelAndView ModelAndViewOtherException() {
        //这里打日志
        return new ModelAndView("/Exception/Exception");
    }

}
