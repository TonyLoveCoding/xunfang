<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2017/8/12
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <script src="assets/uplodephoto/js/jquery-1.8.3.js"></script>
    <link rel="stylesheet" href="assets/estate/add/css/add.css">
    <link rel="stylesheet" href="assets/estate/add/css/bootstrapValidator.css">

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/css/bootstrap-select.min.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/bootstrap-select.min.js"></script>

    <script src="assets/estate/add/add.js"></script>
    <script src="assets/js/bootstrapValidator.js"></script>

</head>
<body style="height: auto">
<div  class="container-fluid">
    <form id="form1" action="/estate/add" method="post" onsubmit="return update(this)">
        <div class="row">
            <div class="col-sm-12" style="padding-left: 0px">
                <h3>基本信息</h3>
            </div>
            <div class="col-sm-12" style="padding-left: 0px">
                <div class="halving_line"></div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-1" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">楼盘名称：</div>
            </div>
            <div class="col-sm-7" style="padding-left: 0px;padding-top: 10px">
                <div class="input-group">
                    <input type="text" class="form-control" name="estateName" value="${EstateDto.estateName}" aria-describedby="basic-addon1">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-1" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">楼盘地址：</div>
            </div>
            <div class="col-sm-4" style="padding-left: 0px;padding-top: 10px">
                <div class="input-group">
                    <input type="text" class="form-control" name="estateAddress" value="${EstateDto.estateAddress}" aria-describedby="basic-addon1">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-1" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">位置：</div>
            </div>
            <div class="col-sm-4" style="padding-left: 0px;padding-top: 10px">
                <div class="btn-group">
                    <select name="location" value="${EstateDto.location}" class="btn btn-default dropdown-toggle">
                        <c:forEach var="dl" items="${dic_location}">
                            <option value="${dl.name}" <c:if test="${dl.name.equals(EstateDto.location)}">selected</c:if>>${dl.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-1" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">物业类型：</div>
            </div>
            <div class="col-sm-7" style="padding-left: 0px;padding-top: 10px">
                <div class="input-group">
                    <input type="text" class="form-control" name="property" value="${EstateDto.property}" aria-describedby="basic-addon1">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-1" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">建筑类型：</div>
            </div>
            <div class="col-sm-7" style="padding-left: 0px;padding-top: 10px">
                <div class="btn-group">
                    <select name="type" value="${EstateDto.type}" class="btn btn-default dropdown-toggle">
                        <c:forEach var="dt" items="${dic_type}">
                            <option value="${dt.name}" <c:if test="${dt.name.equals(EstateDto.type)}">selected</c:if>>${dt.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-1" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">开发商：</div>
            </div>
            <div class="col-sm-7" style="padding-left: 0px;padding-top: 10px">
                <div class="input-group">
                    <input type="text" class="form-control" name="developer" value="${EstateDto.developer}">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-1" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">面积：</div>
            </div>
            <div class="col-sm-7" style="padding-left: 0px;padding-top: 10px">
                <div class="input-group">
                    <input type="text" class="form-control" name="area" value="${EstateDto.area}">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-1" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">最高价：</div>
            </div>
            <div class="col-sm-7" style="padding-left: 0px;padding-top: 10px">
                <div class="input-group">
                    <input type="text" class="form-control" name="maxPrice" value="${EstateDto.maxPrice}">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-1" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">最低价：</div>
            </div>
            <div class="col-sm-7" style="padding-left: 0px;padding-top: 10px">
                <div class="input-group">
                    <input type="text" class="form-control" name="minPrice" value="${EstateDto.minPrice}">
                </div>
            </div>
        </div>
        <br>
        <%--销售信息模块--%>
        <div class="row">
            <div class="col-sm-12" style="padding-left: 0px">
                <h3>销售信息</h3>
            </div>
            <div class="col-sm-12" style="padding-left: 0px">
                <div class="halving_line"></div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-1" style="padding-left: 0px;padding-top: 10px;padding-right: 0px">
                <div style="font-size:15px">开发商报价：</div>
            </div>
            <div class="col-sm-3" style="padding-left: 0px;padding-top: 10px">
                <div class="input-group">
                    <input type="text" class="form-control" name="developerQuotes" value="${EstateDto.developerQuotes}">
                </div>
            </div>
            <div class="col-sm-1 col-sm-offset-1" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">最早交房：</div>
            </div>
            <div class="col-sm-3" style="padding-left: 0px;padding-top: 10px">
                <div class="input-group">
                    <input type="date" name="firstDelivery" class="form-control" value="${EstateDto.firstDelivery}" id="first_delivery">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-1" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">产权年限：</div>
            </div>
            <div class="col-sm-3" style="padding-left: 0px;padding-top: 10px">
                <div class="input-group">
                    <input type="text" class="form-control" name="propertyRights" value="${EstateDto.propertyRights}">
                </div>
            </div>
            <div class="col-sm-1 col-sm-offset-1" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">最新开盘：</div>
            </div>
            <div class="col-sm-3" style="padding-left: 0px;padding-top: 10px">
                <div class="input-group">
                    <input type="date" name="latestOpening" class="form-control" value="${EstateDto.latestOpening}" id="latest_open">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-1" style="padding-left: 0px;padding-top: 10px;padding-right: 0px">
                <div style="font-size:15px">楼盘户型：</div>
            </div>
            <div class="col-sm-3" style="padding-left: 0px;padding-top: 10px">
                <select name="houseType" id="houseType" class="selectpicker show-tick form-control" multiple data-live-search="false">
                    <c:forEach var="dh" items="${dic_houseType}">
                        <option value="${dh.name}" <c:if test="${EstateDto.houseType.contains(dh.name)}">selected</c:if>>${dh.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-sm-1 col-sm-offset-1" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">拿地时间：</div>
            </div>
            <div class="col-sm-3" style="padding-left: 0px;padding-top: 10px">
                <div class="input-group">
                    <input type="date" name="takeTime" class="form-control" value="${EstateDto.takeTime}" id="takeTime">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-1" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">销售状态：</div>
            </div>
            <div class="col-sm-3" style="padding-left: 0px;padding-top: 10px">
                <select name="saleStatus" value="${EstateDto.saleStatus}" class="selectpicker form-control" data-live-search="false">
                    <option value="0" <c:if test="${'0' eq EstateDto.saleStatus}">selected</c:if>>在售</option>
                    <option value="1" <c:if test="${'1' eq EstateDto.saleStatus}">selected</c:if>>待售</option>
                </select>
            </div>
        </div>
        <br>
        <%--小区详情模块--%>
        <div class="row">
            <div class="col-sm-12" style="padding-left: 0px">
                <h3>小区详情</h3>
            </div>
            <div class="col-sm-12" style="padding-left: 0px">
                <div class="halving_line"></div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-1" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">物业公司：</div>
            </div>
            <div class="col-sm-3" style="padding-left: 0px;padding-top: 10px">
                <div class="input-group">
                    <input type="text" class="form-control" name="company" value="${EstateDto.company}">
                </div>
            </div>
            <div class="col-sm-1 col-sm-offset-1" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">车位情况：</div>
            </div>
            <div class="col-sm-3" style="padding-left: 0px;padding-top: 10px">
                <div class="input-group">
                    <input type="text" class="form-control" name="parkingSpaces" value="${EstateDto.parkingSpaces}">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-1" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">物业费用：</div>
            </div>
            <div class="col-sm-3" style="padding-left: 0px;padding-top: 10px">
                <div class="input-group">
                    <input type="text" class="form-control" name="propertyCost" value="${EstateDto.propertyCost}">
                </div>
            </div>
            <div class="col-sm-1 col-sm-offset-1" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">容积率：</div>
            </div>
            <div class="col-sm-3" style="padding-left: 0px;padding-top: 10px">
                <div class="input-group">
                    <input type="text" class="form-control" name="plotRatio" value="${EstateDto.plotRatio}">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-1" style="padding-left: 0px;padding-top: 10px;padding-right: 0px">
                <div style="font-size:15px">水电燃气：</div>
            </div>
            <div class="col-sm-3" style="padding-left: 0px;padding-top: 10px">
                <div class="input-group">
                    <input type="text" class="form-control" name="powerType" value="${EstateDto.powerType}">
                </div>
            </div>
            <div class="col-sm-1 col-sm-offset-1" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">装修情况：</div>
            </div>
            <div class="col-sm-3" style="padding-left: 0px;padding-top: 10px">
                <div class="input-group">
                    <input type="text" class="form-control" name="decoration" value="${EstateDto.decoration}">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-1" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">绿化率：</div>
            </div>
            <div class="col-sm-3" style="padding-left: 0px;padding-top: 10px">
                <div class="input-group">
                    <input type="text" class="form-control" name="greenRate" value="${EstateDto.greenRate}">
                    <span class="input-group-addon" id="basic-addon1">%</span>
                </div>
            </div>
            <div class="col-sm-1 col-sm-offset-1" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">楼栋信息：</div>
            </div>
            <div class="col-sm-3" style="padding-left: 0px;padding-top: 10px">
                <div class="input-group">
                    <input type="text" class="form-control" name="estateInformation" value="${EstateDto.estateInformation}" >
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-1" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">特色：</div>
            </div>
            <div class="col-sm-3" style="padding-left: 0px;padding-top: 10px">
                <select name="feature" id="feature" class="selectpicker show-tick form-control" multiple data-live-search="false">
                    <c:forEach var="df" items="${dic_feature}">
                        <option value="${df.name}" <c:if test="${EstateDto.feature.contains(df.name)}">selected</c:if>>${df.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-sm-1 col-sm-offset-1" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">标签：</div>
            </div>
            <div class="col-sm-3" style="padding-left: 0px;padding-top: 10px">
                <textarea name="sign" maxlength="30" class="form-control">${EstateDto.sign}</textarea>
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-sm-12" style="padding-left: 0px">
                <div class="btn-group center-block" role="group" aria-label="...">
                    <button type="submit" class="btn btn-default center-block">保存</button>
                    <a class="btn btn-default center-block" href="/estate/query" role="button" >返回</a>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
