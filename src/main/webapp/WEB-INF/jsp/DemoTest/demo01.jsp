<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2017/8/10
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试</title>
    <script type="text/javascript">
        i = 1;
        j = 1;
        $(document).ready(function(){

            $("#btn_add2").click(function(){
                document.getElementById("newUpload2").innerHTML+='<div id="div_'+j+'"><input  name="file_'+j+'" type="file"  /><input type="text" id="url" name="url_'+j+'"><input type="button" value="删除"  onclick="del_2('+j+')"/></div>';
                j = j + 1;
            });
        });
        function del_2(o){
            document.getElementById("newUpload2").removeChild(document.getElementById("div_"+o));
        }

    </script>
</head>
<body>
<form action="demo/demo01" enctype="multipart/form-data" method="post">
    <input type="hidden" name="pn" value="1">
    <table class="table">
        <tbody>
            <tr style="border: hidden">
                <th>楼盘名称：</th>
                <th><input name="estateName" value="${estate.estateName}"></th>
            </tr>
            <tr style="border: hidden">
                <th>楼盘地址：</th>
                <th><input name="estateAddress" value="${estate.estateAddress}"></th>
            </tr>
            <tr style="border: hidden">
                <th>位置：</th>
                <th><input name="location" value="${estate.location}"></th>
            </tr>
            <tr style="border: hidden">
                <th>类型：</th>
                <th><input name="type" value="${estate.type}"></th>
            </tr>
            <tr style="border: hidden">
                <th>户型：</th>
                <th><input name="houseType" value="${estate.houseType}"></th>
            </tr>
            <tr style="border: hidden">
                <th>价格：</th>
                <th><input name="minPrice" value="${estate.minPrice}"></th>
            </tr>
        </tbody>
    </table>

    <br>
    图片：
    <div id="newUpload2">
        <input type="file" name="file">
    </div>
    <input type="button" id="btn_add2" value="增加一行" >
    <div class="btn-group center-block" role="group" aria-label="...">
        <button type="submit" class="btn btn-default center-block">确定修改</button>
    </div>
</form>
</body>
</html>
