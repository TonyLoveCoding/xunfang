package team.etop.xunfang.search.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import team.etop.xunfang.common.bean.Msg;
import team.etop.xunfang.search.bo.EstateSearchBo;
import team.etop.xunfang.search.service.SearchSolrService;

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
    public Msg fullUpdate(){
        try {
            searchSolrService.fullUpdate();
            return Msg.success();
        }catch (Exception e){
            e.printStackTrace();
            return Msg.fail("索引更新失败！");
        }
    }

    /**
     * 同步增量更新-添加
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/addEstate")
    public Msg addEstate(@RequestParam("EstateSearchBo") EstateSearchBo estateSearchBo) throws Exception{
        searchSolrService.addEstate(estateSearchBo);
        return Msg.success();
    }

    /**
     * 同步增量更新-更新-与添加其实一样
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/updateEstate")
    public Msg updateEstate(@RequestParam("EstateSearchBo") EstateSearchBo estateSearchBo) throws Exception{
        searchSolrService.updateEstate(estateSearchBo);
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
