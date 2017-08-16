package team.etop.xunfang.home.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import team.etop.xunfang.home.dto.HomeDto;
import team.etop.xunfang.modules.mapper.EstateMapperGenerate;
import team.etop.xunfang.modules.po.Estate;

import java.util.ArrayList;
import java.util.List;

/**
 * @version V1.0
 * @Description:
 * @author: TingFeng Zhang
 * @date: 2017/8/15 18:49
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    EstateMapperGenerate estateMapper;

    @RequestMapping
    public ModelAndView initHomeIndex(){
        List<Estate> estates = estateMapper.selectList(null);
        List<Estate> indexEstates = new ArrayList<>();
        for(int i = 0; i< 16; i++){
            indexEstates.add(estates.get(i));
        }
        ModelAndView mav = new ModelAndView("/home/index");
        mav.addObject("list",indexEstates);
        return mav;
    }

//    @RequestMapping("/details")
//    public ModelAndView initDetails(){
//        Estate estate = estateMapper.selectById("897664297177845761");
//        ModelAndView mav = new ModelAndView("/home/details");
//        mav.addObject("estate",estate);
//        return mav;
//    }

    @RequestMapping("/details/{id}")
    public ModelAndView initDetails(@PathVariable("id")String id){
        Estate estate = estateMapper.selectById(id);
        if(estate == null){
            ModelAndView mav = new ModelAndView("/home/notFound");
            return mav;
        }
        ModelAndView mav = new ModelAndView("/home/details");
        mav.addObject("estate",estate);
        return mav;
    }

}
