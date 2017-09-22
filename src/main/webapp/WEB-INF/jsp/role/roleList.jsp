<%--
  Created by IntelliJ IDEA.
  User: ZYZ
  Date: 2017/8/14
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" type="text/css" href="/assets/home/search/zxf_page.css"/>
    <link rel="stylesheet" href="assets/user/css/bootstrapValidator.css">
    <link rel="stylesheet" href="assets/user/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <script type="text/javascript" src="assets/user/ztree/js/jquery.ztree.core.js"></script>
    <script src="assets/user/ztree/js/jquery.ztree.excheck.js" type="text/javascript"></script>
    <script src="/assets/home/search/zxf_page.js" type="text/javascript"></script>
    <script src="/assets/role/js/role.js" type="text/javascript"></script>





</head>
<body>
<input class="ab" type ="hidden" id="test">

<form action="/role/roleList" method="GET" id="form_search">
    <input id="inp_hid_pn" type="hidden" name="pn" value="${pageInfo.getCurrentPage()}">

</form>

<%--查找框--%>
<div class="container-fluid">
    <div class="row clearfix">
        <div class="col-md-12 column">
        </div>
        <div class="col-md-12 column">
            <table class="table table-striped">
                <thead>
                <tr>

                  <shiro:hasPermission name="role/findRole">
                    <form class="form-search" method="post" action="/role/findRoleByName" >
                        <input class="input-medium search-query" type="text" name="name"/>

                        <button type="submit" class="btn">查找角色</button>
                    </form>
                  </shiro:hasPermission>
                    <shiro:hasPermission name="role/addRole">
                    <a class="btn btn-success" data-target="#addRole" data-toggle="modal" href="">添加角色</a>
                    </shiro:hasPermission>


                </tr>

                </tbody>
            </table>
        </div>
        <div class="col-md-10 column">
        </div>
    </div>
</div>
<%--查找框结束--%>

<%--添加角色模态框--%>
<div id="addRole" class="modal fade" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="form-wrap">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button class="close" data-dismiss="modal">
                        <span>&times;</span>
                    </button>
                </div>
                <div class="modal-title">
                    <h1 class="text-center">添加</h1>
                </div>
                <div class="modal-body">
                    <form class="form-group" id="form1" name="form1" action="/role/addRole" method="post" novalidate>
                        <div class="modal-body">

                            <label>角色名</label>
                            <input class="form-control" type="text" name="name" >
                        </div>
                        <div class="modal-body">

                            <label>角色描述</label>
                            <textarea class="form-control" rows="3"  name="description"></textarea>
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


<div class="container-fluid">
    <div class="row clearfix">
        <div class="col-md-12 column">
        </div>
        <div class="col-md-12 column">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>
                        角色名
                    </th>
                    <th>
                        角色描述
                    </th>
                    <th>
                        创建时间
                    </th>
                    <th>
                        修改时间
                    </th>
                    <th>状态</th>
                    <shiro:hasPermission name="role/getRoleTree">
                    <th>拥有的权限</th>
                    </shiro:hasPermission>

                </tr>
                </thead>
                <tbody>
                <c:forEach var="role" items="${list}" >

                    <tr>

                        <th>${role.id }</th>
                        <th>${role.roleName }</th>
                        <th>${role.description}</th>
                        <th>${role.createtime}</th>
                        <th>${role.updatetime}</th>
                        <th>${role.status}</th>

                        <shiro:hasPermission name="role/getRoleTree">

                        <td><a class=" btn btn-info getRolePermissionBtn" data-target="#findPermission" data-toggle="modal" href="" id="${role.id}">查看权限</a></td>
                        </shiro:hasPermission>

                        <shiro:hasPermission name="role/updateRole">

                        <td><a class="btn btn-success updateRoleBtn" data-target="#update" data-toggle="modal" href="" id="${role.id}">修改</a></td>
                        </shiro:hasPermission>


                       <shiro:hasPermission name="role/deleteRole">
                        <td><a class="btn btn-danger deleteRoleBtn" data-target="#deleteRoleById" data-toggle="modal" id ="${role.id}" href="" method="post">删除</a></td>
                        </shiro:hasPermission>

                        <shiro:hasPermission name="role/updateRolePermission">

                        <td><a class="btn btn-info updateRolePermissionBtn" data-target="#updateRolePermission" id="${role.id}" data-toggle="modal" href="">分配权限</a></td>
                        </shiro:hasPermission>



                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <%--修改角色模态框--%>
            <div id="update" class="modal fade" aria-labelledby="myModalLabel" aria-hidden="true">
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
                            <div class="modal-body">
                                <form class="form-group" id="form3" name="form3" action="/role/updateRole" method="post" novalidate>

                                    <div class="modal-body" id="updateRole">

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
            </div>
            <%--修改角色模态框结束--%>
            <%--查看权限模态框--%>

            <div id="findPermission" class="modal fade" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="form-wrap">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-title">
                                <h1 class="text-center">查看权限</h1>
                            </div>

                            <form class="form-group" id="form00" name="form00"
                                  action="" method="post">
                                <div class="modal-body" >
                                    <div>
                                        <ul id="getTree" class="ztree"></ul>
                                    </div>

                                </div>
                                <div class="modal-footer">

                                    <button class="btn btn-danger" data-dismiss="modal">关闭</button>
                                </div>

                            </form>

                        </div>
                    </div>
                </div>
            </div>

            <%--查看权限模态框结束--%>
            <%--删除角色模态框--%>
            <div id="deleteRoleById" class="modal fade" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="form-wrap">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button class="close" data-dismiss="modal">
                                    <span>&times;</span>
                                </button>
                            </div>
                            <form class="form-group" id="form6" name="form6" action="/role/deleteRole"
                                  method="post">
                                <div class="modal-body" id="deleteRole">

                                </div>
                                <%--<div class="modal-body">--%>
                                <%--<h1 class="text-center"> 确认删除？</h1>--%>
                                <%--<input type="hidden" name="account" value=${user.account }>--%>
                                <%--</div>--%>
                                <div class="modal-footer">
                                    <button class="btn btn-primary" type="submit" id="tijiao3">提交
                                    </button>
                                    <button class="btn btn-danger" data-dismiss="modal">关闭</button>
                                </div>
                            </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <%--删除角色模态框结束--%>
            <%--分配权限模态框--%>
            <div id="updateRolePermission" class="modal fade" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="form-wrap">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-title">
                                <h1 class="text-center">分配权限</h1>
                            </div>

                            <form class="form-group" id="form0" name="form0"
                                  action="" method="post">
                                <div class="modal-body" >
                                    <div>
                                        <ul id="updateTree" class="ztree"></ul>
                                    </div>

                                </div>
                                <div class="modal-footer">
                                    <button id="treeSubmit" class="btn btn-primary" type="submit" id="tijiao223">提交
                                    </button>
                                    <button class="btn btn-danger" data-dismiss="modal">取消</button>
                                </div>

                            </form>

                        </div>
                    </div>
                </div>
            </div>
            <%--分配权限模态框结束--%>

        </div>

    </div>
</div>

</div>
<%--分页--%>
<div class="row">
    <div class="col-md-10 col-md-offset-1">
        <div class="zxf_pagediv"></div>
    </div>
</div>
</div>





</body>

<script type="text/javascript">
    $(document).ready(function () {


        <c:if test="${!empty result}">
        var x=document.getElementById('tset');
        x.onclick= function () {

            $('#Result').modal('show');

        };
        x.click();
        </c:if>
    });
    $(document).ready(function () {
        $(".zxf_pagediv").createPage({
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
