<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>

    <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
    <link href="/assets/menu/font-awesome.min.css" rel="stylesheet" media="screen">
    <link rel="stylesheet" href="/assets/menu/sidebar-menu.css">
    <style type="text/css">
        body{margin:0; padding:0;}
        .main-sidebar{
            position: absolute;
            top: 50px;
            left: 0;
            height: 103%;
            min-height: 100%;
            width: 230px;
            z-index: 810;
            background-color: #222d32;
        }
        .navbar{
            margin-bottom: 0px!important;
            width: 100%;
            height: 50px;
            background-color: #3c8dbc;
            border-radius: 0;
        }
        .navbarLeft{
            float: left;
            background-color: #367fa9;
            width: 230px;
            height: 100%;
        }
        .navbarLeft .logo-lg{
            display: block;
            color: #fff;
            font-size: 20px;
            line-height: 50px;
            text-align: center;
            font-weight: 300;
            font-family: Helvetica, 'Hiragino Sans GB', 'Microsoft Yahei', '微软雅黑', Arial, sans-serif;
        }
        .navbarLeft .logo-lg b{

            font-weight: 600;
        }
        #iframeMain{
            width: 100%;
            height: 100%;
            padding-left: 230px;
        }
        html,body{
            height:100%;
        }
    </style>
</head>
<body>
<nav class="navbar">
    <div class="navbarLeft"><span class="logo-lg"><b>寻房网</b><div class="glyphicon glyphicon-home"></div>后台管理</span></div>
</nav>
<aside class="main-sidebar">
    <section id="div_menu" class="sidebar">
    </section>
</aside>
<iframe src="/main/welcome" id="iframeMain"  scrolling="no" frameborder="0" ></iframe>

<script src="/assets/menu/jquery.min.js"></script>
<script src="/assets/menu/sidebar-menu.js"></script>
<script src="/assets/jsp/main/menu.js"></script>
</body>
</html>