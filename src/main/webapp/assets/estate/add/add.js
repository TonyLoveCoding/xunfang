

function loadData(num) {
    $("#PageCount").val("${pageInfo.total}");
}

function update(form) {

    for(var i=0;i<form.elements.length-2;i++){
        if(form.elements[i].value=="" && form.elements[i].tagName!="BUTTON"){
            form.elements[i].focus();
            alert("所有信息不能为空");
            return false;
        }else if(form.elements[i].value!="" && form.elements[i].tagName!="BUTTON"){
            if(form.elements[i].name=="maxPrice" || form.elements[i].name=="minPrice" || form.elements[i].name=="developerQuotes"
                || form.elements[i].name=="saleStatus"){
                var integer=/^[1-9]\d*|0$/;
                alert(form.elements[i].value);
                if(!integer.test(form.elements[i].value)){
                    form.elements[i].focus();
                    alert(form.elements[i].name+"存在非法字段填充");
                    return false;
                }
            }else if(form.elements[i].name=="plotRatio" || form.elements[i].name=="area" || form.elements[i].name=="greenRate"){
                var reg1=/^[1-9]\d*\.\d*|0\.\d*[1-9]\d*|0?\.0+|0$/;
                var reg2=/^[1-9]\d*|0$/;
                if(!reg1.test(form.elements[i].value) && !reg2.test(form.elements[i].value)){
                    form.elements[i].focus();
                    alert(form.elements[i].name+"存在非法字段填充");
                    return false;
                }
            }
        }
    }
    return true;
}

$(function () {
    var y=$('#form1').bootstrapValidator({
        message:'This value is not valid',
        fields:{
            estateName:{
                validators:{
                    notEmpty:{
                        message:'楼盘名称不能为空'
                    }
                }
            },
            estateAddress:{
                validators:{
                    notEmpty:{
                        message:'楼盘地址不能为空'
                    }
                }
            },
            location:{
                validators:{
                    notEmpty:{
                        message:'位置不能为空'
                    }
                }
            },
            property:{
                validators:{
                    notEmpty:{
                        message:'物业类型不能为空'
                    }
                }
            },
            type:{
                validators:{
                    notEmpty:{
                        message:'建筑类型不能为空'
                    }
                }
            },
            developer:{
                validators:{
                    notEmpty:{
                        message:'开发商不能为空'
                    }
                }
            },
            area:{
                validators:{
                    notEmpty:{
                        message:'面积不能为空'
                    }
                }
            },
            maxPrice:{
                validators:{
                    notEmpty:{
                        message:'最高价不能为空'
                    }
                }
            },
            minPrice:{
                validators:{
                    notEmpty:{
                        message:'最低价不能为空'
                    }
                }
            },
            developerQuotes:{
                validators:{
                    notEmpty:{
                        message:'开发商报价不能为空'
                    }
                }
            },
            firstDelivery:{
                validators:{
                    notEmpty:{
                        message:'最早交房不能为空'
                    }
                }
            },
            propertyRights:{
                validators:{
                    notEmpty:{
                        message:'产权年限不能为空'
                    }
                }
            },
            latestOpening:{
                validators:{
                    notEmpty:{
                        message:'最新开盘不能为空'
                    }
                }
            },
            houseType:{
                validators:{
                    notEmpty:{
                        message:'楼盘户型不能为空'
                    }
                }
            },
            takeTime:{
                validators:{
                    notEmpty:{
                        message:'拿地时间不能为空'
                    }
                }
            },
            saleStatus:{
                validators:{
                    notEmpty:{
                        message:'销售状态不能为空'
                    }
                }
            },
            company:{
                validators:{
                    notEmpty:{
                        message:'物业公司不能为空'
                    }
                }
            },
            parkingSpaces:{
                validators:{
                    notEmpty:{
                        message:'车位情况不能为空'
                    }
                }
            },
            propertyCost:{
                validators:{
                    notEmpty:{
                        message:'物业费用不能为空'
                    }
                }
            },
            plotRatio:{
                validators:{
                    notEmpty:{
                        message:'容积率不能为空'
                    }
                }
            },
            powerType:{
                validators:{
                    notEmpty:{
                        message:'水电燃气不能为空'
                    }
                }
            },
            decoration:{
                validators:{
                    notEmpty:{
                        message:'装修情况不能为空'
                    }
                }
            },
            greenRate:{
                validators:{
                    notEmpty:{
                        message:'绿化率不能为空'
                    }
                }
            },
            estateInformation:{
                validators:{
                    notEmpty:{
                        message:'楼栋信息不能为空'
                    }
                }
            },
            feature:{
                validators:{
                    notEmpty:{
                        message:'特色不能为空'
                    }
                }
            },
            sign:{
                validators:{
                    notEmpty:{
                        message:'标签不能为空'
                    }
                }
            }
        }
    })
})