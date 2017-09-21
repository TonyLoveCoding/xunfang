package util.EstateUtil;


import team.etop.xunfang.modules.mapper.EffectPictureMapperGenerate;
import team.etop.xunfang.modules.mapper.PrototypeRoomPictureMapperGenerate;
import team.etop.xunfang.modules.mapper.RealEstatePictureMapperGenerate;
import team.etop.xunfang.modules.mapper.SamplePlanningPictureMapperGenerate;
import team.etop.xunfang.modules.po.*;
import team.etop.xunfang.search.mapper.DicMapper;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @version V1.0
 * @Description:
 * @author: TingFeng Zhang
 * @date: 2017/8/13 15:30
 */
public class getEstateZTF {
    public static Estate returnEstate(DicMapper dicDao,
                                      EffectPictureMapperGenerate effectPictureDao,
                                      RealEstatePictureMapperGenerate realEstatePictureMapperGenerate,
                                      PrototypeRoomPictureMapperGenerate prototypeRoomPictureMapperGenerate,
                                      SamplePlanningPictureMapperGenerate samplePlanningPictureMapperGenerate){
        List<Dic> locations = dicDao.selectByType("location");
        List<Dic> types = dicDao.selectByType("type");
        List<Dic> houseTypes = dicDao.selectByType("houseType");
        List<Dic> features = dicDao.selectByType("feature");
        String[] signs={"紧邻地铁","改善宜居","环境优质","小高层","品牌地产","精装修"};
        String[] housesName={"富力伯爵山","实地常春藤","实地蔷薇国际","科城山庄","碧桂园豪进左岸","碧桂园伯爵山","实地山庄","科城左岸"};
        String[] addressName={"[增城-荔城]三联村蕉冚地段（逸翠山庄旁边）","[南沙-南沙湾]英东大道金业小学西侧","[黄埔-长岭居]长岭居东部禾丰小学旁","[黄埔-萝岗区府]科学城内水西环路","[增城-荔城]石滩体育馆东行约400米处","[增城-新塘]永宁大道南侧","[增城-广园东]开创大道北埔南路翡翠绿洲大道","[黄埔-长岭居]永顺大道和永和大道交界处"};
        int num=0;
        Random random=new Random();
        Estate estate=new Estate();
        EffectPicture effectPicture=new EffectPicture();
        effectPicture.setName("73952648.jpg");
        effectPicture.setWeight(System.currentTimeMillis());
        effectPictureDao.insert(effectPicture);
        estate.setEffectivePhotos(effectPicture.getId().toString());
        estate.setThumbnail("73952648.jpg");
        num=random.nextInt(locations.size());
        estate.setLocation(locations.get(num).getName());
        num=random.nextInt(features.size());
        estate.setFeature(features.get(num).getName());
        num=random.nextInt(types.size());
        estate.setType(types.get(num).getName());
        num=random.nextInt(houseTypes.size());
        estate.setHouseType(houseTypes.get(num).getName());


        num=random.nextInt(2);
        estate.setSaleStatus(num);
        estate.setStatus(0);
        num=random.nextInt(addressName.length);
        estate.setEstateAddress(addressName[num]);
        num=random.nextInt(housesName.length);
        estate.setEstateName(housesName[num]);
        num=random.nextInt(1300);
        estate.setMinPrice(num);
        Integer temp=num;
        num=random.nextInt(500);
        estate.setMaxPrice(num+temp);
        num=random.nextInt(50000);
        estate.setDeveloperQuotes(num);
        num=random.nextInt(100000);
        estate.setVisitTimes((long)num);
        num=random.nextInt(200);
        estate.setArea((float)num);
        estate.setCreateTime(new Date());

        SamplePlanningPicture samplePlanningPicture=new SamplePlanningPicture();
        samplePlanningPicture.setName("73952648.jpg");
        samplePlanningPicture.setWeight(System.currentTimeMillis());
        samplePlanningPictureMapperGenerate.insert(samplePlanningPicture);
        estate.setSamplePlate(samplePlanningPicture.getId().toString());

        RealEstatePicture realEstatePicture=new RealEstatePicture();
        realEstatePicture.setName("73952648.jpg");
        realEstatePicture.setWeight(System.currentTimeMillis());
        realEstatePictureMapperGenerate.insert(realEstatePicture);
        estate.setLiveAction(realEstatePicture.getId().toString());


        PrototypeRoomPicture prototypeRoomPicture=new PrototypeRoomPicture();
        prototypeRoomPicture.setName("73952648.jpg");
        prototypeRoomPicture.setWeight(System.currentTimeMillis());
        prototypeRoomPictureMapperGenerate.insert(prototypeRoomPicture);
        estate.setPrototypeRoom(prototypeRoomPicture.getId().toString());

        estate.setProperty("新华小区");

        estate.setDeveloper("万达");

        estate.setFirstDelivery(new Date());

        estate.setLatestOpening(new Date());

        num=random.nextInt(100);
        estate.setPropertyRights("70");

        estate.setTakeTime(new Date());

        estate.setCompany("腾讯");

        estate.setPropertyCost("10000");

        estate.setPowerType("每月1000");

        estate.setGreenRate((float)11.1);

        estate.setParkingSpaces("很多空位");

        estate.setDecoration("一般般");

        estate.setEstateInformation("没什么可说的");

        estate.setPlotRatio((float)70.0);

        
        num=random.nextInt(signs.length);
        estate.setSign(signs[num]);

        num=random.nextInt(20000);
        estate.setTurnover(num);


        return  estate;
    }
}
