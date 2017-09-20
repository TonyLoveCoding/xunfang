package team.etop.xunfang.common.bean;

import team.etop.xunfang.modules.po.Role;

/**
 * Created by ZYZ on 2017/8/14
 */
public class RoleJson {
    Role role;
    Boolean exist;

    public Boolean getExist() {
        return exist;
    }

    public void setExist(Boolean exist) {
        this.exist = exist;
    }

    public Role getRole() {
        return role;
    }
    public void setRole(Role role){
        this.role=role;
    }
    
}
