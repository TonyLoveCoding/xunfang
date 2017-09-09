<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2017/8/14
  Time: 10:03
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
    <script type="text/javascript" src="assets/carouselPhotos/js/imgCropUpload.js"></script>
    <link rel="stylesheet" href="assets/carouselPhotos/css/query.css">
    <script type="text/javascript" src="assets/carouselPhotos/js/query.js"></script>
    <script type="text/javascript">
        function contirmd(id) {
            var msg = "您确定要删除吗？"
            if (confirm(msg) == true) {
                $.ajax({
                    type:"GET",
                    url:"/carouselPhotos/deletephoto?id="+id,
                    dataType:"json",
                    error:function () {
                    },
                    success:function (Msg) {
                        if(Msg.code==100){
                            alert("删除成功");
                            location.href="/carouselPhotos/query";
                        }
                        if(Msg.code==200){
                            alert(Msg.tip);
                        }
                    }
                })
            } else {
                return false;
            }
        }

        function exceed(maxNumber) {
            alert("轮播图数量超过规定的"+maxNumber+"张,无法添加");
        }

    </script>
    <style>
        .photo300{
            width: 810px;
            height: 300px;
        }
    </style>
</head>
<body>

<div>
    <div class="row">
        <div class="col-md-12">
            <h4>轮播图（${count}）</h4>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <c:choose>
                <c:when test="${count eq maxNumber}">
                    <div class="crop-picker-wrap">
                        <button class="crop-picker" type="button" onclick="exceed(${maxNumber})">添加图片</button>
                    </div>
                </c:when>
                <c:otherwise>
                    <div id="choosePhotos"></div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    <div class="row">
        <div class="col-md-9">
            <h4>图片</h4>
        </div>
        <div class="col-md-3">
            <h4>操作</h4>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="halving_line"></div>
        </div>
    </div>
    <c:forEach var="photo" items="${list}">
        <div class="row">
            <div class="col-md-9" style="padding-top: 10px">
                <img src="${photo.name}" class="photo300"><br/>
                图片链接：${photo.url}
            </div>
            <div class="col-md-3" style="vertical-align: middle;text-align: center">
                <div class="btn-group-vertical" role="group" aria-label="...">
                    <button type="button" class="btn btn-default glyphicon glyphicon-menu-up" onclick="movePhoto('${photo.id}','-1')"></button>
                    <a class="btn btn-default center-block glyphicon glyphicon-remove" href="javascript:void(0);" onclick="contirmd('${photo.id}')">删除</a>
                    <button type="button" class="btn btn-default glyphicon glyphicon-menu-down" onclick="movePhoto('${photo.id}','1')"></button>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="halving_line"></div>
            </div>
        </div>
    </c:forEach>
</div>

</body>
</html>
