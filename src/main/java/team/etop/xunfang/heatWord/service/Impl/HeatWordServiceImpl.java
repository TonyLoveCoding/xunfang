package team.etop.xunfang.heatWord.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import team.etop.xunfang.heatWord.dto.HeatWord;
import team.etop.xunfang.heatWord.service.HeatWordService;
import team.etop.xunfang.modules.mapper.HeatSearchWordMapperGenerate;
import team.etop.xunfang.modules.po.HeatSearchWord;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @version V1.0
 * @Description:热搜词后台管理服务实现类
 * @author: TingFeng Zhang
 * @date: 11:06
 */
@Service
public class HeatWordServiceImpl implements HeatWordService{

    @Autowired
    HeatSearchWordMapperGenerate heatSearchWordMapperGenerate;

    @Value("${heatWord.max}")
    Integer heatWordMax;

    @Value("${heatWord.length}")
    Integer heatWordLength;


    @Override
    public Long addHeatWord(String heatWord) throws Exception{
            List<HeatSearchWord> heatSearchWords = heatSearchWordMapperGenerate.selectList(null);
            if(heatSearchWords.size()>=heatWordMax){
                throw new RuntimeException("热搜词最多只能添加四个！");
            }
            if(StringUtils.isBlank(heatWord)){
                throw new RuntimeException("热搜词不能为空！");
            }
            if(heatWord.length()>heatWordLength){
                throw new RuntimeException("热搜词字符大小必须在"+heatWordLength+"以下！");
            }
            HeatSearchWord heatSearchWord=new HeatSearchWord(null,heatWord,heatSearchWords.size()+1L);
            heatSearchWordMapperGenerate.insert(heatSearchWord);
            return heatSearchWord.getId();
    }

    @Override
    public void delete(Long id) throws Exception {
        heatSearchWordMapperGenerate.deleteById(id);
    }

    @Override
    public List<HeatWord> getHeatSearchWordList() throws Exception {
        List<HeatWord> heatWordList=new ArrayList<>();
        List<HeatSearchWord> heatSearchWords = heatSearchWordMapperGenerate.selectList(null);
        for(HeatSearchWord heatSearchWord:heatSearchWords){
            heatWordList.add(new HeatWord(String.valueOf(heatSearchWord.getId()),heatSearchWord.getWord()));
        }
        return heatWordList;
    }
}
