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
import team.etop.xunfang.estate.dto.*;
import team.etop.xunfang.heatWord.dto.HeatWord;
import team.etop.xunfang.heatWord.service.HeatWordService;
import team.etop.xunfang.home.dto.HomeDto;
import team.etop.xunfang.modules.mapper.EstateMapperGenerate;
import team.etop.xunfang.modules.po.*;
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
    private String carouselImageUrl;

    @Value("${businessImage.url}")
    private String estateImageUrl;

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
                c.setName(carouselImageUrl + dataPhoto.getName());
                c.setWeight(dataPhoto.getWeight());
                c.setId(dataPhoto.getId());
                clist.add(c);
            }
            //给mav添加object
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
        //根据url中的id查找楼盘，若不存在则返回错误页面
        Estate estate=estateServiceGenerate.selectById(id);
        if(estate == null){
            ModelAndView mav = new ModelAndView("/home/notFound");
            return mav;
        }
        //获取热搜词的列表
        List<HeatWord> heatSearchWordList = heatWordService.getHeatSearchWordList();
        //获取四个图集的列表，代码十分臃肿，待优化
        List<EffectPictureDto> photoList1 = getPhotoList1(estate);
        List<PrototypeRoomPictureDto> photoList2 = getPhotoList2(estate);
        List<RealEststePictureDto> photoList3 = getPhotoList3(estate);
        List<SamplePlanningPictureDto> photoList4 = getPhotoList4(estate);
        //给mav添加object
        ModelAndView mav = new ModelAndView("/home/details");
        mav.addObject("estate",estate);
        mav.addObject("photoList1",photoList1);
        mav.addObject("photoList2",photoList2);
        mav.addObject("photoList3",photoList3);
        mav.addObject("photoList4",photoList4);
        mav.addObject("heatSearchWordList",heatSearchWordList);

        return mav;
    }

    //取出四个图集的私有方法，待优化
    private List<EffectPictureDto> getPhotoList1(Estate estate){
        String[] string = estate.getEffectivePhotos().split(",");
        List<EffectPictureDto> list = new ArrayList<>();
        for(String str:string){
            long photoId = Long.parseLong(str);
            EffectPictureDto effectPictureDto = new EffectPictureDto();
            EffectPicture effectPicture = effectPictureServiceGenerate.selectById(photoId);
            effectPictureDto.setId(photoId);
            effectPictureDto.setName(estateImageUrl + effectPicture.getName());
            effectPictureDto.setType("EffectPicture");
            list.add(effectPictureDto);
        }
        return list;
    }

    private List<PrototypeRoomPictureDto> getPhotoList2(Estate estate){
        String[] PrototypeRoomPictures = estate.getPrototypeRoom().split(",");
        List<PrototypeRoomPictureDto> list = new ArrayList<>();
        for(String str:PrototypeRoomPictures){
            long l=Long.parseLong(str);
            PrototypeRoomPictureDto prototypeRoomPictureDto=new PrototypeRoomPictureDto();
            PrototypeRoomPicture prototypeRoomPicture=prototypeRoomPictureServiceGenerate.selectById(l);
            prototypeRoomPictureDto.setId(l);
            prototypeRoomPictureDto.setName(estateImageUrl+prototypeRoomPicture.getName());
            prototypeRoomPictureDto.setType("PrototypeRoomPicture");
            list.add(prototypeRoomPictureDto);
        }
        return list;
    }

    private List<RealEststePictureDto> getPhotoList3(Estate estate){
        String[] RealEststePictures = estate.getLiveAction().split(",");
        List<RealEststePictureDto> list = new ArrayList<>();
        for(String str:RealEststePictures){
            long l=Long.parseLong(str);
            RealEststePictureDto realEststePictureDto=new RealEststePictureDto();
            RealEstatePicture realEstatePicture = realEstatePictureServiceGenerate.selectById(l);
            realEststePictureDto.setId(l);
            realEststePictureDto.setName(estateImageUrl+realEstatePicture.getName());
            realEststePictureDto.setType("RealEstatePicture");
            list.add(realEststePictureDto);
        }
        return list;
    }

    private List<SamplePlanningPictureDto> getPhotoList4(Estate estate){
        String[] SamplePlanningPictures=estate.getSamplePlate().split(",");
        List<SamplePlanningPictureDto> list = new ArrayList<>();
        for(String str:SamplePlanningPictures){
            long l=Long.parseLong(str);
            SamplePlanningPictureDto samplePlanningPictureDto=new SamplePlanningPictureDto();
            SamplePlanningPicture samplePlanningPicture=samplePlanningPictureServiceGenerate.selectById(l);
            samplePlanningPictureDto.setId(l);
            samplePlanningPictureDto.setName(estateImageUrl+samplePlanningPicture.getName());
            samplePlanningPictureDto.setType("SamplePlanningPicture");
            list.add(samplePlanningPictureDto);
        }
        return list;
    }

}
