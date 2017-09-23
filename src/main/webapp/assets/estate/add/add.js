$().ready(function() {
    $("#form1").validate({
        errorPlacement:function(error, element) {
            if (element.name=="greenRate")
                error.appendTo(element.parent());
            else if (element.is(":checkbox"))
                error.appendTo(element.parent().parent());
            else
                error.insertAfter(element.parent());
        },
        rules:{
            estateName:{
                required: true
            },
            estateAddress:{
                required: true
            },
            location:{
                required: true
            },
            property:{
                required: true
            },
            type:{
                required: true
            },
            developer:{
                required: true
            },
            area:{
                required: true,
                min : 0
            },
            maxPrice:{
                required: true,
                digits:true,
                min : 0
            },
            minPrice:{
                required: true,
                digits:true,
                min : 0
            },
            developerQuotes:{
                required: true,
                digits:true,
                min : 0
            },
            firstDelivery:{
                required: true
            },
            propertyRights:{
                required: true
            },
            latestOpening:{
                required: true
            },
            houseType:{
                required: true
            },
            takeTime:{
                required: true
            },
            saleStatus:{
                required: true
            },
            company:{
                required: true
            },
            parkingSpaces:{
                required: true
            },
            propertyCost:{
                required: true
            },
            plotRatio:{
                required: true,
                min : 0
            },
            powerType:{
                required: true
            },
            decoration:{
                required: true
            },
            greenRate:{
                required: true,
                min : 0
            },
            estateInformation:{
                required: true
            },
            feature:{
                required: true
            },
            sign:{
                required: true
            }
        }
    });
});

function loadData(num) {
    $("#PageCount").val("${pageInfo.total}");
}

$("#feature").change(function (){
    $(this).valid();
});

$("#houseType").change(function () {
    $(this).valid();
});

// function update(form) {
//
//     for(var i=0;i<form.elements.length-2;i++){
//         if(form.elements[i].value=="" && form.elements[i].tagName!="BUTTON"){
//             form.elements[i].focus();
//             alert("所有信息不能为空");
//             return false;
//         }else if(form.elements[i].value!="" && form.elements[i].tagName!="BUTTON"){
//             if(form.elements[i].name=="maxPrice" || form.elements[i].name=="minPrice" || form.elements[i].name=="developerQuotes"
//                 || form.elements[i].name=="saleStatus"){
//                 var integer=/^[1-9]\d*|0$/;
//                 alert(form.elements[i].value);
//                 if(!integer.test(form.elements[i].value)){
//                     form.elements[i].focus();
//                     alert(form.elements[i].name+"存在非法字段填充");
//                     return false;
//                 }
//             }else if(form.elements[i].name=="plotRatio" || form.elements[i].name=="area" || form.elements[i].name=="greenRate"){
//                 var reg1=/^[1-9]\d*\.\d*|0\.\d*[1-9]\d*|0?\.0+|0$/;
//                 var reg2=/^[1-9]\d*|0$/;
//                 if(!reg1.test(form.elements[i].value) && !reg2.test(form.elements[i].value)){
//                     form.elements[i].focus();
//                     alert(form.elements[i].name+"存在非法字段填充");
//                     return false;
//                 }
//             }
//         }
//     }
//     return true;
// }

// $(function () {
//     var y=$('#form1').bootstrapValidator({
//         message:'This value is not valid',
//         fields:{
//             firstDelivery:{
//                 validators:{
//                     notEmpty:{
//                         message:'最早交房不能为空'
//                     }
//                 }
//             },
//             latestOpening:{
//                 validators:{
//                     notEmpty:{
//                         message:'最新开盘不能为空'
//                     }
//                 }
//             },
//             takeTime:{
//                 validators:{
//                     notEmpty:{
//                         message:'拿地时间不能为空'
//                     }
//                 }
//             },
//             saleStatus:{
//                 validators:{
//                     notEmpty:{
//                         message:'销售状态不能为空'
//                     }
//                 }
//             },
//             greenRate:{
//                 validators:{
//                     notEmpty:{
//                         message:'绿化率不能为空'
//                     }
//                 }
//             }
//         }
//     })
// })