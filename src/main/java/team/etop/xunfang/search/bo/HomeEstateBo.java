package team.etop.xunfang.search.bo;

/**
 * 前台主页推荐楼盘、最新楼盘Bo
 */
public class HomeEstateBo {
    private Long id;
    private String estateName;
    private String location;
    private Float area;
    private Integer minPrice;
    private Integer maxPrice;
    private String estateDetailsURL;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstateName() {
        return estateName;
    }

    public void setEstateName(String estateName) {
        this.estateName = estateName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
        this.area = area;
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    public Integer getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Integer maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getEstateDetailsURL() {
        return estateDetailsURL;
    }

    public void setEstateDetailsURL(String estateDetailsURL) {
        this.estateDetailsURL = estateDetailsURL;
    }

    @Override
    public String toString() {
        return "HomeEstateBo{" +
                "id=" + id +
                ", estateName='" + estateName + '\'' +
                ", location='" + location + '\'' +
                ", area=" + area +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                ", estateDetailsURL='" + estateDetailsURL + '\'' +
                '}';
    }
}
