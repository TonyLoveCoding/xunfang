

function loadData(num) {
    $("#PageCount").val("${pageInfo.total}");
}

function update(form) {

    for(var i=0;i<form.elements.length-2;i++){
        if(form.elements[i].value=="" && form.elements[i].tagName!="BUTTON"){
            form.elements[i].focus();
            alert("不能为空");
            return false;
        }
    }
    return true;
}
