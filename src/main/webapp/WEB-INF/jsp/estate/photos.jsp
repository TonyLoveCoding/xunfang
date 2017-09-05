<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2017/9/5
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

</head>
<body style="height: auto">
<div  class="container-fluid">
    <div class="row">
        <div class="col-sm-12" style="padding-left: 0px">
            <h3>${EstateDto.estateName}</h3>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12" style="padding-left: 0px">
            <h4>效果图（${esize}）</h4>
        </div>
        <div class="col-sm-12" style="padding-left: 0px">
            <div class="halving_line"></div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12" style="padding-left: 0px">
            <%--<div class="choosePhotos" id="e_choosePhotos"></div>--%>
            <form action="/photos/addphotos" id="form0" method="post" enctype="multipart/form-data">
                <input id="file1" name="file1" type="file" accept="image/gif, image/jpeg, image/png" style="display: none" multiple="multiple">
                <label for="file1" class="btn btn-default savePhoto">添加图片</label>

            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12" style="padding-left: 0px">
            <c:forEach var="e" items="${EstateDto.effectPictureDtoList}">
                <div class="col-sm-4 saved" style="text-align: center">
                    <img src="${e.name}" class="photo100">
                    <a class="btn btn-default center-block" href="javaspri" role="button" onclick="return contirmd()">删除</a>
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12" style="padding-left: 0px">
            <h4>样板间（${psize}）</h4>
        </div>
        <div class="col-sm-12" style="padding-left: 0px">
            <div class="halving_line"></div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12" style="padding-left: 0px">
            <%--<div class="choosePhotos" id="p_choosePhotos"></div>--%>
            <%--<label for="files" class="btn btn-default savePhoto">添加图片</label>--%>
            <%--<input id="files" type="file" style="display: none" multiple>--%>
            <form action="/photos/addphotos" id="form1" method="post" enctype="multipart/form-data">
                <label for="file2" class="btn btn-default savePhoto">添加图片</label>
                <input id="file2" name="file2" type="file" accept="image/gif, image/jpeg, image/png" style="display: none" multiple>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12" style="padding-left: 0px">
            <c:forEach var="e" items="${EstateDto.prototypeRoomPictureDtoList}">
                <div class="col-sm-4" style="text-align: center">
                    <img src="${e.name}" class="photo100">
                    <a class="btn btn-default center-block" href="" role="button" onclick="return contirmd()">删除</a>
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12" style="padding-left: 0px">
            <h4>环境规划图（${ssize}）</h4>
        </div>
        <div class="col-sm-12" style="padding-left: 0px">
            <div class="halving_line"></div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12" style="padding-left: 0px">
            <%--<div class="choosePhotos" id="s_choosePhotos"></div>--%>
            <%--<label for="files" class="btn btn-default savePhoto">添加图片</label>--%>
            <%--<input id="files" type="file" style="display: none" multiple>--%>
            <form action="/photos/addphotos" id="form2" method="post" enctype="multipart/form-data">
                <label for="file3" class="btn btn-default savePhoto">添加图片</label>
                <input id="file3" name="file3" type="file" accept="image/gif, image/jpeg, image/png" style="display: none" multiple>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12" style="padding-left: 0px">
            <c:forEach var="e" items="${EstateDto.samplePlanningPictureDtoList}">
                <div class="col-sm-4" style="text-align: center">
                    <img src="${e.name}" class="photo100">
                    <a class="btn btn-default center-block" href="" role="button" onclick="return contirmd()">删除</a>
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12" style="padding-left: 0px">
            <h4>楼盘实景图（${rsize}）</h4>
        </div>
        <div class="col-sm-12" style="padding-left: 0px">
            <div class="halving_line"></div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12" style="padding-left: 0px">
            <%--<div class="choosePhotos" id="r_choosePhotos"></div>--%>
            <%--<label for="files" class="btn btn-default savePhoto">添加图片</label>--%>
            <%--<input id="files" type="file" style="display: none" multiple>--%>
            <form action="/photos/addphotos" id="form3" method="post" enctype="multipart/form-data">
                <label for="file4" class="btn btn-default savePhoto">添加图片</label>
                <input id="file4" name="file4" type="file" accept="image/gif, image/jpeg, image/png" style="display: none" multiple>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12" style="padding-left: 0px">
            <c:forEach var="e" items="${EstateDto.realEststePictureDtoList}">
                <div class="col-sm-4" style="text-align: center">
                    <img src="${e.name}" class="photo100">
                    <a class="btn btn-default center-block" href="" role="button" onclick="return contirmd()">删除</a>
                </div>
            </c:forEach>
        </div>
    </div>
    <br>
    <div class="row">
        <div class="col-sm-12" style="padding-left: 0px">
            <div class="btn-group center-block" role="group" aria-label="...">
                <a class="btn btn-default center-block" href="/estate/query" role="button" >返回</a>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="assets/estate/update/update.js"></script>
</body>
</html>
