<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2017/8/10
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>测试</title>
    <link rel="stylesheet" href="assets/uplodephoto/css/jquery.Jcrop.css">
    <script src="assets/uplodephoto/js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="assets/uplodephoto/js/jquery.Jcrop.js"></script>
    <script type="text/javascript" src="assets/uplodephoto/js/imgCropUpload.js"></script>
    <style type="text/css">
        body {
            font-size: 16px;
            font-family:"Microsoft YaHei",Arial, Helvetica, sans-serif;
            height: auto;
        }
        *,
        *:before,
        *:after {
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            -ms-box-sizing: border-box;
            box-sizing: border-box;
        }

        .crop-picker-wrap {
            position: relative;
            width: 100px;
            height: 30px;
            overflow: hidden;
        }
        .crop-picker {
            width: 100%;
            height: 100%;
            line-height: 1;

            -webkit-appearance: none;
            margin: 0;
            border: none;
            border-radius: 5px;
            padding: 9px 0;
            background-color: #1ab2ff;

            color: #fff;
            cursor: pointer;
        }
        .crop-picker-file {
            position: absolute;
            top: 0;
            right: 0;
            height: 100%;
            opacity: 0;
            cursor: pointer;
            filter: alpha(opacity=0);
        }

        .crop-wrapper {
            display: inline-block;
            min-width: 750px;
            margin: 10px 0;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 0 5px 2px #ccc;
        }

        .crop-container {
            font-size: 0;
        }

        .crop-container img[src=""] {
            visibility: hidden;
        }

        .crop-area-wrapper,
        .crop-preview-wrapper {
            display: inline-block;
            vertical-align: top;
        }
        .crop-area-wrapper {
            width: 500px;
            height: 400px;
        }
        .crop-preview-wrapper {
            width: 200px;
            height: 200px;
            margin-left: 28px;
            overflow: hidden;
        }
        .crop-preview-container {
            position: relative;
            overflow: hidden;
        }
        .crop-operate {
            text-align: center;
            margin: 10px 0;
        }
        .crop-save,
        .crop-cancel {
            display: inline-block;
            vertical-align: middle;

            width: 150px;
            height: 50px;
            line-height: 50px;

            -webkit-appearance: none;
            margin: 0 5px;
            border: none;
            border-radius: 5px;
            background-color: #1ab2ff;

            color: #fff;
            cursor: pointer;
        }
        .crop-hidden {
            display: none;
        }
    </style>
</head>
<body>
<%--<input type="file" value="123">--%>
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
    <div class="btn-group center-block" role="group" aria-label="...">
        <button type="submit" class="btn btn-default center-block">确定修改</button>
    </div>
</form>

<div id="TCrop"></div>
<script type="text/javascript">
    $(function() {
        Crop.init({
            id: 'TCrop',
            /* 上传路径 */
            url: '/demo/resolveJsonObject',
            /* 允许上传的图片的后缀 */
            allowsuf: ['jpg', 'jpeg', 'png', 'gif'],
            /* JCrop参数设置 */
            cropParam: {
                minSize: [300, 300],          // 选框最小尺寸
                maxSize: [300, 300],        // 选框最大尺寸
                allowSelect: true,          // 允许新选框
                allowMove: true,            // 允许选框移动
                allowResize: true,          // 允许选框缩放
                dragEdges: true,            // 允许拖动边框
                onChange: function(c) {},   // 选框改变时的事件，参数c={x, y, x1, y1, w, h}
                onSelect: function(c) {}    // 选框选定时的事件，参数c={x, y, x1, y1, w, h}
            },
            /* 是否进行裁剪，不裁剪则按原图上传，默认进行裁剪 */
            isCrop: true,
            /* 图片上传完成之后的回调，无论是否成功上传 */
            onComplete: function(data) {
                console.log('upload complete!');
            }
        });
    });
</script>
</body>
</html>
