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
    <script type="text/javascript" src="assets/uplodephoto/js/imgCropUpload.js"></script>
    <link rel="stylesheet" href="assets/estate/update/update.css">
    <script type="text/javascript" src="assets/estate/update/update.js"></script>
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
            width: 800px;
            height: 300px;
        }
    </style>
</head>
<body>
<h4>轮播图（${count}）</h4>
<div>
    <div class="btn-group center-block" role="group" aria-label="...">
        <!-- Button trigger modal -->
        <button type="button" class="btn btn-primary center-block" data-toggle="modal" data-target="#myModal">
            添加轮播图
        </button>
        <a class="btn btn-default center-block" href="" role="button" >返回</a>
    </div>

    <table class="table">
        <thead>
            <th>图片</th>
            <th>操作</th>
        </thead>
        <tbody>
            <c:forEach var="photo" items="${list}">
                <tr>
                    <td>
                        <img src="${photo.name}" class="photo300"><br/>
                        图片链接：${photo.url}
                    </td>
                    <td style="vertical-align: middle">
                        <div class="btn-group center-block" role="group" aria-label="...">
                            <a class="btn btn-default center-block" href="/carouselPhotos/deletephoto?id=${photo.id}" role="button" onclick="return contirmd()">删除</a>
                        </div>
                    </td>
                </tr>
                <br/>
            </c:forEach>
        </tbody>
    </table>
</div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">添加轮播图</h4>
            </div>
            <div class="modal-body">
                输入图片链接：<input type="text" name="url" style="width: 100%">
                <div id="TCrop"></div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default crop-cancel" data-dismiss="modal">关闭</button>
                <button type="submit" class="btn btn-primary crop-save"onclick="">保存</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
