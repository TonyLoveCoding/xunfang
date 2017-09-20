package team.etop.xunfang.modules.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import team.etop.xunfang.common.bean.PermissionTree;
import team.etop.xunfang.modules.po.Permission;
import team.etop.xunfang.modules.mapper.PermissionMapperGenerate;
import team.etop.xunfang.modules.service.PermissionServiceGenerate;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import team.etop.xunfang.modules.service.RoleServiceGenerate;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ZTF
 * @since 2017-09-08
 */
@Service
public class PermissionServiceImplGenerate extends ServiceImpl<PermissionMapperGenerate, Permission> implements PermissionServiceGenerate {

    @Autowired
    PermissionServiceGenerate permissionServiceGenerate;
    @Autowired
    RoleServiceGenerate roleServiceGenerate;
    public List<PermissionTree> getAllZtree(){
        EntityWrapper<Permission> wrapper=new EntityWrapper<>();
        wrapper.eq("status",1);
        List<Permission> permissions=permissionServiceGenerate.selectList(wrapper);
        List<PermissionTree> treeList=new ArrayList<>();
        for (Permission permission : permissions) {
            if (permission.getIsMenu() == 1) {
                PermissionTree permissionTree = new PermissionTree();
                permissionTree.setPermissionMenu(permission);
                treeList.add(permissionTree);
            }
        }
        for (Permission permission : permissions) {
            PermissionTree permissionTree = new PermissionTree();
            permissionTree.setPermissionTree(permission);
//             if ((rolePermissions.contains(String.valueOf(permission.getId()))) && (permission.getIsMenu() == 0)) {
//                 permissionTree.setChecked(true);
//
//             }
            if (permission.getIsMenu() == 0) {
                treeList.add(permissionTree);
            }
        }

        return treeList;


    }

    @Override
    public List<PermissionTree> getTreeByRoleId(Long id) {
        String rolePermissionString=roleServiceGenerate.selectById(id).getPermissions();
        EntityWrapper<Permission> wrapper=new EntityWrapper<>();
        wrapper.eq("status",1);
        List<Permission> permissionList=permissionServiceGenerate.selectList(wrapper);

        List<PermissionTree> treeList=new ArrayList<>();
        if(rolePermissionString!=null) {
            for (Permission permission : permissionList) {
                if (rolePermissionString.contains(String.valueOf(permission.getId()))&&permission.getIsMenu()==1) {
                    PermissionTree permissionTree = new PermissionTree();
                    permissionTree.setPermissionMenu(permission);
                    treeList.add(permissionTree);
                }
            }
            for (Permission permission : permissionList) {
                if (rolePermissionString.contains(String.valueOf(permission.getId()))&&permission.getIsMenu()==0) {
                    PermissionTree permissionTree = new PermissionTree();
                    permissionTree.setPermissionTree(permission);
                    treeList.add(permissionTree);
                }
            }
        }
        return treeList;
    }
}
