package team.etop.xunfang.search.service;

import team.etop.xunfang.modules.po.Dic;

import java.util.List;

/**
 * @version V1.0
 * @Description:
 * @author: TingFeng Zhang
 * @date: 2017/8/18 10:36
 */
public interface DicService {
    List<Dic> selectByType(String type);
}
