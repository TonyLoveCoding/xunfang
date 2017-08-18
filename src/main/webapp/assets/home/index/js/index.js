$(function(){
    $('.search-terms > .search-terms-item').hover(function(){
        $(this).addClass('hover');
        $(this).children('.hoverBlock').css('display','block');
    },function(){
        $(this).removeClass('hover');
        $(this).children('.hoverBlock').css('display','none');
    });

    $(".select-location li a").click(function () {
        var val = $(this).attr("name");
        $("#inp_hid_location").val(val);
        $("#form_search").submit();
    });

    $(".select-type li a").click(function () {
        var val = $(this).attr("name");
        $("#inp_hid_type").val(val);
        $("#form_search").submit();

    });

    $(".select-houseType li a").click(function () {
        var val = $(this).attr("name");
        $("#inp_hid_houseType").val(val);
        $("#form_search").submit();
    });

    $(".select-total-prices li a").click(function () {
        var val = $(this).attr("name");
        $("#inp_hid_totalPrices").val(val);
        $("#form_search").submit();
    });

    $(".select-unit-price li a").click(function () {
        var val = $(this).attr("name");
        $("#inp_hid_unitPrice").val(val);
        $("#form_search").submit();
    });

    $(".select-feature li a").click(function () {
        var val = $(this).attr("name");
        $("#inp_hid_feature").val(val);
        $("#form_search").submit();
    });

    $("#search-button").click(function () {
        var keyword = $("#search-input").val();
        $("#inp_hid_keyword").val(keyword);
        $("#form_search").submit();
    });

    $("#search-button-hover").click(function () {
        var keyword = $("#search-input-hover").val();
        $("#inp_hid_keyword").val(keyword);
        $("#form_search").submit();
    });
});

