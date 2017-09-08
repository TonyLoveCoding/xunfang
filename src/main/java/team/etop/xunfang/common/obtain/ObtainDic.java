package team.etop.xunfang.common.obtain;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import team.etop.xunfang.modules.po.Dic;
import team.etop.xunfang.modules.service.DicServiceGenerate;

import java.util.List;

/**
 * Created by asus on 2017/9/8.
 */
public class ObtainDic {

    @Autowired
    DicServiceGenerate dicServiceGenerate;

    public List<Dic> obtainLocation(String location){
        EntityWrapper<Dic> locationEntityWrapper=new EntityWrapper<>();
        locationEntityWrapper.where("id = {0}",location);
        List<Dic> dic_location=dicServiceGenerate.selectList(locationEntityWrapper);
        return dic_location;
    }

    public List<Dic> obtainFeature(String feature){
        EntityWrapper<Dic> featureEntityWrapper=new EntityWrapper<>();
        featureEntityWrapper.where("id = {0}",feature);
        List<Dic> dic_feature=dicServiceGenerate.selectList(featureEntityWrapper);
        return dic_feature;
    }

    public List<Dic> obtainHouseType(String houseType){
        EntityWrapper<Dic> houseTypeEntityWrapper=new EntityWrapper<>();
        houseTypeEntityWrapper.where("id = {0}",houseType);
        List<Dic> dic_houseType=dicServiceGenerate.selectList(houseTypeEntityWrapper);
        return dic_houseType;
    }

    public List<Dic> obtainType(String type){
        EntityWrapper<Dic> typeEntityWrapper=new EntityWrapper<>();
        typeEntityWrapper.where("id = {0}",type);
        List<Dic> dic_type=dicServiceGenerate.selectList(typeEntityWrapper);
        return dic_type;
    }
}
