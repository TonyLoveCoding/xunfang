$(document).ready(function(){
    init();
    $(".a_heatWord").click(function () {
        var keyWord=this.innerHTML;
        $("#inp_hid_keyword").attr("value", keyWord);
        $("#form_search").submit();
    });
    $("#btn_coll_keyword").click(function () {
        var keyWord=$("#inp_coll_keyword").val();
        $("#inp_hid_keyword").attr("value", keyWord);
        $("#form_search").submit();
    });
    $("#btn_nav_keyword").click(function () {
        var keyWord=$("#inp_nav_keyword").val();
        $("#inp_hid_keyword").attr("value",keyWord);
        $("#form_search").submit();
    });
    $("#inp_nav_keyword").keydown(function (e) {
        if(e.keyCode == "13") {
            var keyWord=$("#inp_nav_keyword").val();
            $("#inp_hid_keyword").attr("value", keyWord);
            $("#form_search").submit();
        }
    });
    $("#inp_coll_keyword").keydown(function (e) {
        if(e.keyCode == "13") {
            var keyWord=$("#inp_coll_keyword").val();
            $("#inp_hid_keyword").attr("value",keyWord);
            $("#form_search").submit();
        }
    });
    $(".rad_sell").click(function () {
        var saleStatus  = $('input[name="saleRadios"]:checked').val(); //获取被选中Radio的Value值
        $("#inp_hid_saleStatus").attr("value",saleStatus);
        $("#form_search").submit();
    });
    $(".a_location").click(function () {
        var location  = $(this).attr("name");
        $("ul.location li a").css({"color":"#337ab7"});
        $(this).css({"color":"#f44336"});
        $("#inp_hid_location").val(location);
        $("#form_search").submit();
    });
    $(".a_total_prices").click(function () {
        var total_prices  = $(this).attr("name");
        $("ul.total_prices li a").css({"color":"#337ab7"});
        $(this).css({"color":"#f44336"});
        $("#inp_hid_totalPrices").val(total_prices);
        $("#form_search").submit();
    });
    $(".a_type").click(function () {
        var type  = $(this).attr("name");
        $("ul.type li a").css({"color":"#337ab7"});
        $(this).css({"color":"#f44336"});
        $("#inp_hid_type").val(type);
        $("#form_search").submit();
    });
    $(".a_houseType").click(function () {
        var houseType  = $(this).attr("name");
        $("ul.houseType li a").css({"color":"#337ab7"});
        $(this).css({"color":"#f44336"});
        $("#inp_hid_houseType").val(houseType);
        $("#form_search").submit();
    });
    $(".a_feature").click(function () {
        var feature  = $(this).attr("name");
        $("ul.feature li a").css({"color":"#337ab7"});
        $(this).css({"color":"#f44336"});
        $("#inp_hid_feature").val(feature);
        $("#form_search").submit();
    });
    $(".a_unit_price").click(function () {
        var unit_price  = $(this).attr("name");
        $("ul.unit_price li a").css({"color":"#337ab7"});
        $(this).css({"color":"#f44336"});
        $("#inp_hid_unitPrice").val(unit_price);
        $("#form_search").submit();
    });
    $(".a_area").click(function () {
        var area  = $(this).attr("name");
        $("ul.area li a").css({"color":"#337ab7"});
        $(this).css({"color":"#f44336"});
        $("#inp_hid_area").val(area);
        $("#form_search").submit();
    });
    $(".a_sort").click(function () {
       initSort( $(this));
    });
    $("#btn_total_prices").click(function () {
        var pre=$("#inp_total_prices_pre").val()-0;
        var beh=$("#inp_total_prices_beh").val()-0;
        var ret = /^[1-9]\d{0,4}$/;
        if(!ret.test(pre)||!ret.test(beh)||pre>beh){
            alert('请正确输入');
        }else{
            $("#inp_hid_totalPrices").val(pre+"_TO_"+beh);
            $("#form_search").submit();
        }
    });
    $("#btn_aera").click(function () {
        var pre=$("#inp_area_pre").val()-0;
        var beh=$("#inp_area_beh").val()-0;
        var ret = /^[1-9]\d{0,3}$/;
        if(!ret.test(pre)||!ret.test(beh)||pre>beh){
            alert('请正确输入');
        }else{
            $("#inp_hid_area").val(pre+"_TO_"+beh);
            $("#form_search").submit();
        }
    });
    $("#btn_unit_price").click(function () {
        var pre=$("#inp_unit_price_pre").val()-0;
        var beh=$("#inp_unit_price_beh").val()-0;
        var ret = /^[1-9]\d{0,6}$/;
        if(!ret.test(pre)||!ret.test(beh)||pre>beh){
            alert('请正确输入');
        }else{
            $("#inp_hid_unitPrice").val(pre+"_TO_"+beh);
            $("#form_search").submit();
        }
    });
});

function initSort(clickA) {
    var sort  =clickA.attr("name");
    $("#inp_hid_sort").val(sort);
    if(sort=="none"){
        $(".div_sort a").css({"color":"#337ab7"});
        $(".div_sort a").removeClass("glyphicon glyphicon-arrow-up glyphicon-arrow-down");
        clickA.css({"color":"#f44336"});
        $("#form_search").submit();
    }else{
        if(clickA.hasClass("glyphicon glyphicon-arrow-up")){
            $(".div_sort a").removeClass("glyphicon glyphicon-arrow-up glyphicon-arrow-down");
            clickA.addClass("glyphicon glyphicon-arrow-down");
            $("#inp_hid_sortType").val("asc");
            clickA.css({"color":"#f44336"});
            $("#form_search").submit();
        }else if(clickA.hasClass("glyphicon glyphicon-arrow-down")){
            $(".div_sort a").removeClass("glyphicon glyphicon-arrow-up glyphicon-arrow-down");
            clickA.addClass("glyphicon glyphicon-arrow-up");
            clickA.css({"color":"#f44336"});
            $("#inp_hid_sortType").val("desc");
            $("#form_search").submit();
        }else{
            $(".div_sort a").removeClass("glyphicon glyphicon-arrow-up glyphicon-arrow-down");
            clickA.addClass("glyphicon glyphicon-arrow-up");
            $(".div_sort a").css({"color":"#337ab7"});
            clickA.css({"color":"#f44336"});
            $("#inp_hid_sortType").val("desc");
            $("#form_search").submit();
        }
    }
}

function init(){
    $("#inp_hid_pn").val(1);

   var saleStatus=$("#inp_hid_saleStatus").val();
    $(".rad_sale input:radio[value="+saleStatus+"]").attr('checked','true');
    $(".a_location[name="+$("#inp_hid_location").val()+"]").css({"color":"#f44336"});

    $(".a_type[name="+$("#inp_hid_type").val()+"]").css({"color":"#f44336"});
    $(".a_houseType[name="+$("#inp_hid_houseType").val()+"]").css({"color":"#f44336"});
    $(".a_feature[name="+$("#inp_hid_feature").val()+"]").css({"color":"#f44336"});


    $(".a_sort[name="+$("#inp_hid_sort").val()+"]").css({"color":"#f44336"});
    if($("#inp_hid_sort").val()!="none"){
        if($("#inp_hid_sortType").val()=="desc"){
            $(".a_sort[name="+$("#inp_hid_sort").val()+"]").addClass("glyphicon glyphicon-arrow-up");
        }else{
            $(".a_sort[name="+$("#inp_hid_sort").val()+"]").addClass("glyphicon glyphicon-arrow-down");
        }
    }
    var inp_hid_totalPrices=$(".a_total_prices[name="+$("#inp_hid_totalPrices").val()+"]");
    if(inp_hid_totalPrices.length>0){
        inp_hid_totalPrices.css({"color":"#f44336"});
        $("#btn_total_prices").removeClass("btn-success");
        $("#btn_total_prices").addClass("btn-primary");

    }else{
        var split=$("#inp_hid_totalPrices").val().split("_");
        $("#inp_total_prices_pre").val(split[0]);
        $("#inp_total_prices_beh").val(split[2]);
        $("#btn_total_prices").removeClass("btn-primary");
        $("#btn_total_prices").addClass("btn-success");
    }
    var inp_hid_area=$(".a_area[name="+$("#inp_hid_area").val()+"]");
    if(inp_hid_area.length>0){
        inp_hid_area.css({"color":"#f44336"});
        $("#btn_aera").removeClass("btn-success");
        $("#btn_aera").addClass("btn-primary");
    }else{
        var split=$("#inp_hid_area").val().split("_");
        $("#inp_area_pre").val(split[0]);
        $("#inp_area_beh").val(split[2]);
        $("#btn_aera").removeClass("btn-primary");
        $("#btn_aera").addClass("btn-success");
    }
    var inp_hid_unitPrice=$(".a_unit_price[name="+$("#inp_hid_unitPrice").val()+"]");
    if(inp_hid_unitPrice.length>0){
        inp_hid_unitPrice.css({"color":"#f44336"});
        $("#btn_unit_price").removeClass("btn-success");
        $("#btn_unit_price").addClass("btn-primary");
    }else{
        var split=$("#inp_hid_unitPrice").val().split("_");
        $("#inp_unit_price_pre").val(split[0]);
        $("#inp_unit_price_beh").val(split[2]);
        $("#btn_unit_price").removeClass("btn-primary");
        $("#btn_unit_price").addClass("btn-success");
    }
}