<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2017/8/11
  Time: 19:46
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
<body>
<div>
    <div class="btn-group center-block" role="group" aria-label="...">
        <a class="btn btn-default center-block" href="/estate/update1?id=${EstateDto.id}" role="button" target="_self">修改信息</a>
        <a class="btn btn-default center-block" href="" role="button" >返回</a>
    </div>
    <div class="row">
        <div class="col-md-12">
            <h3>基本信息</h3>
            <div class="halving_line"></div>
        </div>
    </div>
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-1" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">楼盘名称：</div>
            </div>
            <div class="col-sm-4" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">${EstateDto.estateName}</div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-1" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">楼盘地址：</div>
            </div>
            <div class="col-sm-4" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">${EstateDto.estateAddress}</div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-1" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">物业类型：</div>
            </div>
            <div class="col-sm-4" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">${EstateDto.property}</div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-1" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">建筑类型：</div>
            </div>
            <div class="col-sm-4" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">${EstateDto.type}</div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-1" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">开发商：</div>
            </div>
            <div class="col-sm-4" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">${EstateDto.developer}</div>
            </div>
        </div>
    </div>
    <br>
    <%--小区详情模块--%>
    <div class="row">
        <div class="col-md-12">
            <h3>小区详情</h3>
            <div class="halving_line"></div>
        </div>
    </div>
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-1" style="padding-left: 0px;padding-top: 10px;padding-right: 0px">
                <div style="font-size:15px">物业公司：</div>
            </div>
            <div class="col-sm-3" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">${EstateDto.company}</div>
            </div>
            <div class="col-sm-1 col-md-offset-1" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">车位情况：</div>
            </div>
            <div class="col-sm-3" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">${EstateDto.parkingSpaces}</div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-1" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">物业费用：</div>
            </div>
            <div class="col-sm-3" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">${EstateDto.propertyCost}</div>
            </div>
            <div class="col-sm-1 col-md-offset-1" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">容积率：</div>
            </div>
            <div class="col-sm-3" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">${EstateDto.plotRatio}</div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-1" style="padding-left: 0px;padding-top: 10px;padding-right: 0px">
                <div style="font-size:15px">水电燃气：</div>
            </div>
            <div class="col-sm-3" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">${EstateDto.powerType}</div>
            </div>
            <div class="col-sm-1 col-md-offset-1" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">装修情况：</div>
            </div>
            <div class="col-sm-3" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">${EstateDto.decoration}</div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-1" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">绿化率：</div>
            </div>
            <div class="col-sm-3" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">${EstateDto.greenRate}%</div>
            </div>
            <div class="col-sm-1 col-md-offset-1" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">楼栋信息：</div>
            </div>
            <div class="col-sm-3" style="padding-left: 0px;padding-top: 10px">
                <div style="font-size:15px">${EstateDto.estateInformation}</div>
            </div>
        </div>
    </div>
    <br>
    <div class="row">
        <div class="col-md-12">
            <h3>楼盘图片</h3>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <h5>效果图（${esize}）</h5>
            <div class="halving_line"></div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <c:forEach var="e" items="${EstateDto.effectPictureDtoList}">
                <div class="col-md-4" style="text-align: center;padding-top: 10px">
                    <img src="piccreate/picCreate.jsp?ppath=${e.name}" class="photo300">
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <h5>样板间（${psize}）</h5>
            <div class="halving_line"></div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <c:forEach var="e" items="${EstateDto.prototypeRoomPictureDtoList}">
                <div class="col-md-4" style="text-align: center;padding-top: 10px">
                    <img src="piccreate/picCreate.jsp?ppath=${e.name}" class="photo300">
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <h5>环境规划图（${ssize}）</h5>
            <div class="halving_line"></div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <c:forEach var="e" items="${EstateDto.samplePlanningPictureDtoList}">
                <div class="col-md-4" style="text-align: center;padding-top: 10px">
                    <img src="piccreate/picCreate.jsp?ppath=${e.name}" class="photo300">
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <h5>楼盘实景图（${rsize}）</h5>
            <div class="halving_line"></div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <c:forEach var="e" items="${EstateDto.realEststePictureDtoList}">
                <div class="col-md-4" style="text-align: center;padding-top: 10px">
                    <img src="piccreate/picCreate.jsp?ppath=${e.name}" class="photo300">
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>
