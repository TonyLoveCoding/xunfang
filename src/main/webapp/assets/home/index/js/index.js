
$(document).ready(function(){
    getEstate();

    //浮动搜索框的效果设置
    $('.search-terms > .search-terms-item').hover(function(){
        $(this).addClass('hover');
        $(this).children('.hoverBlock').css('display','block');
    },function(){
        $(this).removeClass('hover');
        $(this).children('.hoverBlock').css('display','none');
    });

    //条件搜索标签的设置
    $(".select-location li a").click(function () {
        var val = $(this).attr("name");
        $("#inp_hid_location").val(val);
        $("#form_search").submit();
        $("#inp_hid_location").val("none");
    });

    $(".select-type li a").click(function () {
        var val = $(this).attr("name");
        $("#inp_hid_type").val(val);
        $("#form_search").submit();
        $("#inp_hid_type").val("none");

    });

    $(".select-houseType li a").click(function () {
        var val = $(this).attr("name");
        $("#inp_hid_houseType").val(val);
        $("#form_search").submit();
        $("#inp_hid_houseType").val("none");
    });

    $(".select-total-prices li a").click(function () {
        var val = $(this).attr("name");
        $("#inp_hid_totalPrices").val(val);
        $("#form_search").submit();
        $("#inp_hid_totalPrices").val("none");
    });

    $(".select-unit-price li a").click(function () {
        var val = $(this).attr("name");
        $("#inp_hid_unitPrice").val(val);
        $("#form_search").submit();
        $("#inp_hid_unitPrice").val("none");
    });

    $(".select-feature li a").click(function () {
        var val = $(this).attr("name");
        $("#inp_hid_feature").val(val);
        $("#form_search").submit();
        $("#inp_hid_feature").val("none");
    });

    $(".select-area li a").click(function () {
        var val = $(this).attr("name");
        $("#inp_hid_area").val(val);
        $("#form_search").submit();
        $("#inp_hid_area").val("none");
    });

    //顶部输入框的设置
    $("#search-button").click(function () {
        searchSubmit();
    });

    $("#search-input").keydown(function() {
        if(event.keyCode == "13") {
            searchSubmit();
        }
    });

    function searchSubmit() {
        var keyword = $("#search-input").val();
        $("#inp_hid_keyword").val(keyword);
        $("#form_search").submit();
    };

    //浮动输入框的设置
    $("#search-button-hover").click(function () {
        searchSubmit_hover();
    });

    $("#search-input-hover").keydown(function() {
        if(event.keyCode == "13") {
            searchSubmit_hover();
        }
    });
    
    function searchSubmit_hover() {
        var keyword = $("#search-input-hover").val();
        $("#inp_hid_keyword").val(keyword);
        $("#form_search").submit();
    }


});

//将推荐楼盘和最新楼盘系列用ajax方式取到数据并在各自的div中呈现
function getEstate() {
    $.ajax({
        url: "/home/getHomeEstateMsg",
        type: "GET",
        success: function (data) {
            if(data.code == 100){
                var recommendArea = $("#RecommendedEstate_div");
                showEstates(recommendArea,data.extend.RecommendedEstate);
                var latestArea = $("#LatestEstate_div");
                showEstates(latestArea,data.extend.RecommendedEstate);
            }
        }
    });
}

//
function showEstates(area, list) {
    for(var estate in list){
        var div = $("<div class=\"col-md-3\"></div>");
            var div2 = $("<div class=\"thumbnail hovereffect img-background\">");
        var perLink = $("<a href=\"home/details/" + list[estate].id + "\">" +
                        "<img class=\"img-responsive\" src=\"" + list[estate].estateDetailsURL +"\" alt=\"\">" +
                        "<div class=\"overlay\"><h2>" + list[estate].estateName + "</h2></div></a>");
        var perDesc = $("<div class=\"caption\">" +
                        "<h3><a href=\"home/details/" + list[estate].id + "\">" + list[estate].estateName + "</a></h3>" +
                        "<p>" + list[estate].location +
                            " | 建面: " + list[estate].area + " m² | " +
            list[estate].minPrice +"-"+list[estate].maxPrice+" 万" +"</p></div>");
        perLink.appendTo(div2);
        perDesc.appendTo(div2);
        div2.appendTo(div);
        div.appendTo(area);
    }
}



