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
 * @since 2017-09-08
 */
@TableName("heat_search_word")
public class HeatSearchWord extends Model<HeatSearchWord> {

    private static final long serialVersionUID = 1L;

	private Long id;
	private String word;
	private Long weight;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Long getWeight() {
		return weight;
	}

	public void setWeight(Long weight) {
		this.weight = weight;
	}

	public HeatSearchWord(Long id, String word, Long weight) {
		this.id = id;
		this.word = word;
		this.weight = weight;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "HeatSearchWord{" +
			"id=" + id +
			", word=" + word +
			", weight=" + weight +
			"}";
	}
}
