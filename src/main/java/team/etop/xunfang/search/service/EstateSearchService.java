package team.etop.xunfang.search.service;

import org.apache.solr.client.solrj.SolrServerException;
import team.etop.xunfang.search.bo.RecommendEstate;
import team.etop.xunfang.search.bo.SearchInfo;

import java.io.IOException;
import java.util.List;

/**
 * @version V1.0
 * @Description:
 * @author: TingFeng Zhang
 * @date: 2017/8/13 21:34
 */
public interface EstateSearchService {
    void fullUpdate() throws Exception;
    SearchInfo search(Long pn, String keyWord, String saleStatus,String location,String totalPrices,String type,String houseType,String feature,String unitPrice,String area) throws Exception;
    List<RecommendEstate> getRecommendEstate() throws IOException, SolrServerException, Exception;
}
