package team.etop.xunfang.user.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;

import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import team.etop.xunfang.common.bean.EstateJson;
import team.etop.xunfang.common.bean.PageInfo;
import team.etop.xunfang.common.bean.Result;
import team.etop.xunfang.common.bean.RoleJson;
import team.etop.xunfang.modules.po.Estate;
import team.etop.xunfang.modules.po.Role;

import team.etop.xunfang.modules.po.User;
import team.etop.xunfang.modules.service.EstateServiceGenerate;
import team.etop.xunfang.modules.service.RoleServiceGenerate;
import team.etop.xunfang.modules.service.UserServiceGenerate;


import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ZYZ on 2017/8/11
 */
@Controller
@RequestMapping("/user")
public class UserController{


    @Autowired
    private UserServiceGenerate userServiceGenerate;
    @Autowired
    private RoleServiceGenerate roleServiceGenerate;
    @Autowired
    private EstateServiceGenerate estateServiceGenerate;

    @RequestMapping("/userList")
    public ModelAndView userManagement(@RequestParam(value = "pn",defaultValue ="1")int pageNum,
                                       @RequestParam(value = "status",defaultValue = "1")Integer status) {

        ModelAndView modelAndView = new ModelAndView();

        EntityWrapper<User> wrapper=new EntityWrapper<>();
        wrapper.eq("status",1);
        Page<User> userPage=new Page<>();
        userPage.setCurrent(pageNum);
        userPage.setSize(8);
        userPage.setAsc(false);
        userPage.setOrderByField("updateTime");
        Page<User> page=userServiceGenerate.selectPage(userPage,wrapper);
        System.out.println(page.toString());

        PageInfo pageInfo=new PageInfo();
        pageInfo.setCurrentPage((long)(pageNum));
        pageInfo.setTotal((long)(page.getPages()));
        modelAndView.addObject("pageInfo",pageInfo);


        List<User> list=page.getRecords();


        modelAndView.addObject("list",list);
        modelAndView.setViewName("/user/userList");
        return modelAndView;



    }

    private ModelAndView getModelAndView(){
        ModelAndView modelAndView=new ModelAndView();
        EntityWrapper<User> wrapper=new EntityWrapper<>();
        wrapper.eq("status",1);
        Page<User> userPage=new Page<>();
        userPage.setCurrent(1);
        userPage.setSize(8);
        userPage.setAsc(false);
        userPage.setOrderByField("updateTime");
        Page<User> page=userServiceGenerate.selectPage(userPage,wrapper);
        System.out.println(page.toString());

        PageInfo pageInfo=new PageInfo();
        pageInfo.setCurrentPage((long)(1));
        pageInfo.setTotal((long)(page.getPages()));
        modelAndView.addObject("pageInfo",pageInfo);


        List<User> list=page.getRecords();


        modelAndView.addObject("list",list);
        return modelAndView;
    }



@RequestMapping("/addUser")
public ModelAndView addUser(@RequestParam(value ="account") String account,
                             @RequestParam(value = "name") String name,
                             @RequestParam(value = "password") String password,
                             @RequestParam(value ="checkPwd")String checkPwd
                            ){
    System.out.println(account+","+name+","+"password"+","+"checkPwd");
        Result result=new Result();
        User user=new User();
        user.setAccount(account);
        user.setUsername(name);
        user.setStatus(1);

        if(password.equals(checkPwd)){
            user.setPassword(password);

            userServiceGenerate.insert(user);
            result.setSuccess(true);
            result.setMsg("添加用户成功");
        }else{
            result.setSuccess(false);
            result.setMsg("两次密码不一致");

        }
        ModelAndView modelAndView=getModelAndView();
        modelAndView.addObject("result",result);

    modelAndView.setViewName("/user/userList");
    return modelAndView;
}


@RequestMapping("/deleteUser")
public ModelAndView deleteUser(@RequestParam(value = "userId")Long userId){
    Result result=new Result();
    User user=userServiceGenerate.selectById(userId);
    user.setStatus(0);
    userServiceGenerate.updateById(user);
    result.setSuccess(true);
    result.setMsg("删除成功");
    ModelAndView modelAndView=getModelAndView();
    modelAndView.addObject("result",result);
    modelAndView.setViewName("/user/userList");

    return  modelAndView;
}
@RequestMapping("/updateUser")
public ModelAndView updateUser(@RequestParam(value="userId")Long userId,
                         @RequestParam(value = "name")String name,
                         @RequestParam(value ="password")String password,
                         @RequestParam(value ="checkPwd")String checkPwd){

    System.out.println(userId+","+name+","+password+","+checkPwd);

    Result result=new Result();
    User user=userServiceGenerate.selectById(userId);
    System.out.println(user.toString());
    user.setUsername(name);
    if(password.equals(checkPwd)){
        user.setPassword(password);
        userServiceGenerate.updateById(user);
        result.setSuccess(true);
        result.setMsg("更新成功");
    }else{
        result.setSuccess(false);
        result.setMsg("两次密码不一致");
    }
    ModelAndView modelAndView=getModelAndView();
    modelAndView.addObject("result",result);
    modelAndView.setViewName("/user/userList");
    return modelAndView;
}

@RequestMapping("/findUser")
public ModelAndView findUser(@RequestParam(value = "pn",defaultValue ="1")int pageNum,
                             @RequestParam(value = "name")String name,
                              @RequestParam(value="condition")int condition){

    ModelAndView modelAndView=new ModelAndView();
    EntityWrapper<User> wrapper=new EntityWrapper<>();
    if(condition==0){
        wrapper.like("account","%"+name+"%");}
    else {
            wrapper.like("userName","%"+name+"%");
    }
    Page<User> userPage=new Page<>();
    userPage.setCurrent(pageNum);
    userPage.setSize(8);
    userPage.setAsc(false);
    userPage.setOrderByField("updateTime");
    Page<User> page=userServiceGenerate.selectPage(userPage,wrapper);
    System.out.println(page.toString());

    PageInfo pageInfo=new PageInfo();
    pageInfo.setCurrentPage((long)(pageNum));
    pageInfo.setTotal((long)(page.getPages()));
    modelAndView.addObject("pageInfo",pageInfo);


    List<User> list=page.getRecords();


    modelAndView.addObject("list",list);
    modelAndView.setViewName("/user/userList");
    return modelAndView;
}



    @ResponseBody
    @RequestMapping("/getRoleJson")
    public Result getRoleJson(@RequestParam(value = "ID") Long ID) throws Exception{
    Result result=new Result();

    EntityWrapper<Role> wrapper=new EntityWrapper<>();
    wrapper.eq("status",1);
        List<Role> roleList=roleServiceGenerate.selectList(wrapper);
        for(int i=0;i<roleList.size();i++){
            System.out.println(roleList.get(i).getRoleName());
        }

        User user=userServiceGenerate.selectById(ID);
        String roleString=user.getRolesRelevance();
        if(roleString==null){
            roleString="null";
        }
        List<RoleJson> roleJsonList=new ArrayList<>();
        for(int i=0;i<roleList.size();i++){
            RoleJson roleJson=new RoleJson();
            roleJson.setRole(roleList.get(i));
            if(roleString.contains(String.valueOf(roleList.get(i).getId()))){
                roleJson.setExist(true);
            }
            roleJsonList.add(roleJson);
        }
        result.setSuccess(true);
        result.setMsg("成功");

        result.add("roleJsonList", roleJsonList);


        return result;
    }

    @ResponseBody
    @RequestMapping("/getUserRoleJson")
    public Result getUserRoleJson(@RequestParam(value = "ID") Long ID) throws Exception{

          Result result =new Result();
          User user=userServiceGenerate.selectById(ID);

          String roleString=user.getRolesRelevance();
        System.out.println(roleString);

        if(roleString==null){
            System.out.println("该用户无角色");
            result.setMsg("该用户无角色");
        }else{
//            String [] strings=roleString.split(",");
            EntityWrapper<Role> wrapper=new EntityWrapper<>();
            wrapper.eq("status",1);
            List<Role> list=roleServiceGenerate.selectList(wrapper);

            List<RoleJson> roleJsonList = new ArrayList<>();

            for(int i=0;i<list.size();i++){
                if(roleString.contains(String.valueOf(list.get(i).getId()))){
                    RoleJson roleJson = new RoleJson();
                    roleJson.setRole(list.get(i));
                    roleJsonList.add(roleJson);
                }
            }
            result.setSuccess(true);
            result.setMsg("成功");

            result.add("roleJsonList", roleJsonList);

//      }


        }

        return result;
    }


    @ResponseBody
    @RequestMapping("/findEstatesList")
    public Result findEstatesListJson(@RequestParam(value = "ID") Long ID) throws Exception{
        Result result =new Result();
        System.out.println(ID);
        User user=userServiceGenerate.selectById(ID);

        String estateString=user.getEstatesRelevance();

        if(estateString==null){
            System.out.println("该用户无楼盘");
            result.setMsg("该用户无楼盘");
        }else{
            EntityWrapper<Estate> wrapper=new EntityWrapper<>();

            wrapper.eq("status",1);
            List<Estate> list=estateServiceGenerate.selectList(wrapper);

            List<EstateJson> estateJsonList = new ArrayList<>();

            for(int i=0;i<list.size();i++){
                System.out.println(list.get(i).getEstateName());
                if(estateString.contains(String.valueOf(list.get(i).getId()))){
                    EstateJson estateJson=new EstateJson();
                    estateJson.setEstate(list.get(i));
                    estateJsonList.add(estateJson);
                }
            }
            result.setSuccess(true);
            result.setMsg("成功");

            result.add("estateJsonList", estateJsonList);

//      }


        }

        return result;
    }

    @RequestMapping("/updateUserRole")
    public ModelAndView updateUserRole(HttpServletRequest request){
        System.out.println("进入");
        System.out.println(request.getParameter("userId"));
        Long userId=Long.parseLong(request.getParameter("userId"));
        User user=userServiceGenerate.selectById(userId);

        String[] roles=request.getParameterValues("type");
        for(int i=0;i<roles.length;i++){
            System.out.println("获取的角色ID: "+roles[i]);
        }
        String rolesRelevance="";
        for(int i=1;i<roles.length-1;i++){
            rolesRelevance=rolesRelevance.concat(roles[i].concat(","));

        }
        rolesRelevance=rolesRelevance.concat(roles[roles.length-1]);
        System.out.println(rolesRelevance);
        user.setRolesRelevance(rolesRelevance);
        userServiceGenerate.updateById(user);
        Result result=new Result();
        result.setSuccess(true);
        result.setMsg("分配角色成功");
        ModelAndView modelAndView=getModelAndView();
        modelAndView.addObject("result",result);
        modelAndView.setViewName("/user/userList");
        return modelAndView;
    }
    @ResponseBody
    @RequestMapping("/findUserOne")
    public Result findUserOne(@RequestParam(value = "ID")Long ID) throws Exception{
        Result result=new Result();
        System.out.println(ID);
        System.out.println("findUserOne");
        User user=userServiceGenerate.selectById(ID);
        result.add("user",user);
        result.setSuccess(true);
        result.setMsg("成功");
        return result;
    }



}
