

function loadData(num) {
    $("#PageCount").val("${pageInfo.total}");
}

function update(form) {

    for(var i=0;i<form.elements.length-2;i++){
        if(form.elements[i].value=="" && form.elements[i].tagName!="BUTTON"){
            alert("不能为空");
            form.elements[i].focus();
            return false;
        }
    }
    return true;
}
