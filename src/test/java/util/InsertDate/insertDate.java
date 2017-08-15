package util.InsertDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import team.etop.xunfang.modules.mapper.EffectPictureMapperGenerate;
import team.etop.xunfang.modules.mapper.EstateMapperGenerate;
import team.etop.xunfang.modules.po.Estate;
import team.etop.xunfang.search.mapper.Search_DicMapper;
import util.EstateUtil.getEstate;

import java.util.List;


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
    Search_DicMapper search_DicMapper;

    @Autowired
    EffectPictureMapperGenerate effectPictureMapper;

    @Autowired
    EstateMapperGenerate estateMapper;

    @Test
    public void insertData(){
        for(int i=0;i<119;i++){
            estateMapper.insert(getEstate.returnEstate(search_DicMapper,effectPictureMapper));
        }
        List<Estate> estates = estateMapper.selectList(null);
        for(Estate estate:estates){
            System.out.println(estate);
        }


    }


}
