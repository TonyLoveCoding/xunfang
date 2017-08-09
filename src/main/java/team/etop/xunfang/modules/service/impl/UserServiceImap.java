package team.etop.xunfang.modules.service.impl;

import team.etop.xunfang.modules.po.User;
import team.etop.xunfang.modules.mapper.UserDao;
import team.etop.xunfang.modules.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ZTF
 * @since 2017-08-09
 */
@Service
public class UserServiceImap extends ServiceImpl<UserDao, User> implements UserService {
	
}
