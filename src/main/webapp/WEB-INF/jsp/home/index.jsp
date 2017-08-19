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
                        <input id="search-input-hover" type="text" class="form-control" />
                    </div>
                    <button id="search-button-hover" type="submit" class="btn btn-danger">
                        <span class="glyphicon glyphicon-search"></span>找房
                    </button>
                </div>
                <ul class="nav navbar-nav navbar-right">

                    <li>
                        <a href="home#"><b>热搜词：</b></a>
                    </li>

                    <c:forEach begin="0" end="4" items="${list}" var="estate">
                        <li>
                            <a href="home/details/${estate.id}">${estate.estateName}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </ul>
    </div>
</div>


<div class="container ">
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
                            <input id="search-input" type="text" class="form-control" />
                        </div>
                        <button id="search-button" class="btn btn-danger" type="button">
                            <span class="glyphicon glyphicon-search"></span> 找房
                        </button>
                    </div>
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="javascript:void(0);" style="text-decoration-color: red">热搜词：</a>
                        </li>

                        <c:forEach begin="0" end="4" items="${list}" var="estate">
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
                        <li class="search-terms-item hoverDiv">
                            <h3><b>区域</b></h3>
                            <ul class="list-inline search-terms-list select-location">
                                <li><a href="javascript:void(0);" name="南沙">南沙</a></li>
                                <li><a href="javascript:void(0);" name="黄埔">黄埔</a></li>
                                <li><a href="javascript:void(0);" name="花都">花都</a></li>
                                <li><a href="javascript:void(0);" name="增城">增城</a></li>
                            </ul>

                            <div class="hoverBlock">
                                <h3>所有区域</h3>
                                <div class="condition-all">
                                    <ul class="condition-col select-location">
                                        <li><a href="javascript:void(0);" name="none">不限</a></li>
                                        <li><a href="javascript:void(0);" name="南沙">南沙</a></li>
                                        <li><a href="javascript:void(0);" name="黄埔">黄埔</a></li>
                                        <li><a href="javascript:void(0);" name="花都">花都</a></li>
                                        <li><a href="javascript:void(0);" name="增城">增城</a></li>
                                        <li><a href="javascript:void(0);" name="番禺">番禺</a></li>
                                        <li><a href="javascript:void(0);" name="白云">白云</a></li>
                                        <li><a href="javascript:void(0);" name="天河">天河</a></li>
                                        <li><a href="javascript:void(0);" name="荔湾">荔湾</a></li>
                                        <li><a href="javascript:void(0);" name="海珠">海珠</a></li>
                                        <li><a href="javascript:void(0);" name="从化">从化</a></li>
                                        <li><a href="javascript:void(0);" name="越秀">越秀</a></li>
                                        <li><a href="javascript:void(0);" name="广州周边">广州周边</a></li>
                                    </ul>
                                </div>
                            </div>

                        </li>


                        <li class="search-terms-item">
                            <h3><b>面积</b></h3>
                            <ul class="list-inline search-terms-list select-area">
                                <li><a href="javascript:void(0);" name="80_TO_120">80m²-120m²</a></li>
                                <li><a href="javascript:void(0);" name="120_TO_140">120m²-140m²</a></li>
                            </ul>
                            <div class="hoverBlock">
                                <h3>所有面积</h3>
                                <div class="condition-all">
                                    <ul class="condition-col select-area">
                                        <li><a href="javascript:void(0);" name="none">不限</a></li>
                                        <li><a href="javascript:void(0);" name="infinite_TO_50">小于50m²</a>
                                        <li><a href="javascript:void(0);" name="50_TO_80">50m²-80m²</a></li>
                                        <li><a href="javascript:void(0);" name="80_TO_120">80m²-120m²</a></li>
                                        <li><a href="javascript:void(0);" name="120_TO_140">120m²-140m²</a></li>
                                        <li><a href="javascript:void(0);" name="140_TO_160">140m²-160m²</a></li>
                                        <li><a href="javascript:void(0);" name="160_TO_infinite">大于160m²</a></li>
                                    </ul>
                                </div>
                            </div>
                        </li>

                        <li class="search-terms-item item-type">
                            <h3><b>户型</b></h3>
                            <ul class="list-inline search-terms-list select-houseType">
                                <li><a href="javascript:void(0);" name="二居">二居</a></li>
                                <li><a href="javascript:void(0);" name="三居">三居</a></li>
                                <li><a href="javascript:void(0);" name="四居">四居</a></li>
                                <li><a href="javascript:void(0);" name="一居">五居及以上</a></li>
                            </ul>
                            <ul class="list-inline search-terms-list select-unit-type">
                                <li><a href="javascript:void(0);" name="住宅">住宅</a></li>
                                <li><a href="javascript:void(0);" name="别墅">别墅</a></li>
                                <li><a href="javascript:void(0);" name="商业">商业</a></li>
                            </ul>

                            <div class="hoverBlock condition-cols2">
                                <h3>所有户型</h3>
                                <div class="condition-all ">
                                    <ul class="condition-col select-houseType">
                                        <li><b>户型:</b></li>
                                        <li><a href="javascript:void(0);" name="none">不限</a></li>
                                        <li><a href="javascript:void(0);" name="一居">一居</a></li>
                                        <li><a href="javascript:void(0);" name="二居">二居</a></li>
                                        <li><a href="javascript:void(0);" name="三居">三居</a></li>
                                        <li><a href="javascript:void(0);" name="四居">四居</a></li>
                                        <li><a href="javascript:void(0);" name="五居及以上">五居及以上</a></li>
                                    </ul>
                                    <ul class="condition-col select-type">
                                        <li><b>类型:</b></li>
                                        <li><a href="javascript:void(0);" name="none">不限</a></li>
                                        <li><a href="javascript:void(0);" name="住宅">住宅</a>
                                        <li><a href="javascript:void(0);" name="别墅">别墅</a></li>
                                        <li><a href="javascript:void(0);" name="商业">商业</a></li>
                                    </ul>
                                </div>
                            </div>

                        </li>

                        <li class="search-terms-item item-price">
                            <h3><b>价格</b></h3>
                            <ul class="list-inline search-terms-list select-unit-price">
                                <li><a href="javascript:void(0);" name="infinite_TO_10000">小于1万/平方米</a></li>
                                <li><a href="javascript:void(0);" name="10000_TO_15000">1万-1.5万/平方米</a></li>
                            </ul>
                            <ul class="list-inline search-terms-list select-total-prices">
                                <li><a href="javascript:void(0);" name="100_TO_150">100-150万/套</a></li>
                                <li><a href="javascript:void(0);" name="150_TO_200">150-200万/套</a></li>
                            </ul>

                            <div class="hoverBlock condition-cols2">
                                <h3>所有价格</h3>
                                <div class="condition-all ">
                                    <ul class="condition-col select-unit-price">
                                        <li><b>单价:</b></li>
                                        <li><a href="javascript:void(0);" name="none">不限</a></li>
                                        <li><a href="javascript:void(0);" name="infinite_TO_10000">小于1万</a></li>
                                        <li><a href="javascript:void(0);" name="10000_TO_15000">1万至1.5万</a></li>
                                        <li><a href="javascript:void(0);" name="15000_TO_20000">1.5万至2万</a></li>
                                        <li><a href="javascript:void(0);" name="20000_TO_25000">2万至2.5万</a></li>
                                        <li><a href="javascript:void(0);" name="25000_TO_30000">2.5万至3万</a></li>
                                        <li><a href="javascript:void(0);" name="30000_TO_40000">3万至4万</a></li>
                                        <li><a href="javascript:void(0);" name="40000_TO_infinite">大于4万</a></li>

                                    </ul>
                                    <ul class="condition-col select-total-prices">
                                        <li><b>总价:</b></li>
                                        <li><a href="javascript:void(0);" name="none">不限</a></li>
                                        <li><a href="javascript:void(0);" name="infinite_TO_100">小于100万</a></li>
                                        <li><a href="javascript:void(0);" name="100_TO_150">100至150万</a></li>
                                        <li><a href="javascript:void(0);" name="150_TO_200">150至200万</a></li>
                                        <li><a href="javascript:void(0);" name="200_TO_250">200至250万</a></li>
                                        <li><a href="javascript:void(0);" name="250_TO_300">250至300万</a></li>
                                        <li><a href="javascript:void(0);" name="300_TO_500">300至500万</a></li>
                                        <li><a href="javascript:void(0);" name="500_TO_800">500至800万</a></li>
                                        <li><a href="javascript:void(0);" name="800_TO_1000">800至1000万</a></li>
                                        <li><a href="javascript:void(0);" name="1000_TO_infinite">大于1000万</a></li>
                                    </ul>
                                </div>
                            </div>
                        </li>

                        <li class="search-terms-item">
                            <h3><b>特色房</b></h3>
                            <ul class="list-inline search-terms-list select-feature">
                                <li><a href="javascript:void(0);" name="临地铁">临地铁</a></li>
                                <li><a href="javascript:void(0);" name="精装修">精装修</a></li>
                                <li><a href="javascript:void(0);" name="现房">现房</a></li>
                                <li><a href="javascript:void(0);" name="小户型">小户型</a></li>
                            </ul>

                            <div class="hoverBlock">
                                <h3>所有特色房</h3>
                                <div class="condition-all">
                                    <ul class="condition-col select-feature">
                                        <li><a href="javascript:void(0);" name="none">不限</a></li>
                                        <li><a href="javascript:void(0);" name="临地铁">临地铁</a></li>
                                        <li><a href="javascript:void(0);" name="精装修">精装修</a></li>
                                        <li><a href="javascript:void(0);" name="现房">现房</a></li>
                                        <li><a href="javascript:void(0);" name="小户型">小户型</a></li>
                                        <li><a href="javascript:void(0);" name="自由购">自由购</a></li>
                                        <li><a href="javascript:void(0);" name="品牌地产">品牌地产</a></li>
                                    </ul>
                                </div>
                            </div>

                        </li>

                    </ul>
                </div>
                <%--右侧轮播图的设置--%>
                <div class="col-md-9 column">
                    <div class="carousel slide" id="carousel-888301">
                        <ol class="carousel-indicators">
                            <li class="active" data-slide-to="0" data-target="#carousel-888301">
                            </li>
                            <li data-slide-to="1" data-target="#carousel-888301">
                            </li>
                            <li data-slide-to="2" data-target="#carousel-888301">
                            </li>
                        </ol>
                        <div class="carousel-inner">
                            <div class="item active">
                                <a href="/home/details/${list.get(0).id}">
                                    <img alt="" src="/assets/home/index/image/default.jpg" />
                                </a>
                                <div class="carousel-caption carousel-title">
                                    <h3>
                                        1、${list.get(0).estateName}
                                    </h3>
                                </div>
                            </div>
                            <div class="item">
                                <a href="/home/details/${list.get(1).id}">
                                    <img alt="" src="/assets/home/index/image/default1.jpg" />
                                </a>
                                <div class="carousel-caption carousel-title">
                                    <h3>
                                        2、${list.get(1).estateName}
                                    </h3>
                                </div>
                            </div>
                            <div class="item">
                                <a href="/home/details/${list.get(2).id}">
                                    <img alt="" src="/assets/home/index/image/default2.jpg" />
                                </a>
                                <div class="carousel-caption carousel-title">
                                    <h3>
                                        3、${list.get(2).estateName}
                                    </h3>
                                </div>
                            </div>
                        </div> <a class="left carousel-control" href="#carousel-888301" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-888301" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
                    </div>
                </div>
            </div>

            <%--热门楼盘的设置--%>
            <div class="hot_bg">

                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <h3 class="text-center">
                            本周高性价比楼盘TOP8
                        </h3>
                    </div>
                </div>

                <div class="row">
                    <%--从list中取出热门楼盘信息展现，默认数量是8个--%>
                    <c:forEach begin="0" end="7" items="${list}" var="estate">
                        <div class="col-md-3">
                            <div class="thumbnail hovereffect">
                                <a href="home/details/${estate.id}">
                                <img class="img-responsive" src="/assets/home/index/image/example1.jpg" alt="">
                                    <div class="overlay">
                                        <h2>${estate.estateName}</h2>
                                    </div>
                                </a>
                                <div class="caption">
                                    <h3>
                                        <a href="home/details#">${estate.estateName}</a>
                                    </h3>
                                    <p>
                                        ${estate.location} | 建面: ${estate.area} m² | ${estate.minPrice}-${estate.maxPrice} 万
                                    </p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>

            <%--最新楼盘的设置--%>
            <div class="hot_bg">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <h3 class="text-center">
                            本周最新楼盘TOP8
                        </h3>
                    </div>
                </div>

                <div class="row">
                    <%--从list中取出最新楼盘信息展现，默认数量是8个--%>
                    <c:forEach begin="8" end="15" items="${list}" var="estate">
                        <div class="col-md-3">
                            <div class="thumbnail hovereffect">
                                <a href="home/details/${estate.id}">
                                    <img class="img-responsive" src="/assets/home/index/image/example1.jpg" alt="">
                                    <div class="overlay">
                                        <h2>${estate.estateName}</h2>
                                    </div>
                                </a>
                                <div class="caption">
                                    <h3>
                                        <a href="home/details#">${estate.estateName}</a>
                                    </h3>
                                    <p>
                                            ${estate.location} | 建面: ${estate.area} m² | ${estate.minPrice}-${estate.maxPrice} 万
                                    </p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
