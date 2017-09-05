package team.etop.xunfang.common.bean;


import team.etop.xunfang.modules.po.Permission;

/**
 * Created by ZYZ on 2017/8/24
 */
public class PermissionTree {
    Long  id;
    Long pId;
    String name;
    Boolean checked;
    Boolean open;

    public void setPermissionTree(Permission permission){
        this.id=permission.getId();
        this.pId=permission.getParentId();
        this.name=permission.getName();
        this.open=false;
        this.checked=false;
    }
    public void setPermissionMenu(Permission permission){
        this.id=permission.getId();
        this.pId=permission.getParentId();
        this.name=permission.getName();
        this.checked=null;
        this.open=true;

    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }


    public PermissionTree(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PermissionTree{" +
                "id=" + id +
                ", pId=" + pId +
                ", name='" + name + '\'' +
                ", checked=" + checked +
                ", open=" + open +
                '}';
    }
}
