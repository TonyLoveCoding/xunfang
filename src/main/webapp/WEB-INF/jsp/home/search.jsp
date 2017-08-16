<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="/assets/home/search/header.js"></script>
    <link href="/assets/home/search/header.css" rel="stylesheet">
    <link href="/assets/home/search/search.css" rel="stylesheet">
    <title>寻房网</title>
</head>
<body>
<div class="container-fluid">
    <%--头部导航栏--%>
    <div class="row">
        <div class="col-md-12">
            <div class="header-hover">
                <div class="header-hover-wrap">
                    <ul class="menu">
                        <div class="navbar-header">
                            <a class="navbar-brand" href="#">寻房网</a>
                        </div>
                        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <form class="navbar-form navbar-left" role="search">
                                <div class="form-group">
                                    <input type="text" class="form-control"/>
                                </div>
                                <button type="submit" class="btn btn-danger"><span
                                        class="glyphicon glyphicon-search"></span> 找房
                                </button>
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
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">寻房网</a>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                    <form class="navbar-form navbar-left" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control"/>
                        </div>
                        <button type="submit" class="btn btn-danger"><span class="glyphicon glyphicon-search"></span> 找房
                        </button>
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
                    <ul class="ul_item_SearchCondition">
                        <li>不限</li>
                        <li>南沙</li>
                        <li>黄埔</li>
                        <li>花都</li>
                        <li>增城</li>
                        <li>番禺</li>
                        <li>白云</li>
                        <li>天河</li>
                        <li>荔湾</li>
                        <li>海珠</li>
                        <li>从化</li>
                        <li>越秀</li>
                        <li>广州</li>
                        <li>周边</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <%--总价--%>
    <div class="row">
        <div class="col-md-6 col-md-offset-1">
            <div class="sel_item">
                <div class="head_SearchCondition">总价：</div>
                <div class="item_SearchCondition">
                    <ul class="ul_item_SearchCondition">
                        <li>不限</li>
                        <li>小于100万</li>
                        <li>100-150万</li>
                        <li>150-200万</li>
                        <li>200-250万</li>
                        <li>250-300万</li>
                        <li>300-500万</li>
                        <li>500-800万</li>
                        <li>800-1000万</li>
                        <li>大于1000万</li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col-md-3 div_sel_item">
            <input type="text" class="input_sel_item">-<input type="text" class="input_sel_item">万
            <button class="btn_sel_item btn btn-primary">确定</button>
        </div>
    </div>
    <%--类型--%>
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div class="sel_item">
                <div class="head_SearchCondition">类型：</div>
                <div class="item_SearchCondition">
                    <ul class="ul_item_SearchCondition">
                        <li>不限</li>
                        <li>住宅</li>
                        <li>别墅</li>
                        <li>商业</li>
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
                    <ul class="ul_item_SearchCondition">
                        <li>不限</li>
                        <li>一居</li>
                        <li>二居</li>
                        <li>三居</li>
                        <li>四居</li>
                        <li>五居及以上</li>
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
                    <ul class="ul_item_SearchCondition">
                        <li>不限</li>
                        <li>小户型</li>
                        <li>临地铁</li>
                        <li>精装修</li>
                        <li>现房</li>
                        <li>自由购</li>
                        <li>品牌地产</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <%--单价--%>
    <div class="row">
        <div class="col-md-6 col-md-offset-1">
            <div class="sel_item">
                <div class="head_SearchCondition">单价：</div>
                <div class="item_SearchCondition">
                    <ul class="ul_item_SearchCondition">
                        <li>不限</li>
                        <li>小于1万</li>
                        <li>1万-1.5万</li>
                        <li>1.5万-2万</li>
                        <li>2万-2.5万</li>
                        <li>2.5万-3万</li>
                        <li>3万-4万</li>
                        <li>大于4万</li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col-md-3 div_sel_item">
            <input type="text" class="input_sel_item">-<input type="text" class="input_sel_item">元
            <button class="btn_sel_item btn btn-primary">确定</button>
        </div>
    </div>
    <%--面积--%>
    <div class="row">
        <div class="col-md-6 col-md-offset-1">
            <div class="sel_item">
                <div class="head_SearchCondition">单价：</div>
                <div class="item_SearchCondition">
                    <ul class="ul_item_SearchCondition">
                        <li>不限</li>
                        <li>大于50m²</li>
                        <li>50m²-80m²</li>
                        <li>80m²-120m²</li>
                        <li>120m²-140m²</li>
                        <li>140m²-160m²</li>
                        <li>小于160m²</li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col-md-3 div_sel_item">
            <input type="text" class="input_sel_item">-<input type="text" class="input_sel_item">m²
            <button class="btn_sel_item btn btn-primary">确定</button>
        </div>
    </div>
    <%--中间列表--%>
    <div class="row middle_sel">
        <div class="col-md-1 col-md-offset-1">
            <div class="radio radio_sall_status">
                <label><input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>在售</label>
            </div>
            <div class="radio radio_sall_status"><label style="margin-left:3px"><input type="radio" name="optionsRadios"
                                                                                       id="optionsRadios2"
                                                                                       value="option2">待售</label></div>
        </div>
        <div class="col-md-2">
            <div class="sortCondition">总价</div>
            <div class="sortCondition">单价</div>
            <div class="sortCondition">关注度</div>
            <div class="sortCondition">成交量</div>
        </div>
        <div class="col-md-2">
            <div class="sortCondition">共找到<span id="sortCondition_sum">1276</span>个符合条件的楼盘</div>
        </div>
    </div>
    <%--分割线--%>
    <div class="row">
        <div class="col-md-8 col-md-offset-1">
            <div id="line_sortCondition"></div>
        </div>
    </div>

</div>
</body>
</html>