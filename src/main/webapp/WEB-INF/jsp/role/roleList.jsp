<%--
  Created by IntelliJ IDEA.
  User: ZYZ
  Date: 2017/8/14
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" type="text/css" href="/assets/home/search/zxf_page.css"/>
    <link rel="stylesheet" href="assets/user/css/bootstrapValidator.css">

    <script src="/assets/home/search/zxf_page.js" type="text/javascript"></script>
    <script>
        $(document).on('click', '.deleteRoleBtn', function () {
            ID = $(this).attr("id");
            alert(ID);
            $("#deleteRole").empty();
//           alert(ID);
            var deleteRoleString='<h1 class=\"text-center\"> 确认删除？</h1>';
            alert(deleteRoleString);
            $("#deleteRole").append(deleteRoleString);

            var deleteRoleString='<input type="hidden" name="roleId" value="'+ID+'">';
            alert(deleteRoleString);
            $("#deleteRole").append(deleteRoleString);

        });
        $(document).ready(function () {

            <c:if test="${!empty result}">
            var x=document.getElementById('test');
            x.onclick= function () {

                $('#Result').modal('show');

            };
            x.click();
            </c:if>
        });

    </script>


</head>
<body>
<input class="ab" type ="hidden" id="test">

<form action="/role/roleList" method="GET" id="form_search">
    <input id="inp_hid_pn" type="hidden" name="pn" value="${pageInfo.getCurrentPage()}">
    <%--<input id="inp_hid_status" type="hidden" name="status" value="${SearchPageMsg.status}">--%>

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


                    <form class="form-search" method="post" action="/role/findRoleByName" >
                        <input class="input-medium search-query" type="text" name="name"/>

                        <button type="submit" class="btn">查找角色</button>
                    </form>
                    <a class="btn btn-success" data-target="#addRole" data-toggle="modal" href="">添加角色</a>


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
                            <input type="text" name="name" >
                        </div>
                        <div class="modal-body">

                            <label>角色描述</label>
                            <input type="text" name="description">
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
                    <th>拥有的权限</th>

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

                        <td><a class=" btn btn-info estateBtn" data-target="#findPermission" data-toggle="modal" href="" id="${role.id}">查看权限</a></td>
                            <%--&lt;%&ndash;查看权限模态框&ndash;%&gt;--%>

                        <%--<div id="findPermission" class="modal fade" aria-labelledby="myModalLabel" aria-hidden="true">--%>
                            <%--<div class="form-wrap">--%>
                                <%--<div class="modal-dialog">--%>
                                    <%--<div class="modal-content">--%>
                                        <%--<div class="modal-title">--%>
                                            <%--<h1 class="text-center">查看权限</h1>--%>
                                        <%--</div>--%>

                                        <%--<form class="form-group" id="form00" name="form00"--%>
                                              <%--action="" method="post">--%>
                                            <%--<div class="modal-body" id="">--%>
                                                <%--暫未實現--%>
                                            <%--</div>--%>
                                            <%--<div class="modal-footer">--%>
                                                <%--<button class="btn btn-primary" type="submit" id="tijiao222">提交--%>
                                                <%--</button>--%>
                                                <%--<button class="btn btn-danger" data-dismiss="modal">取消</button>--%>
                                            <%--</div>--%>

                                        <%--</form>--%>

                                    <%--</div>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                            <%--&lt;%&ndash;查看权限模态框结束&ndash;%&gt;--%>

                        <td><a class="btn btn-success" data-target="#update" data-toggle="modal" href="">修改</a></td>

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

                                                <div class="modal-body">
                                                    <input type="hidden" name="roleId" value=${role.id }>
                                                    <label>角色名</label>
                                                    <input type="text" name="name" value=${role.roleName }>
                                                </div>
                                                <div class="modal-body">
                                                    <label>角色描述</label>
                                                    <input type="text" name="description" value=${role.description }>
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



                        <td><a class="btn btn-danger deleteRoleBtn" data-target="#deleteRoleById" data-toggle="modal" id ="${role.id}" href="" method="post">删除</a></td>

                        <%--&lt;%&ndash;删除角色模态框&ndash;%&gt;--%>
                        <%--<div id="deleteRole" class="modal fade" aria-labelledby="myModalLabel" aria-hidden="true">--%>
                            <%--<div class="form-wrap">--%>
                                <%--<div class="modal-dialog">--%>
                                    <%--<div class="modal-content">--%>
                                        <%--<div class="modal-header">--%>
                                            <%--<button class="close" data-dismiss="modal">--%>
                                                <%--<span>&times;</span>--%>
                                            <%--</button>--%>
                                        <%--</div>--%>
                                        <%--<div class="modal-title">--%>
                                            <%--<h1 class="text-center">删除</h1>--%>
                                        <%--</div>--%>
                                        <%--<div class="modal-body">--%>
                                            <%--<form class="form-group" id="form5" name="form5" action="/user/deleteRole" method="post" >--%>
                                                <%--<div class="modal-body">--%>
                                                    <%--<label> 确认删除？</label>--%>
                                                    <%--<input type="hidden" name="id" value=${role.id }>--%>
                                                <%--</div>--%>


                                                <%--<div class="modal-footer">--%>
                                                    <%--<button class="btn btn-primary" type="submit" id="tijiao2">提交</button>--%>
                                                    <%--<button class="btn btn-danger" data-dismiss="modal">取消</button>--%>
                                                <%--</div>--%>

                                            <%--</form>--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--&lt;%&ndash;删除角色模态框结束&ndash;%&gt;--%>

                        <td><a class="btn btn-info" data-target="#updateRolePermission" id="${role.id}" data-toggle="modal" href="">分配权限</a></td>

                        <%--&lt;%&ndash;分配权限模态框&ndash;%&gt;--%>
                        <%--<div id="updateRolePermission${role.id}" class="modal fade" aria-labelledby="myModalLabel" aria-hidden="true">--%>
                            <%--<div class="form-wrap">--%>
                                <%--<div class="modal-dialog">--%>
                                    <%--<div class="modal-content">--%>
                                        <%--<div class="modal-title">--%>
                                            <%--<h1 class="text-center">分配权限</h1>--%>
                                        <%--</div>--%>

                                        <%--<form class="form-group" id="form0" name="form0"--%>
                                              <%--action="" method="post">--%>
                                            <%--<div class="modal-body" id="updateRole">--%>
                                         <%--待完善--%>
                                            <%--</div>--%>
                                            <%--<div class="modal-footer">--%>
                                                <%--<button class="btn btn-primary" type="submit" id="tijiao223">提交--%>
                                                <%--</button>--%>
                                                <%--<button class="btn btn-danger" data-dismiss="modal">取消</button>--%>
                                            <%--</div>--%>

                                        <%--</form>--%>

                                    <%--</div>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--&lt;%&ndash;分配权限模态框结束&ndash;%&gt;--%>



                    </tr>
                </c:forEach>
                </tbody>
            </table>
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
                                <div class="modal-body" id="">
                                    暫未實現
                                </div>
                                <div class="modal-footer">
                                    <button class="btn btn-primary" type="submit" id="tijiao222">提交
                                    </button>
                                    <button class="btn btn-danger" data-dismiss="modal">取消</button>
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
                                    <button class="btn btn-danger" data-dismiss="modal">取消</button>
                                </div>
                            </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <%--删除角色模态框结束--%>
            <%--分配权限模态框--%>
            <div id="updateRolePermission${role.id}" class="modal fade" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="form-wrap">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-title">
                                <h1 class="text-center">分配权限</h1>
                            </div>

                            <form class="form-group" id="form0" name="form0"
                                  action="" method="post">
                                <div class="modal-body" id="updateRole">
                                    待完善
                                </div>
                                <div class="modal-footer">
                                    <button class="btn btn-primary" type="submit" id="tijiao223">提交
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
<script>
    $(function() {
        var x = $('#form1').bootstrapValidator({
            message: 'This value is not valid',
            fields: {

                name: {
                    validators: {
                        notEmpty: {
                            message: '角色名不能为空'
                        }
                    }
                },
                description: {
                    validators: {
                        notEmpty: {
                            message: '描述不能为空'
                        }
                    }
                }


            }
        });
    });

</script>
<script type="text/javascript">
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
