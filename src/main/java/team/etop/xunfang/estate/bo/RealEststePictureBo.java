package team.etop.xunfang.estate.bo;

/**
 * Created by asus on 2017/8/9.
 */
public class RealEststePictureBo {

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
    public String toString() {
        return "RealEststePictureBo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
