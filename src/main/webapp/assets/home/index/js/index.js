$(function(){
    $('.search-terms > .search-terms-item').hover(function(){
        $(this).addClass('hover');
        $(this).children('.hoverBlock').css('display','block');
    },function(){
        $(this).removeClass('hover');
        $(this).children('.hoverBlock').css('display','none');
    });
});

