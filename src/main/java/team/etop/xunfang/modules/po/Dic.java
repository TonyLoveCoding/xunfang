package team.etop.xunfang.modules.po;

import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ZTF
 * @since 2017-08-13
 */
public class Dic extends Model<Dic> {

    private static final long serialVersionUID = 1L;

	private String type;
	private String code;
	private String name;
	private Integer weight;


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
		return this.type;
	}

	@Override
	public String toString() {
		return "Dic{" +
			"type=" + type +
			", code=" + code +
			", name=" + name +
			", weight=" + weight +
			"}";
	}
}
