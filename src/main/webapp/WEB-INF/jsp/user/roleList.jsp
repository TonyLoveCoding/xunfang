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

</head>
<body>

<%--查找框--%>
<div class="container-fluid">
    <div class="row clearfix">
        <div class="col-md-12 column">
        </div>
        <div class="col-md-12 column">
            <table class="table table-striped">
                <thead>
                <tr>


                    <form class="form-search" method="post" action="/user/findRoleByName" >
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

<%--添加用户模态框--%>
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
                    <form class="form-group" id="form1" name="form1" action="/user/addRole" method="post" novalidate>
                        <div class="modal-body">

                            <label>角色名</label>
                            <input type="text" name="name" value=${role.roleName }>
                        </div>
                        <div class="modal-body">

                            <label>角色描述</label>
                            <input type="text" name="name" value=${role.description }>
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
                                            <form class="form-group" id="form3" name="form3" action="/user/updateRole" method="post" novalidate>

                                                <div class="modal-body">
                                                    <label>角色名</label>
                                                    <input type="text" name="name" value=${role.roleName }>
                                                </div>
                                                <div class="modal-body">
                                                    <label>角色描述</label>
                                                    <input type="text" name="name" value=${role.description }>
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



                        <td><a class="btn btn-danger" data-target="#deleteRole" data-toggle="modal" href="" method="post">删除</a></td>

                        <%--删除角色模态框--%>
                        <div id="deleteRole" class="modal fade" aria-labelledby="myModalLabel" aria-hidden="true">
                            <div class="form-wrap">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button class="close" data-dismiss="modal">
                                                <span>&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-title">
                                            <h1 class="text-center">删除</h1>
                                        </div>
                                        <div class="modal-body">
                                            <form class="form-group" id="form5" name="form5" action="/user/deleteRole" method="post" >
                                                <div class="modal-body">
                                                    <label> 确认删除？</label>
                                                    <input type="hidden" name="id" value=${role.id }>
                                                </div>


                                                <div class="modal-footer">
                                                    <button class="btn btn-primary" type="submit" id="tijiao2">提交</button>
                                                    <button class="btn btn-danger" data-dismiss="modal">取消</button>
                                                </div>

                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <%--删除角色模态框结束--%>

                        <td><a class="btn btn-info" data-target="#updateRolePermission${role.id}" data-toggle="modal" href="">分配权限</a></td>

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



                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col-md-4 column">
        </div>
    </div>
</div>




</body>
</html>
