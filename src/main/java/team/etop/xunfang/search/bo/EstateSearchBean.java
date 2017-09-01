package team.etop.xunfang.search.bo;

import com.baomidou.mybatisplus.annotations.TableField;

import java.util.Date;

/**
 * @version V1.0
 * @Description:
 * @author: TingFeng Zhang
 * @date: 2017/8/13 20:11
 */
public class  EstateSearchBean {
    private Long id;
    @TableField("visit_times")
    private Long visitTimes;
    @TableField("min_price")
    private Integer minPrice;
    @TableField("max_price")
    private Integer maxPrice;
    @TableField("developer_quotes")
    private Integer developerQuotes;
    private String location;
    private String type;
    @TableField("house_type")
    private String houseType;
    private String feature;
    @TableField("estate_name")
    private String estateName;
    @TableField("estate_address")
    private String estateAddress;
    @TableField("sale_status")
    private Boolean saleStatus;
    @TableField("update_time")
    private Date updateTime;
    @TableField("create_time")
    private Date createTime;
    private Float area;
    private String thumbnail;
    private String sign;
    private Long turnover;
    private String estateDetailsURL;

    public String getEstateDetailsURL() {
        return estateDetailsURL;
    }

    public void setEstateDetailsURL(String estateDetailsURL) {
        this.estateDetailsURL = estateDetailsURL;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Long getTurnover() {
        return turnover;
    }

    public void setTurnover(Long turnover) {
        this.turnover = turnover;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVisitTimes() {
        return visitTimes;
    }

    public void setVisitTimes(Long visitTimes) {
        this.visitTimes = visitTimes;
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

    public Integer getDeveloperQuotes() {
        return developerQuotes;
    }

    public void setDeveloperQuotes(Integer developerQuotes) {
        this.developerQuotes = developerQuotes;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getEstateName() {
        return estateName;
    }

    public void setEstateName(String estateName) {
        this.estateName = estateName;
    }

    public String getEstateAddress() {
        return estateAddress;
    }

    public void setEstateAddress(String estateAddress) {
        this.estateAddress = estateAddress;
    }

    public Boolean getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(Boolean saleStatus) {
        this.saleStatus = saleStatus;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
        this.area = area;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "EstateSearchBean{" +
                "id=" + id +
                ", visitTimes=" + visitTimes +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                ", developerQuotes=" + developerQuotes +
                ", location='" + location + '\'' +
                ", type='" + type + '\'' +
                ", houseType='" + houseType + '\'' +
                ", feature='" + feature + '\'' +
                ", estateName='" + estateName + '\'' +
                ", estateAddress='" + estateAddress + '\'' +
                ", saleStatus=" + saleStatus +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                ", area=" + area +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }
}
