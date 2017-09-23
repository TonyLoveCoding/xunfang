package team.etop.xunfang.common.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import team.etop.xunfang.modules.service.PermissionServiceGenerate;
import team.etop.xunfang.modules.service.RoleServiceGenerate;
import team.etop.xunfang.modules.service.UserServiceGenerate;

import static org.junit.Assert.*;

/**
 * @version V1.0
 * @Description:
 * @author: TingFeng Zhang
 * @date: 16:20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class SplitUtilTest {
    @Autowired
    UserServiceGenerate userServiceGenerate;
    @Autowired
    RoleServiceGenerate roleServiceGenerate;
    @Autowired
    PermissionServiceGenerate permissionServiceGenerate;

    @Test
    public void getPermissionList() throws Exception {
        SplitUtil.GetPermissionList("admin",userServiceGenerate,roleServiceGenerate,permissionServiceGenerate);
    }

}