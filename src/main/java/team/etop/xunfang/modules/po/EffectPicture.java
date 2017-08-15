package team.etop.xunfang.modules.po;

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
@TableName("effect_picture")
public class EffectPicture extends Model<EffectPicture> {

    private static final long serialVersionUID = 1L;

	private Long id;
	private String name;


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

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "EffectPicture{" +
			"id=" + id +
			", name=" + name +
			"}";
	}
}
