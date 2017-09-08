$(document).ready(function () {
    $("#btn_add_heatWord").click(function () {
        var heatWord=$("#inp_add_keyWord").val();
        if(heatWord==null||heatWord=="||"||heatWord.length==0){
            $("#h1_error_tip").text("关键词不能为空！");
            $("#errorModal").modal();
        }else{
            $.ajax({
                url: "/heatWord/addHeatWord",
                data:{"heatWord":heatWord},
                success: function(result){
                    if(result.code==100){
                        initHeatSearchWordList();
                    }else{
                        $("#h1_error_tip").text(result.tip)
                        $("#errorModal").modal();
                    }
                }
            });
        }
    });

    function initHeatSearchWordList() {
        $.ajax({
            url: "/heatWord/getHeatWordList",
            success: function(result){
                if(result.code==100){
                    $("#tbody_heat_word").empty();
                    $.each(result.extend.heatSearchWordList, function (i, item) {
                        var tr = $("<tr><td>" + item.word + "</td><td><button class='btn_delete_heatWord btn btn-danger' name='"+item.id+"' type='button'>删除</button></td></tr>");
                        $("#tbody_heat_word").append(tr);
                    });
                }else{
                    $("#h1_error_tip").text(result.tip)
                    $("#errorModal").modal();
                }
            }
        });

    };
    initHeatSearchWordList();
    $(document).on("click",".btn_delete_heatWord",function(){
        $.ajax({
            url:"/heatWord/deleteHeatWord",
            type:"post",
            data:{"id":this.name},
            success: function(result){
                if(result.code==100){
                    initHeatSearchWordList();
                }else{
                    $("#h1_error_tip").text(result.tip)
                    $("#errorModal").modal();
                }
            }
        });
    });

});