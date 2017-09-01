package team.etop.xunfang.search.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import team.etop.xunfang.common.util.SearchUtil;
import team.etop.xunfang.modules.po.Dic;
import team.etop.xunfang.search.bo.RecommendEstate;
import team.etop.xunfang.search.bo.SearchInfo;
import team.etop.xunfang.search.dto.SearchPageMsg;
import team.etop.xunfang.search.service.DicService;
import team.etop.xunfang.search.service.EstateSearchService;

import java.util.List;
import java.util.Map;

/**
 * @version V1.0
 * @Description:
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

    @Value("${search.shownum}")
    Integer shownum;

    /**
     * 传入条件进行搜索
     * @param pn
     * @param keyWord
     * @param saleStatus
     * @param location
     * @param totalPrices
     * @param type
     * @param houseType
     * @param feature
     * @param unitPrice
     * @param area
     * @param sort
     * @param sortType
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/search",produces="text/html;charset=UTF-8",method = RequestMethod.GET)
    public ModelAndView welcome(@RequestParam(value = "pn",defaultValue = "1") Long pn,
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
        ModelAndView modelAndView=new ModelAndView("/home/search");
        SearchInfo search = estateSearchService.search(pn,keyWord,saleStatus,location,totalPrices,type,houseType,feature,unitPrice,area,sort,sortType);
        List<RecommendEstate> RecommendEstate =
                estateSearchService.getRecommendEstate();
        SearchUtil.AddType(modelAndView,dicService);
        if(search.getEstateSearchBeanList().size()<=0){
            modelAndView.addObject("SearchPageMsg", new SearchPageMsg(0L,1L,0,keyWord,0L,saleStatus,location,totalPrices,type,houseType,feature,unitPrice,area,sort,sortType));
        }else{
            modelAndView.addObject("SearchPageMsg", SearchUtil.GetPage(pn,search.getNumFound(),shownum,keyWord,saleStatus,location,totalPrices,type,houseType,feature,unitPrice,area,sort,sortType));
        }
        modelAndView.addObject("RecommendEstate",RecommendEstate);
        modelAndView.addObject("EstateList",search.getEstateSearchBeanList());
        return modelAndView;
    }



}
