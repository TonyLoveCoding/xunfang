package team.etop.xunfang.search.service.Impl;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import team.etop.xunfang.common.util.SearchUtil;
import team.etop.xunfang.search.bo.EstateSearchBean;
import team.etop.xunfang.search.mapper.EstateSearchMapper;
import team.etop.xunfang.search.service.EstateSearchService;

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

    @Value("${solr.baseURL}")
    String baseURL;

    @Override
    public void fullUpdate() throws Exception {
        SolrClient solrClient=new HttpSolrClient.Builder(baseURL).build();
        solrClient.deleteByQuery("*:*");

        List<EstateSearchBean> estateSearchBeans = estateSearchMapper.selectAll();
        for(EstateSearchBean estateSearchBean:estateSearchBeans){
            solrClient.add(SearchUtil.EstateToDoc(estateSearchBean));
        }
        solrClient.commit();
    }
}
