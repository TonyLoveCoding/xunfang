package team.etop.xunfang.common.bean;

import com.baomidou.mybatisplus.annotations.TableField;
import team.etop.xunfang.modules.po.Permission;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ZYZ on 2017/9/8
 * In order to resolve data type mismatch

 */
public class PermissionJson {
    private String id;
    private String name;
    private String description;
    private Integer isMenu;
    private String url;
    private Long parentId;
    private String ico;
    private String updatetime;
    private String createtime;
    private Integer status;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");


    public PermissionJson(Permission permission){
        this.id=String.valueOf(permission.getId());
        this.name=permission.getName();
        this.description=permission.getDescription();
        this.isMenu=permission.getIsMenu();
        this.url=permission.getUrl();
        this.parentId=permission.getParentId();
        this.ico=permission.getIco();
        this.createtime=dateFormat.format(permission.getCreatetime());
        this.updatetime=dateFormat.format(permission.getUpdatetime());
        this.status=permission.getStatus();

    }


    public String getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = String.valueOf(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(Integer isMenu) {
        this.isMenu = isMenu;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico;
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
        return "Permission{" +
                "id=" + id +
                ", name=" + name +
                ", description=" + description +
                ", isMenu=" + isMenu +
                ", url=" + url +
                ", parentId=" + parentId +
                ", ico=" + ico +
                ", updatetime=" + updatetime +
                ", createtime=" + createtime +
                ", status=" + status +
                "}";
    }
}
