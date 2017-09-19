package team.etop.xunfang.carouselPhotos.dto;

import java.util.Date;

/**
 * Created by asus on 2017/8/9.
 */
public class CarouselPhotosDto {
    private Long id;
    private String name;
    private String url;
    private Integer status;
    private Long weight;
    private Date updatetime;
    private Date createtime;

    public CarouselPhotosDto(Long id, String name, String url, Integer status) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.status = status;
    }

    public CarouselPhotosDto(String name, String url, Integer status) {
        this.name = name;
        this.url = url;
        this.status = status;
    }

    public CarouselPhotosDto() {
    }

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public Long getWeight() {
        return weight;
    }

    @Override
    public void setWeight(Long weight) {
        this.weight = weight;
    }

    @Override
    public Long getWeight() {
        return weight;
    }

    @Override
    public void setWeight(Long weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "CarouselPhotosDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", status=" + status +
                ", updatetime=" + updatetime +
                ", createtime=" + createtime +
                '}';
    }
}
