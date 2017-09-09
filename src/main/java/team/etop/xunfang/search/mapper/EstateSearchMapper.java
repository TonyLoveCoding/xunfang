package team.etop.xunfang.search.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import team.etop.xunfang.search.bo.EstateSearchBo;

import java.util.List;

/**
 * @version V1.0
 * @Description:
 * @author: TingFeng Zhang
 * @date: 2017/8/13 20:05
 */
@Mapper
public interface EstateSearchMapper {
    List<EstateSearchBo> selectAll();
}
