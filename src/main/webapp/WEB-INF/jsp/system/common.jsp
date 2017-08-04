<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    request.setAttribute("basePath", basePath);
%>
<base href="${basePath}">
<!-- Jquery -->
<script src="/assets/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
<!-- Bootstrap -->
<link href="/assets/bookstrap/css/bootstrap.min.css" rel="stylesheet"/>
<script src="/assets/bookstrap/js/bootstrap.min.js" type="text/javascript"></script>