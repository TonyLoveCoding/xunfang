package team.etop.xunfang.modules.po;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ZTF
 * @since 2017-08-13
 */
public class Estate extends Model<Estate> {

    private static final long serialVersionUID = 1L;

	private Long id;
	private Integer status;
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
	@TableField("sample_plate")
	private String samplePlate;
	@TableField("live_action")
	private String liveAction;
	@TableField("prototype_room")
	private String prototypeRoom;
	@TableField("effective_photos")
	private String effectivePhotos;
	@TableField("estate_name")
	private String estateName;
	@TableField("estate_address")
	private String estateAddress;
	private String property;
	private String developer;
	@TableField("sale_status")
	private Integer saleStatus;
	@TableField("first_delivery")
	private Date firstDelivery;
	@TableField("latest_opening")
	private Date latestOpening;
	@TableField("property_rights")
	private String propertyRights;
	@TableField("take_time")
	private Date takeTime;
	private String company;
	@TableField("property_cost")
	private String propertyCost;
	@TableField("power_type")
	private String powerType;
	@TableField("green_rate")
	private Float greenRate;
	@TableField("parking_spaces")
	private String parkingSpaces;
	private String decoration;
	@TableField("estate_information")
	private String estateInformation;
	@TableField("update_time")
	private Date updateTime;
	@TableField("create_time")
	private Date createTime;
	@TableField("plot_ratio")
	private Float plotRatio;
	private Float area;
	private String thumbnail;


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

	public Date getFirstDelivery() {
		return firstDelivery;
	}

	public void setFirstDelivery(Date firstDelivery) {
		this.firstDelivery = firstDelivery;
	}

	public Date getLatestOpening() {
		return latestOpening;
	}

	public void setLatestOpening(Date latestOpening) {
		this.latestOpening = latestOpening;
	}

	public String getPropertyRights() {
		return propertyRights;
	}

	public void setPropertyRights(String propertyRights) {
		this.propertyRights = propertyRights;
	}

	public Date getTakeTime() {
		return takeTime;
	}

	public void setTakeTime(Date takeTime) {
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

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Estate{" +
			"id=" + id +
			", status=" + status +
			", visitTimes=" + visitTimes +
			", minPrice=" + minPrice +
			", maxPrice=" + maxPrice +
			", developerQuotes=" + developerQuotes +
			", location=" + location +
			", type=" + type +
			", houseType=" + houseType +
			", feature=" + feature +
			", samplePlate=" + samplePlate +
			", liveAction=" + liveAction +
			", prototypeRoom=" + prototypeRoom +
			", effectivePhotos=" + effectivePhotos +
			", estateName=" + estateName +
			", estateAddress=" + estateAddress +
			", property=" + property +
			", developer=" + developer +
			", saleStatus=" + saleStatus +
			", firstDelivery=" + firstDelivery +
			", latestOpening=" + latestOpening +
			", propertyRights=" + propertyRights +
			", takeTime=" + takeTime +
			", company=" + company +
			", propertyCost=" + propertyCost +
			", powerType=" + powerType +
			", greenRate=" + greenRate +
			", parkingSpaces=" + parkingSpaces +
			", decoration=" + decoration +
			", estateInformation=" + estateInformation +
			", updateTime=" + updateTime +
			", createTime=" + createTime +
			", plotRatio=" + plotRatio +
			", area=" + area +
			", thumbnail=" + thumbnail +
			"}";
	}
}
