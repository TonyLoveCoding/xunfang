package team.etop.xunfang.estate.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * Created by asus on 2017/8/9.
 */
public class EstateDto {
    private Long id;
    private Integer status;//状态
    private Long visitTimes;//访问次数
    private Integer minPrice;//最低价
    private Integer maxPrice;//最高价
    private Integer developerQuotes;//开发商报价
    private String location;//位置
    private String type;//建筑类型
    private String houseType;//户型
    private String feature;//特点
    private String samplePlate;//样板规划图
    private String liveAction;//楼盘实景图
    private String prototypeRoom;//样板间图
    private String effectivePhotos;//效果图
    private String estateName;//楼盘名称
    private String estateAddress;//楼盘地址
    private String property;//物业类型
    private String developer;//开发商
    private Integer saleStatus;//销售状态
    private String firstDelivery;//最早交房
    private String latestOpening;//最新开盘
    private String propertyRights;//产权年限
    private String takeTime;//拿地时间
    private String company;//物业公司
    private String propertyCost;//物业费用
    private String powerType;//水电燃气
    private Float greenRate;//绿化率
    private String parkingSpaces;//车位情况
    private String decoration;//装修情况
    private String estateInformation;//楼栋信息
    private Date updateTime;//最后修改时间
    private Date createTime;//创建时间
    private Float plotRatio;//容积率
    private Float area;//面积
    private List<EffectPictureDto> effectPictureDtoList;
    private List<PrototypeRoomPictureDto> prototypeRoomPictureDtoList;
    private List<RealEststePictureDto> realEststePictureDtoList;
    private List<SamplePlanningPictureDto> samplePlanningPictureDtoList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getSamplePlate() {
        return samplePlate;
    }

    public void setSamplePlate(String samplePlate) {
        this.samplePlate = samplePlate;
    }

    public String getLiveAction() {
        return liveAction;
    }

    public void setLiveAction(String liveAction) {
        this.liveAction = liveAction;
    }

    public String getPrototypeRoom() {
        return prototypeRoom;
    }

    public void setPrototypeRoom(String prototypeRoom) {
        this.prototypeRoom = prototypeRoom;
    }

    public String getEffectivePhotos() {
        return effectivePhotos;
    }

    public void setEffectivePhotos(String effectivePhotos) {
        this.effectivePhotos = effectivePhotos;
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

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public Integer getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(Integer saleStatus) {
        this.saleStatus = saleStatus;
    }

    public String getFirstDelivery() {
        return firstDelivery;
    }

    public void setFirstDelivery(String firstDelivery) {
        this.firstDelivery = firstDelivery;
    }

    public String getLatestOpening() {
        return latestOpening;
    }

    public void setLatestOpening(String latestOpening) {
        this.latestOpening = latestOpening;
    }

    public String getPropertyRights() {
        return propertyRights;
    }

    public void setPropertyRights(String propertyRights) {
        this.propertyRights = propertyRights;
    }

    public String getTakeTime() {
        return takeTime;
    }

    public void setTakeTime(String takeTime) {
        this.takeTime = takeTime;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPropertyCost() {
        return propertyCost;
    }

    public void setPropertyCost(String propertyCost) {
        this.propertyCost = propertyCost;
    }

    public String getPowerType() {
        return powerType;
    }

    public void setPowerType(String powerType) {
        this.powerType = powerType;
    }

    public Float getGreenRate() {
        return greenRate;
    }

    public void setGreenRate(Float greenRate) {
        this.greenRate = greenRate;
    }

    public String getParkingSpaces() {
        return parkingSpaces;
    }

    public void setParkingSpaces(String parkingSpaces) {
        this.parkingSpaces = parkingSpaces;
    }

    public String getDecoration() {
        return decoration;
    }

    public void setDecoration(String decoration) {
        this.decoration = decoration;
    }

    public String getEstateInformation() {
        return estateInformation;
    }

    public void setEstateInformation(String estateInformation) {
        this.estateInformation = estateInformation;
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

    public Float getPlotRatio() {
        return plotRatio;
    }

    public void setPlotRatio(Float plotRatio) {
        this.plotRatio = plotRatio;
    }

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
        this.area = area;
    }

    public List<EffectPictureDto> getEffectPictureDtoList() {
        return effectPictureDtoList;
    }

    public void setEffectPictureDtoList(List<EffectPictureDto> effectPictureDtoList) {
        this.effectPictureDtoList = effectPictureDtoList;
    }

    public List<PrototypeRoomPictureDto> getPrototypeRoomPictureDtoList() {
        return prototypeRoomPictureDtoList;
    }

    public void setPrototypeRoomPictureDtoList(List<PrototypeRoomPictureDto> prototypeRoomPictureDtoList) {
        this.prototypeRoomPictureDtoList = prototypeRoomPictureDtoList;
    }

    public List<RealEststePictureDto> getRealEststePictureDtoList() {
        return realEststePictureDtoList;
    }

    public void setRealEststePictureDtoList(List<RealEststePictureDto> realEststePictureDtoList) {
        this.realEststePictureDtoList = realEststePictureDtoList;
    }

    public List<SamplePlanningPictureDto> getSamplePlanningPictureDtoList() {
        return samplePlanningPictureDtoList;
    }

    public void setSamplePlanningPictureDtoList(List<SamplePlanningPictureDto> samplePlanningPictureDtoList) {
        this.samplePlanningPictureDtoList = samplePlanningPictureDtoList;
    }

    @Override
    public String toString() {
        return "EstateDto{" +
                "id=" + id +
                ", status=" + status +
                ", visitTimes=" + visitTimes +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                ", developerQuotes=" + developerQuotes +
                ", location='" + location + '\'' +
                ", type='" + type + '\'' +
                ", houseType='" + houseType + '\'' +
                ", feature='" + feature + '\'' +
                ", samplePlate='" + samplePlate + '\'' +
                ", liveAction='" + liveAction + '\'' +
                ", prototypeRoom='" + prototypeRoom + '\'' +
                ", effectivePhotos='" + effectivePhotos + '\'' +
                ", estateName='" + estateName + '\'' +
                ", estateAddress='" + estateAddress + '\'' +
                ", property='" + property + '\'' +
                ", developer='" + developer + '\'' +
                ", saleStatus=" + saleStatus +
                ", firstDelivery=" + firstDelivery +
                ", latestOpening=" + latestOpening +
                ", propertyRights='" + propertyRights + '\'' +
                ", takeTime=" + takeTime +
                ", company='" + company + '\'' +
                ", propertyCost='" + propertyCost + '\'' +
                ", powerType='" + powerType + '\'' +
                ", greenRate=" + greenRate +
                ", parkingSpaces='" + parkingSpaces + '\'' +
                ", decoration='" + decoration + '\'' +
                ", estateInformation='" + estateInformation + '\'' +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                ", plotRatio=" + plotRatio +
                ", area=" + area +
                ", effectPictureDtoList=" + effectPictureDtoList +
                ", prototypeRoomPictureDtoList=" + prototypeRoomPictureDtoList +
                ", realEststePictureDtoList=" + realEststePictureDtoList +
                ", samplePlanningPictureDtoList=" + samplePlanningPictureDtoList +
                '}';
    }
}
