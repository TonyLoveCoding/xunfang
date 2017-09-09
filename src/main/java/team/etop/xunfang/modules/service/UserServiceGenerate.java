package team.etop.xunfang.modules.service;

import team.etop.xunfang.modules.po.User;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ZTF
 * @since 2017-08-15
 */
public interface UserServiceGenerate extends IService<User> {
    List<User> selectByName(String name);
	
}
