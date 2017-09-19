//package team.etop.xunfang.common.util;
//
//import org.apache.solr.common.SolrInputDocument;
//import team.etop.xunfang.modules.po.Estate;
//import team.etop.xunfang.search.bo.EstateSearchBean;
//
///**
// * @version V1.0
// * @Description:
// * @author: TingFeng Zhang
// * @date: 2017/8/14 0:00
// */
//public class SearchUtil {
//    public static SolrInputDocument EstateToDoc(EstateSearchBean estateSearchBean){
//        SolrInputDocument solrInputFields=new SolrInputDocument();
//        solrInputFields.addField("id",estateSearchBean.getId());
//        solrInputFields.addField("estate_visit_times",estateSearchBean.getVisitTimes());
//        solrInputFields.addField("estate_min_price",estateSearchBean.getMinPrice());
//        solrInputFields.addField("estate_max_price",estateSearchBean.getMaxPrice());
//        solrInputFields.addField("estate_developer_quotes",estateSearchBean.getDeveloperQuotes());
//        solrInputFields.addField("estate_location",estateSearchBean.getLocation());
//        solrInputFields.addField("estate_type",estateSearchBean.getType());
//        solrInputFields.addField("estate_house_type",estateSearchBean.getHouseType());
//        solrInputFields.addField("estate_feature",estateSearchBean.getFeature());
//        solrInputFields.addField("estate_name",estateSearchBean.getEstateName());
//        solrInputFields.addField("estate_address",estateSearchBean.getEstateAddress());
//        solrInputFields.addField("estate_update_time",estateSearchBean.getUpdateTime());
//        solrInputFields.addField("estate_create_time",estateSearchBean.getCreateTime());
//        solrInputFields.addField("estate_thumbnail",estateSearchBean.getThumbnail());
//        solrInputFields.addField("estate_status",estateSearchBean.getStatus());
//        solrInputFields.addField("estate_sale_status",estateSearchBean.getSaleStatus());
//        return solrInputFields;
//    }
//}
