
$(function(){
		$('#Carousel-ID').on('slide.bs.carousel', function (ev) {
		  var id = ev.relatedTarget.id;  
		  $("#img-1").removeClass("blueBorder");
		  $("#img-2").removeClass("blueBorder");
		  $("#img-3").removeClass("blueBorder");
		  $("#img-4").removeClass("blueBorder");
		  switch (id) { 
			case "item-1":
			  $("#img-1").addClass("blueBorder");
			  break;
			case "item-2":
			  $("#img-2").addClass("blueBorder");
			  break;
			case "item-3":
			  $("#img-3").addClass("blueBorder");
			  break;
			case "item-4":
			  $("#img-4").addClass("blueBorder");
			  break;
			default:
			  //the id is none of the above
		  } 
		});
}); 