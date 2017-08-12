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
    <div>
        <h3>基本信息</h3>
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
        <br>
        <h3>销售信息</h3>
        <table class="table">
            <tbody>
                <tr border="1">
                    <th>开发商报价：${estate.estateName}</th>
                    <th>楼盘户型：${estate.estateName}</th>
                </tr>
                <tr style="border: hidden">
                    <th>销售状态：${estate.estateName}</th>
                    <th>产权年限：${estate.estateName}年</th>
                </tr>
                <tr style="border: hidden">
                    <th>最新开盘：${estate.estateName}</th>
                    <th>拿地时间：${estate.estateName}</th>
                </tr>
                <tr style="border: hidden">
                    <th>最早交房：${estate.estateName}</th>
                </tr>
                <%--<tr style="border: hidden">--%>
                    <%--<th>楼盘户型：${estate.estateName}</th>--%>
                <%--</tr>--%>
                <%--<tr style="border: hidden">--%>
                    <%--<th>产权年限：${estate.estateName}年</th>--%>
                <%--</tr>--%>
                <%--<tr style="border: hidden">--%>
                    <%--<th>拿地时间：${estate.estateName}</th>--%>
                <%--</tr>--%>
            </tbody>
        </table>
        <br>
        <h3>小区详情</h3>
        <table class="table">
            <tbody>
                <tr border="1">
                    <th>物业公司：${estate.estateName}</th>
                    <th>车位情况：${estate.estateName}</th>
                </tr>
                <tr style="border: hidden">
                    <th>物业费用：${estate.estateName}</th>
                    <th>容积率：${estate.estateName}</th>
                </tr>
                <tr style="border: hidden">
                    <th>水电燃气：${estate.estateName}</th>
                    <th>装修情况：${estate.estateName}</th>
                </tr>
                <tr style="border: hidden">
                    <th>绿化率：${estate.estateName}%</th>
                    <th>楼栋信息：${estate.estateName}</th>
                </tr>
                <%--<tr style="border: hidden">--%>
                    <%--<th>车位情况：${estate.estateName}</th>--%>
                <%--</tr>--%>
                <%--<tr style="border: hidden">--%>
                    <%--<th>容积率：${estate.estateName}</th>--%>
                <%--</tr>--%>
                <%--<tr style="border: hidden">--%>
                    <%--<th>装修情况：${estate.estateName}</th>--%>
                <%--</tr>--%>
                <%--<tr style="border: hidden">--%>
                    <%--<th>楼栋信息：${estate.estateName}</th>--%>
                <%--</tr>--%>
            </tbody>
        </table>
        <hr>
        <h3>楼盘图片</h3>
        <table class="table">
            <thead>效果图（加数量）</thead>
            <tbody>
                <c:forEach var="e" items="${estate.effectPictureDtoList}">

                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
