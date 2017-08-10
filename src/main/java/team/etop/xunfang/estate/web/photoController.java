package team.etop.xunfang.estate.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team.etop.xunfang.common.bean.Msg;

/**
 * Created by asus on 2017/8/10.
 */
@Controller
@RequestMapping("/photos")
public class photoController {

    /**
     * 通过Ajax交互进行删除
     * 其余模块的图片都有一个同样的方法进行删除
     * @param id
     */
    @RequestMapping("/deleteeffectpicture")
    public Msg deleteEffectPicture(@RequestParam("id")long id){
        //根据id删除对应的图片
        return Msg.success();
    }

}
