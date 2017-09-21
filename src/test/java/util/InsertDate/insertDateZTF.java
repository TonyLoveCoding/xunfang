package util.InsertDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import team.etop.xunfang.modules.mapper.*;
import team.etop.xunfang.modules.po.Estate;
import team.etop.xunfang.modules.po.SamplePlanningPicture;
import team.etop.xunfang.search.mapper.DicMapper;
import util.EstateUtil.getEstateZTF;

import java.util.List;


/**
 * @version V1.0
 * @Description:
 * @author: TingFeng Zhang
 * @date: 2017/8/5 14:41
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class insertDateZTF {

    @Autowired
    DicMapper search_DicMapper;

    @Autowired
    EffectPictureMapperGenerate effectPictureMapper;

    @Autowired
    EstateMapperGenerate estateMapper;

    @Autowired
    RealEstatePictureMapperGenerate realEstatePictureMapperGenerate;

    @Autowired
    PrototypeRoomPictureMapperGenerate prototypeRoomPictureMapperGenerate;

    @Autowired
    SamplePlanningPictureMapperGenerate samplePlanningPictureMapperGenerate;

    /**
     * 插入数据用，默认10000条
     */
    @Test
    public void insertData(){
        for(int i=0;i<10000;i++){
            estateMapper.insert(getEstateZTF.returnEstate(search_DicMapper,effectPictureMapper,
                    realEstatePictureMapperGenerate,prototypeRoomPictureMapperGenerate,
                    samplePlanningPictureMapperGenerate));
        }

    }


}
