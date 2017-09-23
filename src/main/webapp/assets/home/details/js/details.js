
$(function(){
	$('#Carousel-ID').on('slide.bs.carousel', function (ev) {
	  var id = ev.relatedTarget.id;
	  $("#img-1").removeClass("blueBorder");
	  $("#img-2").removeClass("blueBorder");
	  $("#img-3").removeClass("blueBorder");
	  $("#img-4").removeClass("blueBorder");
	  switch (id) {
		case "item-1":
		  $("#img-1").addClass("blueBorder");
		  break;
		case "item-2":
		  $("#img-2").addClass("blueBorder");
		  break;
		case "item-3":
		  $("#img-3").addClass("blueBorder");
		  break;
		case "item-4":
		  $("#img-4").addClass("blueBorder");
		  break;
		default:
		  //the id is none of the above
	  }
	});

    //主页点击轮播图后滑动到图册的设置
    $('#toPic1, #toPic2, #toPic3, #toPic4').click(function(){
        $('#tabs-ID li:eq(2) a').tab('show');
        var scrollToDom =$(this).attr("data-scroll");
        setTimeout(function () {
            $('html,body').animate({
                scrollTop:$(scrollToDom).offset().top},600
            );
        }, 200);
    });

    //设置滚动到某个dom节点的代码
    jQuery.scrollToDom = function(scrollDom,scrollTime) {
        $(scrollDom).click( function(){
            var scrollToDom = $(this).attr("data-scroll");
            $(this).addClass("thisScroll").siblings().removeClass("thisScroll");
            $('html,body').animate({
                scrollTop:$(scrollToDom).offset().top},scrollTime
            );
            return false;
        });
    };

    //为右侧导航栏子节点赋予滚动效果
    $.scrollToDom("#myScrollspy a",600);

	//热搜词设置
    $(".a_heatWord").click(function () {
        var keyWord=this.innerHTML;
        $("#inp_hid_keyword").attr("value", keyWord);
        $("#form_search").submit();
    });
}); 