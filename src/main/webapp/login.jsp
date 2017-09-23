<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: ZYZ
  Date: 2017/8/19
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

</head >

<body >
<div id="Layer1" style="position:absolute; left:0px; top:0px; width:100%; height:100%">
    <img src="/assets/login/background3.jpg" width="100%" height="100%"/>
</div>
<div class="container" >
    <div class="row clearfix">
        <div class="col-md-4 column">
        </div>
        <div class="col-md-4 column  form-box">
            <h3 class="cursive-font text-center">后台管理系统</h3>
            <form class="form-horizontal"  action="/login/login" method="POST">
                <div class="form-group">
                    <label for="id" class="col-sm-2 control-label">账号</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="id" name="account" placeholder="输入你的账户"/>
                    </div>
                </div>
                <div class="form-group" method="post">
                    <label  class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" name="password" placeholder="输入你的密码"/>
                    </div>
                </div>

                <div class="form-group"method="post">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">登录</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-md-4 column"method="post">
        </div>
    </div>
</div>
</body>

</html>
