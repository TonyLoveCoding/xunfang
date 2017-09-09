package team.etop.xunfang.common.bean;

/**
 * @version V1.0
 * @Description:前后台分页通用对象
 * @author: TingFeng Zhang
 * @date: 2017/8/8 19:48
 */
public class PageInfo {
    private Long PageSize;
    private Long countindex;
    private Long visiblePages;
    private Long total;
    private Long currentPage;
    public PageInfo(){

    }

    public PageInfo(Long pageSize, Long countindex, Long visiblePages, Long total, Long currentPage) {
        this.PageSize = pageSize;
        this.countindex = countindex;
        this.visiblePages = visiblePages;
        this.total = total;
        this.currentPage = currentPage;
    }

    public Long getPageSize() {
        return PageSize;
    }

    public void setPageSize(Long pageSize) {
        PageSize = pageSize;
    }

    public Long getCountindex() {
        return countindex;
    }

    public void setCountindex(Long countindex) {
        this.countindex = countindex;
    }

    public Long getVisiblePages() {
        return visiblePages;
    }

    public void setVisiblePages(Long visiblePages) {
        this.visiblePages = visiblePages;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Long currentPage) {
        this.currentPage = currentPage;
    }
}