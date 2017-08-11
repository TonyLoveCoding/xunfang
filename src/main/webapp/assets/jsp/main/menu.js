$(document).ready(function () {
    var isFirstMenu;


    $(window).load(function(){
        $.ajax({
            url: "/main/menu",
            type: "GET",
            success: function (menulist) {
                if(menulist.code==100){
                    var showlist = $("<ul class=\"sidebar-menu\"></ul>");
                    $("<li class=\"header\">主导航</li>").appendTo(showlist);
                    isFirstMenu=menulist.extend.children.length;
                    showall(menulist.extend.children, showlist);
                    $("#div_menu").append(showlist);
                }
                //TODO 错误异常处理
            }
        });
    });

    function showall(menu_list, parent) {
        for (var menu in menu_list) {
            if (menu_list[menu].children.length > 0) {
                var li = $("<li></li>");
                if(isFirstMenu==0){
                    li = $("<li></li>");
                }else{
                    li = $("<li class=\"treeview\"></li>");
                    isFirstMenu=isFirstMenu-1;
                }
                $(li).append("<a href=\"javascript:void(0);\" name='"+menu_list[menu].url+"'><i class=\"fa fa-share\"></i> <span>"+menu_list[menu].text+"</span><i class=\"fa fa-angle-right pull-right\"></i></a>");
                var nextParent=$("<ul class=\"treeview-menu\"></ul>");
                $(nextParent).appendTo(li);
                $(li).appendTo(parent);
                showall(menu_list[menu].children, nextParent);
            }
            else {
                $("<li><a href=\"javascript:void(0);\" name='"+menu_list[menu].url+"'><i class=\"fa fa-circle-o\"></i>"
                    +menu_list[menu].text
                    +"</a></li>").appendTo(parent);
            }
        }
    }


});