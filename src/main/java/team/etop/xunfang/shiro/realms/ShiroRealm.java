package team.etop.xunfang.shiro.realms;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import team.etop.xunfang.modules.po.Permission;
import team.etop.xunfang.modules.po.Role;
import team.etop.xunfang.modules.po.User;
import team.etop.xunfang.modules.service.PermissionServiceGenerate;
import team.etop.xunfang.modules.service.RoleServiceGenerate;
import team.etop.xunfang.modules.service.UserServiceGenerate;

import javax.jws.soap.SOAPBinding;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @version V1.0
 * @Description:
 * @author: TingFeng Zhang
 * @date: 2017/8/4 0:12
 */
@Component
public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    UserServiceGenerate userServiceGenerate;
    @Autowired
    RoleServiceGenerate roleServiceGenerate;
    @Autowired
    PermissionServiceGenerate permissionServiceGenerate;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String account=(String)principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();

        Set<Long> permissionIds=new HashSet<>();


        EntityWrapper<Role> wrapper=new EntityWrapper<>();
        wrapper.eq("status",1);

        List<Role> roles=roleServiceGenerate.selectList(wrapper);

        EntityWrapper<Permission> wrapper1=new EntityWrapper<>();
        wrapper.eq("status",1);
        List<Permission> permissions=permissionServiceGenerate.selectList(wrapper1);

        EntityWrapper<User> wrapper2=new EntityWrapper<>();
        wrapper.eq("account",account);
        User user=userServiceGenerate.selectOne(wrapper2);
        String rolesRelevance=user.getRolesRelevance();
         String [] roleList=rolesRelevance.split(",");
         for(int i=0;i<roleList.length;i++){
             Role role=roleServiceGenerate.selectById(Long.parseLong(roleList[i]));
             String [] permissionList=role.getPermissions().split(",");
             for(String permisionID:permissionList){
                 permissionIds.add(Long.parseLong(permisionID));
             }
         }

         for(Permission permission:permissions){
             if(permissionIds.contains(permission.getId())){
                 authorizationInfo.addStringPermission(permission.getUrl());
             }
         }

        return authorizationInfo;

    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token=(UsernamePasswordToken) authenticationToken;

        EntityWrapper<User> wrapper=new EntityWrapper<>();
        wrapper.eq("status",1);
        try {
            System.out.println("realm:"+token.getUsername());
            List<User> list=userServiceGenerate.selectList(wrapper);
            System.out.println(list.get(0));
            User user=list.get(0);
            System.out.println(user.getAccount()+",,"+user.getPassword());
               if(user.getPassword().equals(token.getPassword())) {
                   AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(token.getUsername(), token.getPassword(), this.getName());
                   System.out.println(token.getUsername());
                   return authenticationInfo;
               }


        }catch (Exception e){

        }




        return  null;
    }
}
