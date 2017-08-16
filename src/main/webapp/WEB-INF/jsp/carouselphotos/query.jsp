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
        function contirmd() {
            var msg = "您确定要删除吗？"
            if (confirm(msg) == true) {
                return ture;
            } else {
                return false;
            }
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
        <div class="col-md-12"><div id="choosePhotos"></div></div>
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
                <div class="btn-group center-block" role="group" aria-label="...">
                    <a class="btn btn-default center-block" href="/carouselPhotos/deletephoto?id=${photo.id}" role="button" onclick="return contirmd()">删除</a>
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

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document" style="width: auto">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">添加轮播图</h4>
            </div>
            <div class="modal-body">
                输入图片链接：<input type="text" name="url" style="width: 100%">
                <div id="TCrop"></div>
            </div>

        </div>
    </div>
</div>
</body>
</html>
