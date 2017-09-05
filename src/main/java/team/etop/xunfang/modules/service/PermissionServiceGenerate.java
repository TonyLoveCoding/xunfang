package team.etop.xunfang.modules.service;

import team.etop.xunfang.common.bean.PermissionTree;
import team.etop.xunfang.modules.po.Permission;
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
public interface PermissionServiceGenerate extends IService<Permission> {
    public List<PermissionTree> getAllZtree(Long id);
    public List<PermissionTree> getTreeByRoleId(Long id);


	
}
