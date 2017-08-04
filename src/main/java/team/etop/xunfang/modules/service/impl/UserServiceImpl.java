package team.etop.xunfang.modules.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.etop.xunfang.modules.mapper.UserMapper;
import team.etop.xunfang.modules.model.User;
import team.etop.xunfang.modules.service.IUserService;


import java.util.List;

/**
 * @version V1.0
 * @Description:
 * @author: TingFeng Zhang
 * @date: 2017/8/3 20:42
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public  List<User> selectAll() {
        List<User> users = userMapper.selectList(null);
        return users;
    }
}
