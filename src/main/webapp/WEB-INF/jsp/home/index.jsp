<%--
  Created by IntelliJ IDEA.
  User: Tony Yao
  Date: 2017/8/12
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>寻房网</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <script src="/assets/home/index/js/index.js" type="text/javascript"></script>
    <script src="/assets/home/index/js/header.js" type="text/javascript"></script>

    <link rel="stylesheet" href="/assets/home/index/css/index.css">
    <link rel="stylesheet" href="/assets/home/index/css/header.css">
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
                    <a class="navbar-brand" href="home#">寻房网</a>
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
                    <ul class="nav navbar-nav navbar-right">

                        <li>
                            <a href="home#"><b>热搜词：</b></a>
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
                <div class="navbar-header">
                    <a class="navbar-brand" href="home#">寻房网</a>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <div class="navbar-form navbar-left" role="search">
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
            <%--左侧条件搜索的设置--%>
            <div class="row clearfix ">
                <div class="col-md-3 column">
                    <ul class="list-group search-terms">
                        <li class="search-terms-item item-location">
                            <div class="search-terms-title">
                                <a href="/home/search">位置</a>
                            </div>
                            <ul class="list-inline search-terms-list select-location">
                                <c:forEach var="location" items="${locations}" begin="1" end="4">
                                    <li>
                                        <a href="javascript:void(0);" name="${location.code}" >
                                                ${location.name}
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>

                            <div class="hoverBlock">
                                <h3>所有位置</h3>
                                <div class="condition-all">
                                    <ul class="condition-col select-location">
                                        <c:forEach var="location" items="${locations}">
                                            <li>
                                                <a href="javascript:void(0);" name="${location.code}" >
                                                        ${location.name}
                                                </a>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>

                        </li>

                        <li class="search-terms-item item-area">
                            <div class="search-terms-title">
                                <a href="/home/search">面积</a>
                            </div>
                            <ul class="list-inline search-terms-list select-area">
                                <c:forEach var="area" items="${areas}" begin="2" end="3">
                                    <li>
                                        <a href="javascript:void(0);" name="${area.code}" >
                                                ${area.name}
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>
                            <div class="hoverBlock">
                                <h3>所有面积</h3>
                                <div class="condition-all">
                                    <ul class="condition-col select-area">
                                        <c:forEach var="area" items="${areas}">
                                            <li>
                                                <a href="javascript:void(0);" name="${area.code}" >
                                                        ${area.name}
                                                </a>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>
                        </li>

                        <li class="search-terms-item item-type">
                            <div class="search-terms-title">
                                <a href="/home/search">类型</a>
                            </div>
                            <ul class="list-inline search-terms-list select-type">
                                <c:forEach var="type" items="${types}" begin="2" end="3">
                                    <li>
                                        <a href="javascript:void(0);" name="${type.code}" >
                                                ${type.name}
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>
                            <div class="hoverBlock">
                                <h3>所有类型</h3>
                                <div class="condition-all">
                                    <ul class="condition-col select-type">
                                        <c:forEach var="type" items="${types}">
                                            <li>
                                                <a href="javascript:void(0);" name="${type.code}" >
                                                        ${type.name}
                                                </a>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>
                        </li>

                        <li class="search-terms-item item-houseType" >
                            <div class="search-terms-title">
                                <a href="/home/search">户型</a>
                            </div>
                            <ul class="list-inline search-terms-list select-houseType">
                                <c:forEach var="houseType" items="${houseTypes}" begin="1" end="4">
                                    <li>
                                        <a href="javascript:void(0);" name="${houseType.code}" >
                                                ${houseType.name}
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>
                            <div class="hoverBlock">
                                <h3>所有户型</h3>
                                <div class="condition-all ">
                                    <ul class="condition-col select-houseType">
                                        <c:forEach var="houseType" items="${houseTypes}">
                                            <li>
                                                <a href="javascript:void(0);" name="${houseType.code}" >
                                                        ${houseType.name}
                                                </a>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>

                        </li>

                        <li class="search-terms-item item-unit-price">
                            <div class="search-terms-title">
                                <a href="/home/search">单价</a>
                            </div>
                            <ul class="list-inline search-terms-list select-unit-price">
                                <c:forEach var="unit_price" items="${unit_prices}" begin="1" end="2">
                                    <li>
                                        <a href="javascript:void(0);" name="${unit_price.code}" >
                                                ${unit_price.name}
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>
                            <div class="hoverBlock ">
                                <h3>所有单价</h3>
                                <div class="condition-all ">
                                    <ul class="condition-col select-unit-price">
                                        <c:forEach var="unit_price" items="${unit_prices}">
                                            <li>
                                                <a href="javascript:void(0);" name="${unit_price.code}" >
                                                        ${unit_price.name}
                                                </a>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>
                        </li>

                        <li class="search-terms-item item-total-price">
                            <div class="search-terms-title">
                                <a href="/home/search">总价</a>
                            </div>
                            <ul class="list-inline search-terms-list select-total-prices">
                                <c:forEach var="total_price" items="${total_pricess}" begin="1" end="2">
                                    <li>
                                        <a href="javascript:void(0);" name="${total_price.code}" >
                                                ${total_price.name}
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>
                            <div class="hoverBlock ">
                                <h3>所有总价</h3>
                                <div class="condition-all ">
                                    <ul class="condition-col select-total-prices">
                                        <c:forEach var="total_price" items="${total_pricess}">
                                            <li>
                                                <a href="javascript:void(0);" name="${total_price.code}" >
                                                        ${total_price.name}
                                                </a>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>
                        </li>

                        <li class="search-terms-item item-total-price">
                            <div class="search-terms-title">
                                <a href="/home/search">特色房</a>
                            </div>
                            <ul class="list-inline search-terms-list select-feature">
                                <c:forEach var="feature" items="${features}" begin="1" end="4">
                                    <li>
                                        <a href="javascript:void(0);" name="${feature.code}" >
                                                ${feature.name}
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>

                            <div class="hoverBlock">
                                <h3>所有特色房</h3>
                                <div class="condition-all">
                                    <ul class="condition-col select-feature">
                                        <c:forEach var="feature" items="${features}">
                                            <li>
                                                <a href="javascript:void(0);" name="${feature.code}" >
                                                        ${feature.name}
                                                </a>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>

                        </li>

                    </ul>
                </div>
                <%--右侧轮播图的设置--%>
                <div class="col-md-9 column set_carousel">
                    <div class="carousel slide " id="carousel-index">
                        <ol class="carousel-indicators">
                            <li class="active" data-slide-to="0" data-target="#carousel-index">
                            </li>
                            <li data-slide-to="1" data-target="#carousel-index">
                            </li>
                            <li data-slide-to="2" data-target="#carousel-index">
                            </li>
                        </ol>
                        <div class="carousel-inner carousel-image">
                            <div class="item active">
                                <a href="/home/details/${RecommendEstate.get(0).id}">
                                    <img alt="" src="/assets/home/index/image/default.jpg"/>
                                </a>
                                <div class="carousel-caption carousel-title">
                                    <h3>
                                        1、${RecommendEstate.get(0).estateName}
                                    </h3>
                                </div>
                            </div>
                            <div class="item">
                                <a href="/home/details/${RecommendEstate.get(1).id}">
                                    <img alt="" src="/assets/home/index/image/default1.jpg" />
                                </a>
                                <div class="carousel-caption carousel-title">
                                    <h3>
                                        2、${RecommendEstate.get(1).estateName}
                                    </h3>
                                </div>
                            </div>
                            <div class="item">
                                <a href="/home/details/${RecommendEstate.get(2).id}">
                                    <img alt="" src="/assets/home/index/image/default2.jpg" />
                                </a>
                                <div class="carousel-caption carousel-title">
                                    <h3>
                                        3、${RecommendEstate.get(2).estateName}
                                    </h3>
                                </div>
                            </div>
                        </div>
                        <a class="left carousel-control" href="#carousel-index" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left"></span>
                        </a>
                        <a class="right carousel-control" href="#carousel-index" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right"></span>
                        </a>
                    </div>
                </div>
            </div>

            <%--热门楼盘的设置--%>
            <div class="hot_bg">

                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <h3 class="text-center">
                            <b>本周高性价比楼盘TOP8</b>
                        </h3>
                    </div>
                </div>

                <%--显示推荐楼盘的区域，具体代码在js文件中用ajxa实现--%>
                <div id="RecommendedEstate_div" class="row">
                </div>
            </div>

            <%--最新楼盘的设置--%>
            <div class="hot_bg">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <h3 class="text-center">
                            <b>本周最新楼盘TOP8</b>
                        </h3>
                    </div>
                </div>

                <%--显示推荐楼盘的区域，具体代码在js文件中用ajxa实现--%>
                <div id="LatestEstate_div" class="row">
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
