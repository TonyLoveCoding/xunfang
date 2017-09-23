(function ($) {

    var ID;
    $(document).ready(function(){
        $("#Mymodal").click(function(){
            $("#new").modal("show")
        })
    });

    $(document).on('click', '.roleBtn', function () {
        ID = $(this).attr("id");
        $("#updateRole").empty();
//           alert(ID);
        $.ajax({
            url: "user/getRoleJson",
            data: "ID=" + ID,
            type: "GET",
            success: function (result) {
                if (result.success) {
                    var roleList = result.map.roleJsonList;
                    $("#updateRole").empty();
                    var checkboxString='<input type="hidden" name="userId" value="'+ID+'">';
                    $("#updateRole").append(checkboxString);
                    var checkboxString = '<input type="hidden" name="type" value="-1"  ><br>';
                    $("#updateRole").append(checkboxString);

                    $.each(roleList, function (index, item) {
                        if(item.isExist){
                            var checkboxString = '<input type="checkbox" name="type" value="' + item.role.id + '"  checked><span>' + item.role.roleName + '</span><br>';

                        }
                        else {
                            var checkboxString = '<input type="checkbox" name="type" value="' + item.role.id + '" ><span>' + item.role.roleName + '</span><br>';
                        }
                        $("#updateRole").append(checkboxString);
//
                    });
                }
                else {
                }
            }
        });
    });

    $(document).on('click', '.findUserRoleBtn', function () {
        ID = $(this).attr("id");
        $("#findUserRole").empty();
        $.ajax({
            url: "user/getUserRoleJson",
            data: "ID=" + ID,
            type: "GET",
            success: function (result) {
                if (result.success) {
                    var roleList = result.map.roleJsonList;
                    $("#findUserRole").empty();

                    $.each(roleList, function (index, item) {
                        var roleString= '<span>' + item.role.roleName + '</span><br>';
                        $("#findUserRole").append(roleString);
                    });
                }


                else {
                    var roleString=result.msg;
                    $("#findUserRole").append(roleString);

                }
            }
        });
    });

    $(document).on('click', '.estateBtn', function () {
        ID = $(this).attr("id");
        $("#findEstates").empty();

        $.ajax({
            url: "user/findEstatesList",
            data: "ID=" + ID,
            type: "GET",
            success: function (result) {
                if (result.success) {
                    var estateList = result.map.estateJsonList;
                    $("#findEstates").empty();
                    $.each(estateList, function (index, item) {
                        var estateString= '<span>' + item.estate.estateName + '</span><br>';
                        $("#findEstates").append(estateString);
                    });
                }
                else {
                    var estateString=result.msg;
                    $("#findEstates").append(estateString);
                }
            }
        });
    });
    $(document).on('click','.updateUserBtn',function(){
        ID = $(this).attr("id");
//            alert("updateUser");
        $("#updateUserMsg").empty();
        $.ajax({
            url: "user/findUserOne",
            data: "ID=" + ID,
            type: "GET",
            success: function (result) {
                if (result.success) {

                    var user = result.map.user;
                    var updateUserString='<h3>账号：'+user.account+'</h3>';
                    $("#updateUserMsg").append(updateUserString);
                    updateUserString='<input type="hidden" name="userId" value="'+user.id+'"><br>';
                    $("#updateUserMsg").append(updateUserString);
                    updateUserString=' <label>昵称：</label>';
                    $("#updateUserMsg").append(updateUserString);
                    updateUserString='<input class="form-control" type="text" name="name" value="'+user.username+'"><br>';
                    $("#updateUserMsg").append(updateUserString);
                    updateUserString=' <label>密码：</label>';
                    $("#updateUserMsg").append(updateUserString);
                    updateUserString='<input class="form-control" type="password" name="password" placeholder="至少6位数字或字母" ><br>';
                    $("#updateUserMsg").append(updateUserString);
                    updateUserString='<label>验证密码：</label>';
                    $("#updateUserMsg").append(updateUserString);
                    updateUserString='<input class="form-control" type="password" name="checkPwd" autofocus="autofocus" placeholder="至少6位字母或数字" ><br>';
                    $("#updateUserMsg").append(updateUserString);
                }
                else {
                    var estateString=result.msg;
                    $("#findEstates").append(estateString);
                }
            }
        });
    });

    $(document).on('click', '.deteleUserBtn', function () {
        ID = $(this).attr("id");
        $("#deleteUser").empty();
        var deteleUserString='<h1 class=\"text-center\"> 确认删除？</h1>';
        $("#deleteUser").append(deteleUserString);
        var deteleUserString='<input type="hidden" name="userId" value="'+ID+'">';
        $("#deleteUser").append(deteleUserString);

    });
    $(function() {
        var x = $('#form2').bootstrapValidator({
            message: 'This value is not valid',
            fields: {
                account: {
                    validators: {
                        notEmpty: {
                            message: '账号不能为空'
                        },
                        remote: {
                            url: 'user/accountCheck',
                            message: '用户已存在',
                            delay: 5000,
                            type: 'POST',
                            dataType: 'json'
                        }

                    }
                },
                name: {
                    validators: {
                        notEmpty: {
                            message: '用户名不能为空'
                        }
                    }
                },
                password: {
                    validators: {
                        notEmpty: {
                            message: '密码不能为空'
                        }

                    }
                },
                checkPwd: {
                    validators: {
                        notEmpty: {
                            message: '密码不能为空'
                        },
                        identical: {
                            field: 'password',
                            message: '前后密码不一致'
                        }
                    }

                }

            }
        });
        var y = $('#form55').bootstrapValidator({
            message: 'This value is not valid',
            fields: {
                name: {
                    validators: {
                        notEmpty: {
                            message: '用户名不能为空'
                        }
                    }
                },
                password: {
                    validators: {
                        notEmpty: {
                            message: '密码不能为空'
                        }
                    }
                },
                checkPwd: {
                    validators: {
                        notEmpty: {
                            message: '密码不能为空'
                        },
                        identical: {
                            field: 'password',
                            message: '前后密码不一致'
                        }
                    }
                }

            }
        });
    });
})(jQuery);
