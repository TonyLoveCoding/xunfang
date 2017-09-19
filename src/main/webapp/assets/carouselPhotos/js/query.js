
function loadData(num) {
    $("#PageCount").val("${pageInfo.total}");
}

$(function() {
    Crop.init({
        id: 'TCrop',
        /* 上传路径 */
        url: '/carouselPhotos/uplodephotos',
        /* 允许上传的图片的后缀 */
        allowsuf: ['jpg', 'jpeg', 'png', 'gif'],
        /* JCrop参数设置 */
        cropParam: {
            minSize: [540, 200],          // 选框最小尺寸
            maxSize: [540, 200],        // 选框最大尺寸
            allowSelect: true,          // 允许新选框
            allowMove: true,            // 允许选框移动
            allowResize: true,          // 允许选框缩放
            dragEdges: true,            // 允许拖动边框
            onChange: function(c) {},   // 选框改变时的事件，参数c={x, y, x1, y1, w, h}
            onSelect: function(c) {}    // 选框选定时的事件，参数c={x, y, x1, y1, w, h}
        },
        /* 是否进行裁剪，不裁剪则按原图上传，默认进行裁剪 */
        isCrop: true,
        /* 图片上传完成之后的回调，无论是否成功上传 */
        onComplete: function(data) {
            alert(data.toString().substring(19,23));
            console.log('upload complete!');
            location.href="/carouselPhotos/query";
        }
    });
});

function movePhoto(id,direction) {
    $.ajax({
        type:"get",
        url:"/carouselPhotos/movePhoto",
        data:{"id":id,"direction":direction},
        dataType:"json",
        success:function (Msg) {
            location.reload();
            alert(Msg.tip);
        }
    })
}