<%--
  Created by IntelliJ IDEA.
  User: ZYZ
  Date: 2017/8/11
  Time: 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">

    <!-- 可选的Bootstrap主题文件（一般不用引入） -->
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-theme.min.css">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="assets/jquery/query-3.2.1..min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<%--查找用户框，增加用户按钮
--%>
<div class="container-fluid">
    <div class="row clearfix">
        <div class="col-md-10 column">
        </div>
        <div class="col-md-10 column">
            <table class="table table-striped">
                <thead>
                <tr>


                    <form class="form-search" method="post" action="/user/findUser">
                        <input class="input-medium search-query" type="text" name="name"/>

                        <button type="submit" class="btn btn-success">查找用户</button>
                    </form>
                    <a class="btn btn-info" data-target="#addUser" data-toggle="modal" href="">添加用户</a>

                </tr>

                </tbody>
            </table>
        </div>

    </div>
</div>
<%--end>

<%--增加用户模态框
--%>
<div id="addUser" class="modal fade" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="form-wrap">
        <div class="modal-dialog">
            <div class="modal-content">

                <div class="modal-title">
                    <h1 class="text-center">添加用户</h1>
                </div>
                <div class="modal-body">
                    <form class="form-group" id="form1" name="form1" action="/user/addUser" method="post" novalidate>
                        <div class="modal-body">
                            <label>账号</label>
                            <input type="text" name="account" value=${user.account }>
                        </div>
                        <div class="modal-body">
                            <label>昵称</label>
                            <input type="text" name="name" value=${user.username }>
                        </div>

                        <div class="modal-body">
                            <label>密码</label>
                            <input type="password" name="password" autofocus="autofocus" placeholder="至少6位字母或数字"
                                   value="${user.password }">
                        </div>
                        <div class="modal-body">
                            <label>验证密码</label>
                            <input type="password" name="checkPwd" autofocus="autofocus" placeholder="至少6位字母或数字"
                                   value="${user.password}">
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

        <div class="col-md-10 column">
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
                    </th>

                    <th>
                        所拥有楼盘
                    </th>

                    <th>
                        用户类型
                    </th>
                    <th>
                        创建时间
                    </th>
                    <th>
                        最后更新时间
                    </th>
                    <th>
                        用户状态
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${list}">

                    <tr>

                        <th>${user.id }</th>
                        <th>${user.account }</th>
                        <th>${user.username }</th>
                        <th>${user.estatesRelevance }</th>
                            <%--可做成按钮，进行楼盘管理--%>
                        <th>${user.rolesRelevance}</th>
                        <th>${user.createtime }</th>
                        <th>${user.updatetime }</th>
                        <th>${user.status }</th>

                        <td><a class="btn btn-success" data-target="#updateUser" data-toggle="modal"
                               href="">修改</a></td>
                        <td><a class="btn btn-danger" data-target="#deleteUser" data-toggle="modal"
                               href="" method="post">删除</a></td>
                        <td><a class="btn btn-info" data-target="#updateUserRole" data-toggle="modal"
                               href="">分配角色</a></td>
                        <td><a class="btn btn-info" data-target="#updateEstate" data-toggle="modal"
                               href="">楼盘管理</a></td>


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
                                        <div class="modal-body">
                                            <form class="form-group" id="form3" name="form3" action="/user/updateUser"
                                                  method="post">
                                                <div class="modal-body">
                                                    <label>账号:</label>
                                                    <input type="text" name="account" value=${user.account }>
                                                </div>
                                                <div class="modal-body">
                                                    <label>昵称</label>
                                                    <input type="text" name="name" value=${user.username }>
                                                </div>
                                                <div class="modal-body">
                                                    <label>密码</label>
                                                    <input class="form-control" type="password" name="password"
                                                           autofocus="autofocus" placeholder="至少6位字母或数字"
                                                           value="${user.password }">
                                                </div>
                                                <div class="modal-body">
                                                    <label>验证密码</label>
                                                    <input class="form-control" type="password" name="checkPwd"  autofocus="autofocus" placeholder="至少6位字母或数字"               value="${user.password}">
                                                </div>



                                                <div class="modal-body">
                                                    <label>用户状态</label>
                                                    <input type="radio" name="status" value="1" checked>激活
                                                    <input type="radio" name="status" value="0">封禁</input>
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
                            <%--修改用户模态框结束--%>

                            <%--删除用户模态框--%>
                        <div id="deleteUser" class="modal fade" aria-labelledby="myModalLabel" aria-hidden="true">
                            <div class="form-wrap">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-title">
                                            <h1 class="text-center">删除</h1>
                                        </div>
                                        <div class="modal-body">
                                            <form class="form-group" id="form5" name="form5" action="/user/deleteUser"
                                                  method="post">
                                                <div class="modal-body">
                                                    <label> 确认删除？</label>
                                                    <input type="hidden" name="account" value=${user.account }>
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
                        </div>
                            <%--删除用户模态框结束--%>

                            <%--分配角色模态框--%>
                        <div id="updateUserRole" class="modal fade" aria-labelledby="myModalLabel"
                             aria-hidden="true">
                            <div class="form-wrap">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-title">
                                            <h1 class="text-center">分配角色</h1>
                                        </div>
                                        <div class="modal-body">
                                            <form class="form-group" id="form0" name="form0"
                                                  action="/user/updateUserRole" method="post">
                                                <input type="hidden" name="userid" value=${user.userid }>
                                                <input type="radio" name="type" value="管理员" checked>管理员
                                                <input type="radio" name="type" value="教师"> 教师
                                                <input type="radio" name="type" value="学生">学生</input>
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
                        </div>
                            <%--分配角色模态框结束--%>


                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

    </div>
</div>


</body>

</html>
