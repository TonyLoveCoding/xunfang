package team.etop.xunfang.estate.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import team.etop.xunfang.common.bean.Msg;
import team.etop.xunfang.common.change.ChangeType;
import team.etop.xunfang.estate.dto.*;
import team.etop.xunfang.modules.po.*;
import team.etop.xunfang.modules.service.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2017/8/10.
 */
@Controller
@RequestMapping("/photos")
public class photoController {

    @RequestMapping("/addphotos")
    @ResponseBody
    public Msg addPhotos(@RequestParam("num")int number,@RequestParam("files")MultipartFile[] multipartFiles){
        System.out.println("num:"+number);

       for(MultipartFile f:multipartFiles){
           System.out.println(f.getOriginalFilename());
       }
        return Msg.success();
    }

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
