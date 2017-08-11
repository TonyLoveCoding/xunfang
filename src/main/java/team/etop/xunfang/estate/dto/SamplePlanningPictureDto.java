package team.etop.xunfang.estate.dto;

/**
 * Created by asus on 2017/8/9.
 */
public class SamplePlanningPictureDto {

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
        return "SamplePlanningPictureDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
