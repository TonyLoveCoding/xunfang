$(function(){
	$(window).scroll(function(){
            var height = $(document).scrollTop();
            var headerHeight = $(".navbar-header").height();  
            if(height > headerHeight){
                $('.header-hover').fadeIn('slow',function(){
                    $('.header-hover').css('display','block');
                });
            }else{
                $('.header-hover').fadeOut('slow',function(){
                    $('.header-hover').css('display','none');
                });
            }
        });
});