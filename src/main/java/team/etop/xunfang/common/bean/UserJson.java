package team.etop.xunfang.common.bean;

import com.baomidou.mybatisplus.annotations.TableField;
import team.etop.xunfang.modules.po.User;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ZYZ on 2017/9/10
 * In order to resolve data type mismatch
 */
public class UserJson {
    private static final long serialVersionUID = 1L;

    private String id;
    private String account;
    private String password;
    private String username;
    @TableField("estates_relevance")
    private String estatesRelevance;
    @TableField("roles_relevance")
    private String rolesRelevance;
    private String updatetime;
    private String createtime;
    private String status;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");


    public UserJson(User user){

        this.id=String.valueOf(user.getId());
        this.account=user.getAccount();
        this.createtime=dateFormat.format(user.getCreatetime());
        this.estatesRelevance=user.getEstatesRelevance();
        this.password=user.getPassword();
        this.rolesRelevance=user.getRolesRelevance();
        this.updatetime=dateFormat.format(user.getUpdatetime());
        this.status=user.getStatus()==1?"启用":"禁用";
        this.username=user.getUsername();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEstatesRelevance() {
        return estatesRelevance;
    }

    public void setEstatesRelevance(String estatesRelevance) {
        this.estatesRelevance = estatesRelevance;
    }

    public String getRolesRelevance() {
        return rolesRelevance;
    }

    public void setRolesRelevance(String rolesRelevance) {
        this.rolesRelevance = rolesRelevance;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status==1?"启用":"禁用";
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", account=" + account +
                ", password=" + password +
                ", username=" + username +
                ", estatesRelevance=" + estatesRelevance +
                ", rolesRelevance=" + rolesRelevance +
                ", updatetime=" + updatetime +
                ", createtime=" + createtime +
                ", status=" + status +
                "}";
    }
}
