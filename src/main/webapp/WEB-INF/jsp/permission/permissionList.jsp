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
    <link rel="stylesheet" href="assets/permission/zTree/css/zTreeStyle/zTreeStyle.css" />
    <script type="text/javascript" src="assets/permission/zTree/js/jquery.ztree.core.js"></script>
    <script type="text/javascript" src="assets/permission/zTree/js/jquery.ztree.excheck.js"></script>
    <script type="text/javascript" src="assets/permission/zTree/js/jquery.ztree.exedit.js"></script>
    <%--<script type="text/javascript" src="assets/permission/zTree/js/jquery-1.4.4.min.js"></script>--%>



</head>
<SCRIPT type="text/javascript">
    var dragId;var zTree_Menu;
    var setting = {
        view: {
            addHoverDom: addHoverDom,
            removeHoverDom: removeHoverDom,
            selectedMulti: false,
            showLine: true,
            selectedMulti: false,
            showIcon: true
        },
        edit: {
            enable: true,
            showRemoveBtn: setRemoveBtn,
            removeTitle:"删除权限",
            renameTitle:"编辑权限",
            drag: {
                prev: true,
                next: true,
                inner: false
            },
            editNameSelectAll: true
        },
        data: {
            simpleData: {
                enable: true
            }
        },
        callback: {
            beforeDrag: beforeDrag,
//            beforeClick: beforeClick,
            beforeEditName: beforeEditName,
            beforeRemove: beforeRemove,
            beforeRename: beforeRename,
            onRemove: onRemove,
            onRename: onRename,
            beforeDrop: beforeDrop,
            onClick:zTreeOnClick
        }
    };
    //采用简单数据模式 (Array)
    var zNodes ;

    function zTreeOnClick(event,treeId,treeNode) {
        var ID=treeNode.id;
        $.ajax({
            data:"ID="+ID,
            type:"post",
            url:"permission/getPermissionMsg",
            success:function (result) {
                if(result.success){
                    $("#permissionMsg").empty();
                    var item=result.map.item;


                   var permisiionString='<input class="form-control" type="hidden" name="permissionId" value="'+item.id+'">';
                   $("#permissionMsg").append(permisiionString);
                   permisiionString='<label>权限名:</label>';
                    $("#permissionMsg").append(permisiionString);
                   permisiionString= '<input class="form-control" type="text" name="name" value="'+item.name+'"><br>';
                    $("#permissionMsg").append(permisiionString);
                    permisiionString=' <label>权限描述：</label>';
                    $("#permissionMsg").append(permisiionString);
                    permisiionString='<textarea class="form-control" rows="3" name="description" >'+item.description+'</textarea>';
                    $("#permissionMsg").append(permisiionString);
                    permisiionString='<label>是否是菜单:</label>';
                    $("#permissionMsg").append(permisiionString);
                    if(item.isMenu==1){
                        permisiionString='<label>是</label><br>';
                        $("#permissionMsg").append(permisiionString);
                    }else{
                        permisiionString='<label>否</label><br>';
                        $("#permissionMsg").append(permisiionString);
                    }
                    permisiionString='<label>url:<label>';
                    $("#permissionMsg").append(permisiionString);
                    permisiionString= '<input class="form-control" type="text" name="url" value="'+item.url+'"><br>';
                    $("#permissionMsg").append(permisiionString);
                    permisiionString='<label>创建时间:<label>';
                    $("#permissionMsg").append(permisiionString);
                    permisiionString= '<label>'+item.createtime+'</label><br>';
                    $("#permissionMsg").append(permisiionString);

                    permisiionString='<label>最后更新时间:<label>';
                    $("#permissionMsg").append(permisiionString);
                    permisiionString= '<label>'+item.updatetime+'</label><br>';
                    $("#permissionMsg").append(permisiionString);
                    permisiionString='<button type="submit" class="btn btn-primary" >确认修改</button>';
                    $("#permissionMsg").append(permisiionString);
                    permisiionString='<button class="btn btn-primary">关闭</button>';
                    $("#permissionMsg").append(permisiionString);
                }
                else{

                }

            }
        });



    }


    function beforeDrag(treeId, treeNodes) {//用于捕获节点被拖拽之前的事件回调函数
        return false;
    }
    function beforeEditName(treeId, treeNode) {//用于捕获节点编辑按钮的 click 事件，并且根据返回值确定是否允许进入名称编辑状态
        var zTree = $.fn.zTree.getZTreeObj("treeDemo");
        zTree.selectNode(treeNode);
        return true;
    }
    function beforeRemove(treeId, treeNode) { //用于捕获节点被删除之前的事件回调函数，并且根据返回值确定是否允许删除操作
        var zTree = $.fn.zTree.getZTreeObj("treeDemo");
        zTree.selectNode(treeNode);
        var confirmFlag= confirm("确认删除权限 [" + treeNode.name + "] 吗？");
        var confirmVal=false;
        if(confirmFlag){
            var ID = treeNode.id;
            $.ajax({
                async: false,
                data: "ID=" + ID,
                url:"permission/deletePermission",
                type:"POST",
                success:function (result) {
                    if (result.success) {
                        alert("a");
                        confirmVal=true;
                        alert(confirmVal);
                    }
                    else {
                        alert("b");

                        confirmVal=false;
                    }
                }

            });

        }
        alert(confirmVal+"ces");
        return confirmVal;

    }
    function onRemove(e, treeId, treeNode) {//用于捕获删除节点之后的事件回调函数
    }

    function beforeRename(treeId, treeNode, newName) {//更新节点名称数据之前的事件回调函数，并且根据返回值确定是否允许更改名称的操作
        if (newName.length == 0) {
              alert("请输入名称.");
            var zTree = $.fn.zTree.getZTreeObj("treeDemo");
            setTimeout(function(){zTree.editName(treeNode)}, 10);
            return false;
        }

        native_name = treeNode.name;
        return true;
    }
    function onRename(e, treeId, treeNode) {//用于捕获节点编辑名称结束之后的事件回调函数
        if(native_name==treeNode.name) return;
//        var data={id:treeNode.id,pid:treeNode.pId,name:treeNode.name};
        var ID = new Array();
        ID.push(treeNode.id);
        ID.push(treeNode.pId);
        ID.push(treeNode.name);
        alert(treeNode.id);

        $.ajax({
            async: false,
            data: "ID=" + ID,
            url:"permission/updatePermissionName",
            type:"POST",
            success: function (result) {
                if (result.success) {
                    $('#Result').modal('show');

                }
                else {

                }
            }

        });



    }

    var newCount = 1;


    function addHoverDom(treeId, treeNode) {//用于当鼠标移动到节点上时，显示用户自定义控件
        <shiro:hasPermission name="permission/addPermission">
        var sObj = $("#" + treeNode.tId + "_span");
        if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
        var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
            + "' title='添加权限' onfocus='this.blur();'></span>";
        sObj.after(addStr);

        var btn = $("#addBtn_"+treeNode.tId);
        </shiro:hasPermission>

        if (btn) btn.bind("click", function(){
            var zTree = $.fn.zTree.getZTreeObj("treeDemo");
            var treeNodes;

            $.ajax({
                async: false,
                type:"post",
                url:"permission/getNewNodeId",
                success: function (result) {
                    if (result.success) {
                                var item=result.map.item;
                        alert("cc"+result.map.item);
                        if(item!=""){
                            treeNodes=zTree.addNodes(treeNode,{id:(item),pId:treeNode.id,name:"请输入名称"});
                        }
                        if(treeNodes){
                            zTree.editName(treeNodes[0]);
                        }

                    }
                    else {

                    }
                }
            });

            return false;
        });
    }

    function setRemoveBtn(treeId, treeNode) {//父分类去掉删除功能
        return !treeNode.isParent;
    }

    function removeHoverDom(treeId, treeNode) {
        $("#addBtn_"+treeNode.tId).unbind().remove();
    }

    function beforeDrag(treeId, treeNodes) {//拖拽时执行
        for (var i=0,l=treeNodes.length; i<l; i++) {
            dragId = treeNodes[i].pId;
            if (treeNodes[i].drag === false) {
                return false;
            }
        }
        return true;
    }
    function addClick(){
        $( "#addParent").bind("click" , {isParent:true}, add);
    }
    function beforeDrop(treeId, treeNodes, targetNode, moveType) {//拖拽释放后执行
        if(targetNode.pId == dragId){
            return true;
        }else{
            return false;
        }
    }

    function selectAll() {
        var zTree = $.fn.zTree.getZTreeObj("treeDemo");
        zTree.setting.edit.editNameSelectAll =  $("#selectAll").attr("checked");
    }

    $(document).ready(function(){

        $.ajax({
            async: false,
            url: "role/getTree",
            type: "POST",
            success: function (result) {
                if (result.success) {
                    zNodes=result.map.ztreeMsg;

                    $.fn.zTree.init($("#treeDemo"), setting, zNodes);//初始化ztree


                }
                else {
                    $("#permissionTree").empty();
                    var permissionString=result.msg;
                    alert(permissionString);
                    $("#permissionTree").append(permissionString);
                }
            }
        });
//        $.fn.zTree.init($("#treeDemo"), setting, zNodes);//初始化ztree
        zTree_Menu = $.fn.zTree.getZTreeObj("treeDemo");
        $("#selectAll").bind("click", selectAll);
    });

</SCRIPT>



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
