package team.etop.xunfang.search.service;

import team.etop.xunfang.modules.po.Estate;
import team.etop.xunfang.search.bo.EstateSearchBean;

public interface SearchSolrService {
    void fullUpdate() throws Exception;
    void addEstate(EstateSearchBean estateSearchBean) throws Exception;
    void updateEstate(EstateSearchBean estateSearchBean) throws Exception;
    void deleteEstate(Long id) throws Exception;
}
