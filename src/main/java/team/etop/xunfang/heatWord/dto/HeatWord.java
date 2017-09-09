package team.etop.xunfang.heatWord.dto;

/**
 * @version V1.0
 * @Description:
 * @author: TingFeng Zhang
 * @date: 14:53
 */
public class HeatWord {
    private String id;
    private String word;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public HeatWord(String id, String word) {
        this.id = id;
        this.word = word;
    }
}
