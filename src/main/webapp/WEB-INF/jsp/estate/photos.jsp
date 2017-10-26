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
    <%--<link rel="stylesheet" href="assets/uplodephoto/css/jquery.Jcrop.css">--%>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <script src="assets/estate/photos/js/jquery-1.7.2.min.js"></script>
    <link rel="stylesheet" href="assets/estate/photos/css/photos.css">
    <script>
        window.onload = function (){
            if(${bool}==false){
                alert("图片上传失败！请确保图片比例为3:2");
            }
        };
    </script>
</head>
<body style="height: auto">
<div  class="container-fluid">
    <div class="row">
        <div class="col-sm-12" style="padding-left: 0px">
            <h3>${EstateDto.estateName}</h3>
            <input type="text" value="${bool}" hidden>
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
            <form action="/estate/saveEffectPicture" method="post" enctype="multipart/form-data">
                <input type="text" name="id" value="${EstateDto.id}" hidden>
                <input id="file1" class="inp_photos conImage" name="files" type="file" style="display: none" accept="image/gif, image/jpeg, image/png, image/jpg">
                <label for="file1" class="btn btn-default savePhoto">添加图片</label>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12" style="padding-left: 0px">
            <c:forEach var="e" items="${EstateDto.effectPictureDtoList}">
                <div class="col-sm-4 saved" style="text-align: center">
                    <img src="${e.name}" class="photo100">
                    <c:if test="${esize!=0}">
                        <div class="btn-group" role="group" aria-label="...">
                            <button type="button" class="btn btn-default glyphicon glyphicon-menu-left" onclick="moveEffectPicture('${EstateDto.id}','${e.id}','-1')"></button>
                                <%--<button class="btn btn-default center-block glyphicon glyphicon-remove" href="javascript:void(0);" onclick="deleteEffectPicture('${e.id}','${EstateDto.id}')">删除</button>--%>
                            <a class="btn btn-default center-block glyphicon glyphicon-remove" href="javascript:void(0);" role="button" onclick="deleteEffectPicture('${e.id}','${EstateDto.id}')">删除</a>
                            <button type="button" class="btn btn-default glyphicon glyphicon-menu-right" onclick="moveEffectPicture('${EstateDto.id}','${e.id}','1')"></button>
                        </div>
                    </c:if>
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
            <form action="/estate/savePrototypeRoomPicture" method="post" enctype="multipart/form-data">
                <input type="text" name="id" value="${EstateDto.id}" hidden>
                <input id="file2" class="inp_photos" name="files" type="file" style="display: none" accept="image/gif, image/jpeg, image/png">
                <label for="file2" class="btn btn-default savePhoto">添加图片</label>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12" style="padding-left: 0px">
            <c:forEach var="e" items="${EstateDto.prototypeRoomPictureDtoList}">
                <div class="col-sm-4" style="text-align: center">
                    <img src="${e.name}" class="photo100">
                    <c:if test="${psize!=0}">
                        <div class="btn-group" role="group" aria-label="...">
                            <button type="button" class="btn btn-default glyphicon glyphicon-menu-left" onclick="movePrototypeRoomPicture('${EstateDto.id}','${e.id}','-1')"></button>
                            <a class="btn btn-default center-block glyphicon glyphicon-remove" href="javascript:void(0);" role="button" onclick="deletePrototypeRoomPicture('${e.id}','${EstateDto.id}')">删除</a>
                            <button type="button" class="btn btn-default glyphicon glyphicon-menu-right" onclick="movePrototypeRoomPicture('${EstateDto.id}','${e.id}','1')"></button>
                        </div>
                    </c:if>
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
            <form action="/estate/saveSamplePlanningPicture" method="post" enctype="multipart/form-data">
                <input type="text" name="id" value="${EstateDto.id}" hidden>
                <input onChange="handleConFiles(this.files);" id="file3" class="inp_photos" name="files" type="file" style="display: none" accept="image/gif, image/jpeg, image/png">
                <label for="file3" class="btn btn-default savePhoto">添加图片</label>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12" style="padding-left: 0px">
            <c:forEach var="e" items="${EstateDto.samplePlanningPictureDtoList}">
                <div class="col-sm-4" style="text-align: center">
                    <img src="${e.name}" class="photo100">
                    <c:if test="${ssize!=0}">
                        <div class="btn-group" role="group" aria-label="...">
                            <button type="button" class="btn btn-default glyphicon glyphicon-menu-left" onclick="moveSamplePlanningPicture('${EstateDto.id}','${e.id}','-1')"></button>
                            <a class="btn btn-default center-block glyphicon glyphicon-remove" href="javascript:void(0);" role="button" onclick="deleteSamplePlanningPicture('${e.id}','${EstateDto.id}')">删除</a>
                            <button type="button" class="btn btn-default glyphicon glyphicon-menu-right" onclick="moveSamplePlanningPicture('${EstateDto.id}','${e.id}','1')"></button>
                        </div>
                    </c:if>
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
            <form action="/estate/saveRealEststePicture" method="post" enctype="multipart/form-data">
                <input type="text" name="id" value="${EstateDto.id}" hidden>
                <input id="file4" class="inp_photos" name="files" type="file" style="display: none" accept="image/gif, image/jpeg, image/png">
                <label for="file4" class="btn btn-default savePhoto">添加图片</label>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12" style="padding-left: 0px">
            <c:forEach var="e" items="${EstateDto.realEststePictureDtoList}">
                <div class="col-sm-4" style="text-align: center">
                    <img src="${e.name}" class="photo100">
                    <c:if test="${rsize!=0}">
                        <div class="btn-group" role="group" aria-label="...">
                            <button type="button" class="btn btn-default glyphicon glyphicon-menu-left" onclick="moveRealEststePicture('${EstateDto.id}','${e.id}','-1')"></button>
                            <a class="btn btn-default center-block glyphicon glyphicon-remove" href="javascript:void(0);" role="button" onclick="deleteRealEststePicture('${e.id}','${EstateDto.id}')">删除</a>
                            <button type="button" class="btn btn-default glyphicon glyphicon-menu-right" onclick="moveRealEststePicture('${EstateDto.id}','${e.id}','1')"></button>
                        </div>
                    </c:if>
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
<script type="text/javascript" src="assets/estate/photos/js/photos.js"></script>
</body>
</html>
