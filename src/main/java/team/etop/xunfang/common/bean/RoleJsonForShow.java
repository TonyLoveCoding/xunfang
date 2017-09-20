package team.etop.xunfang.common.bean;

import team.etop.xunfang.modules.po.Role;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ZYZ on 2017/9/19
 */
public class RoleJsonForShow {

    private String id;
    private String rolename;
    private String description;
    private String permissions;
    private String updatetime;
    private String createtime;
    private Integer status;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");



    public RoleJsonForShow(Role role){
        this.id=String.valueOf(role.getId());
        this.createtime=dateFormat.format(role.getCreatetime());
        this.updatetime=dateFormat.format(role.getUpdatetime());
        this.status=role.getStatus();
        this.rolename=role.getRoleName();
        this.description=role.getDescription();
        this.permissions=role.getPermissions();

    }
    public String getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = String.valueOf(id);
    }

    public String getRoleName() {
        return rolename;
    }

    public void setRoleName(String roleName) {
        this.rolename = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = dateFormat.format(updatetime);
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = dateFormat.format(createtime);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName=" + rolename +
                ", description=" + description +
                ", permissions=" + permissions +
                ", updatetime=" + updatetime +
                ", createtime=" + createtime +
                ", status=" + status +
                "}";
    }
}
