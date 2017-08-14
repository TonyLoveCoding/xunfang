package util.InsertDate;

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
import util.EstateUtil.getEstate;

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

        for(int i=0;i<119;i++){
            estateDao.insert(getEstate.returnEstate(dicDao,effectPictureDao));
        }
    }


}
