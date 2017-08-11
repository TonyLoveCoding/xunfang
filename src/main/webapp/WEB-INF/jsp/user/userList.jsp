<%--
  Created by IntelliJ IDEA.
  User: ZYZ
  Date: 2017/8/11
  Time: 8:58
  To change this template use File | Settings | File Templates.
--%>
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
<%--查找用户框，增加用户按钮
--%>
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

                </tr>

                </tbody>
            </table>
        </div>
        <div class="col-xs-12 column">
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
                    <h1 class="text-center">添加</h1>
                </div>
                <div class="modal-body">
                    <form class="form-group" id="form1" name="form1" action="/user/addUser" method="post" novalidate>
                        <div class="modal-body">
                            <label>用户名</label>
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

<%--模态框结束--%>

</body>
</html>
