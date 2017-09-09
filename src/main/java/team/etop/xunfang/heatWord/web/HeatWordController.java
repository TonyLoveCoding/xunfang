package team.etop.xunfang.heatWord.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import team.etop.xunfang.common.bean.Msg;
import team.etop.xunfang.heatWord.service.HeatWordService;

import java.util.Date;

/**
 * @version V1.0
 * @Description:热搜词管理界面controller
 * @author: TingFeng Zhang
 * @date: 10:55
 */
@Controller
@RequestMapping("/heatWord")
public class HeatWordController {

//    private static final Logger logger = LoggerFactory.getLogger(HeatWordController.class);

    @Autowired
    HeatWordService heatWordService;

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView index() throws Exception{
        return new ModelAndView("/HeatWord/HeatWord");
    }

    @RequestMapping(path = {"/getHeatWordList"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Msg getHeatWordList() throws Exception{
        try {
            return Msg.success().add("heatSearchWordList",heatWordService.getHeatSearchWordList());
        }
        catch (Exception e){
//            logger.error(new Date().toString()+"初始化热搜词列表时发生错误："+e.getMessage());
            throw new RuntimeException(new Date().toString()+"初始化热搜词列表时发生错误！");
        }
    }

    @RequestMapping(path = {"/addHeatWord"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Msg addHeatWord(@RequestParam(value = "heatWord",defaultValue = "")String heatWord) throws Exception{
        try {
            heatWordService.addHeatWord(heatWord);
            return Msg.success();
        }catch (RuntimeException runtimeExcepiton){
            runtimeExcepiton.printStackTrace();
            return Msg.fail(runtimeExcepiton.getMessage());
        }
        catch (Exception e){
            //logger.error(new Date().toString()+"新增热搜词时发生了错误："+e.getMessage());
            throw new RuntimeException(new Date().toString()+"新增热搜词时发生了错误！");
        }

    }

    @RequestMapping(path = {"/deleteHeatWord"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Msg deleteHeatWord(@RequestParam(value = "id",defaultValue = "0")Long id) throws Exception{
        try {
            heatWordService.delete(id);
            return Msg.success();
        }catch (RuntimeException runtimeExcepiton){
            return Msg.fail(runtimeExcepiton.getMessage());
        }
        catch (Exception e){
            //logger.error(new Date().toString()+"删除热搜词时发生了错误："+e.getMessage());
            throw new RuntimeException(new Date().toString()+"删除热搜词时发生了错误！");
        }
    }

}
