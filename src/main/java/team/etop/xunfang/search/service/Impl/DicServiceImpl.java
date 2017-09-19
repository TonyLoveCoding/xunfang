package team.etop.xunfang.search.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.etop.xunfang.modules.po.Dic;
import team.etop.xunfang.search.mapper.DicMapper;
import team.etop.xunfang.search.service.DicService;

import java.util.List;

/**
 * @version V1.0
 * @Description:
 * @author: TingFeng Zhang
 * @date: 2017/8/18 10:37
 */
@Service
public class DicServiceImpl implements DicService{

    @Autowired
    DicMapper dicMapper;

    /**
     * 根据种类获取该字典类型
     * @param type
     * @return
     */
    @Override
    public List<Dic> selectByType(String type) {
        return dicMapper.selectByType(type);
    }
}
