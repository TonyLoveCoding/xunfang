package team.etop.xunfang.search.mapper;




import org.springframework.stereotype.Component;
import team.etop.xunfang.modules.po.Dic;

import java.util.List;

/**
 * @version V1.0
 * @Description:
 * @author: TingFeng Zhang
 * @date: 2017/8/15 18:15
 */
@Component
public interface DicMapper {
    List<Dic> selectByType(String type);
}
