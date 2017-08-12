$(document).ready(function () {
    var animationSpeed = 300;
    var frm =$("#iframeMain");
    var url;
    $(frm).load(function(){
        if(url!=""){
            var ifm= $("#iframeMain");
            var iframeHeight = $("#iframeMain").contents().find("body").height();
            ifm.attr("style","height:"+iframeHeight+"px");
            $(".main-sidebar").attr("style","height:"+iframeHeight+"px");
            var pre_height=iframeHeight;
            timer = setInterval(function(){
                iframeHeight = $("#iframeMain").contents().find("body").height();
                if (iframeHeight != pre_height){
                    ifm.attr("style","height:"+iframeHeight+"px");
                    $(".main-sidebar").attr("style","height:"+iframeHeight+"px");
                }
            },500);
        }
    });
    $("#iframeMain").contents().find("body").resize(function () {
        if(url!=""){
            var ifm= $("#iframeMain");
            var iframeHeight = $("#iframeMain").contents().find("body").height();
            ifm.attr("style","height:"+iframeHeight+"px");
            $(".main-sidebar").attr("style","height:"+iframeHeight+"px");
        }
    });

    $(document.body).on('click', '.sidebar-menu li a', function(e){
        var $this = $(this);
        url=$this.attr("name");
        var checkElement = $this.next();
        if(url!=""){
            var body=$("#iframeMain").contents().find("body");
            var ifm= $("#iframeMain");
            body.attr("style","height:580px");
            ifm.attr("style","height:580px");
            $("#iframeMain").attr("src",url);
        }
        if (checkElement.is('.treeview-menu') && checkElement.is(':visible')) {
            checkElement.slideUp(animationSpeed, function() {
                checkElement.removeClass('menu-open');
            });
            checkElement.parent("li").removeClass("active");
        }

        //If the menu is not visible
        else if ((checkElement.is('.treeview-menu')) && (!checkElement.is(':visible'))) {
            //Get the parent menu
            var parent = $this.parents('ul').first();
            //Close all open menus within the parent
            var ul = parent.find('ul:visible').slideUp(animationSpeed);
            //Remove the menu-open class from the parent
            ul.removeClass('menu-open');
            //Get the parent li
            var parent_li = $this.parent("li");

            //Open the target menu and add the menu-open class
            checkElement.slideDown(animationSpeed, function() {
                //Add the class active to the parent li
                checkElement.addClass('menu-open');
                parent.find('li.active').removeClass('active');
                parent_li.addClass('active');
            });
        }
        //if this isn't a link, prevent the page from being redirected
        if (checkElement.is('.treeview-menu')) {
            e.preventDefault();
        }
    });
});
