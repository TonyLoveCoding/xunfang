package team.etop.xunfang.modules.model;

import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * @version V1.0
 * @Description:
 * @author: TingFeng Zhang
 * @date: 2017/8/3 20:25
 */
@TableName("user")
public class User  implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String account;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
