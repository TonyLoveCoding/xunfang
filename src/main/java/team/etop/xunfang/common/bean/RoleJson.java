package team.etop.xunfang.common.bean;

import team.etop.xunfang.modules.po.Role;

/**
 * Created by ZYZ on 2017/8/14
 */
public class RoleJson {
   private Role role;
   public boolean isExist= false;

    public Role getRole() {
        return role;
    }
    public void setRole(Role role){
        this.role=role;
    }
    public void setExist(boolean isExist){
        this.isExist=isExist;
    }
    public boolean getIsExit(){
        return isExist;
    }
    
}
