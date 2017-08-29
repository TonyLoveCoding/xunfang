<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2017/8/12
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="assets/uplodephoto/css/jquery.Jcrop.css">
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <script src="assets/uplodephoto/js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="assets/uplodephoto/js/jquery.Jcrop.js"></script>
    <script type="text/javascript" src="assets/uplodephoto/js/imgCropUpload.js"></script>
    <link rel="stylesheet" href="assets/estate/update/update.css">
    <script type="text/javascript" src="assets/estate/update/update.js"></script>
</head>
<body style="height: auto">
<div  class="container-fluid">
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
        <div class="col-sm-4" style="padding-left: 0px;padding-top: 10px">
            <input type="text" name="estateName" value="${EstateDto.estateName}">
        </div>
    </div>
    <div class="row">
        <div class="col-sm-1" style="padding-left: 0px;padding-top: 10px">
            <div style="font-size:15px">楼盘地址：</div>
        </div>
        <div class="col-sm-4" style="padding-left: 0px;padding-top: 10px">
            <input type="text" name="estateAddress" value="${EstateDto.estateAddress}">
        </div>
    </div>
    <div class="row">
        <div class="col-sm-1" style="padding-left: 0px;padding-top: 10px">
            <div style="font-size:15px">物业类型：</div>
        </div>
        <div class="col-sm-4" style="padding-left: 0px;padding-top: 10px">
            <input type="text" name="property" value="${EstateDto.property}">
        </div>
    </div>
    <div class="row">
        <div class="col-sm-1" style="padding-left: 0px;padding-top: 10px">
            <div style="font-size:15px">建筑类型：</div>
        </div>
        <div class="col-sm-4" style="padding-left: 0px;padding-top: 10px">
            <input type="text" name="type" value="${EstateDto.type}">
        </div>
    </div>
    <div class="row">
        <div class="col-sm-1" style="padding-left: 0px;padding-top: 10px">
            <div style="font-size:15px">开发商：</div>
        </div>
        <div class="col-sm-4" style="padding-left: 0px;padding-top: 10px">
            <input type="text" name="developer" value="${EstateDto.developer}">
        </div>
    </div>
    <div class="row">
        <div class="col-sm-1" style="padding-left: 0px;padding-top: 10px">
            <div style="font-size:15px">面积：</div>
        </div>
        <div class="col-sm-4" style="padding-left: 0px;padding-top: 10px">
            <input type="text" name="developer" value="${EstateDto.area}">
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
            <input type="text" name="estateName" value="${EstateDto.developerQuotes}">
        </div>
        <div class="col-sm-1 col-sm-offset-1" style="padding-left: 0px;padding-top: 10px">
            <div style="font-size:15px">销售状态：</div>
        </div>
        <div class="col-sm-3" style="padding-left: 0px;padding-top: 10px">
            <%--<input type="text" name="saleStatus" value="${EstateDto.saleStatus}">--%>
            <select name="saleStatus" value="EstateDto.saleStatus">
                <option value="0" <c:if test="${'0' eq EstateDto.saleStatus}">selected</c:if>>在售</option>
                <option value="1" <c:if test="${'1' eq EstateDto.saleStatus}">selected</c:if>>待售</option>
            </select>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-1" style="padding-left: 0px;padding-top: 10px">
            <div style="font-size:15px">最新开盘：</div>
        </div>
        <div class="col-sm-3" style="padding-left: 0px;padding-top: 10px">
            <input type="text" name="estateName" value="${EstateDto.latestOpening}">
        </div>
        <div class="col-sm-1 col-sm-offset-1" style="padding-left: 0px;padding-top: 10px">
            <div style="font-size:15px">最早交房：</div>
        </div>
        <div class="col-sm-3" style="padding-left: 0px;padding-top: 10px">
            <input type="text" name="estateName" value="${EstateDto.firstDelivery}">
        </div>
    </div>
    <div class="row">
        <div class="col-sm-1" style="padding-left: 0px;padding-top: 10px;padding-right: 0px">
            <div style="font-size:15px">楼盘户型：</div>
        </div>
        <div class="col-sm-3" style="padding-left: 0px;padding-top: 10px">
            <input type="text" name="estateName" value="${EstateDto.houseType}">
        </div>
        <div class="col-sm-1 col-sm-offset-1" style="padding-left: 0px;padding-top: 10px">
            <div style="font-size:15px">产权年限：</div>
        </div>
        <div class="col-sm-3" style="padding-left: 0px;padding-top: 10px">
            <input type="text" name="estateName" value="${EstateDto.propertyRights}">
        </div>
    </div>
    <div class="row">
        <div class="col-sm-1" style="padding-left: 0px;padding-top: 10px">
            <div style="font-size:15px">拿地时间：</div>
        </div>
        <div class="col-sm-3" style="padding-left: 0px;padding-top: 10px">
            <input type="text" name="developer" value="${EstateDto.takeTime}">
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
            <input type="text" name="estateName" value="${EstateDto.company}">
        </div>
        <div class="col-sm-1 col-sm-offset-1" style="padding-left: 0px;padding-top: 10px">
            <div style="font-size:15px">车位情况：</div>
        </div>
        <div class="col-sm-3" style="padding-left: 0px;padding-top: 10px">
            <input type="text" name="estateName" value="${EstateDto.parkingSpaces}">
        </div>
    </div>
    <div class="row">
        <div class="col-sm-1" style="padding-left: 0px;padding-top: 10px">
            <div style="font-size:15px">物业费用：</div>
        </div>
        <div class="col-sm-3" style="padding-left: 0px;padding-top: 10px">
            <input type="text" name="estateName" value="${EstateDto.propertyCost}">
        </div>
        <div class="col-sm-1 col-sm-offset-1" style="padding-left: 0px;padding-top: 10px">
            <div style="font-size:15px">容积率：</div>
        </div>
        <div class="col-sm-3" style="padding-left: 0px;padding-top: 10px">
            <input type="text" name="estateName" value="${EstateDto.plotRatio}">
        </div>
    </div>
    <div class="row">
        <div class="col-sm-1" style="padding-left: 0px;padding-top: 10px;padding-right: 0px">
            <div style="font-size:15px">水电燃气：</div>
        </div>
        <div class="col-sm-3" style="padding-left: 0px;padding-top: 10px">
            <input type="text" name="estateName" value="${EstateDto.powerType}">
        </div>
        <div class="col-sm-1 col-sm-offset-1" style="padding-left: 0px;padding-top: 10px">
            <div style="font-size:15px">装修情况：</div>
        </div>
        <div class="col-sm-3" style="padding-left: 0px;padding-top: 10px">
            <input type="text" name="estateName" value="${EstateDto.decoration}">
        </div>
    </div>
    <div class="row">
        <div class="col-sm-1" style="padding-left: 0px;padding-top: 10px">
            <div style="font-size:15px">绿化率：</div>
        </div>
        <div class="col-sm-3" style="padding-left: 0px;padding-top: 10px">
            <input type="text" name="developer" value="${EstateDto.greenRate}">%
        </div>
        <div class="col-sm-1 col-sm-offset-1" style="padding-left: 0px;padding-top: 10px">
            <div style="font-size:15px">楼栋信息：</div>
        </div>
        <div class="col-sm-3" style="padding-left: 0px;padding-top: 10px">
            <input type="text" name="estateName" value="${EstateDto.estateInformation}">
        </div>
    </div>
    <br>
    <div class="row">
        <div class="col-sm-12" style="padding-left: 0px">
            <h3>楼盘图片</h3>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12" style="padding-left: 0px">
            <h5>效果图（${esize}）</h5>
        </div>
        <div class="col-sm-12" style="padding-left: 0px">
            <div class="halving_line"></div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12" style="padding-left: 0px">
            <%--<div class="choosePhotos" id="e_choosePhotos"></div>--%>
            <input type="file" value="">
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12" style="padding-left: 0px">
            <c:forEach var="e" items="${EstateDto.effectPictureDtoList}">
                <div class="col-sm-4" style="text-align: center">
                    <img src="piccreate/picCreate.jsp?ppath=${e.name}" class="photo100">
                    <a class="btn btn-default center-block" href="" role="button" onclick="return contirmd()">删除</a>
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12" style="padding-left: 0px">
            <h5>样板间（${psize}）</h5>
        </div>
        <div class="col-sm-12" style="padding-left: 0px">
            <div class="halving_line"></div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12" style="padding-left: 0px">
            <div class="choosePhotos" id="p_choosePhotos"></div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12" style="padding-left: 0px">
            <c:forEach var="e" items="${EstateDto.prototypeRoomPictureDtoList}">
                <div class="col-sm-4" style="text-align: center">
                    <img src="piccreate/picCreate.jsp?ppath=${e.name}" class="photo100">
                    <a class="btn btn-default center-block" href="" role="button" onclick="return contirmd()">删除</a>
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12" style="padding-left: 0px">
            <h5>环境规划图（${ssize}）</h5>
        </div>
        <div class="col-sm-12" style="padding-left: 0px">
            <div class="halving_line"></div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12" style="padding-left: 0px">
            <div class="choosePhotos" id="s_choosePhotos"></div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12" style="padding-left: 0px">
            <c:forEach var="e" items="${EstateDto.samplePlanningPictureDtoList}">
                <div class="col-sm-4" style="text-align: center">
                    <img src="piccreate/picCreate.jsp?ppath=${e.name}" class="photo100">
                    <a class="btn btn-default center-block" href="" role="button" onclick="return contirmd()">删除</a>
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12" style="padding-left: 0px">
            <h5>楼盘实景图（${rsize}）</h5>
        </div>
        <div class="col-sm-12" style="padding-left: 0px">
            <div class="halving_line"></div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12" style="padding-left: 0px">
            <div class="choosePhotos" id="r_choosePhotos"></div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12" style="padding-left: 0px">
            <c:forEach var="e" items="${EstateDto.realEststePictureDtoList}">
                <div class="col-sm-4" style="text-align: center">
                    <img src="piccreate/picCreate.jsp?ppath=${e.name}" class="photo100">
                    <a class="btn btn-default center-block" href="" role="button" onclick="return contirmd()">删除</a>
                </div>
            </c:forEach>
        </div>
    </div>
    <br>
    <div class="row">
        <div class="col-sm-12" style="padding-left: 0px">
            <div class="btn-group center-block" role="group" aria-label="...">
                <a class="btn btn-default center-block" href="" role="button">保存</a>
                <a class="btn btn-default center-block" href="/estate/query" role="button" >返回</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
