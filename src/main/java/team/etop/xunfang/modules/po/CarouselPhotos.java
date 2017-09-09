package team.etop.xunfang.modules.po;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ZTF
 * @since 2017-08-15
 */
@TableName("carousel_photos")
public class CarouselPhotos extends Model<CarouselPhotos> {

    private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	@TableField("URL")
	private String url;
	private Integer status;
	private Date updatetime;
	private Date createtime;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "CarouselPhotos{" +
			"id=" + id +
			", name=" + name +
			", url=" + url +
			", status=" + status +
			", updatetime=" + updatetime +
			", createtime=" + createtime +
			"}";
	}
}
