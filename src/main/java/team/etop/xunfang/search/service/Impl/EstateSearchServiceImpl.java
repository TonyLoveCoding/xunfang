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
import team.etop.xunfang.search.bo.EstateSearchBo;
import team.etop.xunfang.search.bo.HomeEstateBo;
import team.etop.xunfang.search.bo.RecommendEstateBo;
import team.etop.xunfang.search.bo.SearchInfoBo;
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

    /**
     * 搜索层：传入搜索条件进行搜索
     * @param pn 页码
     * @param keyWord 关键词
     * @param saleStatus 销售情况
     * @param location  位置
     * @param totalPrices  总价
     * @param type 类型
     * @param houseType 户型
     * @param feature 特色
     * @param unitPrice 单价
     * @param area 面积
     * @param sort 排序条件
     * @param sortType 排序条件-正反序
     * @return SearchInfoBo
     * @throws Exception
     */
    @Override
    public SearchInfoBo search(Long pn, String keyWord, String saleStatus,
                               String location, String totalPrices, String type,
                               String houseType, String feature, String unitPrice,
                               String area, String sort, String sortType) throws Exception {
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
            solrQuery.add("fq","estate_sale_status:true");
        } else if ("ForSale".equals(saleStatus)) {
            solrQuery.add("fq", "estate_sale_status:false");
        }

        if (!"none".equals(location)) {
            solrQuery.add("fq", "estate_location:" + location);
        }
        if (!"none".equals(totalPrices)) {
            String replace = totalPrices.replace("infinite", "*").replace("_"," ");
            solrQuery.add("fq", "estate_min_price:["+replace+"]");
        }
        if (!"none".equals(type)) {
            solrQuery.add("fq", "estate_type:" + type);
        }
        if (!"none".equals(houseType)) {
            solrQuery.add("fq", "estate_house_type:" + houseType);
        }
        if (!"none".equals(feature)) {
            solrQuery.add("fq", "estate_feature:" + feature);
        }
        if (!"none".equals(unitPrice)) {
            String replace = unitPrice.replace("infinite", "*").replace("_"," ");
            solrQuery.add("fq", "estate_developer_quotes:[" + replace+"]");
        }
        if (!"none".equals(area)) {
            String replace = area.replace("infinite", "*").replace("_"," ");
            solrQuery.add("fq", "estate_area:[" + replace+"]");

        }
        if(!"none".equals(sort)){
            solrQuery.add("sort",sort+" "+sortType);
        }
        solrQuery.setStart((int) ((pn - 1) * shownum));
        solrQuery.setRows(shownum);
        QueryResponse query = solrClient.query(solrQuery);
        SolrDocumentList results = query.getResults();
        Map<String, Map<String, List<String>>> highlighting = query.getHighlighting();
        List<EstateSearchBo> estateSearchBos = new ArrayList<>();
        for (SolrDocument document : results) {
            estateSearchBos.add(SearchUtil.DocToEstateSearchBean(document, serverAddress, highlighting));
        }
        return new SearchInfoBo(estateSearchBos, results.getNumFound());
    }

    /**
     * 得到搜索界面推荐楼盘
     * @param start
     * @param rows
     * @return
     * @throws Exception
     */
    @Override
    public List<RecommendEstateBo> getRecommendEstate(Integer start, Integer rows) throws Exception {
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setStart(start);
        solrQuery.setRows(rows);
        solrQuery.setQuery("*:*");
        
        solrQuery.addSort("estate_visit_times", SolrQuery.ORDER.asc);
        SolrDocumentList results = solrClient.query(solrQuery).getResults();
        List<RecommendEstateBo> recommendEstateBos = new ArrayList<>();
        for (SolrDocument document : results) {
            recommendEstateBos.add(SearchUtil.DocToRecommendEstate(document, serverAddress));
        }
        return recommendEstateBos;
    }

    /**
     * 得到主页推荐楼盘、最新楼盘
     * @param start
     * @param rows
     * @param type
     * @param order
     * @return
     * @throws Exception
     */
    @Override
    public List<HomeEstateBo> getHomeEstate(Integer start, Integer rows, String type,SolrQuery.ORDER order) throws Exception {
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setStart(start).setRows(rows).setQuery("*:*");
        solrQuery.addSort(type, order);
        SolrDocumentList results = solrClient.query(solrQuery).getResults();
        List<HomeEstateBo> HomeEstateBoList = new ArrayList<>();
        for (SolrDocument document : results) {
            HomeEstateBoList.add(SearchUtil.DocToHomeEstate(document, serverAddress));
        }
        return HomeEstateBoList;
    }


}
