package team.etop.xunfang.search.web;

import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import team.etop.xunfang.common.bean.Msg;
import team.etop.xunfang.common.util.SearchUtil;
import team.etop.xunfang.heatWord.dto.HeatWord;
import team.etop.xunfang.heatWord.service.HeatWordService;
import team.etop.xunfang.modules.po.HeatSearchWord;
import team.etop.xunfang.search.bo.HomeEstateBo;
import team.etop.xunfang.search.bo.RecommendEstateBo;
import team.etop.xunfang.search.bo.SearchInfoBo;
import team.etop.xunfang.search.dto.SearchPageMsg;
import team.etop.xunfang.search.service.DicService;
import team.etop.xunfang.search.service.EstateSearchService;

import java.util.List;

/**
 * @version V1.0
 * @Description:索引数据APIController
 * @author: TingFeng Zhang
 * @date: 2017/8/9 8:46
 */
@Controller
@RequestMapping("/home")
public class SearchController {

    @Autowired
    DicService dicService;

    @Autowired
    EstateSearchService estateSearchService;

    @Autowired
    HeatWordService heatWordService;

    @Value("${search.shownum}")
    Integer shownum;

    /**
     * @Author: TingFeng Zhang
     * @Description 传入条件进行搜索
     * @param pn 页码
     * @param keyWord 关键词
     * @param saleStatus 销售情况
     * @param location  位置
     * @param totalPrices  总价
     * @param type 类型
     * @param houseType 户型
     * @param feature 特色
     * @param unitPrice 单价
     * @param area 面积
     * @param sort 排序条件
     * @param sortType 排序条件-正反序
     * @return ModelAndView
     * @Date 2017/9/7 10:07
     */
    @RequestMapping(value = "/search",produces="text/html;charset=UTF-8",method = RequestMethod.GET)
    public ModelAndView search(@RequestParam(value = "pn",defaultValue = "1") Long pn,
                                @RequestParam(value = "keyWord",defaultValue = "")String keyWord,
                                @RequestParam(value ="saleStatus",defaultValue = "none")String saleStatus,
                                @RequestParam(value = "location",defaultValue = "none")String location,
                                @RequestParam(value = "totalPrices",defaultValue = "none")String totalPrices,
                                @RequestParam(value = "type",defaultValue = "none")String type,
                                @RequestParam(value = "houseType",defaultValue = "none")String houseType,
                                @RequestParam(value = "feature",defaultValue = "none")String feature,
                                @RequestParam(value = "unitPrice",defaultValue = "none")String unitPrice,
                                @RequestParam(value = "area",defaultValue = "none")String area,
                                @RequestParam(value = "sort",defaultValue = "none")String sort,
                                @RequestParam(value = "sortType",defaultValue = "none")String sortType) throws Exception {
        try {
            ModelAndView modelAndView=new ModelAndView("/home/search");
            SearchInfoBo search = estateSearchService.search(pn,keyWord,saleStatus,location,totalPrices,type,houseType,feature,unitPrice,area,sort,sortType);
            List<RecommendEstateBo> RecommendEstateBo =
                    estateSearchService.getRecommendEstate(0,5);
            SearchUtil.AddType(modelAndView,dicService);
            if(search.getEstateSearchBoList().size()<=0){
                modelAndView.addObject("SearchPageMsg", new SearchPageMsg(0L,1L,0,keyWord,0L,saleStatus,location,totalPrices,type,houseType,feature,unitPrice,area,sort,sortType));
            }else{
                modelAndView.addObject("SearchPageMsg", SearchUtil.GetPage(pn,search.getNumFound(),shownum,keyWord,saleStatus,location,totalPrices,type,houseType,feature,unitPrice,area,sort,sortType));
            }
            List<HeatWord> heatSearchWordList = heatWordService.getHeatSearchWordList();

            modelAndView.addObject("RecommendEstateBo", RecommendEstateBo);
            modelAndView.addObject("EstateList",search.getEstateSearchBoList());
            modelAndView.addObject("heatSearchWordList",heatSearchWordList);
            return modelAndView;
        }catch (Exception e){
            //打日志
            throw e;
        }
    }


    /**
     * @Author: TingFeng Zhang
     * @Description 得到搜索界面推荐楼盘
     * @Date 2017/9/7 10:09
     */
    @RequestMapping("/getHomeEstateMsg")
    @ResponseBody
    public Msg getHomeEstateJson(){
        try {
            List<HomeEstateBo> RecommendedEstate = estateSearchService.getHomeEstate(0, 8, "estate_visit_times", SolrQuery.ORDER.asc);
            List<HomeEstateBo> LatestEstate = estateSearchService.getHomeEstate(0, 8, "estate_create_time",SolrQuery.ORDER.desc);
            return Msg.success().add("RecommendedEstate",RecommendedEstate).add("LatestEstate",LatestEstate);
        }catch (Exception e){
            e.printStackTrace();
            return Msg.fail("首页数据加载失败！");
        }
    }


}
