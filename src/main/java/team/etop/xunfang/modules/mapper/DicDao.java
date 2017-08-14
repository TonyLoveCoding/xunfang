package team.etop.xunfang.modules.mapper;

import team.etop.xunfang.modules.po.Dic;
import team.etop.xunfang.common.bean.SuperMapper;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author ZTF
 * @since 2017-08-13
 */
public interface DicDao extends SuperMapper<Dic> {
    List<Dic> selectByType(String type);
}