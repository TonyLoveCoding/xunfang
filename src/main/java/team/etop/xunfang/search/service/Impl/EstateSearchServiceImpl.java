package team.etop.xunfang.search.service.Impl;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import team.etop.xunfang.common.util.SearchUtil;
import team.etop.xunfang.search.bo.EstateSearchBean;
import team.etop.xunfang.search.bo.RecommendEstate;
import team.etop.xunfang.search.bo.SearchInfo;
import team.etop.xunfang.search.mapper.EstateSearchMapper;
import team.etop.xunfang.search.service.EstateSearchService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @version V1.0
 * @Description:
 * @author: TingFeng Zhang
 * @date: 2017/8/13 22:49
 */
@Service
public class EstateSearchServiceImpl implements EstateSearchService {

    @Autowired
    EstateSearchMapper estateSearchMapper;

    @Autowired
    SolrClient solrClient;

    @Value("${server.address}")
    String serverAddress;

    @Value("${search.shownum}")
    Integer shownum;


    @Override
    public void fullUpdate() throws Exception {
        solrClient.deleteByQuery("*:*");
//
//        List<EstateSearchBean> estateSearchBeans = estateSearchMapper.selectAll();
//        for(EstateSearchBean estateSearchBean:estateSearchBeans){
//            solrClient.add(SearchUtil.EstateToDoc(estateSearchBean));
//        }
        solrClient.commit();
    }

    @Override
    public SearchInfo search(Long pn, String keyWord, String saleStatus,
                             String location, String totalPrices, String type,
                             String houseType, String feature, String unitPrice,
                             String area,String sort) throws Exception {
        SolrQuery solrQuery = new SolrQuery();
        if ("".equals(keyWord)) {
            solrQuery.setQuery("*:*");
        } else {
            solrQuery.setHighlight(true);
            solrQuery.setQuery("estate_keywords:" + keyWord);
            solrQuery.addHighlightField("estate_address");
            solrQuery.addHighlightField("estate_name");
            solrQuery.setHighlightSimplePre("<span style='color:red'>");
            solrQuery.setHighlightSimplePost("</span>");
        }

        if ("onSale".equals(saleStatus)) {
            solrQuery.set("fq", "estate_sale_status:true");
        } else if ("ForSale".equals(saleStatus)) {
            solrQuery.set("fq", "estate_sale_status:false");
        }

        if (!"none".equals(location)) {
            solrQuery.set("fq", "estate_location:" + location);
        }
        if (!"none".equals(totalPrices)) {
            String replace = totalPrices.replace("infinite", "*").replace("_"," ");
            solrQuery.set("fq", "estate_min_price:["+replace+"]");
        }
        if (!"none".equals(type)) {
            solrQuery.set("fq", "estate_type:" + type);
        }
        if (!"none".equals(houseType)) {
            solrQuery.set("fq", "estate_house_type:" + houseType);
        }
        if (!"none".equals(feature)) {
            solrQuery.set("fq", "estate_feature:" + feature);
        }
        if (!"none".equals(unitPrice)) {
            String replace = unitPrice.replace("infinite", "*").replace("_"," ");
            solrQuery.set("fq", "estate_developer_quotes:[" + replace+"]");
            System.out.println( "estate_area:[" + replace+"]");
        }
        if (!"none".equals(area)) {
            String replace = area.replace("infinite", "*").replace("_"," ");
            solrQuery.set("fq", "estate_area:[" + replace+"]");

        }
        if(!"none".equals(sort)){
            solrQuery.setSort(sort, SolrQuery.ORDER.desc);
        }

        solrQuery.setStart((int) ((pn - 1) * shownum));
        solrQuery.setRows(shownum);
        QueryResponse query = solrClient.query(solrQuery);
        SolrDocumentList results = query.getResults();
        Map<String, Map<String, List<String>>> highlighting = query.getHighlighting();
        List<EstateSearchBean> estateSearchBeans = new ArrayList<>();
        for (SolrDocument document : results) {
            estateSearchBeans.add(SearchUtil.DocToEstateSearchBean(document, serverAddress, highlighting));
        }
        return new SearchInfo(estateSearchBeans, results.getNumFound());
    }

    @Override
    public List<RecommendEstate> getRecommendEstate() throws Exception {
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setStart(0);
        solrQuery.setRows(5);
        solrQuery.setQuery("*:*");
        solrQuery.addSort("estate_visit_times", SolrQuery.ORDER.asc);
        QueryResponse query = solrClient.query(solrQuery);
        SolrDocumentList results = query.getResults();
        List<RecommendEstate> recommendEstates = new ArrayList<>();
        long numFound = results.getNumFound();
        for (SolrDocument document : results) {
            recommendEstates.add(SearchUtil.DocToRecommendEstate(document, serverAddress));
        }
        return recommendEstates;
    }
}
