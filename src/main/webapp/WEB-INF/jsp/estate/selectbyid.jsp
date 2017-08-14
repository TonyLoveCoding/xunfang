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
    <style>
        .photo300{
            width: 300px;
            height: 300px;
            margin-top: 10px;
        }
        .halving_line{
            background-color: #0074c1;
            width: 100%;
            height: 2px;}
    </style>
</head>
<body>
    <div class="btn-group center-block" role="group" aria-label="...">
        <a class="btn btn-default center-block" href="/estate/update1?id=${EstateDto.id}" role="button">修改信息</a>
        <a class="btn btn-default center-block" href="/estate/query" role="button">返回</a>
    </div>
    <br>
    <div>
        <h3>基本信息</h3>
        <table class="table">
            <tbody>
                <tr border="1">
                    <th>楼盘名称：${EstateDto.estateName}</th>
                </tr>
                <tr style="border: hidden">
                    <th>楼盘地址：${EstateDto.estateAddress}</th>
                </tr>
                <tr style="border: hidden">
                    <th>物业类型：${EstateDto.property}</th>
                </tr>
                <tr style="border: hidden">
                    <th>建筑类型：${EstateDto.type}</th>
                </tr>
                <%--<tr style="border: hidden">--%>
                    <%--<th>环线：${EstateDto.estateName}</th>--%>
                <%--</tr>--%>
                <tr style="border: hidden">
                    <th>开发商：${EstateDto.developer}</th>
                </tr>
            </tbody>
        </table>
        <br>
        <h3>销售信息</h3>
        <table class="table">
            <tbody>
                <tr border="1">
                    <th>开发商报价：${EstateDto.developerQuotes}</th>
                    <th>楼盘户型：${EstateDto.houseType}</th>
                </tr>
                <tr style="border: hidden">
                    <th>销售状态：${EstateDto.saleStatus}</th>
                    <th>产权年限：${EstateDto.propertyRights}</th>
                </tr>
                <tr style="border: hidden">
                    <th>最新开盘：${EstateDto.latestOpening}</th>
                    <th>拿地时间：${EstateDto.takeTime}</th>
                </tr>
                <tr style="border: hidden">
                    <th>最早交房：${EstateDto.firstDelivery}</th>
                </tr>
            </tbody>
        </table>
        <br>
        <h3>小区详情</h3>
        <table class="table">
            <tbody>
                <tr border="1">
                    <th>物业公司：${EstateDto.company}</th>
                    <th>车位情况：${EstateDto.parkingSpaces}</th>
                </tr>
                <tr style="border: hidden">
                    <th>物业费用：${EstateDto.propertyCost}</th>
                    <th>容积率：${EstateDto.plotRatio}</th>
                </tr>
                <tr style="border: hidden">
                    <th>水电燃气：${EstateDto.powerType}</th>
                    <th>装修情况：${EstateDto.decoration}</th>
                </tr>
                <tr style="border: hidden">
                    <th>绿化率：${EstateDto.greenRate}%</th>
                    <th>楼栋信息：${EstateDto.estateInformation}</th>
                </tr>
            </tbody>
        </table>
        <br>
        <h3>楼盘图片</h3>
        <div class="row">
            <div class="col-md-12">
                <h5>效果图（${esize}）</h5>
                <div class="halving_line"></div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <c:forEach var="e" items="${EstateDto.effectPictureDtoList}">
                    <div class="col-md-4" >
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
                    <div class="col-md-4" >
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
                    <div class="col-md-4" >
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
                    <div class="col-md-4" >
                        <img src="piccreate/picCreate.jsp?ppath=${e.name}" class="photo300">
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</body>
</html>
