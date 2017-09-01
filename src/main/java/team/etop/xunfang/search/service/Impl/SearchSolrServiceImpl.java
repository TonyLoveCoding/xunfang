package team.etop.xunfang.search.service.Impl;

import org.apache.solr.client.solrj.SolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.etop.xunfang.common.util.SearchUtil;
import team.etop.xunfang.modules.po.Estate;
import team.etop.xunfang.search.bo.EstateSearchBean;
import team.etop.xunfang.search.mapper.EstateSearchMapper;
import team.etop.xunfang.search.service.SearchSolrService;

import java.util.List;

@Service
public class SearchSolrServiceImpl implements SearchSolrService{
    @Autowired
    EstateSearchMapper estateSearchMapper;
    @Autowired
    SolrClient solrClient;

    @Override
    public void fullUpdate() throws Exception {
        solrClient.deleteByQuery("*:*");
        List<EstateSearchBean> estateSearchBeans = estateSearchMapper.selectAll();
        for(EstateSearchBean estateSearchBean:estateSearchBeans){
            solrClient.add(SearchUtil.EstateToDoc(estateSearchBean));
        }
        solrClient.commit();
    }


    @Override
    public void addEstate(EstateSearchBean estateSearchBean) throws Exception {
        solrClient.add(SearchUtil.EstateToDoc(estateSearchBean));
        solrClient.commit();
    }

    @Override
    public void updateEstate(EstateSearchBean estateSearchBean) throws Exception {
        solrClient.add(SearchUtil.EstateToDoc(estateSearchBean));
        solrClient.commit();
    }

    @Override
    public void deleteEstate(Long id) throws Exception {
        solrClient.deleteByQuery("id:"+id);
        solrClient.commit();
    }
}
