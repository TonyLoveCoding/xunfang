package team.etop.xunfang.home.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import team.etop.xunfang.common.util.SearchUtil;
import team.etop.xunfang.home.dto.HomeDto;
import team.etop.xunfang.modules.mapper.EstateMapperGenerate;
import team.etop.xunfang.modules.po.Estate;
import team.etop.xunfang.search.bo.RecommendEstateBo;
import team.etop.xunfang.search.service.DicService;
import team.etop.xunfang.search.service.EstateSearchService;

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

    @Autowired
    DicService dicService;

    @Autowired
    EstateSearchService estateSearchService;

    @RequestMapping
    public ModelAndView initHomeIndex() throws Exception{
        try {
            List<RecommendEstateBo> RecommendEstate = estateSearchService.getRecommendEstate(0,4);
            ModelAndView mav = new ModelAndView("/home/index");
            mav.addObject("RecommendEstate",RecommendEstate);
            SearchUtil.AddType(mav,dicService);
            return mav;
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }

    }

    @RequestMapping("/details/{id}")
    public ModelAndView initDetails(@PathVariable("id")String id) throws Exception {
        Estate estate = estateMapper.selectById(id);
        if(estate == null){
            ModelAndView mav = new ModelAndView("/home/notFound");
            return mav;
        }
        List<RecommendEstateBo> RecommendEstate = estateSearchService.getRecommendEstate(0,4);
        ModelAndView mav = new ModelAndView("/home/details");
        mav.addObject("estate",estate);
        mav.addObject("RecommendEstate",RecommendEstate);
        return mav;
    }

}
