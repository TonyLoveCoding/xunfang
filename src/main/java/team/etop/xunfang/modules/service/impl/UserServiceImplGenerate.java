package team.etop.xunfang.modules.service.impl;

import team.etop.xunfang.modules.po.User;
import team.etop.xunfang.modules.mapper.UserMapperGenerate;
import team.etop.xunfang.modules.service.UserServiceGenerate;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ZTF
 * @since 2017-09-06
 */
@Service
public class UserServiceImplGenerate extends ServiceImpl<UserMapperGenerate, User> implements UserServiceGenerate {
	
}
