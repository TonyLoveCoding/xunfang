<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>楼盘列表</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="assets/estate/search/zxf_page.css"/>
    <script src="assets/estate/search/zxf_page.js" type="text/javascript"></script>
    <script src="/assets/jsp/HomePage/homeIndex.js" type="text/javascript"></script>
    <script type="text/javascript">
        function loadData(num) {
            $("#PageCount").val("${pageMsg.total}");
        }

        function ask() {
            var msg="您确定要更新吗？"
            if(confirm(msg)==true){
                $.ajax({
                    type:"GET",
                    url:"http://localhost:8081/solr/solr_test/dataimport?&command=full-import&clean=true&commit=true",
                    success:function (Msg) {
                        alert("更新成功");
                    }
                })

            }else{
                alert("取消");
                return false;
            }
        };

        function contirmd(id) {
            var msg = "您确定要删除吗？"
            if (confirm(msg) == true) {
                $.ajax({
                    type:"GET",
                    url:"/estate/delete?id="+id,
                    dataType:"json",
                    error:function () {
                    },
                    success:function (Msg) {
                        if(Msg.code==100){
                            location.href="/estate/query";
                            alert("删除成功");
                        }
                        if(Msg.code==200){
                            alert(Msg.tip);
                        }
                    }
                })
            } else {
                return false;
            }
        };

    </script>
</head>
<body>
<form action="/estate/query" method="GET" id="form_search">
    <input id="inp_hid_pn" type="hidden" name="pn" value="${current}">
    <input id="inp_hid_keyword" type="hidden" name="keyword" value="${keyword}">
</form>
<div class="container-fiuled">
    <div class="row">
        <div class="col-md-4">
            <div class="input-group">
                <input id="input_search_keyword" type="text" name="keyword" class="form-control input-md" value="${keyword}"><span id="submit_search" class="input-group-addon btn btn-primary">搜索</span>
            </div>
        </div>
        <div class="col-md-3 col-md-offset-1">
            <div class="btn-group center-block" role="group" aria-label="...">
                <shiro:hasPermission name="estate/add">
                    <a class="btn btn-default center-block glyphicon glyphicon-plus" href="/estate/add" role="button">添加楼盘</a>
                </shiro:hasPermission>
                <a class="btn btn-default center-block glyphicon glyphicon-pencil" href="javascript:void(0);" role="button" onclick="ask()">更新索引库</a>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12 ">
            <table class="table table-hover table table-striped">
                <thead>
                <tr>
                    <%--<th>ID</th>--%>
                    <th style="text-align: center">楼盘名</th>
                    <th style="text-align: center">楼盘地址</th>
                    <th style="text-align: center">位置</th>
                    <th style="text-align: center">类型</th>
                    <th style="text-align: center">户型</th>
                    <th style="text-align: center">最低价</th>
                    <th style="text-align: center">最高价</th>
                    <th style="text-align: center">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${estateDtos}" var="estateDto">
                    <tr>
                        <td>${estateDto.estateName}</td>
                        <td>${estateDto.estateAddress}</td>
                        <td>${estateDto.location}</td>
                        <td>${estateDto.type}</td>
                        <td>${estateDto.houseType}</td>
                        <td>${estateDto.minPrice}</td>
                        <td>${estateDto.maxPrice}</td>
                        <td>
                            <div class="btn-group center-block" role="group" aria-label="..." style="display: block;margin-left: auto;margin-right: auto">
                                <a class="btn btn-default center-block glyphicon glyphicon-list-alt" href="/estate/selectbyid?id=${estateDto.id}" role="button">查看</a>
                                <a class="btn btn-default center-block glyphicon glyphicon-erase" href="/estate/update?id=${estateDto.id}" role="button">修改</a>
                                <a class="btn btn-default center-block glyphicon glyphicon-picture" href="/estate/upload?id=${estateDto.id}" role="button">楼盘图片</a>
                                <shiro:hasPermission name="estate/delete">
                                    <a class="btn btn-warning center-block glyphicon glyphicon-trash" href="javascript:void(0);" role="button" onclick="contirmd('${estateDto.id}')">删除</a>
                                </shiro:hasPermission>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <%--分页--%>
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div class="zxf_pagediv"></div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        $(".zxf_pagediv").createPage({
            pageNum: ${pageNum},//总页码
            current: ${current},//当前页
            shownum: ${shownum},//每页显示个数
            backfun: function (e) {
                $("#inp_hid_pn").attr("value", e.current);
                var keyword=$("#input_search_keyword").val();
                $("#inp_hid_keyword").attr("value", keyword);
                $("#form_search").submit();
            }
        });

        $("#submit_search").click(function () {
            var keyword=$("#input_search_keyword").val();
            $("#inp_hid_keyword").attr("value", keyword);
            $("#form_search").submit();
        });
    });
</script>
</html>
