<%--
  Created by IntelliJ IDEA.
  User: Tony Yao
  Date: 2017/8/12
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>详情页面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <script src="/assets/home/index/js/header.js" type="text/javascript"></script>
    <script src="/assets/home/details/js/details.js" type="text/javascript"></script>

    <link rel="stylesheet" href="/assets/home/index/css/header.css">
    <link rel="stylesheet" href="/assets/home/details/css/details.css">

    <link rel="stylesheet" href="/assets/home/lightGallery/css/lightgallery.min.css">
    <script src="/assets/home/lightGallery/js/jquery.mousewheel.min.js" type="text/javascript"></script>
    <script src="/assets/home/lightGallery/js/lightgallery-all.js" type="text/javascript"></script>
    <script src="/assets/home/lightGallery/js/picturefill.min.js" type="text/javascript"></script>


    <script type="text/javascript">
        $(document).ready(function() {
            $("#auto-loop-1").lightGallery();
            $("#auto-loop-2").lightGallery();
            $("#auto-loop-3").lightGallery();
            $("#auto-loop-4").lightGallery();

        });
        lightGallery(document.getElementById("#auto-loop-1"));
        lightGallery(document.getElementById("#auto-loop-2"));
        lightGallery(document.getElementById("#auto-loop-3"));
        lightGallery(document.getElementById("#auto-loop-4"));
        $(function () {
            $("#testmao").click(function () {
                $.scrollTo('#section-1',1000);
            });
        });
    </script>
</head>
<body data-spy="scroll" data-target="#myScrollspy" data-offset="50">

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

            <ul class="breadcrumb">

                <li>
                    <a href="home">寻房网</a>
                </li>
                <li class="active">
                    ${estate.estateName}
                </li>
            </ul>
            <div class="page-header">
                <div class="details-title">
                    <b>${estate.estateName}</b>
                    <label class="label label-success">
                        <c:if test="${estate.status eq 1}">在售</c:if>
                        <c:if test="${estate.status eq 0}">待售 </c:if>
                    </label>
                    <label class="label label-success">${estate.sign}</label>
                </div>
                <small>  别名：${estate.estateName}</small>
            </div>
            <div class="tabbable" id="tabs-420817">
                <ul class="nav nav-tabs tabs" id="section-1">
                    <li class="col-md-4 active">
                        <a href="#panel-index" data-toggle="tab">楼盘主页</a>
                    </li>
                    <li class="col-md-4">
                        <a href="#panel-details" data-toggle="tab">楼盘详情</a>
                    </li>
                    <li class="col-md-4">
                        <a href="#panel-pictures" data-toggle="tab">楼盘图册</a>
                    </li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane active" id="panel-index">
                        <div class="row clearfix tab-items">
                            <div class="col-md-6 column">
                                <div class="carousel slide" id="Carousel-ID">
                                    <ol class="carousel-indicators">
                                        <li data-slide-to="0" data-target="#Carousel-ID" class="active">
                                        </li>
                                        <li data-slide-to="1" data-target="#Carousel-ID">
                                        </li>
                                        <li data-slide-to="2" data-target="#Carousel-ID">
                                        </li>
                                        <li data-slide-to="3" data-target="#Carousel-ID">
                                        </li>
                                    </ol>
                                    <div class="carousel-inner full-image">
                                        <div id="item-1" class="item active">
                                            <img alt=""  src="/assets/home/details/image/1-big.jpg" />
                                        </div>
                                        <div id="item-2" class="item">
                                            <img alt="" src="/assets/home/details/image/2-big.jpg" />
                                        </div>
                                        <div id="item-3" class="item">
                                            <img alt="" src="/assets/home/details/image/3-big.jpg" />
                                        </div>
                                        <div id="item-4" class="item">
                                            <img alt="" src="/assets/home/details/image/4-big.jpg" />
                                        </div>
                                    </div>
                                    <a class="left carousel-control" href="#Carousel-ID" data-slide="prev">
                                        <span class="glyphicon glyphicon-chevron-left"></span>
                                    </a>
                                    <a class="right carousel-control" href="#Carousel-ID" data-slide="next">
                                        <span class="glyphicon glyphicon-chevron-right"></span>
                                    </a>
                                </div>

                                <div class="row" style="padding-top:10px">
                                    <div class="col-md-2 col-md-offset-2">
                                        <div id="img-1" class="hovereffect blueBorder">
                                            <img class="img-responsive " src="/assets/home/details/image/1-small.jpg" alt="">
                                            <a href="#Carousel-ID" data-slide-to="0">
                                                <div class="overlay">
                                                    <h2>效果图</h2>
                                                </div>
                                            </a>
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div id="img-2" class="hovereffect">
                                            <img class="img-responsive" src="/assets/home/details/image/2-small.jpg" alt="">
                                            <a href="#Carousel-ID" data-slide-to="1">
                                                <div class="overlay">
                                                    <h2>样板间</h2>
                                                </div>
                                            </a>
                                        </div>
                                    </div>

                                    <div class="col-md-2">
                                        <div id="img-3" class="hovereffect">
                                            <img class="img-responsive" src="/assets/home/details/image/3-small.jpg" alt="">
                                            <a href="#Carousel-ID" data-slide-to="2">
                                                <div class="overlay">
                                                    <h2>环境规划图</h2>
                                                </div>
                                            </a>
                                        </div>
                                    </div>


                                    <div class="col-md-2">
                                        <div id="img-4" class="hovereffect">
                                            <img class="img-responsive" src="/assets/home/details/image/4-small.jpg" alt="">
                                            <a href="#Carousel-ID" data-slide-to="3">
                                                <div class="overlay">
                                                    <h2>楼盘实景图</h2>
                                                </div>
                                            </a>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <div class="col-md-6 column">
                                <div class="list-group main-info">
                                    <div class="list-group-item active">
                                        主要信息
                                    </div>
                                    <div class="list-group-item">
                                        <ul class="index-info">
                                            <li>
                                                <div class="field">开发商报价：　</div>
                                                <div class="value keynote">${estate.developerQuotes}元/平方米</div>
                                            </li>
                                            <li>
                                                <div class="field">参考总价：　　</div>
                                                <div class="value">${estate.minPrice}-${estate.maxPrice}万</div>
                                            </li>
                                            <li>
                                                <div class="field">楼盘面积：　　</div>
                                                <div class="value">${estate.area}平方米</div>
                                            </li>
                                            <li>
                                                <div class="field">楼盘户型：　　</div>
                                                <div class="value">${estate.houseType}</div>
                                            </li>
                                            <li>
                                                <div class="field">楼盘地址：　　</div>
                                                <div class="value">${estate.estateAddress}</div>
                                            </li>
                                            <li>
                                                <div class="field">物业公司：　　</div>
                                                <div class="value">${estate.company}</div>
                                            </li>
                                            <li>
                                                <div class="field">最新开盘时间：</div>
                                                <div class="value">
                                                    <fmt:formatDate value="${estate.latestOpening}"
                                                                    pattern="yyyy年MM月dd日HH点" /></div>
                                            </li>
                                        </ul>
                                    </div>

                                    <div class="list-group-item active">
                                        最新动态
                                    </div>
                                    <div class="list-group-item">
                                        <ul class="index-info">
                                            <li>
                                                ${estate.sign}生活住所
                                            </li>
                                            <li>
                                                一日狂销${estate.turnover}套，
                                                ${estate.location}最火爆楼盘—${estate.estateName}！
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="list-group-item active">
                                        联系方式
                                    </div>
                                    <div class="list-group-item">
                                        <ul class="index-info">
                                            <li>
                                                <div class="field">资讯热线：　</div>
                                                <div class="value keynote">400-057-6213</div>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane" id="panel-details">
                        <div class="row clearfix tab-items">
                            <div class="col-md-12 column">
                                <div class="list-group details-header">
                                    <div class="list-group-item active">
                                        基本信息
                                    </div>
                                    <div class="list-group-item">
                                        <ul class="index-info details-info">
                                            <li>
                                                <div class="field">楼盘名称　</div>
                                                <div class="value">${estate.estateName}</div>
                                            </li>
                                            <li>
                                                <div class="field">楼盘地址　</div>
                                                <div class="value">${estate.estateName}位于${estate.estateAddress}</div>
                                            </li>
                                            <li>
                                                <div class="field">物业类型　</div>
                                                <div class="value">${estate.property}</div>
                                            </li>
                                            <li>
                                                <div class="field">建筑类型　</div>
                                                <div class="value">高层</div>
                                            </li>
                                            <li>
                                                <div class="field">环　　线　</div>
                                                <div class="value">暂无</div>
                                            </li>
                                            <li>
                                                <div class="field">开发商　　</div>
                                                <div class="value">${estate.developer}</div>
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="list-group-item active">
                                        销售信息
                                    </div>
                                    <div class="list-group-item">
                                        <ul class="index-info details-info">
                                            <li>
                                                <div class="field">开发商报价</div>
                                                <div class="value">${estate.developerQuotes}元/平米</div>
                                            </li>
                                            <li>
                                                <div class="field">销售状态　</div>
                                                <div class="value">
                                                    <c:if test="${estate.status eq 1}">在售</c:if>
                                                    <c:if test="${estate.status eq 0}">待售</c:if>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="field">优惠信息　</div>
                                                <div class="value">暂无</div>
                                            </li>
                                            <li>
                                                <div class="field">最新开盘　</div>
                                                <div class="value">
                                                    <fmt:formatDate value="${estate.latestOpening}" pattern="yyyy年MM月dd日HH点" />
                                                </div>
                                            </li>
                                            <li>
                                                <div class="field">最早交房　</div>
                                                <div class="value">
                                                    <fmt:formatDate value="${estate.firstDelivery}" pattern="yyyy年MM月dd日HH点" />
                                                </div>
                                            </li>
                                            <li>
                                                <div class="field">楼盘户型　</div>
                                                <div class="value">${estate.houseType}</div>
                                            </li>
                                            <li>
                                                <div class="field">产权年限　</div>
                                                <div class="value">${estate.propertyRights}</div>
                                            </li>
                                            <li>
                                                <div class="field">拿地时间　</div>
                                                <div class="value">
                                                    <fmt:formatDate value="${estate.takeTime}" pattern="yyyy年MM月dd日HH点" />
                                                </div>
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="list-group-item active">
                                        小区详情
                                    </div>
                                    <div class="list-group-item">
                                        <ul class="index-info details-info">
                                            <li>
                                                <div class="field">物业公司　</div>
                                                <div class="value">${estate.company}</div>
                                            </li>
                                            <li>
                                                <div class="field">物业费用　</div>
                                                <div class="value">${estate.propertyCost}元/m²/月</div>
                                            </li>
                                            <li>
                                                <div class="field">水电燃气　</div>
                                                <div class="value">${estate.powerType}</div>
                                            </li>
                                            <li>
                                                <div class="field">绿化率　　</div>
                                                <div class="value">${estate.greenRate}%</div>
                                            </li>
                                            <li>
                                                <div class="field">车位情况　</div>
                                                <div class="value">${estate.parkingSpaces}</div>
                                            </li>
                                            <li>
                                                <div class="field">容积率　　</div>
                                                <div class="value">${estate.plotRatio}</div>
                                            </li>
                                            <li>
                                                <div class="field">装修状况　</div>
                                                <div class="value">${estate.decoration}</div>
                                            </li>
                                            <li>
                                                <div class="field">楼栋信息　</div>
                                                <div class="value">${estate.estateInformation}</div>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane" id="panel-pictures">
                        <div class="row clearfix tab-items">
                            <div class="col-md-12 column" >
                                <div class="row">

                                    <div class="col-xs-10">
                                        <a data-toggle="collapse"  href="#auto-loop-1">
                                            <div class="list-group-item active">
                                                <b>效果图（12）</b>
                                            </div>
                                        </a>
                                        <div id="auto-loop-1" class="row gallery in">
                                            <c:forEach begin="0" end="11">
                                                <div class="col-xs-6 col-sm-4 col-md-3 pic-show"
                                                     data-responsive=""
                                                     data-sub-html="<h4>${estate.estateName}</h4>
                                                                    <p>${estate.estateName}效果图</p>"
                                                     data-src="/assets/home/details/image/1.jpg">
                                                    <div class="hovereffect">
                                                        <img class="img-responsive"
                                                             src="/assets/home/details/image/example1.jpg" alt="${estate.estateName}">
                                                        <a href="javascript:void(0);">
                                                            <div class="overlay">
                                                                <h2>${estate.estateName}效果图</h2>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </div>
                                        <hr>

                                        <a data-toggle="collapse"  href="#auto-loop-2">
                                            <div class="list-group-item active">
                                                <b id="section-2">样板间（20）</b>
                                            </div>
                                        </a>
                                        <div id="auto-loop-2" class="row gallery in">
                                            <c:forEach begin="0" end="19">
                                                <div class="col-xs-6 col-sm-4 col-md-3 pic-show"
                                                     data-responsive=""
                                                     data-sub-html="<h4>${estate.estateName}</h4>
                                                                    <p>${estate.estateName}样板间</p>"
                                                     data-src="/assets/home/details/image/1.jpg">
                                                    <div class="hovereffect">
                                                        <img class="img-responsive"
                                                             src="/assets/home/details/image/example1.jpg" alt="${estate.estateName}">
                                                        <a href="javascript:void(0);">
                                                            <div class="overlay">
                                                                <h2>${estate.estateName}样板间</h2>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </div>
                                        <hr>

                                        <a data-toggle="collapse"  href="#auto-loop-3">
                                            <div class="list-group-item active">
                                                <b id="section-3">环境规划图（1）</b>
                                            </div>
                                        </a>
                                        <div id="auto-loop-3" class="row gallery in">
                                            <c:forEach begin="0" end="0">
                                                <div class="col-xs-6 col-sm-4 col-md-3 pic-show"
                                                     data-responsive=""
                                                     data-sub-html="<h4>${estate.estateName}</h4>
                                                                    <p>${estate.estateName}环境规划图</p>"
                                                     data-src="/assets/home/details/image/1.jpg">
                                                    <div class="hovereffect">
                                                        <img class="img-responsive"
                                                             src="/assets/home/details/image/example1.jpg" alt="${estate.estateName}">
                                                        <a href="javascript:void(0);">
                                                            <div class="overlay">
                                                                <h2>${estate.estateName}环境规划图</h2>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </div>
                                        <hr>

                                        <a data-toggle="collapse"  href="#auto-loop-4">
                                            <div class="list-group-item active">
                                                <b id="section-4">楼盘实景图（21）</b>
                                            </div>
                                        </a>
                                        <div id="auto-loop-4" class="row gallery ">
                                            <c:forEach begin="0" end="20">
                                                <div class="col-xs-6 col-sm-4 col-md-3 pic-show"
                                                     data-responsive=""
                                                     data-sub-html="<h4>${estate.estateName}</h4>
                                                                    <p>${estate.estateName}楼盘实景图</p>"
                                                     data-src="/assets/home/details/image/1.jpg">
                                                    <div class="hovereffect">
                                                        <img class="img-responsive"
                                                             src="/assets/home/details/image/example1.jpg" alt="${estate.estateName}">
                                                        <a href="javascript:void(0);">
                                                            <div class="overlay">
                                                                <h2>${estate.estateName}楼盘实景图</h2>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </div>
                                        <hr>
                                    </div>

                                    <div class="col-xs-2" id="myScrollspy">
                                        <ul class="nav nav-tabs nav-stacked affix" data-spy="affix" data-offset-top="100">
                                            <li><a date-scroll="#section-0" href="javascript:void(0);">全部（54）</a></li>
                                            <li><a date-scroll="#section-1" href="javascript:void(0);">效果图（12）</a></li>
                                            <li><a date-scroll="#section-2" href="javascript:void(0);">样板间（20）</a></li>
                                            <li><a date-scroll="#section-3" href="javascript:void(0);">环境规划图（1）</a></li>
                                            <li><a date-scroll="#section-4" href="javascript:void(0);">楼盘实景图（21）</a></li>
                                        </ul>
                                    </div>


                                </div>
                            </div>
                        </div>
                    </div>
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
