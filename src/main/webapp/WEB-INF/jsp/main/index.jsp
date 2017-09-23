<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <link href="/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>

    <link href="/assets/menu/font-awesome.min.css" rel="stylesheet" media="screen">
    <link rel="stylesheet" href="/assets/menu/sidebar-menu.css">
    <link rel="stylesheet" href="/assets/menu/menu.css">
</head>
<body>
<nav class="navbar">
    <div class="navbarLeft"><span class="logo-lg"><b>寻房网</b><div class="glyphicon glyphicon-home"></div>后台管理</span></div>
    <div class="navbarRight div_logout"><a href="javascript:void(0);"><div class="text_center"><span class="glyphicon glyphicon-log-out"></span> 退出登录</div></a></div>
    <div class="navbarMiddle"><div class="text_center"><span class="glyphicon glyphicon-user"></span> 尊敬的${account}，您好！</div></div>
</nav>
<aside class="main-sidebar">
    <section id="div_menu" class="sidebar">
    </section>
</aside>
<div class="modal fade" id="tipModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title">确定要退出登录吗？</h4>
            </div>
            <div class="modal-body">
                <h2>当前用户：${account}</h2>
            </div>
            <div class="modal-footer">
                <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
                <button id="btn_logout" class="btn btn-danger" type="button">确定退出</button>
            </div>
        </div>
    </div>
</div>
<form id="form_logout" action="/login"></form>
<iframe src="/main/welcome" id="iframeMain"  scrolling="no" frameborder="0"></iframe>
<script src="/assets/menu/jquery.min.js"></script>
<script src="/assets/menu/sidebar-menu.js"></script>
<script src="/assets/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/assets/jsp/main/menu.js"></script>
</body>
</html>