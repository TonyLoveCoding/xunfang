package team.etop.xunfang.main.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import team.etop.xunfang.common.Tree.BuildTree;
import team.etop.xunfang.common.Tree.Tree;
import team.etop.xunfang.common.bean.Msg;
import team.etop.xunfang.common.util.SplitUtil;
import team.etop.xunfang.main.dto.MenuDto;
import team.etop.xunfang.modules.mapper.RoleMapperGenerate;
import team.etop.xunfang.modules.mapper.UserMapperGenerate;
import team.etop.xunfang.modules.po.Permission;
import team.etop.xunfang.modules.po.User;
import team.etop.xunfang.modules.service.PermissionServiceGenerate;
import team.etop.xunfang.modules.service.RoleServiceGenerate;
import team.etop.xunfang.modules.service.UserServiceGenerate;

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

    @Autowired
    private UserServiceGenerate userServiceGenerate;

    @Autowired
    private RoleServiceGenerate roleServiceGenerate;

    @Autowired
    private PermissionServiceGenerate permissionServiceGenerate;

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
    public Msg initMenu() throws Exception {
        ModelAndView modelAndView=new ModelAndView("/main/index");
        List<Tree<MenuDto>> trees = new ArrayList<Tree<MenuDto>>();
        List<MenuDto> menuDtoList = new ArrayList<MenuDto>();
        User currentUser = (User) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
        List<Permission> permissionList = SplitUtil.GetPermissionList(currentUser.getAccount(), userServiceGenerate, roleServiceGenerate, permissionServiceGenerate);
        for(Permission permission:permissionList){
            String url=permission.getUrl();
            if(url==null){
                url="";
            }
            menuDtoList.add(new MenuDto(permission.getId(),permission.getName(),permission.getParentId(),url));
        }

//        menuDtoList.add(new MenuDto(1L,"主菜单",1L,""));
//        menuDtoList.add(new MenuDto(2L,"权限系统",1L,""));
//        menuDtoList.add(new MenuDto(3L,"内容管理",1L,""));
//        menuDtoList.add(new MenuDto(4L,"用户管理",2L,"/user/userList"));
//        menuDtoList.add(new MenuDto(5L,"角色管理",2L,"/role/roleList"));
//        menuDtoList.add(new MenuDto(6L,"权限管理",2L,"/permission/permissionList"));
//        menuDtoList.add(new MenuDto(9L,"轮播图管理",3L,"/carouselPhotos/query"));
//        menuDtoList.add(new MenuDto(10L,"楼盘管理",3L,"/estate/query"));
//        menuDtoList.add(new MenuDto(11L,"热搜词管理",3L,"/heatWord"));
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
