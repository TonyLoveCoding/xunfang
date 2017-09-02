package team.etop.xunfang.role.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import team.etop.xunfang.common.bean.PageInfo;
import team.etop.xunfang.common.bean.Result;
import team.etop.xunfang.modules.po.Role;

import team.etop.xunfang.modules.po.User;
import team.etop.xunfang.modules.service.RoleServiceGenerate;

import java.util.List;

/**
 * Created by ZYZ on 2017/8/14
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleServiceGenerate roleServiceGenerate;


    @RequestMapping("/roleList")
    public ModelAndView getRoleList(@RequestParam(value = "pn", defaultValue = "1") int pageNum,
                                    @RequestParam(value = "status", defaultValue = "1") Integer status) {
        ModelAndView modelAndView = new ModelAndView();
        EntityWrapper<Role> wrapper = new EntityWrapper<>();
        wrapper.eq("status", 1);
        Page<Role> rolePage = new Page<>();
        rolePage.setCurrent(pageNum);
        rolePage.setSize(8);
        rolePage.setAsc(false);
        rolePage.setOrderByField("updateTime");
        Page<Role> page = roleServiceGenerate.selectPage(rolePage, wrapper);
        System.out.println(page.toString());

        PageInfo pageInfo = new PageInfo();
        pageInfo.setCurrentPage((long) (pageNum));
        pageInfo.setTotal((long) (page.getPages()));
        modelAndView.addObject("pageInfo", pageInfo);


        List<Role> list = page.getRecords();


        modelAndView.addObject("list", list);
        modelAndView.setViewName("/role/roleList");
        return modelAndView;

    }

    private ModelAndView getModelAndView() {
        ModelAndView modelAndView = new ModelAndView();
        EntityWrapper<Role> wrapper = new EntityWrapper<>();
        wrapper.eq("status", 1);
        Page<Role> rolePage = new Page<>();
        rolePage.setCurrent(1);
        rolePage.setSize(8);
        rolePage.setAsc(false);
        rolePage.setOrderByField("updateTime");
        Page<Role> page = roleServiceGenerate.selectPage(rolePage, wrapper);
        System.out.println(page.toString());

        PageInfo pageInfo = new PageInfo();
        pageInfo.setCurrentPage((long) (1));
        pageInfo.setTotal((long) (page.getPages()));
        modelAndView.addObject("pageInfo", pageInfo);


        List<Role> list = page.getRecords();


        modelAndView.addObject("list", list);
        return modelAndView;
    }

    @RequestMapping("/addRole")
    public ModelAndView addUser(@RequestParam(value = "name") String name,
                                @RequestParam(value = "description") String description

    ) {

        Result result = new Result();
        Role role = new Role();
        role.setRoleName(name);
        role.setDescription(description);
        role.setStatus(1);
        roleServiceGenerate.insert(role);

        result.setSuccess(true);
        result.setMsg("添加角色成功");


        ModelAndView modelAndView = getModelAndView();
        modelAndView.addObject("result", result);

        modelAndView.setViewName("/role/roleList");
        return modelAndView;
    }

    @RequestMapping("/deleteRole")
    public ModelAndView deleteRole(@RequestParam(value = "roleId") Long roleId) {
        Result result = new Result();
        Role role = roleServiceGenerate.selectById(roleId);
        role.setStatus(0);
        roleServiceGenerate.updateById(role);

        result.setSuccess(true);
        result.setMsg("删除成功");
        ModelAndView modelAndView = getModelAndView();
        modelAndView.addObject("result", result);
        modelAndView.setViewName("/role/roleList");

        return modelAndView;
    }

    @RequestMapping("/findRoleByName")
    public ModelAndView findUser(@RequestParam(value = "pn", defaultValue = "1") int pageNum,
                                 @RequestParam(value = "name") String name
    ) {

        ModelAndView modelAndView = new ModelAndView();
        EntityWrapper<Role> wrapper = new EntityWrapper<>();


        wrapper.like("roleName", "%" + name + "%");

        Page<Role> rolePage = new Page<>();
        rolePage.setCurrent(pageNum);
        rolePage.setSize(8);
        rolePage.setAsc(false);
        rolePage.setOrderByField("updateTime");
        Page<Role> page = roleServiceGenerate.selectPage(rolePage, wrapper);
        System.out.println(page.toString());

        PageInfo pageInfo = new PageInfo();
        pageInfo.setCurrentPage((long) (pageNum));
        pageInfo.setTotal((long) (page.getPages()));
        modelAndView.addObject("pageInfo", pageInfo);


        List<Role> list = page.getRecords();


        modelAndView.addObject("list", list);
        modelAndView.setViewName("/role/roleList");
        return modelAndView;


    }
    @RequestMapping("/updateRole")
    public ModelAndView updateUser(@RequestParam(value = "roleId") Long roleId,
                                   @RequestParam(value = "name")String name,
                                   @RequestParam(value ="description")String description
    ) {



        Result result = new Result();
        Role role = roleServiceGenerate.selectById(roleId);
       role.setRoleName(name);
       role.setDescription(description);
       role.setStatus(1);
       roleServiceGenerate.updateById(role);
      result.setSuccess(true);
      result.setMsg("修改成功");

        ModelAndView modelAndView = getModelAndView();
        modelAndView.addObject("result", result);
        modelAndView.setViewName("/role/roleList");
        return modelAndView;

    }
    }
