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

    <script src="assets/home/index/js/index.js" type="text/javascript"></script>

    <link rel="stylesheet" href="assets/home/index/css/index.css">
    <link rel="stylesheet" href="assets/home/index/css/header.css">
</head>
<body>
<div class="header-hover">
    <div class="header-hover-wrap">
        <ul class="menu">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">寻房网</a>
            </div>

            <div class="collapse navbar-collapse" >

                <form class="navbar-form navbar-left" role="search">
                    <div class="form-group">
                        <input type="text" class="form-control" />
                    </div> <button type="submit" class="btn btn-default"><span class="ico ico-search"></span>找房</button>
                </form>
                <ul class="nav navbar-nav navbar-right">

                    <li>
                        <a href="#"><b>热搜词：</b></a>
                    </li>
                    <li>
                        <a href="#">实地蔷薇国际</a>
                    </li>

                    <li>
                        <a href="#">万科幸福誉</a>
                    </li>
                    <li>
                        <a href="#">南沙保利城</a>
                    </li>
                    <li>
                        <a href="#">富力伯爵山</a>
                    </li>
                    <li>
                        <a href="#">佳兆业城市广场</a>
                    </li>
                </ul>
            </div>
        </ul>
    </div>
</div>

<div class="container ">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <nav class="navbar navbar-default " role="navigation">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">寻房网</a>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                    <form class="navbar-form navbar-left" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control" />
                        </div> <button type="submit" class="btn btn-default"><span class="ico ico-search"></span>找房</button>
                    </form>
                    <ul class="nav navbar-nav navbar-right">

                        <li>
                            <a href="#">热搜词：</a>
                        </li>
                        <li>
                            <a href="#">实地蔷薇国际</a>
                        </li>

                        <li>
                            <a href="#">万科幸福誉</a>
                        </li>
                        <li>
                            <a href="#">南沙保利城</a>
                        </li>
                        <li>
                            <a href="#">富力伯爵山</a>
                        </li>
                        <li>
                            <a href="#">佳兆业城市广场</a>
                        </li>
                    </ul>
                </div>

            </nav>
            <div class="row clearfix ">
                <div class="col-md-3 column">
                    <ul class="list-group search-terms">
                        <li class="search-terms-item hoverDiv">
                            <h3><a href="#">区域</a></h3>
                            <ul class="list-inline search-terms-list">
                                <li><a href="#">南沙</a></li>
                                <li><a href="#">黄埔</a></li>
                                <li><a href="#">花都</a></li>
                                <li><a href="#">增城</a></li>
                            </ul>

                            <div class="hoverBlock">
                                <h3>所有区域</h3>
                                <div class="condition-all">
                                    <ul class="condition-col">
                                        <a href="#">不限</a>
                                        <li><a href="#">南沙</a></li>
                                        <li><a href="#">黄埔</a></li>
                                        <li><a href="#">花都</a></li>
                                        <li><a href="#">增城</a></li>
                                        <li><a href="#">番禺</a></li>
                                        <li><a href="#">白云</a></li>
                                        <li><a href="#">天河</a></li>
                                        <li><a href="#">荔湾</a></li>
                                        <li><a href="#">海珠</a></li>
                                        <li><a href="#">从化</a></li>
                                        <li><a href="#">越秀</a></li>
                                        <li><a href="#">广州周边</a></li>
                                    </ul>
                                </div>
                            </div>

                        </li>


                        <li class="search-terms-item">
                            <h3><a href="#">地铁房</a></h3>
                            <ul class="list-inline search-terms-list">
                                <li><a href="#">1号线</a></li>
                                <li><a href="#">3号线</a></li>
                                <li><a href="#">5号线</a></li>
                                <li><a href="#">APM线</a></li>
                            </ul>
                            <div class="hoverBlock">
                                <h3>所有地铁线路</h3>
                                <div class="condition-all">
                                    <ul class="condition-col">
                                        <a href="#">不限</a>
                                        <li><a href="#">1号线</a></li>
                                        <li><a href="#">2号线</a></li>
                                        <li><a href="#">3号线</a></li>
                                        <li><a href="#">4号线</a></li>
                                        <li><a href="#">5号线</a></li>
                                        <li><a href="#">6号线</a></li>
                                        <li><a href="#">7号线</a></li>
                                        <li><a href="#">8号线</a></li>
                                        <li><a href="#">APM线</a></li>
                                        <li><a href="#">广佛线</a></li>
                                    </ul>
                                </div>
                            </div>

                        </li>

                        <li class="search-terms-item">
                            <h3><a href="#">户型</a></h3>
                            <ul class="list-inline search-terms-list">
                                <li><a href="#">一居</a></li>
                                <li><a href="#">二居</a></li>
                                <li><a href="#">三居</a></li>
                                <li><a href="#">四居</a></li>
                            </ul>

                            <div class="hoverBlock">
                                <h3>所有户型</h3>
                                <div class="condition-all">
                                    <ul class="condition-col">
                                        <a href="#">不限</a>
                                        <li><a href="#">一居</a></li>
                                        <li><a href="#">二居</a></li>
                                        <li><a href="#">三居</a></li>
                                        <li><a href="#">四居</a></li>
                                        <li><a href="#">五居及以上</a></li>
                                    </ul>
                                </div>
                            </div>

                        </li>

                        <li class="search-terms-item item-price">
                            <h3><a href="#">价格</a></h3>
                            <ul class="list-inline search-terms-list">
                                <li><a href="#"><1万/平方米</a></li>
                                <li><a href="#">1万-1万/平方米</a></li>
                                <li><a href="#">100-150万/套</a></li>
                                <li><a href="#">150-200万/套</a></li>
                            </ul>

                            <div class="hoverBlock condition-cols2">
                                <h3>所有价格</h3>
                                <div class="condition-all ">
                                    <ul class="condition-col">
                                        <li><b>单价:</b></li>
                                        <a href="#">不限</a>
                                        <li><a href="#"><1万</a></li>
                                        <li><a href="#">1万-1.5万</a></li>
                                        <li><a href="#">1.5万-2万</a></li>
                                        <li><a href="#">2万-2.5万</a></li>
                                        <li><a href="#">2.5万-3万</a></li>
                                        <li><a href="#">3万-4万</a></li>
                                        <li><a href="#">> 4万</a></li>

                                    </ul>
                                    <ul class="condition-col">
                                        <li><b>总价:</b></li>
                                        <a href="#">不限</a>
                                        <li><a href="#"><100万</a></li>
                                        <li><a href="#">100-150万</a></li>
                                        <li><a href="#">150-200万</a></li>
                                        <li><a href="#">200-250万</a></li>
                                        <li><a href="#">250-300万</a></li>
                                        <li><a href="#">300-500万</a></li>
                                        <li><a href="#">500-800万</a></li>
                                        <li><a href="#">800-1000万</a></li>
                                        <li><a href="#">>1000万</a></li>
                                    </ul>

                                </div>

                            </div>

                        </li>

                        <li class="search-terms-item">
                            <h3><a href="#">特色房</a></h3>
                            <ul class="list-inline search-terms-list">
                                <li><a href="#">临地铁</a></li>
                                <li><a href="#">精装修</a></li>
                                <li><a href="#">现房</a></li>
                                <li><a href="#">小户型</a></li>
                            </ul>

                            <div class="hoverBlock">
                                <h3>所有特色房</h3>
                                <div class="condition-all">
                                    <ul class="condition-col">
                                        <a href="#">不限</a>
                                        <li><a href="#">临地铁</a></li>
                                        <li><a href="#">精装修</a></li>
                                        <li><a href="#">现房</a></li>
                                        <li><a href="#">小户型</a></li>
                                        <li><a href="#">自由购</a></li>
                                        <li><a href="#">品牌地产</a></li>
                                    </ul>
                                </div>
                            </div>

                        </li>

                    </ul>
                </div>
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
                                <img alt="" src="assets/home/index/image/default.jpg" />
                                <div class="carousel-caption">
                                    <h4>
                                        First 楼盘1
                                    </h4>
                                </div>
                            </div>
                            <div class="item">
                                <img alt="" src="assets/home/index/image/default1.jpg" />
                                <div class="carousel-caption">
                                    <h4>
                                        Second 楼盘2
                                    </h4>
                                </div>
                            </div>
                            <div class="item">
                                <img alt="" src="assets/home/index/image/default2.jpg" />
                                <div class="carousel-caption">
                                    <h4>
                                        Third 楼盘3
                                    </h4>
                                </div>
                            </div>
                        </div> <a class="left carousel-control" href="#carousel-888301" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-888301" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
                    </div>
                </div>
            </div>

            <div class="hot_bg">

                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <h3 class="text-center">
                            本周高性价比楼盘TOP8
                        </h3>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-3">
                        <div class="thumbnail">
                            <a href="#"> <img alt="300x200" src="assets/home/index/image/example1.jpg" /> </a>
                            <div class="caption">
                                <h3>
                                    <a href="#">实地蔷薇国际</a>
                                </h3>
                                <p>
                                    增城 | 建面: 85-117 m² | 157-216 万
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="thumbnail">
                            <a href="#"> <img alt="300x200" src="assets/home/index/image/example1.jpg" /> </a>
                            <div class="caption">
                                <h3>
                                    <a href="#">实地蔷薇国际</a>
                                </h3>
                                <p>
                                    增城 | 建面: 85-117 m² | 157-216 万
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="thumbnail">
                            <a href="#"> <img alt="300x200" src="assets/home/index/image/example1.jpg" /> </a>
                            <div class="caption">
                                <h3>
                                    <a href="#">实地蔷薇国际</a>
                                </h3>
                                <p>
                                    增城 | 建面: 85-117 m² | 157-216 万
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="thumbnail">
                            <a href="#"> <img alt="300x200" src="assets/home/index/image/example1.jpg" /> </a>
                            <div class="caption">
                                <h3>
                                    <a href="#">实地蔷薇国际</a>
                                </h3>
                                <p>
                                    增城 | 建面: 85-117 m² | 157-216 万
                                </p>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-3">
                        <div class="thumbnail">
                            <a href="#"> <img alt="300x200" src="assets/home/index/image/example1.jpg" /> </a>
                            <div class="caption">
                                <h3>
                                    <a href="#">实地蔷薇国际</a>
                                </h3>
                                <p>
                                    增城 | 建面: 85-117 m² | 157-216 万
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="thumbnail">
                            <a href="#"> <img alt="300x200" src="assets/home/index/image/example1.jpg" /> </a>
                            <div class="caption">
                                <h3>
                                    <a href="#">实地蔷薇国际</a>
                                </h3>
                                <p>
                                    增城 | 建面: 85-117 m² | 157-216 万
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="thumbnail">
                            <a href="#"> <img alt="300x200" src="assets/home/index/image/example1.jpg" /> </a>
                            <div class="caption">
                                <h3>
                                    <a href="#">实地蔷薇国际</a>
                                </h3>
                                <p>
                                    增城 | 建面: 85-117 m² | 157-216 万
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="thumbnail">
                            <a href="#"> <img alt="300x200" src="assets/home/index/image/example1.jpg" /> </a>
                            <div class="caption">
                                <h3>
                                    <a href="#">实地蔷薇国际</a>
                                </h3>
                                <p>
                                    增城 | 建面: 85-117 m² | 157-216 万
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <div class="hot_bg">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <h3 class="text-center">
                            本周最新楼盘TOP8
                        </h3>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-3">
                        <div class="thumbnail">
                            <a href="#"> <img alt="300x200" src="assets/home/index/image/example1.jpg" /> </a>
                            <div class="caption">
                                <h3>
                                    <a href="#">实地蔷薇国际</a>
                                </h3>
                                <p>
                                    增城 | 建面: 85-117 m² | 157-216 万
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="thumbnail">
                            <a href="#"> <img alt="300x200" src="assets/home/index/image/example1.jpg" /> </a>
                            <div class="caption">
                                <h3>
                                    <a href="#">实地蔷薇国际</a>
                                </h3>
                                <p>
                                    增城 | 建面: 85-117 m² | 157-216 万
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="thumbnail">
                            <a href="#"> <img alt="300x200" src="assets/home/index/image/example1.jpg" /> </a>
                            <div class="caption">
                                <h3>
                                    <a href="#">实地蔷薇国际</a>
                                </h3>
                                <p>
                                    增城 | 建面: 85-117 m² | 157-216 万
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="thumbnail">
                            <a href="#"> <img alt="300x200" src="assets/home/index/image/example1.jpg" /> </a>
                            <div class="caption">
                                <h3>
                                    <a href="#">实地蔷薇国际</a>
                                </h3>
                                <p>
                                    增城 | 建面: 85-117 m² | 157-216 万
                                </p>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-3">
                        <div class="thumbnail">
                            <a href="#"> <img alt="300x200" src="assets/home/index/image/example1.jpg" /> </a>
                            <div class="caption">
                                <h3>
                                    <a href="#">实地蔷薇国际</a>
                                </h3>
                                <p>
                                    增城 | 建面: 85-117 m² | 157-216 万
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="thumbnail">
                            <a href="#"> <img alt="300x200" src="assets/home/index/image/example1.jpg" /> </a>
                            <div class="caption">
                                <h3>
                                    <a href="#">实地蔷薇国际</a>
                                </h3>
                                <p>
                                    增城 | 建面: 85-117 m² | 157-216 万
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="thumbnail">
                            <a href="#"> <img alt="300x200" src="assets/home/index/image/example1.jpg" /> </a>
                            <div class="caption">
                                <h3>
                                    <a href="#">实地蔷薇国际</a>
                                </h3>
                                <p>
                                    增城 | 建面: 85-117 m² | 157-216 万
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="thumbnail">
                            <a href="#"> <img alt="300x200" src="assets/home/index/image/example1.jpg" /> </a>
                            <div class="caption">
                                <h3>
                                    <a href="#">实地蔷薇国际</a>
                                </h3>
                                <p>
                                    增城 | 建面: 85-117 m² | 157-216 万
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
