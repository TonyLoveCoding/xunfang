package team.etop.xunfang.common.util;

import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.web.servlet.ModelAndView;
import team.etop.xunfang.modules.po.Dic;
import team.etop.xunfang.search.bo.EstateSearchBean;
import team.etop.xunfang.search.bo.RecommendEstate;
import team.etop.xunfang.search.dto.SearchPageMsg;
import team.etop.xunfang.search.service.DicService;

import java.util.*;

/**
 * @version V1.0
 * @Description:
 * @author: TingFeng Zhang
 * @date: 2017/8/14 0:00
 */
public class SearchUtil {

    public static RecommendEstate DocToRecommendEstate(SolrDocument solrDocument, String serverAddress) {
        RecommendEstate recommendEstate = new RecommendEstate();
        recommendEstate.setId(Long.valueOf(solrDocument.get("id").toString()));
        recommendEstate.setDeveloperQuotes(Integer.valueOf(solrDocument.get("estate_developer_quotes").toString()));
        recommendEstate.setHouseType(solrDocument.get("estate_house_type").toString());
        recommendEstate.setEstateName(solrDocument.get("estate_name").toString());
        recommendEstate.setEstateAddress(solrDocument.get("estate_address").toString());
        recommendEstate.setThumbnail(solrDocument.get("estate_thumbnail").toString());
        recommendEstate.setEstateDetailsURL(serverAddress + recommendEstate.getId());
        return recommendEstate;
    }

    public static EstateSearchBean DocToEstateSearchBean(SolrDocument solrDocument, String serverAddress, Map<String, Map<String, List<String>>> highlighting) {
        EstateSearchBean estateSearchBean = new EstateSearchBean();
        estateSearchBean.setId(Long.valueOf(solrDocument.get("id").toString()));
        estateSearchBean.setVisitTimes(Long.valueOf(solrDocument.get("estate_visit_times").toString()));
        estateSearchBean.setMinPrice(Integer.valueOf(solrDocument.get("estate_min_price").toString()));
        estateSearchBean.setMaxPrice(Integer.valueOf(solrDocument.get("estate_max_price").toString()));
        estateSearchBean.setDeveloperQuotes(Integer.valueOf(solrDocument.get("estate_developer_quotes").toString()));
        estateSearchBean.setLocation(solrDocument.get("estate_location").toString());
        estateSearchBean.setType(solrDocument.get("estate_type").toString());
        estateSearchBean.setHouseType(solrDocument.get("estate_house_type").toString());
        estateSearchBean.setFeature(solrDocument.get("estate_feature").toString());
        estateSearchBean.setUpdateTime((Date) solrDocument.get("estate_update_time"));
        estateSearchBean.setCreateTime((Date) solrDocument.get("estate_create_time"));
        estateSearchBean.setThumbnail(solrDocument.get("estate_thumbnail").toString());
        estateSearchBean.setSaleStatus(Boolean.valueOf(solrDocument.get("estate_sale_status").toString()));
        estateSearchBean.setSign(solrDocument.get("estate_sign").toString());
        estateSearchBean.setTurnover(Long.valueOf(solrDocument.get("estate_turnover").toString()));
        estateSearchBean.setEstateDetailsURL(serverAddress + estateSearchBean.getId());
        estateSearchBean.setArea(Float.valueOf(solrDocument.get("estate_area").toString()));
        if (highlighting != null) {
            Map<String, List<String>> map = highlighting.get(solrDocument.get("id").toString());
            if (map.get("estate_name") != null) {
                String estate_name = map.get("estate_name").toString();
                String substring = estate_name.substring(1, estate_name.length() - 1);
                estateSearchBean.setEstateName(substring);
            } else {
                estateSearchBean.setEstateName(solrDocument.get("estate_name").toString());
            }
            if (map.get("estate_address") != null) {
                String estate_address = map.get("estate_address").toString();
                String substring = estate_address.substring(1, estate_address.length() - 1);
                estateSearchBean.setEstateAddress(substring);
            } else {
                estateSearchBean.setEstateAddress(solrDocument.get("estate_address").toString());
            }

        } else {
            estateSearchBean.setEstateName(solrDocument.get("estate_name").toString());
            estateSearchBean.setEstateAddress(solrDocument.get("estate_address").toString());
        }
        return estateSearchBean;
    }

    public static SolrInputDocument EstateToDoc(EstateSearchBean estateSearchBean) {
        SolrInputDocument solrInputFields = new SolrInputDocument();
        solrInputFields.addField("id", estateSearchBean.getId());
        solrInputFields.addField("estate_visit_times", estateSearchBean.getVisitTimes());
        solrInputFields.addField("estate_min_price", estateSearchBean.getMinPrice());
        solrInputFields.addField("estate_max_price", estateSearchBean.getMaxPrice());
        solrInputFields.addField("estate_developer_quotes", estateSearchBean.getDeveloperQuotes());
        solrInputFields.addField("estate_location", estateSearchBean.getLocation());
        solrInputFields.addField("estate_type", estateSearchBean.getType());
        solrInputFields.addField("estate_house_type", estateSearchBean.getHouseType());
        solrInputFields.addField("estate_feature", estateSearchBean.getFeature());
        solrInputFields.addField("estate_name", estateSearchBean.getEstateName());
        solrInputFields.addField("estate_address", estateSearchBean.getEstateAddress());
        solrInputFields.addField("estate_update_time", estateSearchBean.getUpdateTime());
        solrInputFields.addField("estate_create_time", estateSearchBean.getCreateTime());
        solrInputFields.addField("estate_thumbnail", estateSearchBean.getThumbnail());
        solrInputFields.addField("estate_sale_status", estateSearchBean.getSaleStatus());
        solrInputFields.addField("estate_sign", estateSearchBean.getSign());
        solrInputFields.addField("estate_turnover", estateSearchBean.getTurnover());
        solrInputFields.addField("estate_area", estateSearchBean.getArea());
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
