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
 * @since 2017-08-09
 */
@TableName("prototype_room_picture")
public class PrototypeRoomPicture extends Model<PrototypeRoomPicture> {

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
		return "PrototypeRoomPicture{" +
			"id=" + id +
			", name=" + name +
			"}";
	}
}
