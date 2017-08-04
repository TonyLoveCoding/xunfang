<html>
<head>
    <title>Title</title>
</head>
<body>
<table class="table table-bordered">
    <caption>边框表格布局</caption>
    <thead>
    <tr>
        <th>ID</th>
        <th>帐号</th>
        <th>密码</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.account}</td>
            <td>${user.password}</td>
        </tr>
    </c:forEach>

    </tbody>
</table>

</body>
</html>
