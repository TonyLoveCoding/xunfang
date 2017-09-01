package team.etop.xunfang.search.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import team.etop.xunfang.common.bean.Msg;
import team.etop.xunfang.common.util.SearchUtil;
import team.etop.xunfang.search.bo.EstateSearchBean;
import team.etop.xunfang.search.bo.RecommendEstate;
import team.etop.xunfang.search.bo.SearchInfo;
import team.etop.xunfang.search.dto.SearchPageMsg;
import team.etop.xunfang.search.service.EstateSearchService;
import team.etop.xunfang.search.service.SearchSolrService;

import java.util.List;

@Controller
@RequestMapping("/searchUpdate")
public class SearchUpdate {
    @Autowired
    SearchSolrService searchSolrService;

    /**
     * 手动全量更新
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/fullUpdate")
    public Msg fullUpdate() throws Exception{
        searchSolrService.fullUpdate();
        return Msg.success();
    }

    /**
     * 同步增量更新-添加
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/addEstate")
    public Msg addEstate(@RequestParam("EstateSearchBean") EstateSearchBean estateSearchBean) throws Exception{
        searchSolrService.addEstate(estateSearchBean);
        return Msg.success();
    }

    /**
     * 同步增量更新-更新-与添加其实一样
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/updateEstate")
    public Msg updateEstate(@RequestParam("EstateSearchBean") EstateSearchBean estateSearchBean) throws Exception{
        searchSolrService.updateEstate(estateSearchBean);
        return Msg.success();
    }


    /**
     * 同步增量更新-删除
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/deleteEstate")
    public Msg deleteEstate(@RequestParam("id") Long id) throws Exception{
        searchSolrService.deleteEstate(id);
        return Msg.success();
    }


}
