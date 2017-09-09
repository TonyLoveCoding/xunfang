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
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <h3>基本信息</h3>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <table class="table">
                <tbody>
                <tr border="1">
                    <th>楼盘名称：${estate.estateName}</th>
                </tr>
                <tr style="border: hidden">
                    <th>楼盘地址：${estate.estateName}</th>
                </tr>
                <tr style="border: hidden">
                    <th>物业类型：${estate.estateName}</th>
                </tr>
                <tr style="border: hidden">
                    <th>建筑类型：${estate.estateName}</th>
                </tr>
                <tr style="border: hidden">
                    <th>环线：${estate.estateName}</th>
                </tr>
                <tr style="border: hidden">
                    <th>开发商：${estate.estateName}</th>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <br>
    <div class="row">
        <div class="col-md-12">
            <h3>销售信息</h3>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <table class="table">
                <tbody>
                <tr border="1">
                    <th>开发商报价：${estate.estateName}</th>
                </tr>
                <tr style="border: hidden">
                    <th>销售状态：${estate.estateName}</th>
                </tr>
                <tr style="border: hidden">
                    <th>最新开盘：${estate.estateName}</th>
                </tr>
                <tr style="border: hidden">
                    <th>最早交房：${estate.estateName}</th>
                </tr>
                <tr style="border: hidden">
                    <th>楼盘户型：${estate.estateName}</th>
                </tr>
                <tr style="border: hidden">
                    <th>产权年限：${estate.estateName}</th>
                </tr>
                <tr style="border: hidden">
                    <th>拿地时间：${estate.estateName}</th>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <br>
    <div class="row">
        <div class="col-md-12">
            <h3>小区详情</h3>
            <table class="table">
                <tbody>
                <tr border="1">
                    <th>开发商报价：${estate.estateName}</th>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
