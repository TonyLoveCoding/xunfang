(function ($) {
    var ID;

    $(document).on('click', '.deleteRoleBtn', function () {
        ID = $(this).attr("id");
        $("#deleteRole").empty();
        var deleteRoleString='<h1 class=\"text-center\"> 确认删除？</h1>';
        $("#deleteRole").append(deleteRoleString);

        var deleteRoleString='<input type="hidden" name="roleId" value="'+ID+'">';
        $("#deleteRole").append(deleteRoleString);

    });


    var setting = {
        check: {
            enable: true
        },
        data: {
            simpleData: {
                enable: true
            }
        }
    };
    var zNodes ;

    $(document).on('click', '.updateRolePermissionBtn', function () {
        ID = $(this).attr("id");
        $.ajax({
            url: "role/getTree",
            data: "ID=" + ID,
            type: "POST",
            success: function (result) {
                if (result.success) {
                    zNodes=result.map.ztreeMsg;

                    $.fn.zTree.init($("#updateTree"),setting,zNodes);


                }
                else {
                    $("#updateTree").empty();
                    var permissionString=result.msg;
                    alert(permissionString);
                    $("#updateTree").append(permissionString);
                }
            }
        });
    });
    $(document).on('click', '#treeSubmit', function () {
        var zTree= $.fn.zTree.getZTreeObj("updateTree");
        var nodes=zTree.getCheckedNodes(true);
        var checkedTree=new Array();
        checkedTree.push(ID);
        for(var i=0;i<nodes.length;i++){
            checkedTree.push(nodes[i].id);
        }
        $.ajax({

            url: "role/updateTreeById",
            data: "checkedTree="+checkedTree,
            type: "POST",
            success: function (result) {
                if(result.success){

                    alert(result.msg);
                }else{


                }

            }
        });

    });


    var setting2 = {
        check: {
            enable: false
        },
        data: {
            simpleData: {
                enable: true
            }
        }
    };
    var zNodes ;

    $(document).on('click', '.getRolePermissionBtn', function () {
        ID = $(this).attr("id");

        $.ajax({
            url: "role/getRoleTree",
            data: "ID=" + ID,
            type: "POST",
            success: function (result) {
                if (result.success) {
                    zNodes=result.map.ztreeMsg;

                    $.fn.zTree.init($("#getTree"),setting2,zNodes);


                }
                else {
                    $("#getTree").empty();
                    var permissionString=result.msg;
                    $("#getTree").append(permissionString);
                }
            }
        });
    });
    $(document).on('click','.updateRoleBtn',function(){
        ID = $(this).attr("id");
        $("#updateRole").empty();
        $.ajax({
            url: "role/findRoleOne",
            data: "ID=" + ID,
            type: "GET",
            success: function (result) {
                if (result.success) {
                    var role = result.map.role;
                    var updateRoleString;
                    updateRoleString='<input type="hidden" name="roleId" value="'+role.id+'"><br>';
                    $("#updateRole").append(updateRoleString);
                    updateRoleString=' <label>角色名：</label>';
                    $("#updateRole").append(updateRoleString);
                    updateRoleString='<input class="form-control" type="text" name="name" value="'+role.roleName+'"><br>';
                    $("#updateRole").append(updateRoleString);
                    updateRoleString=' <label>角色描述：</label>';
                    $("#updateRole").append(updateRoleString);
                    updateRoleString='<textarea class="form-control" rows="3" name="description" >'+role.description+'</textarea>';
                    $("#updateRole").append(updateRoleString);
                }
                else {
                    var estateString=result.msg;
                    $("#findEstates").append(estateString);
                }
            }
        });
    });

    $(function() {
        var x = $('#form1').bootstrapValidator({
            message: 'This value is not valid',
            fields: {

                name: {
                    validators: {
                        notEmpty: {
                            message: '角色名不能为空'
                        },
                        remote: {
                            url: 'role/roleCheck',
                            message: '角色已存在',
                            delay: 5000,
                            type: 'POST',
                            dataType: 'json'
                        }
                    }
                },
                description: {
                    validators: {
                        notEmpty: {
                            message: '描述不能为空'
                        }
                    }
                }


            }
        });
    });

})(jQuery);