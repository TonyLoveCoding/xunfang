$(document).ready(function(){
    init();
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
});
function init(){
   var saleStatus=$("#inp_hid_saleStatus").val();
    $(".rad_sale input:radio[value="+saleStatus+"]").attr('checked','true');
    $(".a_location[name="+$("#inp_hid_location").val()+"]").css({"color":"#f44336"});
    $(".a_total_prices[name="+$("#inp_hid_totalPrices").val()+"]").css({"color":"#f44336"});
    $(".a_type[name="+$("#inp_hid_type").val()+"]").css({"color":"#f44336"});
    $(".a_houseType[name="+$("#inp_hid_houseType").val()+"]").css({"color":"#f44336"});
    $(".a_feature[name="+$("#inp_hid_feature").val()+"]").css({"color":"#f44336"});
    $(".a_unit_price[name="+$("#inp_hid_unitPrice").val()+"]").css({"color":"#f44336"});
    $(".a_area[name="+$("#inp_hid_area").val()+"]").css({"color":"#f44336"});
}