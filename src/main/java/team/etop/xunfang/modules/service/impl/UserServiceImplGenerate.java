package team.etop.xunfang.modules.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import team.etop.xunfang.modules.po.User;
import team.etop.xunfang.modules.mapper.UserMapperGenerate;
import team.etop.xunfang.modules.service.UserServiceGenerate;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ZTF
 * @since 2017-08-15
 */
@Service
public class UserServiceImplGenerate extends ServiceImpl<UserMapperGenerate, User> implements UserServiceGenerate {

    @Autowired
    UserServiceGenerate userServiceGenerate;
    @Override
    public List<User> selectByName(String name) {
        System.out.println(name);
        EntityWrapper<User> wrapper=new EntityWrapper<>();
        wrapper.eq("account",name);
        System.out.println(2);

        List<User> list=userServiceGenerate.selectList(wrapper);
        System.out.println(list.get(0));
        return userServiceGenerate.selectList(wrapper);
    }
}
