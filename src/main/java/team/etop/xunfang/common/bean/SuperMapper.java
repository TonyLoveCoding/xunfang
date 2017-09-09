package team.etop.xunfang.common.bean;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * @version V1.0
 * @Description:通用Mapper方法
 * @author: TingFeng Zhang
 * @date: 2017/8/3 20:32
 */
public interface SuperMapper<T> extends BaseMapper<T> {
    // 这里可以写自己的公共方法、注意不要让 mp 扫描到误以为是实体 Base 的操作
}
