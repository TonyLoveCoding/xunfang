$().ready(function() {
    $("#form1").validate({
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
                number:true,
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
            },
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

