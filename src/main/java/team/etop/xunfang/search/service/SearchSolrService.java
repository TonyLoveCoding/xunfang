package team.etop.xunfang.search.service;

import team.etop.xunfang.search.bo.EstateSearchBo;

public interface SearchSolrService {
    void fullUpdate() throws Exception;
    void addEstate(EstateSearchBo estateSearchBo) throws Exception;
    void updateEstate(EstateSearchBo estateSearchBo) throws Exception;
    void deleteEstate(Long id) throws Exception;
}
