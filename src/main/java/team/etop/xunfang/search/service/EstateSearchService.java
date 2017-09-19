package team.etop.xunfang.search.service;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import team.etop.xunfang.search.bo.HomeEstateBo;
import team.etop.xunfang.search.bo.RecommendEstateBo;
import team.etop.xunfang.search.bo.SearchInfoBo;

import java.io.IOException;
import java.util.List;

/**
 * @version V1.0
 * @Description:
 * @author: TingFeng Zhang
 * @date: 2017/8/13 21:34
 */
public interface EstateSearchService {

    SearchInfoBo search(Long pn, String keyWord, String saleStatus, String location, String totalPrices, String type, String houseType, String feature, String unitPrice, String area, String sort, String sortType) throws Exception;
    List<RecommendEstateBo> getRecommendEstate(Integer start, Integer rows) throws Exception;
    List<HomeEstateBo> getHomeEstate(Integer start, Integer rows,String type,SolrQuery.ORDER order) throws Exception;
}
