package team.etop.xunfang.main.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import team.etop.xunfang.common.Tree.BuildTree;
import team.etop.xunfang.common.Tree.Tree;
import team.etop.xunfang.common.bean.Msg;
import team.etop.xunfang.main.dto.MenuDto;

import java.util.ArrayList;
import java.util.List;

/**
 * @version V1.0
 * @Description:
 * @author: TingFeng Zhang
 * @date: 2017/8/9 11:46
 */

@Controller
@RequestMapping("/main")
public class MainController {

    @RequestMapping
    public ModelAndView initIndex(){
        return new ModelAndView("/main/index");
    }

    @RequestMapping("/welcome")
    public ModelAndView welcome(){
        return new ModelAndView("/main/welcome");
    }

    @RequestMapping("/menu")
    @ResponseBody
    public Msg initMenu(){
        ModelAndView modelAndView=new ModelAndView("/main/index");
        List<Tree<MenuDto>> trees = new ArrayList<Tree<MenuDto>>();
        List<MenuDto> menuDtoList = new ArrayList<MenuDto>();
        menuDtoList.add(new MenuDto(1L,"主菜单",1L,""));
        menuDtoList.add(new MenuDto(2L,"权限系统",1L,""));
        menuDtoList.add(new MenuDto(3L,"内容管理",1L,""));
        menuDtoList.add(new MenuDto(4L,"用户管理",2L,"/user/login"));
        menuDtoList.add(new MenuDto(5L,"角色管理",2L,""));
        menuDtoList.add(new MenuDto(6L,"权限管理",2L,""));
        menuDtoList.add(new MenuDto(7L,"权限增加",6L,""));
        menuDtoList.add(new MenuDto(8L,"权限删除",6L,""));
        menuDtoList.add(new MenuDto(9L,"轮播图管理",3L,""));
        menuDtoList.add(new MenuDto(10L,"商品管理",3L,""));

        for (MenuDto test : menuDtoList) {
            Tree<MenuDto> tree = new Tree<MenuDto>();
            tree.setId(test.getId().toString());
            tree.setParentId(test.getParent_id().toString());
            tree.setUrl(test.getUrl());
            tree.setText(test.getMenuNmae());
            trees.add(tree);
        }
        List<Tree<MenuDto>> children=BuildTree.build(trees);
        return Msg.success().add("children",children);
    }

}
