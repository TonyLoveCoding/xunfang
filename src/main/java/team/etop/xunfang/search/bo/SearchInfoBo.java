package team.etop.xunfang.search.bo;

import java.util.List;

/**
 * @version V1.0
 * @Description:
 * @author: TingFeng Zhang
 * @date: 2017/8/17 15:58
 */
public class SearchInfoBo {

    List<EstateSearchBo> estateSearchBoList;
    Long numFound;

    public SearchInfoBo(List<EstateSearchBo> estateSearchBoList, Long numFound) {
        this.estateSearchBoList = estateSearchBoList;
        this.numFound = numFound;
    }

    public List<EstateSearchBo> getEstateSearchBoList() {
        return estateSearchBoList;
    }

    public void setEstateSearchBoList(List<EstateSearchBo> estateSearchBoList) {
        this.estateSearchBoList = estateSearchBoList;
    }

    public Long getNumFound() {
        return numFound;
    }

    public void setNumFound(Long numFound) {
        this.numFound = numFound;
    }
}
