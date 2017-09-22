package team.etop.xunfang.common.util;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.apache.commons.lang.StringUtils;
import team.etop.xunfang.modules.po.Permission;
import team.etop.xunfang.modules.po.Role;
import team.etop.xunfang.modules.po.User;
import team.etop.xunfang.modules.service.PermissionServiceGenerate;
import team.etop.xunfang.modules.service.RoleServiceGenerate;
import team.etop.xunfang.modules.service.UserServiceGenerate;

import java.util.ArrayList;
import java.util.List;

/**
 * @version V1.0
 * @Description:
 * @author: TingFeng Zhang
 * @date: 15:03
 */
public class SplitUtil {
    public static List<Permission> GetPermissionList(String account, UserServiceGenerate userServiceGenerate
                                                    , RoleServiceGenerate roleServiceGenerate, PermissionServiceGenerate permissionServiceGenerate) throws Exception{
        User user = userServiceGenerate.selectOne(new EntityWrapper<User>()
                .eq("account", account)
                .eq("status", 1));
        if(user==null){
            throw new RuntimeException("当前用户在数据库中找不到信息！");
        }
        String rolesRelevance = user.getRolesRelevance();
        if(StringUtils.isBlank(rolesRelevance)){
            return null;
        }
        String[] roles = rolesRelevance.split(",");
        if(roles.length<=0){
            return null;
        }
        List<Permission> permissionsList=new ArrayList<>();
        for(String roleId:roles){
            Role role = roleServiceGenerate.selectOne(new EntityWrapper<Role>()
                    .eq("id", roleId)
                    .eq("status", 1));
            if(role==null){
                throw new RuntimeException("找不到所属用户:"+role.getRoleName());
            }
            String permissionRela = role.getPermissions();
            if(!StringUtils.isBlank(permissionRela)){
                String[] permissions = permissionRela.split(",");
                if(permissions.length>0){
                    for(String permissionId:permissions){
                        Permission permission = permissionServiceGenerate.selectOne(new EntityWrapper<Permission>()
                                .eq("id", permissionId)
                                .eq("status", 1)
                                .eq("is_menu",1));
                        if(permission!=null)
                        permissionsList.add(permission);
                    }
                }
            }
        }
        return permissionsList;
    }
}
