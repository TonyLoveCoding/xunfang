<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="\css\bootstrap.css">

    <!-- 可选的Bootstrap主题文件（一般不用引入） -->
    <link rel="stylesheet" href="\css\bootstrap-theme.css">



</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-xs-12 column">
        </div>
        <div class="col-xs-12 column">
            <table class="table table-striped">
                <thead>
                <tr>


                    <form class="form-search" method="post" action="/user/findUser" >
                        <input class="input-medium search-query" type="text" name="name"/>

                        <button type="submit" class="btn">查找用户</button>
                    </form>
                    <a class="btn btn-success" data-target="#addUser" data-toggle="modal" href="">添加用户</a>
                    <form class="form-search" method="post" action="/user/findRole" >

                        <button type="submit" class="btn">角色管理</button>
                    </form>
                    <form class="form-search" method="post" action="/user/findUserList" >
                        <button type="submit" class="btn">用户列表</button>
                    </form>
                </tr>

                </tbody>
            </table>
        </div>
        <div class="col-xs-12 column">
        </div>
    </div>
</div>

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
                    <h1 class="text-center">添加</h1>
                </div>
                <div class="modal-body">
                    <form class="form-group" id="form1" name="form1" action="/user/addUser" method="post" novalidate>
                        <div class="modal-body">
                            <label>ID</label>
                            ${user.userid }<input type="hidden" name="id" value=${user.userid }>
                        </div>
                        <div class="modal-body">
                            <label>用户名</label>
                            <input type="text" name="name" value=${user.username }>
                        </div>
                        <div class="modal-body">
                            <label>密码</label>
                            <input class="form-control" type="password" name="password" autofocus="autofocus" placeholder="至少6位字母或数字" value="${user.password }">
                        </div>
                        <div class="modal-body">
                            <label>验证密码</label>
                            <input class="form-control" type="password" name="checkPwd" autofocus="autofocus" placeholder="至少6位字母或数字" value="${user.password}">
                        </div>

                        <div class="modal-body">
                            <label>性别</label>
                            <input type="radio" name="sex" value="男" checked>男
                            <input type="radio" name="sex" value="女">女</input>
                        </div>
                        <div class="modal-body">
                            <label>电话号码</label>
                            ${user.phone }<input type="text" name="phone" value=${user.phone }>
                        </div>
                        <div class="modal-body">
                            <label>年龄</label>
                            <input type="text" name="age" value=${user.age}>
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


<div class="container">
    <div class="row clearfix">
        <div class="col-xs-12 column">
        </div>
        <div class="col-xs-12 column">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>
                        ID
                    </th>
                    <th>
                        姓名
                    </th>
                    <th>
                        性别
                    </th>
                    <th>
                        电话
                    </th>
                    <th>
                        年龄
                    </th>
                    <th>
                    用户类型
                </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${list}" >

                    <tr>

                        <th>${user.userid }</th>
                        <th>${user.username }</th>
                        <th>${user.sex }</th>
                        <th>${user.phone }</th>
                        <th>${user.age}</th>
                        <th>${user.type }</th>

                        <td><a class="btn btn-success" data-target="#update${user.username }" data-toggle="modal" href="">修改</a></td>
                        <div id="update${user.username }" class="modal fade" aria-labelledby="myModalLabel" aria-hidden="true">
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
                                            <form class="form-group" id="form3" name="form3" action="/user/update" method="post" novalidate>
                                                <div class="modal-body">
                                                    <label>ID:</label>
                                                        ${user.userid }<input type="hidden" name="id" value=${user.userid }>
                                                </div>
                                                <div class="modal-body">
                                                    <label>用户名</label>
                                                        <input type="text" name="name" value=${user.username }>
                                                </div>
                                                <div class="modal-body">
                                                    <label>密码</label>
                                                    <input class="form-control" type="password" name="password" autofocus="autofocus" placeholder="至少6位字母或数字" value="${user.password }">
                                                </div>
                                                <div class="modal-body">
                                                    <label>验证密码</label>
                                                    <input class="form-control" type="password" name="checkPwd" autofocus="autofocus" placeholder="至少6位字母或数字" value="${user.password}">
                                                </div>

                                                <div class="modal-body">
                                                    <label>性别</label>
                                                    <input type="radio" name="sex" value="男" checked>男
                                                    <input type="radio" name="sex" value="女">女</input>
                                                </div>
                                                <div class="modal-body">
                                                    <label>电话号码</label>
                                                        <input type="text" name="phone" value=${user.phone }>
                                                </div>
                                                <div class="modal-body">
                                                    <label>年龄</label>
                                                      <input type="text" name="age" value=${user.age}>
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




                        <td><a class="btn btn-danger" data-target="#deleteUser${user.username }" data-toggle="modal" href="" method="post">删除</a></td>
                        <div id="deleteUser${user.username }" class="modal fade" aria-labelledby="myModalLabel" aria-hidden="true">
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
                                            <form class="form-group" id="form5" name="form5" action="/user/deleteUser" method="post" >
                                                <div class="modal-body">
                                                    <label> 确认删除？</label>
                                                        <input type="hidden" name="id" value=${user.userid }>
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

                        <td><a class="btn btn-info" data-target="#updateUserRole${user.username }" data-toggle="modal" href="">分配角色</a></td>
                        <div id="updateUserRole${user.username }" class="modal fade" aria-labelledby="myModalLabel" aria-hidden="true">
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
                                        <div class="modal-body">
                                            <form class="form-group" id="form0" name="form0" action="/user/updateUserRole" method="post" >
                                                <input type="hidden" name="userid" value=${user.userid }>
                                                <input type="radio" name="type" value="管理员" checked>管理员
                                                <input type="radio" name="type" value="教师"> 教师
                                                <input type="radio" name="type" value="学生">学生</input>



                                                <div class="modal-footer">
                                                    <button class="btn btn-primary" type="submit" id="tijiao223">提交</button>
                                                    <button class="btn btn-danger" data-dismiss="modal">取消</button>
                                                </div>

                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

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




<script src="/js/jquery-3.0.0.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/bootstrapValidator.js"></script>
<script src="/js/language/zh_CN.js"></script>
<script src="/js/jquery.flot.js"></script>
<script src="/js/jquery.flot.resize.js"></script>
<script src="/js/jquery.js"></script>
<script src="/js/bootstrapValidator.min.js"></script>
<script src="/js/bootstrap-paginator.js"></script>
<script src="/js/html5.js"></script>
<script src="/js/excanvas.min.js"></script>


</html>
