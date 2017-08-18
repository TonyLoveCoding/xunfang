package team.etop.xunfang.carouselPhotos.dto;

import com.baomidou.mybatisplus.annotations.TableName;
import team.etop.xunfang.modules.po.CarouselPhotos;

import java.util.Date;

/**
 * Created by asus on 2017/8/9.
 */
@TableName("carousel_photos")
public class CarouselPhotosDto extends CarouselPhotos{
    private Long id;
    private String name;
    private String url;
    private Integer status;
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
