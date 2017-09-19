<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2017/8/12
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.*" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String ppath=request.getParameter("ppath");
    System.out.println(ppath);
    FileInputStream in = new FileInputStream(new File(ppath));
    OutputStream o = response.getOutputStream();
    int l = 0;
    byte[] buffer = new byte[4096];
    while((l = in.read(buffer)) != -1){
        o.write(buffer,0,l);
    }
    o.flush();
    in.close();
    o.close();
%>
</body>
</html>
