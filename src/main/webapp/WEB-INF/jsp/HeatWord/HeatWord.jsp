<%--
  Created by IntelliJ IDEA.
  User: 63574
  Date: 2017/9/7
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>热搜词管理</title>
    <link href="/assets/HeatWord/HeatWord.css" rel="stylesheet">
    <script src="/assets/HeatWord/HeatWord.js" type="text/javascript"></script>
</head>
<body>
<div class="container-fluid">
    <div class="modal fade" id="errorModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title">操作失败</h4>
                </div>
                <div class="modal-body">
                    <img src="/assets/HeatWord/sign-error-icon.png" alt=""  style="width: 200px;height: 200px;">
                    <h3 id="h1_error_tip"></h3>
                </div>
                <div class="modal-footer">
                    <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div>
    <div class="row">
        <div class=" col-md-12 div_title"><div class="glyphicon glyphicon-edit"><span class="span_title">热搜词管理</span></div></div>
    </div>
    <div class="row_border">
        <div class="row">
            <div class="col-md-6 row_border_top row_border_left_right">
                <div class="bg_fff">
                    <button class="btn btn-primary" id="btn_add_heatWord" type="button">添加热搜词</button>
                    <input type="text" id="inp_add_keyWord">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 row_border_left_right row_border-bottom">
                <div class="bg_fff">
                    <table class="table table-bordered tbl_heat_word">
                        <caption>热搜词列表</caption>
                        <thead>
                            <tr>
                                <th>热搜词</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody id="tbody_heat_word">

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
