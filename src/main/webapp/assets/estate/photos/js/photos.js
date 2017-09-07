$(document).ready(function () {
    function contirmd(id) {
        var msg = "您确定要删除吗？"
        if (confirm(msg) == true) {
            return true;
        } else {
            return false;
        }
    }

    $(".inp_photos").change(function (){
        alert("input改变了");
        // var id=$(this).prev().val();
        var type=1;
        $(this).parent().submit();
    });
});

