package team.etop.xunfang.search.dto;

import team.etop.xunfang.modules.po.Dic;

import java.util.List;
import java.util.Map;

/**
 * @version V1.0
 * @Description:搜索界面传输用DTO
 * @author: TingFeng Zhang
 * @date: 2017/8/17 15:38
 */
public class SearchPageMsg {
    private Long pageNum;
    private Long current;
    private Integer shownum;
    private String keyWord;
    private Long foundNum;
    private String saleStatus;
    private String location;
    private String totalPrices;
    private String type;
    private String houseType;
    private String feature;
    private String unitPrice;
    private String area;
    private String sort;
    private String sortType;

    public SearchPageMsg(Long pageNum, Long current, Integer shownum, String keyWord, Long foundNum, String saleStatus, String location, String totalPrices, String type, String houseType, String feature, String unitPrice, String area, String sort, String sortType) {
        this.pageNum = pageNum;
        this.current = current;
        this.shownum = shownum;
        this.keyWord = keyWord;
        this.foundNum = foundNum;
        this.saleStatus = saleStatus;
        this.location = location;
        this.totalPrices = totalPrices;
        this.type = type;
        this.houseType = houseType;
        this.feature = feature;
        this.unitPrice = unitPrice;
        this.area = area;
        this.sort = sort;
        this.sortType = sortType;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTotalPrices() {
        return totalPrices;
    }

    public void setTotalPrices(String totalPrices) {
        this.totalPrices = totalPrices;
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

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(String saleStatus) {
        this.saleStatus = saleStatus;
    }

    public Long getFoundNum() {
        return foundNum;
    }

    public void setFoundNum(Long foundNum) {
        this.foundNum = foundNum;
    }

    public SearchPageMsg() {
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public Integer getShownum() {
        return shownum;
    }

    public void setShownum(Integer shownum) {
        this.shownum = shownum;
    }

    public Long getPageNum() {
        return pageNum;
    }

    public void setPageNum(Long pageNum) {
        this.pageNum = pageNum;
    }

    public Long getCurrent() {
        return current;
    }

    public void setCurrent(Long current) {
        this.current = current;
    }
}
