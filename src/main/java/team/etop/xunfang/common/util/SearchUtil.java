package team.etop.xunfang.common.util;

import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.web.servlet.ModelAndView;
import team.etop.xunfang.modules.po.Dic;
import team.etop.xunfang.search.bo.EstateSearchBo;
import team.etop.xunfang.search.bo.HomeEstateBo;
import team.etop.xunfang.search.bo.RecommendEstateBo;
import team.etop.xunfang.search.dto.SearchPageMsg;
import team.etop.xunfang.search.service.DicService;

import java.util.*;

/**
 * @version V1.0
 * @Description:工具类-搜索模块
 * @author: TingFeng Zhang
 * @date: 2017/8/14 0:00
 */
public class SearchUtil {

    public static RecommendEstateBo DocToRecommendEstate(SolrDocument solrDocument, String serverAddress) {
        RecommendEstateBo recommendEstateBo = new RecommendEstateBo();
        recommendEstateBo.setId(Long.valueOf(solrDocument.get("id").toString()));
        recommendEstateBo.setDeveloperQuotes(Integer.valueOf(solrDocument.get("estate_developer_quotes").toString()));
        recommendEstateBo.setHouseType(solrDocument.get("estate_house_type").toString());
        recommendEstateBo.setEstateName(solrDocument.get("estate_name").toString());
        recommendEstateBo.setEstateAddress(solrDocument.get("estate_address").toString());
        recommendEstateBo.setThumbnail(solrDocument.get("estate_thumbnail").toString());
        recommendEstateBo.setEstateDetailsURL(serverAddress + recommendEstateBo.getId());
        return recommendEstateBo;
    }

    public static HomeEstateBo DocToHomeEstate(SolrDocument solrDocument, String serverAddress) {
        HomeEstateBo homeEstateBo = new HomeEstateBo();
        homeEstateBo.setId(Long.valueOf(solrDocument.get("id").toString()));
        //TODO
        homeEstateBo.setEstateDetailsURL("http://othgjp7hs.bkt.clouddn.com/17-8-14/91109352.jpg");
//        homeEstateBo.setEstateDetailsURL(serverAddress + solrDocument.get("estate_thumbnail").toString());
        homeEstateBo.setArea(Float.valueOf(solrDocument.get("estate_area").toString()));
        homeEstateBo.setEstateName(solrDocument.get("estate_name").toString());
        homeEstateBo.setLocation(solrDocument.get("estate_location").toString());
        homeEstateBo.setMaxPrice(Integer.valueOf(solrDocument.get("estate_max_price").toString()));
        homeEstateBo.setMinPrice(Integer.valueOf(solrDocument.get("estate_min_price").toString()));
        return homeEstateBo;
    }

    public static EstateSearchBo DocToEstateSearchBean(SolrDocument solrDocument, String serverAddress, Map<String, Map<String, List<String>>> highlighting) {
        EstateSearchBo estateSearchBo = new EstateSearchBo();
        estateSearchBo.setId(Long.valueOf(solrDocument.get("id").toString()));
        estateSearchBo.setVisitTimes(Long.valueOf(solrDocument.get("estate_visit_times").toString()));
        estateSearchBo.setMinPrice(Integer.valueOf(solrDocument.get("estate_min_price").toString()));
        estateSearchBo.setMaxPrice(Integer.valueOf(solrDocument.get("estate_max_price").toString()));
        estateSearchBo.setDeveloperQuotes(Integer.valueOf(solrDocument.get("estate_developer_quotes").toString()));
        estateSearchBo.setLocation(solrDocument.get("estate_location").toString());
        estateSearchBo.setType(solrDocument.get("estate_type").toString());
        estateSearchBo.setHouseType(solrDocument.get("estate_house_type").toString());
        estateSearchBo.setFeature(solrDocument.get("estate_feature").toString());
        estateSearchBo.setUpdateTime((Date) solrDocument.get("estate_update_time"));
        estateSearchBo.setCreateTime((Date) solrDocument.get("estate_create_time"));
        estateSearchBo.setThumbnail(solrDocument.get("estate_thumbnail").toString());
        estateSearchBo.setSaleStatus(Boolean.valueOf(solrDocument.get("estate_sale_status").toString()));
        estateSearchBo.setSign(solrDocument.get("estate_sign").toString());
        estateSearchBo.setTurnover(Long.valueOf(solrDocument.get("estate_turnover").toString()));
        estateSearchBo.setEstateDetailsURL(serverAddress + solrDocument.get("id").toString());
        estateSearchBo.setArea(Float.valueOf(solrDocument.get("estate_area").toString()));
        if (highlighting != null) {
            Map<String, List<String>> map = highlighting.get(solrDocument.get("id").toString());
            if (map.get("estate_name") != null) {
                String estate_name = map.get("estate_name").toString();
                String substring = estate_name.substring(1, estate_name.length() - 1);
                estateSearchBo.setEstateName(substring);
            } else {
                estateSearchBo.setEstateName(solrDocument.get("estate_name").toString());
            }
            if (map.get("estate_address") != null) {
                String estate_address = map.get("estate_address").toString();
                String substring = estate_address.substring(1, estate_address.length() - 1);
                estateSearchBo.setEstateAddress(substring);
            } else {
                estateSearchBo.setEstateAddress(solrDocument.get("estate_address").toString());
            }

        } else {
            estateSearchBo.setEstateName(solrDocument.get("estate_name").toString());
            estateSearchBo.setEstateAddress(solrDocument.get("estate_address").toString());
        }
        return estateSearchBo;
    }

    public static SolrInputDocument EstateToDoc(EstateSearchBo estateSearchBo) {
        SolrInputDocument solrInputFields = new SolrInputDocument();
        solrInputFields.addField("id", estateSearchBo.getId());
        solrInputFields.addField("estate_visit_times", estateSearchBo.getVisitTimes());
        solrInputFields.addField("estate_min_price", estateSearchBo.getMinPrice());
        solrInputFields.addField("estate_max_price", estateSearchBo.getMaxPrice());
        solrInputFields.addField("estate_developer_quotes", estateSearchBo.getDeveloperQuotes());
        solrInputFields.addField("estate_location", estateSearchBo.getLocation());
        solrInputFields.addField("estate_type", estateSearchBo.getType());
        solrInputFields.addField("estate_house_type", estateSearchBo.getHouseType());
        solrInputFields.addField("estate_area", estateSearchBo.getArea());
        solrInputFields.addField("estate_feature", estateSearchBo.getFeature());
        solrInputFields.addField("estate_name", estateSearchBo.getEstateName());
        solrInputFields.addField("estate_address", estateSearchBo.getEstateAddress());
        solrInputFields.addField("estate_update_time", estateSearchBo.getUpdateTime());
        solrInputFields.addField("estate_create_time", estateSearchBo.getCreateTime());
        solrInputFields.addField("estate_thumbnail", estateSearchBo.getThumbnail());
        solrInputFields.addField("estate_sale_status", estateSearchBo.getSaleStatus());
        solrInputFields.addField("estate_sign", estateSearchBo.getSign());
        solrInputFields.addField("estate_turnover", estateSearchBo.getTurnover());

        return solrInputFields;
    }

    public static SearchPageMsg GetPage(Long pn, Long numFound, Integer shownum, String keyWord, String saleStatus, String location, String totalPrices, String type, String houseType, String feature, String unitPrice, String area,String sort,String sortType) {
        Long pageNumber = numFound / shownum;
        if (numFound % shownum > 0) {
            pageNumber++;
        }
        return new SearchPageMsg(pageNumber, pn, shownum, keyWord, numFound, saleStatus, location, totalPrices, type, houseType, feature, unitPrice, area,sort,sortType);
    }

    public static void AddType(ModelAndView modelAndView, DicService dicService) throws Exception{
        List<Dic> location = dicService.selectByType("location");
        List<Dic> feature = dicService.selectByType("feature");
        List<Dic> houseType = dicService.selectByType("houseType");
        List<Dic> type = dicService.selectByType("type");
        List<Dic> total_prices = dicService.selectByType("total_prices");
        List<Dic> unit_price = dicService.selectByType("unit_price");
        List<Dic> area = dicService.selectByType("area");
        modelAndView.addObject("locations", location);
        modelAndView.addObject("features", feature);
        modelAndView.addObject("houseTypes", houseType);
        modelAndView.addObject("types", type);
        modelAndView.addObject("total_pricess", total_prices);
        modelAndView.addObject("unit_prices", unit_price);
        modelAndView.addObject("areas", area);
    }

}
