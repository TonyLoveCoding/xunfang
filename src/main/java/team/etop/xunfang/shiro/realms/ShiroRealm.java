package team.etop.xunfang.shiro.realms;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import team.etop.xunfang.modules.po.Permission;
import team.etop.xunfang.modules.po.Role;
import team.etop.xunfang.modules.po.User;
import team.etop.xunfang.modules.service.PermissionServiceGenerate;
import team.etop.xunfang.modules.service.RoleServiceGenerate;
import team.etop.xunfang.modules.service.UserServiceGenerate;


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

        EntityWrapper<Permission> wrapper1=new EntityWrapper<>();
        wrapper.eq("status",1);
        List<Permission> permissions=permissionServiceGenerate.selectList(wrapper1);

        EntityWrapper<User> wrapper2=new EntityWrapper<>();
        System.out.println(account);
        wrapper2.eq("account",account);
        User user=userServiceGenerate.selectOne(wrapper2);
        System.out.println(user.toString());
        String rolesRelevance;
        rolesRelevance=user.getRolesRelevance();
        if(!rolesRelevance.isEmpty()) {
            String[] roleList = rolesRelevance.split(",");
            for (int i = 0; i < roleList.length; i++) {
                Role role = roleServiceGenerate.selectById(Long.parseLong(roleList[i]));
                System.out.println(role.getPermissions());
                String[] permissionList = role.getPermissions().split(",");
                for (String permisionID : permissionList) {
                    permissionIds.add(Long.parseLong(permisionID));
                }
            }

            for (Permission permission : permissions) {
                if (permissionIds.contains(permission.getId())&& !StringUtils.isBlank(permission.getUrl())) {
                    authorizationInfo.addStringPermission(permission.getUrl());
                }
            }
        }else{
            System.out.println("无权限");
        }

        return authorizationInfo;

    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token=(UsernamePasswordToken) authenticationToken;

        EntityWrapper<User> wrapper=new EntityWrapper<>();
        wrapper.eq("account",token.getUsername());

             User user= null;
             user=userServiceGenerate.selectOne(wrapper);
        System.out.println(user==null);
            if(user!=null){


                   AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getAccount(), user.getPassword(), user.getUsername());
                   this.setSession("currentUser",user);
                   return authenticationInfo;
               }else{
                return  null;

            }

    }
    private void setSession(Object key,Object value){
        Subject currentUser= SecurityUtils.getSubject();
        if(currentUser!=null){
           Session session=currentUser.getSession();
            if(session!=null){
                session.setAttribute(key,value);
            }
        }
    }
}
