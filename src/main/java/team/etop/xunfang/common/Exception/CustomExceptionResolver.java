package team.etop.xunfang.common.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version V1.0
 * @Description:
 * @author: TingFeng Zhang
 * @date: 2017/8/17 9:15
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {

    /**日志log*/
    private static Logger log = LoggerFactory.getLogger(CustomExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
        ex.printStackTrace();
        ModelAndView mv = new ModelAndView();
            /*  使用response返回    */
        httpServletResponse.setStatus(HttpStatus.OK.value()); //设置状态码
        httpServletResponse.setCharacterEncoding("UTF-8"); //避免乱码
        String header = httpServletRequest.getHeader("x-requested-with");
        httpServletResponse.setHeader("Cache-Control", "no-cache, must-revalidate");

        if("XMLHttpRequest".equals(header)){

            try {
                httpServletResponse.getWriter().write("{\"success\":false,\"msg\":\"" + ex.getMessage() + "\"}");
            } catch (IOException e) {
                log.error("与客户端通讯异常:"+ e.getMessage(), e);
            }
        }else{
            mv.setViewName("/Exception/Exception");
        }
        log.debug("异常:" + ex.getMessage(), ex);
        return mv;
    }

}
