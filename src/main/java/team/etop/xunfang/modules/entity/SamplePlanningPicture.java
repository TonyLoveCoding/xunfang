package team.etop.xunfang.modules.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ZTF
 * @since 2017-08-07
 */
@TableName("sample_planning_picture")
public class SamplePlanningPicture extends Model<SamplePlanningPicture> {

    private static final long serialVersionUID = 1L;

	private Long id;
	private byte[] name;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getName() {
		return name;
	}

	public void setName(byte[] name) {
		this.name = name;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "SamplePlanningPicture{" +
			"id=" + id +
			", name=" + name +
			"}";
	}
}
