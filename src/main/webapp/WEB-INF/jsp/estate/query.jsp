<html>
<head>
    <title>楼盘列表</title>
    <script src="/assets/Paginator/jqPaginator.min.js" type="text/javascript"></script>
    <script src="/assets/Paginator/pageController.js" type="text/javascript"></script>
    <script src="/assets/jsp/HomePage/homeIndex.js" type="text/javascript"></script>
    <script type="text/javascript">
        function loadData(num) {
            $("#PageCount").val("${pageInfo.total}");
        }

        function contirmd() {
            var msg = "您确定要删除吗？"
            if (confirm(msg) == true) {
                return ture;
            } else {
                return false;
            }
        }
    </script>
</head>
<body>
<div class="container-fiuled">
    <div class="row">
        <div class="col-md-4">
            <div class="input-group">
                <input id="input_search_keyword" type="text" class="form-control input-lg" value="${search_keyword}"><span id="submit_search" class="input-group-addon btn btn-primary">搜索</span>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12 ">
            <table class="table table-hover table table-striped">
                <thead>
                <tr>
                    <%--<th>ID</th>--%>
                    <th>楼盘名</th>
                    <th>楼盘地址</th>
                    <th>位置</th>
                    <th>类型</th>
                    <th>户型</th>
                    <th>最低价</th>
                    <th>最高价</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${estateList}" var="estate">
                    <tr>
                        <th>${estate.estateName}</th>
                        <th>${estate.estateAddress}</th>
                        <th>${estate.location}</th>
                        <th>${estate.type}</th>
                        <th>${estate.houseType}</th>
                        <th>${estate.minPrice}</th>
                        <th>${estate.maxPrice}</th>
                        <th>
                            <div class="btn-group center-block" role="group" aria-label="...">
                                <a class="btn btn-default center-block" href="/estate/selectbyid?id=${estate.id}" role="button">查看</a>
                                <a class="btn btn-default center-block" href="" role="button" onclick="return contirmd()">删除</a>
                            </div>
                        </th>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <form id="formHomeList" method="post">
        <input type="hidden" name="_method" value="GET">
        <%--<input id="formHomeList_currentPage" type="hidden" name="currentPage">--%>
    </form>
        <div class="Paginator">

            <ul class="pagination" id="pagination">
            </ul>
            <input type="hidden" id="PageCount" runat="server" />
            <input type="hidden" id="PageSize" runat="server" value="${pageInfo.pageSize}" />
            <input type="hidden" id="countindex" runat="server" value="${pageInfo.countindex}"/>
            <!--设置最多显示的页码数 可以手动设置 默认为7-->
            <input type="hidden" id="visiblePages" runat="server" value="${pageInfo.visiblePages}" />
            <input type="hidden" id="currentPage" runat="server" value="${pageInfo.currentPage}" />
        </div>

</div>
</body>
</html>
