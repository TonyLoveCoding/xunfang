package team.etop.xunfang.heatWord.service;

import team.etop.xunfang.heatWord.dto.HeatWord;
import team.etop.xunfang.modules.po.HeatSearchWord;

import java.util.List;

/**
 * @version V1.0
 * @Description:热搜词后台管理服务接口
 * @author: TingFeng Zhang
 * @date: 11:02
 */
public interface HeatWordService {
    /**
     * 增加热搜词
     * @param heatWord
     * @return 插入后的ID
     */
    Long addHeatWord(String heatWord) throws Exception;

    /**
     * 传入ID删除热搜词
     * @param id
     * @throws Exception
     */
    void delete(Long id) throws Exception;

    /**
     * 得到所有热搜词
     * @return
     * @throws Exception
     */
    List<HeatWord> getHeatSearchWordList()  throws Exception;
}
