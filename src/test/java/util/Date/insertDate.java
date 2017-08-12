package util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import team.etop.xunfang.modules.mapper.DicDao;
import team.etop.xunfang.modules.mapper.EffectPictureDao;
import team.etop.xunfang.modules.mapper.EstateDao;
import team.etop.xunfang.modules.po.Dic;
import team.etop.xunfang.modules.po.EffectPicture;
import team.etop.xunfang.modules.po.Estate;

import java.util.Date;
import java.util.List;
import java.util.Random;


/**
 * @version V1.0
 * @Description:
 * @author: TingFeng Zhang
 * @date: 2017/8/5 14:41
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class insertDate {

    @Autowired
    DicDao dicDao;

    @Autowired
    EffectPictureDao effectPictureDao;

    @Autowired
    EstateDao estateDao;

    @Test
    public void insertData(){
        List<Dic> areas = dicDao.selectByType("location");
        List<Dic> types = dicDao.selectByType("type");
        List<Dic> houseTypes = dicDao.selectByType("houseType");
        List<Dic> features = dicDao.selectByType("feature");
        List<Dic> price = dicDao.selectByType("price");
        String[] housesName={"富力伯爵山","实地常春藤","实地蔷薇国际","科城山庄","碧桂园豪进左岸","碧桂园伯爵山","实地山庄","科城左岸"};
        int num=0;
        Random random=new Random();
        for(int i=0;i<119;i++){
            Estate estate=new Estate();
            EffectPicture effectPicture=new EffectPicture();
            effectPicture.setName("73952648.jpg");
            effectPictureDao.insert(effectPicture);
            estate.setEffectivePhotos(effectPicture.getId().toString());

            num=random.nextInt(areas.size());
            estate.setLocation(areas.get(num).getName());
            num=random.nextInt(features.size());
            estate.setFeature(features.get(num).getName());
            num=random.nextInt(types.size());
            estate.setType(types.get(num).getName());
            num=random.nextInt(houseTypes.size());
            estate.setHouseType(houseTypes.get(num).getName());
            num=random.nextInt(price.size());
            estate.setHouseType(price.get(num).getName());

            num=random.nextInt(housesName.length);
            estate.setEstateName(housesName[num]);
            num=random.nextInt(2);
            estate.setStatus(num);
            num=random.nextInt(50);
            estate.setMaxPrice(num);
            num=random.nextInt(10000);
            estate.setMinPrice(num);
            num=random.nextInt(100000);
            estate.setDeveloperQuotes(num);
            num=random.nextInt(100000);
            estate.setVisitTimes((long)num);
            num=random.nextInt(1000);
            estate.setArea((float)num);
            estate.setUpdateTime(new Date());

            estateDao.insert(estate);
        }
    }


}
