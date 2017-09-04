

function loadData(num) {
    $("#PageCount").val("${pageInfo.total}");
}

function contirmd() {
    var msg = "您确定要删除吗？"
    if (confirm(msg) == true) {
        return ture;
    } else {
        return false;
    }
}

// function add(p){
//     alert(p);
// }
function getFileName(o){
    var pos=o.lastIndexOf("\\");
    return o.substring(pos+1);
}
function getPhotoType() {
    var child= $(".savePhoto");
    console.log(child)
    for(var i=0;i<child.length;i++){
        (function (i) {
            $(child[i]).click(function () {
                console.log(i)
                console.log($(this).next("input"))
                $(this).next("input").unbind('change')
                $(this).next("input").change(function () {

                    var formData = new FormData($("#addfiles")[0].value);
                    // console.log($(this).next("input").val())
                    // console.log(111)
                    $.ajax({
                        type:"POST",
                        url:"/photos/addphotos",
                        data:{
                            "num":i,
                            "formData":formData
                        },
                        dataType:"json",
                        error:function () {
                            alert("错误1")
                        },
                        success:function (Msg) {
                            if(Msg.code==100){
                                alert("添加成功");
                            }
                            if(Msg.code==200){
                                alert("错误2");
                            }
                        }
                    })
                })
            })
        })(i)
    }
}
$(function() {
    Crop.init({
        id: 'TCrop',
        /* 上传路径 */
        url: '/demo/resolveJsonObject',
        /* 允许上传的图片的后缀 */
        allowsuf: ['jpg', 'jpeg', 'png', 'gif'],
        /* JCrop参数设置 */
        cropParam: {
            minSize: [300, 300],          // 选框最小尺寸
            maxSize: [300, 300],        // 选框最大尺寸
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
            console.log('upload complete!');
        }
    });
});
getPhotoType();