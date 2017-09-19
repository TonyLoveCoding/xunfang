<%--
  Created by IntelliJ IDEA.
  User: Tony Yao
  Date: 2017/8/16
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>寻房网</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <script src="/assets/home/index/js/header.js" type="text/javascript"></script>

    <link rel="stylesheet" href="/assets/home/index/css/index.css">
    <link rel="stylesheet" href="/assets/home/index/css/header.css">
    <link rel="stylesheet" href="/assets/home/notFound/css/notFound.css">


    <script type="text/javascript">
        $(document).ready(function() {
            function jump(count) {
                window.setTimeout(function(){
                    count--;
                    if(count > 0) {
                        $('#jump_text').html("访问页面出错!将在"+ count +"秒后跳转至<a href=\"home\">主页</a>……");
                        jump(count);
                    } else {
                        location.href="home";
                    }
                }, 1000);
            }
            jump(10);
        });
    </script>
</head>
<body>

<%--条件搜索的提交表单--%>
<form action="/home/search" method="get" id="form_search">
    <input id="inp_hid_pn" type="hidden" name="pn" value="1">
    <input id="inp_hid_keyword" type="hidden" name="keyWord" value="">
    <input id="inp_hid_saleStatus" type="hidden" name="saleStatus" value="none">
    <input id="inp_hid_location" type="hidden" name="location" value="none">
    <input id="inp_hid_totalPrices" type="hidden" name="totalPrices" value="none">
    <input id="inp_hid_type" type="hidden" name="type" value="none">
    <input id="inp_hid_houseType" type="hidden" name="houseType" value="none">
    <input id="inp_hid_feature" type="hidden" name="feature" value="none">
    <input id="inp_hid_unitPrice" type="hidden" name="unitPrice" value="none">
    <input id="inp_hid_area" type="hidden" name="area" value="none">
</form>

<div class="container-fluid">
    <%--浮动框的设置--%>
    <div class="header-hover">
        <div class="header-hover-wrap">
            <ul class="menu">
                <div class="navbar-header">
                    <a href="home">
                        <img style="padding-top: 14px" src="/assets/home/index/image/logo.png">
                    </a>
                </div>

                <div class="collapse navbar-collapse" >

                    <div class="navbar-form navbar-left" role="search">
                        <div class="form-group">
                            <input id="search-input-hover" type="text" class="form-control"/>
                        </div>
                        <button id="search-button-hover" type="submit" class="btn btn-danger">
                            <span class="glyphicon glyphicon-search"></span>找房
                        </button>
                    </div>
                    <ul class="nav navbar-nav navbar-right"  style="padding-top: 8px">

                        <li>
                            <a href="home"><b>热搜词：</b></a>
                        </li>

                        <c:forEach begin="0" end="2" items="${RecommendEstate}" var="estate">
                            <li>
                                <a href="home/details/${estate.id}">${estate.estateName}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </ul>
        </div>
    </div>


    <div class="row clearfix">
        <div class="col-md-12 column">
            <%--顶部导航栏设置--%>
            <nav class="navbar navbar-default " role="navigation">

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <div class="navbar-form navbar-left" role="search">
                        <a href="home">
                            <img src="/assets/home/index/image/logo.png">
                        </a>
                        <div class="form-group">
                            <input id="search-input" type="text" class="form-control"  />
                        </div>
                        <button id="search-button" class="btn btn-danger" type="button">
                            <span class="glyphicon glyphicon-search"></span> 找房
                        </button>
                    </div>
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="javascript:void(0);" style="text-decoration-color: red">热搜词：</a>
                        </li>

                        <c:forEach begin="0" end="4" items="${RecommendEstate}" var="estate">
                            <li>
                                <a href="home/details/${estate.id}">${estate.estateName}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </nav>
        </div>
    </div>

    <div class="bg">
        <div class="row clearfix">
            <div class="col-md-8 column col-md-offset-4">
                <div class="col-md-3 ">
                    <img src="/assets/home/notFound/img/notFound.png">
                </div>
                <div class="col-md-4 notFoundMessage">
                    <h3>
                        访问的页面不存在！
                    </h3>
                    <p id="jump_text">
                        访问页面出错!将在10秒后跳转至<a href="home">主页</a>……
                    </p>
                </div>
            </div>
        </div>
    </div>

</div>


</body>

<footer>
    <div class="container">
        <div class="row">
            <div class="col-sm-2">
                <h6>Copyright &copy;易拓工作室</h6>
            </div>

            <div class="col-sm-2">
                <h6><a href="javascript:void(0);">关于我们</a></h6>
            </div>

            <div class="col-sm-2">
                <h6><a href="javascript:void(0);">招聘信息</a></h6>
            </div>

            <div class="col-sm-2">
                <h6><a href="javascript:void(0);">服务声明</a></h6>
            </div>

            <div class="col-sm-2">
                <h6><a href="javascript:void(0);">投诉反馈</a></h6>
            </div>

            <div class="col-sm-2">
                <h6>本网站由易拓工作室制作</h6>
            </div>
        </div>
        <div class="row col-sm-12">
            <p class="text-center">
                易拓工作室
                ©2014-2017 rights reversed.
            </p>
        </div>
    </div>
</footer>
</html>
