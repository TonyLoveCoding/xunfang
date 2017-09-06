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
 * @since 2017-09-06
 */
@TableName("prototype_room_picture")
public class PrototypeRoomPicture extends Model<PrototypeRoomPicture> {

    private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private Long weight;


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

	public Long getWeight() {
		return weight;
	}

	public void setWeight(Long weight) {
		this.weight = weight;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "PrototypeRoomPicture{" +
			"id=" + id +
			", name=" + name +
			", weight=" + weight +
			"}";
	}
}
