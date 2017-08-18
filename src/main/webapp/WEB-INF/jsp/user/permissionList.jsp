<%--
  Created by IntelliJ IDEA.
  User: ZYZ
  Date: 2017/8/14
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
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


                    <form class="form-search" method="post" action="/user/findPermissionByName" >
                        <input class="input-medium search-query" type="text" name="name"/>

                        <button type="submit" class="btn">查找权限</button>
                    </form>
                    <a class="btn btn-success" data-target="#addPermission" data-toggle="modal" href="">添加权限</a>

                </tr>

                </tbody>
            </table>
        </div>
        <div class="col-md-10 column">
        </div>
    </div>
</div>
<%--查找框结束--%>

<%--添加权限模态框--%>
<div id="addPermission" class="modal fade" aria-labelledby="myModalLabel" aria-hidden="true">
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
                    <form class="form-group" id="form1" name="form1" action="/user/addPermission" method="post" novalidate>
                        <div class="modal-body">

                            <label>权限名</label>
                            <input type="text" name="name" value=${permission.name }>
                        </div>

                        <div class="modal-body">

                            <label>权限描述</label>
                            <input type="text" name="name" value=${permission.description }>
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
<%--添加权限模态框结束--%>

<div class="container-fluid">
    <div class="row clearfix">
        <div class="col-md-12 column">
        </div>
        <div class="col-md-12 column">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>
                        ID
                    </th>
                    <th>
                        权限名
                    </th>
                    <th>权限描述</th>
                    <th>是否是菜单</th>
                    <th>url</th>
                    <th>父节点</th>
                    <th>创建时间</th>
                    <th>修改时间</th>
                    <th>状态</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach var="permission" items="${list}" >

                    <tr>

                        <th>${permission.id }</th>
                        <th>${permission.name }</th>
                        <th>${permission.description}</th>
                        <th>${permission.isMenu}</th>
                        <th>${permission.url}</th>
                        <th>${permission.parentId}</th>
                        <th>${permission.createtime}</th>
                        <th>${permission.updatetime}</th>
                        <th>${permission.status}</th>






                        <td><a class="btn btn-success" data-target="#update" data-toggle="modal" href="">修改</a></td>

                        <%--修改权限模态框--%>
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
                                            <form class="form-group" id="form3" name="form3" action="/user/updatePermission" method="post" novalidate>

                                                <div class="modal-body">
                                                    <label>权限名</label>
                                                    <input type="text" name="name" value=${permission.name }>
                                                </div>
                                                <div class="modal-body">
                                                    <label>权限描述</label>
                                                    <input type="text" name="name" value=${permission.description }>
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
                        <%--修改权限模态框结束--%>



                        <td><a class="btn btn-danger" data-target="#deletePermission" data-toggle="modal" href="" method="post">删除</a></td>

                        <%--删除权限模态框--%>
                        <div id="deletePermission" class="modal fade" aria-labelledby="myModalLabel" aria-hidden="true">
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
                                            <form class="form-group" id="form5" name="form5" action="/user/deletePermission" method="post" >
                                                <div class="modal-body">
                                                    <label> 确认删除？</label>
                                                    <input type="hidden" name="id" value=${permission.id }>
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
                        <%--删除权限模态框结束--%>



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
