<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<%--
  Created by IntelliJ IDEA.
  User: ZYZ
  Date: 2017/8/11
  Time: 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" type="text/css" href="/assets/home/search/zxf_page.css"/>
    <link rel="stylesheet" href="assets/user/css/bootstrapValidator.css">


    <script src="/assets/home/search/zxf_page.js" type="text/javascript"></script>
    <script src="/assets/user/js/user.js" type="text/javascript"></script>






</head>
<body>

       <input class="ab" type ="hidden" id="test">

       <form action="/user/userList" method="GET" id="form_search">
           <input id="inp_hid_pn" type="hidden" name="pn" value="${pageInfo.getCurrentPage()}">
       </form>


<%--查找用户框，增加用户按钮
--%>
<div class="container-fluid">
    <div class="row clearfix">
        <div class="col-md-12 column">
        </div>
        <div class="col-md-12 column">
            <table class="table table-striped">
                <thead>
                <tr>

                      <shiro:hasPermission name="user/findUser">
                    <form class="form-search" method="post" action="/user/findUser" name="form1">
                        <input class="input-medium search-query" type="text" name="name"/>
                        <input type="radio" name ="condition" value="0" checked> 按账号查找
                        <input type="radio" name ="condition" value="1"> 按姓名查找

                        <button type="submit" class="btn btn-success">查找用户</button>
                    </form>
                      </shiro:hasPermission>
                    <shiro:hasPermission name="user/addUser">
                    <a class="btn btn-info" data-target="#addUser" data-toggle="modal" href="">添加用户</a>
                    </shiro:hasPermission>

                </tr>

                </tbody>
            </table>
        </div>

    </div>
</div>
<%--end>
<%--结果提示模态框
--%>
       <div id="Result" class="modal fade" aria-labelledby="myModalLabel" aria-hidden="true">
           <div class="form-wrap">
               <div class="modal-dialog">
                   <div class="modal-content">
                       <div class="modal-header">
                           <button class="close" data-dismiss="modal">
                               <span>&times;</span>
                           </button>
                       </div>
                               <div class="modal-body">
                                   <h1>${result.msg}</h1>
                               </div>
                       <div class="modal-footer">

                           <button class="btn btn-primary" data-dismiss="modal">取消</button>
                       </div>
                   </div>
               </div>
           </div>
       </div>

       <%--结果提示模态框结束--%>




<%--增加用户模态框
--%>
<div id="addUser" class="modal fade" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="form-wrap">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button class="close" data-dismiss="modal">
                        <span>&times;</span>
                    </button>
                </div>

                <div class="modal-title">
                    <h1 class="text-center">添加用户</h1>
                </div>
                <div class="modal-body">
                    <form class="form-group" id="form2" name="form2" action="/user/addUser" method="post" novalidate>
                        <div class="modal-body">
                            <label>账号</label>
                            <input class="form-control" type="text" name="account" >
                        </div>
                        <div class="modal-body">
                            <label>昵称</label>
                            <input class="form-control" type="text" name="name" >
                        </div>

                        <div class="modal-body">
                            <label>密码</label>
                            <input class="form-control" type="password" name="password" autofocus="autofocus" placeholder="至少6位字母或数字"
                                  >
                        </div>
                        <div class="modal-body">
                            <label>验证密码</label>
                            <input class="form-control" type="password" name="checkPwd" autofocus="autofocus" placeholder="至少6位字母或数字"
                                  >
                        </div>



                        <div class="modal-footer">
                            <button class="btn btn-primary" type="submit" id="tijiao">提交</button>
                            <button class="btn btn-danger" data-dismiss="modal">取消</button>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<%--添加用户模态框结束--%>


<%--用户列表--%>
<div class="container-fluid">
    <div class="row clearfix">


    <table class="table table-striped">
                <thead>
                <tr>
                    <th>
                        ID
                    </th>

                    <th>
                        账号
                    </th>
                    <th>
                        姓名
                    <th>
                        创建时间
                    </th>
                    <th>
                        最后更新时间
                    </th>
                    <th>
                        用户状态
                    </th>

                    <shiro:hasPermission name="user/findUserRole">
                    <th>
                        查看用户类型
                    </th>
                    </shiro:hasPermission>
                       <shiro:hasPermission name="user/findEstatesList">
                    <th>
                        所拥有楼盘
                    </th>
                       </shiro:hasPermission>

                </tr>
                </thead>
                <tbody>

                <c:forEach var="user" items="${list}">

                    <tr id="${user.id}" class="userClass">

                        <th>${user.id }</th>
                        <th>${user.account }</th>
                        <th>${user.username }</th>
                        <th>${user.createtime }</th>
                        <th>${user.updatetime }</th>
                        <th>${user.status }</th>

                        <shiro:hasPermission name="user/findUserRole">
                        <th><a class=" btn btn-info findUserRoleBtn" data-target="#findUserRoleModel" data-toggle="modal" href="" id="${user.id}">查看用户类型</a></th>
                        </shiro:hasPermission>

                        <shiro:hasPermission name="user/findEstatesList">
                        <th><a class=" btn btn-info estateBtn" data-target="#findEstatesList" data-toggle="modal" href="" id="${user.id}">查看楼盘</a></th>
                        </shiro:hasPermission>

                        <shiro:hasPermission name="user/updateUser">

                        <th><a class="btn btn-success updateUserBtn" data-target="#updateUser" data-toggle="modal" id="${user.id}">修改</a></th>
                        </shiro:hasPermission>

                       <shiro:hasPermission name="user/deleteUser">
                        <th><a class="btn btn-danger deteleUserBtn" data-target="#deleteUserById" data-toggle="modal" href="" method="post" id="${user.id}">删除</a></th>
                       </shiro:hasPermission>

                        <shiro:hasPermission name="user/updateUserRole">
                        <th><a class=" btn btn-info roleBtn" data-target="#updateUserRole" data-toggle="modal" href="" id="${user.id}" value="${user}">分配角色</a></th>
                        </shiro:hasPermission>

                    </tr>
                </c:forEach>

                </tbody>

            </table>




        <%--分页--%>
        <div class="row">
            <div class="col-md-10 col-md-offset-1">
                <div class="zxf_pagediv"></div>
            </div>

        </div>
    </div>






</div>
<%--分配角色模态框--%>
<div id="updateUserRole" class="modal fade" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="form-wrap">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button class="close" data-dismiss="modal">
                        <span>&times;</span>
                    </button>
                </div>
                <div class="modal-title">
                    <h1 class="text-center">分配角色</h1>
                </div>
                <%--<div class="modal-body">--%>
                    <form class="form-group"name="form7"
                          action="/user/updateUserRole" method="post">

                        <div class="modal-body" id="updateRole">

                        </div>
                        <div class="modal-footer">
                            <button class="btn btn-primary" type="submit" id="tijiao223">提交
                            </button>
                            <button class="btn btn-danger" data-dismiss="modal">取消</button>
                        </div>

                    </form>
                <%--</div>--%>
            </div>
        </div>
    </div>
</div>
<%--分配角色模态框结束--%>
<%--查看用户角色类型模态框--%>

<div id="findUserRoleModel" class="modal fade" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="form-wrap">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button class="close" data-dismiss="modal">
                        <span>&times;</span>
                    </button>
                </div>
                <div class="modal-title">
                    <h1 class="text-center">用户类型</h1>
                </div>

                    <form class="form-group" name="form3"
                          action="/user/findUserRole" method="post">
                        <%--<input type="hidden" name="userId" value=>--%>
                        <div class="modal-body" id="findUserRole">

                        </div>
                        <div class="modal-footer">
                            <%--<button class="btn btn-primary" type="submit" id="tijia3">提交--%>
                            <%--</button>--%>
                            <button class="btn btn-danger" data-dismiss="modal">关闭</button>
                        </div>

                    </form>

            </div>
        </div>
    </div>
</div>

<%--查看用户类型模态框结束--%>

       <%--修改用户信息模态框--%>
       <div id="updateUser" class="modal fade" aria-labelledby="myModalLabel"  aria-hidden="true">
           <div class="form-wrap">
               <div class="modal-dialog">
                   <div class="modal-content">
                       <div class="modal-header">
                           <button class="close" data-dismiss="modal">
                               <span>&times;</span>
                           </button>
                       </div>
                       <div class="modal-title">
                           <h1 class="text-center">修改</h1>
                       </div>

                           <form class="form-group" id="form55" name="form55" action="/user/updateUser" method="post" novalidate >
                               <div class="modal-body" id="updateUserMsg">

                               </div>


                               <div class="modal-footer">
                                   <button class="btn btn-primary" type="submit" id="tijiao22">提交</button>

                                   <button class="btn btn-danger" data-dismiss="modal">取消</button>
                               </div>

                           </form>

                   </div>
               </div>
           </div>
       </div>
       <%--修改用户模态框结束--%>
<%--查看樓盤模态框--%>

<div id="findEstatesList" class="modal fade" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="form-wrap">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button class="close" data-dismiss="modal">
                        <span>&times;</span>
                    </button>
                </div>
                <div class="modal-title">
                    <h1 class="text-center">所拥有的楼盘</h1>
                </div>

                    <form class="form-group" name="form4"
                          action="/user/findEstatesList" method="post">

                        <div class="modal-body" id="findEstates">

                        </div>
                        <div class="modal-footer">
                            <%--<button class="btn btn-primary" type="submit" id="tijia30">提交--%>
                            <%--</button>--%>
                            <button class="btn btn-danger" data-dismiss="modal">关闭</button>
                        </div>

                    </form>

            </div>
        </div>
    </div>
</div>

<%--查看樓盤模态框结束--%>

<%--删除用户模态框--%>
<div id="deleteUserById" class="modal fade" aria-labelledby="myModalLabel" >
    <div class="form-wrap">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button class="close" data-dismiss="modal">
                        <span>&times;</span>
                    </button>
                </div>


                    <form class="form-group" id="form6" name="form6" action="/user/deleteUser"
                          method="post">
                        <div class="modal-body" id="deleteUser">

                        </div>
                        <div class="modal-footer">
                            <button class="btn btn-primary" type="submit" id="tijiao2">提交
                            </button>
                            <button class="btn btn-danger" data-dismiss="modal">取消</button>
                        </div>
                    </form>

            </div>
        </div>
    </div>
</div>
<%--删除用户模态框结束--%>




</body>

<script type="text/javascript">
    $(document).ready(function () {
        <c:if test="${!empty result}">
        var x=document.getElementById('test');
        x.onclick= function () {
            $('#Result').modal('show');

        };
        x.click();
        </c:if>
    });


        $(document).ready(function () {

        $(".zxf_pagediv").createPage({
//            pageNum: 10,//总页码
//            current: 1,//当前页
//            shownum: 10,//每页显示个数
            pageNum: ${pageInfo.getTotal()},//总页码
            current: ${pageInfo.getCurrentPage()},//当前页

            shownum: 8,//每页显示个数
            backfun: function (e) {
                $("#inp_hid_pn").attr("value", e.current);
                $("#form_search").submit();
            }
        });
    });
</script>
<script src="assets/js/bootstrapValidator.js"></script>




</html>
