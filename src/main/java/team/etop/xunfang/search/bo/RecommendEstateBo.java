package team.etop.xunfang.search.bo;

import com.baomidou.mybatisplus.annotations.TableField;

import java.util.Date;

/**
 * @version V1.0
 * @Description:
 * @author: TingFeng Zhang
 * @date: 2017/8/17 12:24
 */
public class RecommendEstateBo {
    private Long id;
    @TableField("developer_quotes")
    private Integer developerQuotes;
    @TableField("house_type")
    private String houseType;
    @TableField("estate_name")
    private String estateName;
    @TableField("estate_address")
    private String estateAddress;
    private String estateDetailsURL;
    private String thumbnail;

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDeveloperQuotes() {
        return developerQuotes;
    }

    public void setDeveloperQuotes(Integer developerQuotes) {
        this.developerQuotes = developerQuotes;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
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

    public String getEstateDetailsURL() {
        return estateDetailsURL;
    }

    public void setEstateDetailsURL(String estateDetailsURL) {
        this.estateDetailsURL = estateDetailsURL;
    }
}
