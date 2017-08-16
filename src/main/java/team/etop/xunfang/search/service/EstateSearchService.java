package team.etop.xunfang.search.service;

import org.apache.solr.client.solrj.SolrServerException;
import team.etop.xunfang.search.bo.EstateSearchBean;

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
    List<EstateSearchBean> search() throws Exception;
}
