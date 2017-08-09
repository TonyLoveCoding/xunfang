package team.etop.xunfang.modules.po;

import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ZTF
 * @since 2017-08-09
 */
public class Dic extends Model<Dic> {

    private static final long serialVersionUID = 1L;

	private String id;
	private String code;
	private String name;
	private Integer weight;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Dic{" +
			"id=" + id +
			", code=" + code +
			", name=" + name +
			", weight=" + weight +
			"}";
	}
}
