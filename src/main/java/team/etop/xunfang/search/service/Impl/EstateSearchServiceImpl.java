package team.etop.xunfang.search.service.Impl;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.etop.xunfang.search.bo.EstateSearchBean;
import team.etop.xunfang.search.mapper.EstateSearchMapper;
import team.etop.xunfang.search.service.EstateSearchService;

import java.io.IOException;
import java.util.List;

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
    public List<EstateSearchBean> search() throws Exception {
        SolrQuery solrQuery=new SolrQuery();
        QueryResponse query = solrClient.query(solrQuery);
        SolrDocumentList results = query.getResults();
        long numFound = results.getNumFound();
        for(SolrDocument document:results){

        }
        return null;
    }
}
