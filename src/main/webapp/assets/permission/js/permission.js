(function ($) {
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
                    $("#resultMsg").append(result.msg);
                    $('#Result').modal('show');

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
                        confirmVal=true;
                    }
                    else {
                        $("#resultMsg").append(result.msg);
                        $('#Result').modal('show');
                        confirmVal=false;
                    }
                }

            });

        }
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

        $.ajax({
            async: false,
            data: "ID=" + ID,
            url:"permission/updatePermissionName",
            type:"POST",
            success: function (result) {
                if (result.success) {
                    $("#resultMsg").append(result.msg);
                    $('#Result').modal('show');

                }
                else {
                    $("#resultMsg").append(result.msg);
                    $('#Result').modal('show');

                }
            }

        });



    }



    function addHoverDom(treeId, treeNode) {//用于当鼠标移动到节点上时，显示用户自定义控件
        var sObj = $("#" + treeNode.tId + "_span");
        if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
        var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
            + "' title='添加权限' onfocus='this.blur();'></span>";
        sObj.after(addStr);

        var btn = $("#addBtn_"+treeNode.tId);

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
                        if(item!=""){
                            treeNodes=zTree.addNodes(treeNode,{id:(item),pId:treeNode.id,name:"请输入名称"});
                        }
                        if(treeNodes){
                            zTree.editName(treeNodes[0]);
                        }

                    }
                    else {
                        $("#resultMsg").append(result.msg);
                        $('#Result').modal('show');

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


})(jQuery);