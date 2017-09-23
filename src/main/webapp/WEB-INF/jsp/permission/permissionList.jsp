<%--
  Created by IntelliJ IDEA.
  User: ZYZ
  Date: 2017/8/14
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/assets/permission/zTree/css/zTreeStyle/zTreeStyle.css" />
    <script type="text/javascript" src="/assets/permission/zTree/js/jquery.ztree.core.js"></script>
    <script type="text/javascript" src="/assets/permission/zTree/js/jquery.ztree.excheck.js"></script>
    <script type="text/javascript" src="/assets/permission/zTree/js/jquery.ztree.exedit.js"></script>
    <script type="text/javascript" src="/assets/permission/js/permission.js"></script>




</head>




<body>
<input class="ab" type ="hidden" id="test">

<div class="container-fluid">
    <div class="row clearfix">
        <div class="col-md-5 column">
            <div class="panel panel-primary" id="tree">
                <div class="panel-heading">
                    <h3 class="panel-title">
                       菜单树
                    </h3>
                </div>
                <div class="panel-body">
                    <div>
                        <ul id="treeDemo" class="zTree"></ul>
                    </div>
                </div>

            </div>
        </div>


    <div class="row clearfix">
        <div class="col-md-offset-5 column">
            <div class="panel panel-primary" id="Msg">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        详情
                    </h3>
                </div>
                <div class="panel-body" id="">

                            <div class="col-md-8 column">
                                <form class="form-horizontal"  method="post" action="/permission/updatePermission">
                                    <div class="form-group" id="permissionMsg">
                                    </div>



                                </form>
                            </div>
                            <div class="col-md-4 column"method="post">
                            </div>

                </div>

            </div>
        </div>

    </div>

    </div>
</div>

<%--结果提示模态框
--%>
<div id="Result" class="modal fade" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="form-wrap">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button class="close" data-dismiss="modal">
                        <span>&times;</span>
                    </button>
                </div>



                <div class="modal-body">
                    <h1>${result.msg}</h1>

                </div>
                <div class="modal-footer">

                    <button class="btn btn-primary" data-dismiss="modal">取消</button>
                </div>


            </div>
        </div>
    </div>
</div>

<%--结果提示模态框结束--%>






</body>

</html>
