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
<body>
<div>
    <h3>基本信息</h3>
    <table class="table">
        <tbody>
        <div class="container-fluid">
            <div class="row">
                <tr border="1">
                    <td style="vertical-align: middle">
                        <div class="col-sm-1" style="padding-left: 0px">
                            <div style="font-size:15px">楼盘名称：</div>
                        </div>
                        <div class="col-sm-4" style="padding-left: 0px">
                            <input type="text" name="estateName" value="${EstateDto.estateName}">
                        </div>
                    </td>
                </tr>
                <tr style="border: hidden">
                    <td>
                        <div class="col-sm-1" style="padding-left: 0px">
                            <div style="font-size:15px">楼盘地址：</div>
                        </div>
                        <div class="col-sm-4" style="padding-left: 0px">
                            <input type="text" name="estateAddress" value="${EstateDto.estateAddress}">
                        </div>
                    </td>
                </tr>
                <tr style="border: hidden">
                    <td>
                        <div class="col-sm-1" style="padding-left: 0px">
                            <div style="font-size:15px">物业类型：</div>
                        </div>
                        <div class="col-sm-4" style="padding-left: 0px">
                            <input type="text" name="property" value="${EstateDto.property}">
                        </div>
                    </td>
                </tr>
                <tr style="border: hidden">
                    <td>
                        <div class="col-sm-1" style="padding-left: 0px">
                            <div style="font-size:15px">建筑类型：</div>
                        </div>
                        <div class="col-sm-4" style="padding-left: 0px">
                            <input type="text" name="type" value="${EstateDto.type}">
                        </div>
                    </td>
                </tr>
                <tr style="border: hidden">
                    <td>
                        <div class="col-sm-1" style="padding-left: 0px">
                            <div style="font-size:15px">开发商：</div>
                        </div>
                        <div class="col-sm-4" style="padding-left: 0px">
                            <input type="text" name="developer" value="${EstateDto.developer}">
                        </div>
                    </td>
                </tr>
            </div>
        </div>
        </tbody>
    </table>
    <br>
    <h3>销售信息</h3>
    <table class="table">
        <tbody>
        <tr border="1">
            <td>
                <div class="col-sm-3" style="padding-left: 0px">
                    <div style="font-size:15px">开发商报价：</div>
                </div>
                <div class="col-sm-2" style="padding-left: 0px">
                    <input type="text" name="developerQuotes" value="${EstateDto.developerQuotes}">
                </div>
            </td>
            <td>
                <div class="col-sm-3 col-sm-offset-1" style="padding-left: 0px">
                    <div style="font-size:15px">楼盘户型：</div>
                </div>
                <div class="col-sm-2" style="padding-left: 0px">
                    <input type="text" name="houseType" value="${EstateDto.houseType}">
                </div>
            </td>
        </tr>
        <tr style="border: hidden">
            <td>
                <div class="col-sm-3" style="padding-left: 0px">
                    <div style="font-size:15px">销售状态：</div>
                </div>
                <div class="col-sm-2" style="padding-left: 0px">
                    <input type="text" name="saleStatus" value="${EstateDto.saleStatus}">
                </div>
            </td>
            <td>
                <div class="col-sm-3 col-sm-offset-1" style="padding-left: 0px">
                    <div style="font-size:15px">产权年限：</div>
                </div>
                <div class="col-sm-2" style="padding-left: 0px">
                    <input type="text" name="propertyRights" value="${EstateDto.propertyRights}">
                </div>
            </td>
        </tr>
        <tr style="border: hidden">
            <td>
                <div class="col-sm-3" style="padding-left: 0px">
                    <div style="font-size:15px">最新开盘：</div>
                </div>
                <div class="col-sm-2" style="padding-left: 0px">
                    <input type="text" name="latestOpening" value="${EstateDto.latestOpening}">
                </div>
            </td>
            <td>
                <div class="col-sm-3 col-sm-offset-1" style="padding-left: 0px">
                    <div style="font-size:15px">拿地时间：</div>
                </div>
                <div class="col-sm-2" style="padding-left: 0px">
                    <input type="text" name="takeTime" value="${EstateDto.takeTime}">
                </div>
            </td>
        </tr>
        <tr style="border: hidden">
            <td>
                <div class="col-sm-3" style="padding-left: 0px">
                    <div style="font-size:15px">最早交房：</div>
                </div>
                <div class="col-sm-2" style="padding-left: 0px">
                    <input type="text" name="firstDelivery" value="${EstateDto.firstDelivery}">
                </div>
            </td>
        </tr>
        </tbody>
    </table>
    <br>
    <h3>小区详情</h3>
    <table class="table">
        <tbody>
        <tr border="1">
            <td>
                <div class="col-sm-3" style="padding-left: 0px">
                    <div style="font-size:15px">物业公司：</div>
                </div>
                <div class="col-sm-2" style="padding-left: 0px">
                    <input type="text" name="company" value="${EstateDto.company}">
                </div>
            </td>
            <td>
                <div class="col-sm-3 col-sm-offset-1" style="padding-left: 0px">
                    <div style="font-size:15px">车位情况：</div>
                </div>
                <div class="col-sm-2" style="padding-left: 0px">
                    <input type="text" name="parkingSpaces" value="${EstateDto.parkingSpaces}">
                </div>
            </td>
        </tr>
        <tr style="border: hidden">
            <td>
                <div class="col-sm-3" style="padding-left: 0px">
                    <div style="font-size:15px">物业费用：</div>
                </div>
                <div class="col-sm-2" style="padding-left: 0px">
                    <input type="text" name="propertyCost" value="${EstateDto.propertyCost}">
                </div>
            </td>
            <td>
                <div class="col-sm-3 col-sm-offset-1" style="padding-left: 0px">
                    <div style="font-size:15px">容积率：</div>
                </div>
                <div class="col-sm-2" style="padding-left: 0px">
                    <input type="text" name="plotRatio" value="${EstateDto.plotRatio}">
                </div>
            </td>
        </tr>
        <tr style="border: hidden">
            <td>
                <div class="col-sm-3" style="padding-left: 0px">
                    <div style="font-size:15px">水电燃气：</div>
                </div>
                <div class="col-sm-2" style="padding-left: 0px">
                    <input type="text" name="powerType" value="${EstateDto.powerType}">
                </div>
            </td>
            <td>
                <div class="col-sm-3 col-sm-offset-1" style="padding-left: 0px">
                    <div style="font-size:15px">装修情况：</div>
                </div>
                <div class="col-sm-2" style="padding-left: 0px">
                    <input type="text" name="decoration" value="${EstateDto.decoration}">
                </div>
            </td>
        </tr>
        <tr style="border: hidden">
            <td>
                <div class="col-sm-3" style="padding-left: 0px">
                    <div style="font-size:15px">绿化率：</div>
                </div>
                <div class="col-sm-2" style="padding-left: 0px">
                    <input type="text" name="greenRate" value="${EstateDto.greenRate}%">
                </div>
            </td>
            <td>
                <div class="col-sm-3 col-sm-offset-1" style="padding-left: 0px">
                    <div style="font-size:15px">楼栋信息：</div>
                </div>
                <div class="col-sm-2" style="padding-left: 0px">
                    <input type="text" name="estateInformation" value="${EstateDto.estateInformation}">
                </div>
            </td>
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
    <div>
        <!-- Button trigger modal -->
        <button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal">
            添加图片
        </button>
    </div>

    <br>
    <div class="row">
        <div class="col-md-12">
            <c:forEach var="e" items="${EstateDto.effectPictureDtoList}">
                <div class="col-md-4" style="text-align: center">
                    <img src="piccreate/picCreate.jsp?ppath=${e.name}" class="photo100">
                    <a class="btn btn-default center-block" href="" role="button" onclick="return contirmd()">删除</a>
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
    <div>
        <!-- Button trigger modal -->
        <button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal">
            添加图片
        </button>
    </div>

    <br>
    <div class="row">
        <div class="col-md-12">
            <c:forEach var="e" items="${EstateDto.prototypeRoomPictureDtoList}">
                <div class="col-md-4" style="text-align: center">
                    <img src="piccreate/picCreate.jsp?ppath=${e.name}" class="photo100">
                    <a class="btn btn-default center-block" href="" role="button" onclick="return contirmd()">删除</a>
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
    <div>
        <!-- Button trigger modal -->
        <button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal">
            添加图片
        </button>
    </div>

    <br>
    <div class="row">
        <div class="col-md-12">
            <c:forEach var="e" items="${EstateDto.samplePlanningPictureDtoList}">
                <div class="col-md-4" style="text-align: center">
                    <img src="piccreate/picCreate.jsp?ppath=${e.name}" class="photo100">
                    <a class="btn btn-default center-block" href="" role="button" onclick="return contirmd()">删除</a>
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
    <div>
        <!-- Button trigger modal -->
        <button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal">
            添加图片
        </button>
    </div>

    <br>
    <div class="row">
        <div class="col-md-12">
            <c:forEach var="e" items="${EstateDto.realEststePictureDtoList}">
                <div class="col-md-4" style="text-align: center">
                    <img src="piccreate/picCreate.jsp?ppath=${e.name}" class="photo100">
                    <a class="btn btn-default center-block" href="" role="button" onclick="return contirmd()">删除</a>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<div class="btn-group center-block" role="group" aria-label="...">
    <a class="btn btn-default center-block" href="" role="button">保存</a>
    <a class="btn btn-default center-block" href="" role="button" >返回</a>
</div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document" style="width: auto">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">添加图片</h4>
            </div>
            <div class="modal-body">
                <div id="TCrop"></div>
            </div>
            <%--<div class="modal-footer">--%>
                <%--<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>--%>
                <%--<button type="button" class="btn btn-primary">保存</button>--%>
            <%--</div>--%>
        </div>
    </div>
</div>
</body>
</html>
