<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/assets/home/search/header.css" rel="stylesheet">
    <link href="/assets/home/search/search.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/assets/home/search/zxf_page.css"/>
    <script type="text/javascript" src="/assets/home/search/header.js"></script>
    <script src="/assets/home/search/zxf_page.js" type="text/javascript"></script>
    <script src="/assets/home/search/search.js" type="text/javascript"></script>
    <title>寻房网</title>
</head>
<body>
<form action="/home/search" method="GET" id="form_search">
    <input id="inp_hid_pn" type="hidden" name="pn" value="${SearchPageMsg.current}">
    <input id="inp_hid_keyword" type="hidden" name="keyWord" value="${SearchPageMsg.keyWord}">
    <input id="inp_hid_saleStatus" type="hidden" name="saleStatus" value="${SearchPageMsg.saleStatus}">
    <input id="inp_hid_location" type="hidden" name="location" value="${SearchPageMsg.location}">
    <input id="inp_hid_totalPrices" type="hidden" name="totalPrices" value="${SearchPageMsg.totalPrices}">
    <input id="inp_hid_type" type="hidden" name="type" value="${SearchPageMsg.type}">
    <input id="inp_hid_houseType" type="hidden" name="houseType" value="${SearchPageMsg.houseType}">
    <input id="inp_hid_feature" type="hidden" name="feature" value="${SearchPageMsg.feature}">
    <input id="inp_hid_unitPrice" type="hidden" name="unitPrice" value="${SearchPageMsg.unitPrice}">
    <input id="inp_hid_area" type="hidden" name="area" value="${SearchPageMsg.area}">
    <input id="inp_hid_sort" type="hidden" name="sort" value="${SearchPageMsg.sort}">
    <input id="inp_hid_sortType" type="hidden" name="sortType" value="${SearchPageMsg.sortType}">
</form>
<div class="container-fluid">
    <%--头部导航栏--%>
    <div class="row">
        <div class="col-md-12">
            <div class="header-hover">
                <div class="header-hover-wrap">
                    <ul class="menu">
                        <div class="collapse navbar-collapse">
                            <div class="navbar-form navbar-left" role="search">
                                <a href="home">
                                    <img src="/assets/home/index/image/logo.png">
                                </a>
                                <div class="form-group">
                                    <input id="inp_coll_keyword" type="text" class="form-control"
                                           value="${SearchPageMsg.keyWord}"/>
                                </div>
                                <button type="button" class="btn btn-danger" id="btn_coll_keyword"><span
                                        class="glyphicon glyphicon-search"></span> 找房
                                </button>
                            </div>
                            <ul class="nav navbar-nav navbar-right">
                                <li>
                                    <a href="javascript:void(0);"><b>热搜词：</b></a>
                                </li>
                                <c:forEach var="heatSearchWord" items="${heatSearchWordList}">
                                <li>
                                    <a class="a_heatWord" href="javascript:void(0);">${heatSearchWord.word}</a>
                                </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <%--头部漂浮栏--%>
    <div class="row">
        <div class="col-md-12">
            <nav class="navbar navbar-default " role="navigation">
                <div class="collapse navbar-collapse">

                    <div class="navbar-form navbar-left" role="search">
                        <a href="home">
                            <img src="/assets/home/index/image/logo.png">
                        </a>
                        <div class="form-group">
                            <input id="inp_nav_keyword" type="text" class="form-control"
                                   value="${SearchPageMsg.keyWord}"/>
                        </div>
                        <button id="btn_nav_keyword" type="button" class="btn btn-danger"><span
                                class="glyphicon glyphicon-search"></span> 找房
                        </button>
                    </div>
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="javascript:void(0);" style="text-decoration-color: red">热搜词：</a>
                        </li>
                        <c:forEach var="heatSearchWord" items="${heatSearchWordList}">
                            <li>
                                <a class="a_heatWord" href="javascript:void(0);">${heatSearchWord.word}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>

            </nav>
        </div>
    </div>
    <%--全部楼盘--%>
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <button class="btn btn-primary" id="btn_AllEstate">全部楼盘</button>
            <div id="line_AllEstate"></div>
        </div>
    </div>
    <%--位置--%>
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div class="sel_item">
                <div class="head_SearchCondition">位置：</div>
                <div class="item_SearchCondition">
                    <ul class="ul_item_SearchCondition location">
                        <c:forEach var="location" items="${locations}">
                            <li><a href="javascript:void(0);" name="${location.code}"
                                   class="a_location">${location.name}</a></li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <%--类型--%>
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div class="sel_item">
                <div class="head_SearchCondition">类型：</div>
                <div class="item_SearchCondition">
                    <ul class="ul_item_SearchCondition type">
                        <c:forEach var="type" items="${types}">
                            <li><a href="javascript:void(0);" name="${type.code}" class="a_type">${type.name}</a></li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <%--户型--%>
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div class="sel_item">
                <div class="head_SearchCondition">户型：</div>
                <div class="item_SearchCondition">
                    <ul class="ul_item_SearchCondition houseType">
                        <c:forEach var="houseType" items="${houseTypes}">
                            <li><a href="javascript:void(0);" name="${houseType.code}"
                                   class="a_houseType">${houseType.name}</a></li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <%--特色--%>
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div class="sel_item">
                <div class="head_SearchCondition">特色：</div>
                <div class="item_SearchCondition">
                    <ul class="ul_item_SearchCondition feature">
                        <c:forEach var="feature" items="${features}">
                            <li><a href="javascript:void(0);" name="${feature.code}"
                                   class="a_feature">${feature.name}</a></li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <%--单价--%>
    <div class="row">
        <div class="col-md-7 col-md-offset-1">
            <div class="sel_item">
                <div class="head_SearchCondition">单价：</div>
                <div class="item_SearchCondition">
                    <ul class="ul_item_SearchCondition unit_price">
                        <c:forEach var="unit_price" items="${unit_prices}">
                            <li><a href="javascript:void(0);" name="${unit_price.code}"
                                   class="a_unit_price">${unit_price.name}</a></li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col-md-3 div_sel_item">
            <input type="number" id="inp_unit_price_pre" class="input_sel_item">-<input id="inp_unit_price_beh" type="number" class="input_sel_item">元
            <button id="btn_unit_price" class="btn_sel_item btn btn-primary">确定</button>
        </div>
    </div>
    <%--面积--%>
    <div class="row">
        <div class="col-md-7 col-md-offset-1">
            <div class="sel_item">
                <div class="head_SearchCondition">面积：</div>
                <div class="item_SearchCondition">
                    <ul class="ul_item_SearchCondition area">
                        <c:forEach var="area" items="${areas}">
                            <li><a href="javascript:void(0);" name="${area.code}" class="a_area">${area.name}</a></li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col-md-3 div_sel_item">
            <input type="number" id="inp_area_pre" class="input_sel_item">-<input id="inp_area_beh" type="number" class="input_sel_item">m²
            <button id="btn_aera" class="btn_sel_item btn btn-primary">确定</button>
        </div>
    </div>
        <%--总价--%>
        <div class="row">
            <div class="col-md-7 col-md-offset-1">
                <div class="sel_item">
                    <div class="head_SearchCondition">最低总价：</div>
                    <div class="item_SearchCondition">
                        <ul class="ul_item_SearchCondition total_prices">
                            <c:forEach var="total_prices" items="${total_pricess}">
                                <li><a href="javascript:void(0);" name="${total_prices.code}"
                                       class="a_total_prices">${total_prices.name}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-md-3 div_sel_item">
                <input type="number" id="inp_total_prices_pre" class="input_sel_item">-<input type="number" id="inp_total_prices_beh" class="input_sel_item">万
                <button id="btn_total_prices" class="btn_sel_item btn btn-primary">确定</button>
            </div>
        </div>
    <%--中间列表--%>
    <div class="row middle_sel">
        <div class="rad_sale col-md-2 col-md-offset-1">
            <div class="radio radio_sall_status">
                <label><input type="radio" name="saleRadios" id="optionsRadios1" class="rad_sell"
                              value="onSale">在售</label>
            </div>
            <div class="radio radio_sall_status">
                <label style="margin-left:3px"><input type="radio" name="saleRadios" class="rad_sell"
                                                      id="optionsRadios2" value="ForSale">待售</label></div>
            <div class="radio radio_sall_status">
                <label><input type="radio" name="saleRadios" id="optionsRadios3" class="rad_sell"
                              value="none">所有</label>
            </div>
        </div>
        <div class="col-md-2 div_sort">
            <div class="sortCondition"><a href="javascript:void(0);" name="none" class="a_sort">默认</a></div>
            <div class="sortCondition"><a href="javascript:void(0);" name="estate_min_price" class="a_sort">总价</a></div>
            <div class="sortCondition"><a href="javascript:void(0);" name="estate_developer_quotes"
                                          class="a_sort">单价</a></div>
            <div class="sortCondition"><a href="javascript:void(0);" name="estate_visit_times" class="a_sort">访问量</a>
            </div>
            <div class="sortCondition"><a href="javascript:void(0);" name="estate_turnover" class="a_sort">成交量</a></div>
        </div>
        <a href=""></a>
        <div class="col-md-2">
            <div class="sortCondition">共找到<span id="sortCondition_sum">${SearchPageMsg.foundNum}</span>个符合条件的楼盘</div>
        </div>
    </div>
    <%--分割线--%>
    <div class="row">
        <div class="col-md-8 col-md-offset-1">
            <div class="line_sortCondition"></div>
        </div>
    </div>
    <%--楼盘列表--%>
    <c:forEach items="${EstateList}" var="Estate">
        <div class="row search_list">
            <div class="col-md-2 col-md-offset-1">
                <a href="${Estate.estateDetailsURL}">
                    <img src="${Estate.thumbnail}" class="estateThumbnail">
                </a>

            </div>
            <div class="col-md-7">
                <div class="row search_list_detail">
                    <div class="col-md-11 col-md-offset-1">
                        <div class="estateName"><a href="${Estate.estateDetailsURL}">${Estate.estateName}</a></div>
                        <div class="tag-sale"><c:choose><c:when
                                test="${Estate.saleStatus}">在售</c:when><c:otherwise>待售</c:otherwise></c:choose></div>
                    </div>
                </div>
                <div class="row search_list_detail">
                    <div class="col-md-11 col-md-offset-1">
                        <div class="glyphicon glyphicon-map-marker nomral_div"></div>
                        <div class="estateAdress nomral_div">${Estate.estateAddress}</div>
                    </div>
                </div>
                <div class="row search_list_detail_other">
                    <div class="col-md-6 col-md-offset-1">
                        <div class="estateHouseType">${Estate.houseType}</div>
                    </div>
                    <div class="col-md-5 min_max_price">
                        <div class="nomral_div">参考总价:</div>
                        <div class="estateMinPrice nomral_div">${Estate.minPrice}</div>
                        <div class="price_sign nomral_div"> ~</div>
                        <div class="estateMaxPrice nomral_div">${Estate.maxPrice}</div>
                    </div>
                </div>
                <div class="row search_list_detail">
                    <div class="col-md-6 col-md-offset-1">
                        <div class="estateSign nomral_div">${Estate.sign}</div>
                    </div>
                    <div class="col-md-5">
                        <div class="nomral_div DeveloperQuotes">开发商报价：</div>
                        <div class="DeveloperQuotes estateDeveloperQuotes nomral_div">${Estate.developerQuotes}</div>
                        <div class="nomral_div DeveloperQuotes">元/平米</div>
                    </div>
                </div>
                <div class="row search_list_detail">
                    <div class="col-md-6 col-md-offset-1">
                        <div class="nomral_div visitTime">访问次数:</div>
                        <div class="nomral_div estateVisitTime">${Estate.visitTimes}</div>
                    </div>
                    <div class="col-md-5">
                        <div class="nomral_div visitTime">成交量：</div>
                        <div class="estateVisitTime nomral_div">${Estate.turnover}</div>
                    </div>
                </div>
                <div class="row search_list_detail">
                    <div class="col-md-11 col-md-offset-1">
                        <div class="nomral_div visitTime">面积:</div>
                        <div class="nomral_div estateVisitTime">${Estate.area}</div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-8 col-md-offset-1">
                <div class="line_sortCondition"></div>
            </div>
        </div>
    </c:forEach>


    <%--分页--%>
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div class="zxf_pagediv"></div>
        </div>
    </div>

    <%--分割线-你可能感兴趣的楼盘--%>
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div class="tip">你可能感兴趣的楼盘</div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-10 col-md-offset-1" style="margin-bottom: 20px">
            <div class="line_sortCondition"></div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-1"></div>
        <c:forEach items="${RecommendEstateBo}" var="Recommend">
            <div class="col-md-2">
                <div class="RecommendEstateBo">
                    <div class="tip_img">
                        <a href="${Recommend.estateDetailsURL}"> <img
                                src="${Recommend.thumbnail}" class="tip_estateThumbnail"></a>
                    </div>

                    <div class="bg_RecommendEstate">
                        <div class="title_RecommendEstate">
                            <h4>
                                <a href="${Recommend.estateDetailsURL}">${Recommend.estateName}</a>
                            </h4>
                        </div>
                        <div class="price_RecommendEstate">开发商报价：
                            <div class="inner_price_RecommendEstate nomral_div">${Recommend.developerQuotes}元/平米</div>
                        </div>
                        <div class="info_RecommendEstate">楼盘户型：
                            <div class="inner_info_RecommendEstate nomral_div">${Recommend.houseType}</div>
                        </div>
                        <div class="info_RecommendEstate">楼盘地址：
                            <div class="info_RecommendEstate nomral_div">${Recommend.estateAddress}</div>
                        </div>
                    </div>

                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        $(".zxf_pagediv").createPage({
            pageNum: ${SearchPageMsg.pageNum},//总页码
            current: ${SearchPageMsg.current},//当前页
            shownum: ${SearchPageMsg.shownum},//每页显示个数
            backfun: function (e) {
                $("#inp_hid_pn").attr("value", e.current);
                $("#form_search").submit();
            }
        });
    });
</script>
</html>