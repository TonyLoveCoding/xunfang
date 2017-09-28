$(document).ready(function () {


    $(".inp_photos").change(function (){
        // var id=$(this).prev().val();
        var type=1;
        var file=$(this).value;
        var filepath=$("input[name='files']").val();
        alert(filepath)
        var extStart=filepath.lastIndexOf(".");
        var ext=filepath.substring(extStart,filepath.length).toUpperCase();
        if(ext!=".BMP"&&ext!=".PNG"&&ext!=".GIF"&&ext!=".JPG"&&ext!=".JPEG"){
            alert("图片限于bmp,png,gif,jpeg,jpg格式");
            return false;
        }
        $(this).parent().submit();
    });
});

function deleteEffectPicture(pid,eid) {
    var msg = "您确定要删除吗？"
    if (confirm(msg) == true) {
        $.ajax({
            type:"post",
            url:"/estate/deleteEffectPicture",
            data:{"id":pid},
            dataType:"json",
            success:function (Msg) {
                alert(Msg.tip);
                location.href="/estate/upload?id="+eid;

            }
        })
    } else {
        return false;
    }
}

function deletePrototypeRoomPicture(pid,eid) {
    var msg = "您确定要删除吗？"
    if (confirm(msg) == true) {
        $.ajax({
            type:"post",
            url:"/estate/deletePrototypeRoomPicture",
            data:{"id":pid},
            dataType:"json",
            success:function (Msg) {
                alert(Msg.tip);
                location.href="/estate/upload?id="+eid;

            }
        })
    } else {
        return false;
    }
}

function deleteRealEststePicture(pid,eid) {
    var msg = "您确定要删除吗？"
    if (confirm(msg) == true) {
        $.ajax({
            type:"post",
            url:"/estate/deleteRealEststePicture",
            data:{"id":pid},
            dataType:"json",
            success:function (Msg) {
                alert(Msg.tip);
                location.href="/estate/upload?id="+eid;

            }
        })
    } else {
        return false;
    }
}

function deleteSamplePlanningPicture(pid,eid) {
    var msg = "您确定要删除吗？"
    if (confirm(msg) == true) {
        $.ajax({
            type:"post",
            url:"/estate/deleteSamplePlanningPicture",
            data:{"id":pid},
            dataType:"json",
            success:function (Msg) {
                alert(Msg.tip);
                location.href="/estate/upload?id="+eid;

            }
        })
    } else {
        return false;
    }
}

function moveEffectPicture(id,direction) {
    $.ajax({
        type:"get",
        url:"/estate/moveEffectPicture",
        data:{"id":id,"direction":direction},
        dataType:"json",
        success:function (Msg) {
            location.reload();
            alert(Msg.msg);
        }
    })
}

function movePrototypeRoomPicture(id,direction) {
    $.ajax({
        type:"get",
        url:"/estate/movePrototypeRoomPicture",
        data:{"id":id,"direction":direction},
        dataType:"json",
        success:function (Msg) {
            location.reload();
            alert(Msg.msg);
        }
    })
}

function moveRealEststePicture(id,direction) {
    $.ajax({
        type:"get",
        url:"/estate/moveRealEststePicture",
        data:{"id":id,"direction":direction},
        dataType:"json",
        success:function (Msg) {
            location.reload();
            alert(Msg.msg);
        }
    })
}

function moveSamplePlanningPicture(id,direction) {
    $.ajax({
        type:"get",
        url:"/estate/moveSamplePlanningPicture",
        data:{"id":id,"direction":direction},
        dataType:"json",
        success:function (Msg) {
            location.reload();
            alert(Msg.msg);
        }
    })
}

