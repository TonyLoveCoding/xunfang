package team.etop.xunfang.search.bo;

import team.etop.xunfang.search.bo.EstateSearchBean;

import java.util.List;

/**
 * @version V1.0
 * @Description:
 * @author: TingFeng Zhang
 * @date: 2017/8/17 15:58
 */
public class SearchInfo {

    List<EstateSearchBean> estateSearchBeanList;
    Long numFound;

    public SearchInfo(List<EstateSearchBean> estateSearchBeanList, Long numFound) {
        this.estateSearchBeanList = estateSearchBeanList;
        this.numFound = numFound;
    }

    public List<EstateSearchBean> getEstateSearchBeanList() {
        return estateSearchBeanList;
    }

    public void setEstateSearchBeanList(List<EstateSearchBean> estateSearchBeanList) {
        this.estateSearchBeanList = estateSearchBeanList;
    }

    public Long getNumFound() {
        return numFound;
    }

    public void setNumFound(Long numFound) {
        this.numFound = numFound;
    }
}
