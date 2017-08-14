$(function(){
    $('.search-terms > .search-terms-item').hover(function(){
        $(this).addClass('hover');
        $(this).children('.hoverBlock').css('display','block');
    },function(){
        $(this).removeClass('hover');
        $(this).children('.hoverBlock').css('display','none');
    });
	
	
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

