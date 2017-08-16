package util.EstateUtil;


import team.etop.xunfang.modules.mapper.EffectPictureMapperGenerate;
import team.etop.xunfang.modules.po.Dic;
import team.etop.xunfang.modules.po.EffectPicture;
import team.etop.xunfang.modules.po.Estate;
import team.etop.xunfang.search.mapper.Search_DicMapper;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @version V1.0
 * @Description:
 * @author: TingFeng Zhang
 * @date: 2017/8/13 15:30
 */
public class getEstate {
    public static Estate returnEstate(Search_DicMapper dicDao, EffectPictureMapperGenerate effectPictureDao){
        List<Dic> areas = dicDao.selectByType("location");
        List<Dic> types = dicDao.selectByType("type");
        List<Dic> houseTypes = dicDao.selectByType("houseType");
        List<Dic> features = dicDao.selectByType("feature");
        String[] housesName={"富力伯爵山","实地常春藤","实地蔷薇国际","科城山庄","碧桂园豪进左岸","碧桂园伯爵山","实地山庄","科城左岸"};
        String[] addressName={"[增城-荔城]三联村蕉冚地段（逸翠山庄旁边）","[南沙-南沙湾]英东大道金业小学西侧","[黄埔-长岭居]长岭居东部禾丰小学旁","[黄埔-萝岗区府]科学城内水西环路","[增城-荔城]石滩体育馆东行约400米处","[增城-新塘]永宁大道南侧","[增城-广园东]开创大道北埔南路翡翠绿洲大道","[黄埔-长岭居]永顺大道和永和大道交界处"};
        int num=0;
        Random random=new Random();
        Estate estate=new Estate();

        EffectPicture effectPicture=new EffectPicture();
        effectPicture.setName("73952648.jpg");
        effectPictureDao.insert(effectPicture);

        estate.setEffectivePhotos(effectPicture.getId().toString());

        estate.setThumbnail("73952648.jpg");

        num=random.nextInt(areas.size());
        estate.setLocation(areas.get(num).getName());

        num=random.nextInt(features.size());
        estate.setFeature(features.get(num).getName());

        num=random.nextInt(types.size());
        estate.setType(types.get(num).getName());

        num=random.nextInt(houseTypes.size());
        estate.setHouseType(houseTypes.get(num).getName());

        estate.setSaleStatus(0);

        num=random.nextInt(addressName.length);
        estate.setEstateAddress(addressName[num]);

        num=random.nextInt(housesName.length);
        estate.setEstateName(housesName[num]);

        num=random.nextInt(2);
        estate.setStatus(num);

        num=random.nextInt(500)+500;
        estate.setMaxPrice(num);

        num=random.nextInt(500);
        estate.setMinPrice(num);

        num=random.nextInt(4000)+3000;
        estate.setDeveloperQuotes(num);

        num=random.nextInt(100000);
        estate.setVisitTimes((long)num);

        num=random.nextInt(1000);
        estate.setArea((float)num);

        estate.setCreateTime(new Date());

        estate.setUpdateTime(new Date());

        estate.setSamplePlate(effectPicture.getId().toString());

        estate.setLiveAction(effectPicture.getId().toString());

        estate.setPrototypeRoom(effectPicture.getId().toString());

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

        estate.setGreenRate(11.1);

		<result column="power_type" property="powerType" />
		<result column="green_rate" property="greenRate" />
		<result column="parking_spaces" property="parkingSpaces" />
		<result column="decoration" property="decoration" />
		<result column="estate_information" property="estateInformation" />
		<result column="plot_ratio" property="plotRatio" />
		<result column="area" property="area" />
		<result column="turnover" property="turnover" />
		<result column="sign" property="sign" />


        return  estate;
    }
}
