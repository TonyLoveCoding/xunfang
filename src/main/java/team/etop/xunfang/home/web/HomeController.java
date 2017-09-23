package team.etop.xunfang.home.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import team.etop.xunfang.carouselPhotos.dto.CarouselPhotosDto;
import team.etop.xunfang.common.change.ChangeType;
import team.etop.xunfang.common.util.SearchUtil;
import team.etop.xunfang.estate.dto.EffectPictureDto;
import team.etop.xunfang.estate.dto.EstateDto;
import team.etop.xunfang.heatWord.dto.HeatWord;
import team.etop.xunfang.heatWord.service.HeatWordService;
import team.etop.xunfang.home.dto.HomeDto;
import team.etop.xunfang.modules.mapper.EstateMapperGenerate;
import team.etop.xunfang.modules.po.CarouselPhotos;
import team.etop.xunfang.modules.po.EffectPicture;
import team.etop.xunfang.modules.po.Estate;
import team.etop.xunfang.modules.service.*;
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

    @Autowired
    HeatWordService heatWordService;

    @Autowired
    CarouselPhotosServiceGenerate carouselPhotosServiceGenerate;

    @Autowired
    EstateServiceGenerate estateServiceGenerate;
    @Autowired
    EffectPictureServiceGenerate effectPictureServiceGenerate;
    @Autowired
    PrototypeRoomPictureServiceGenerate prototypeRoomPictureServiceGenerate;
    @Autowired
    RealEstatePictureServiceGenerate realEstatePictureServiceGenerate;
    @Autowired
    SamplePlanningPictureServiceGenerate samplePlanningPictureServiceGenerate;

    @Value("${adImage.url}")
    private String imageUrl;

    @RequestMapping
    public ModelAndView initHomeIndex() throws Exception{
        try {
            List<RecommendEstateBo> RecommendEstate = estateSearchService.getRecommendEstate(0,4);
            List<HeatWord> heatSearchWordList = heatWordService.getHeatSearchWordList();

            //轮播图板块初始化
            EntityWrapper<CarouselPhotos> carouselPhotosEntityWrapper=new EntityWrapper<>();
            carouselPhotosEntityWrapper.isNotNull("name").orderBy("weight");
            List<CarouselPhotos> dataList=carouselPhotosServiceGenerate.selectList(carouselPhotosEntityWrapper);
            List<CarouselPhotosDto> clist=new ArrayList<>();
            for(CarouselPhotos dataPhoto:dataList){
                CarouselPhotosDto c=new CarouselPhotosDto();
                c.setUrl(dataPhoto.getUrl());
                c.setName(imageUrl + dataPhoto.getName());
                c.setWeight(dataPhoto.getWeight());
                c.setId(dataPhoto.getId());
                clist.add(c);
            }

            ModelAndView mav = new ModelAndView("/home/index");
            mav.addObject("RecommendEstate",RecommendEstate);
            mav.addObject("heatSearchWordList",heatSearchWordList);
            mav.addObject("carouselPhotoList",clist);
            SearchUtil.AddType(mav,dicService);

            return mav;
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }

    }

    @RequestMapping("/details/{id}")
    public ModelAndView initDetails(@PathVariable("id")String id) throws Exception {
        Estate estate=estateServiceGenerate.selectById(id);
        if(estate == null){
            ModelAndView mav = new ModelAndView("/home/notFound");
            return mav;
        }
        List<HeatWord> heatSearchWordList = heatWordService.getHeatSearchWordList();

        ModelAndView mav = new ModelAndView("/home/details");
        mav.addObject("estate",estate);
        mav.addObject("heatSearchWordList",heatSearchWordList);
        return mav;
    }

//    private void get(Estate estate){
//        String[] string = estate.getEffectivePhotos().split(",");
//        for(String str:string){
//            long photoId = Long.parseLong(str);
//            EffectPictureDto effectPictureDto = new EffectPictureDto();
//            EffectPicture effectPicture = effectPictureServiceGenerate.selectById(photoId);
//            effectPictureDto.setId(photoId);
//            effectPictureDto.setName(imageUrl+effectPicture.getName());
//            effectPictureDto.setType("EffectPicture");
//        }
//    }

}
