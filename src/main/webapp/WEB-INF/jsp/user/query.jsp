<html>
<head>
    <title></title>
    <style type="text/css">body{overflow：hidden}</style>
</head>
<body>

    <div class="container-fiuled ">
        <div class="row">
            <div class="col-md-12 ">
                <table id="tbl_user" class="table table-hover table table-striped">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>用户名</th>
                        <th>帐号</th>
                        <th>ID</th>
                        <th>用户名</th>
                        <th>帐号</th>
                        <th>ID</th>
                        <th>用户名</th>
                        <th>帐号</th>
                        <th>ID</th>
                        <th>用户名</th>
                        <th>帐号</th>
                        <th>ID</th>
                        <th>用户名</th>
                        <th>帐号</th>
                        <th>ID</th>
                        <th>用户名</th>
                        <th>帐号</th>
                        <th>ID</th>
                        <th>用户名</th>
                        <th>帐号</th>
                        <th>ID</th>
                        <th>用户名</th>
                        <th>帐号</th>
                        <th>ID</th>
                        <th>用户名</th>
                        <th>帐号</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${userList}" var="user">
                        <tr>
                            <th>${user.id}</th>
                            <th>${user.username}</th>
                            <th>${user.account}</th>
                            <th>${user.id}</th>
                            <th>${user.username}</th>
                            <th>${user.account}</th>
                            <th>${user.id}</th>
                            <th>${user.username}</th>
                            <th>${user.account}</th>
                            <th>${user.id}</th>
                            <th>${user.username}</th>
                            <th>${user.account}</th>
                            <th>${user.id}</th>
                            <th>${user.username}</th>
                            <th>${user.account}</th>
                            <th>${user.id}</th>
                            <th>${user.username}</th>
                            <th>${user.account}</th>
                            <th>${user.id}</th>
                            <th>${user.username}</th>
                            <th>${user.account}</th>
                            <th>${user.id}</th>
                            <th>${user.username}</th>
                            <th>${user.account}</th>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
