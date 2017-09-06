package team.etop.xunfang.modules.po;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ZTF
 * @since 2017-09-06
 */
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

	private Long id;
	private String account;
	private String password;
	private String username;
	@TableField("estates_relevance")
	private String estatesRelevance;
	@TableField("roles_relevance")
	private String rolesRelevance;
	private Date updatetime;
	private Date createtime;
	private Integer status;


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

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
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
