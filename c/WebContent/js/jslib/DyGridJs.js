// JavaScript Document

$(document).ready(function(){
	$('.create_row').click(function(){
		$('.createPopup1_Bg').fadeIn(50);
		$('.createPopup').fadeIn(100);
	});
	$('.close_button').click(function(){
		$('.createPopup1_Bg').fadeOut(300);
		$('.createPopup').fadeOut(500);
		$('.editPopup').fadeOut(500);
		$('.createPopup1_Bg').fadeOut(500);
		$('.createPopup_taxi').fadeOut(500);
		$('.createPopup_bus').fadeOut(500);
		$('.createPopup_bike').fadeOut(100);
	});
	$('.createPopup1_Bg').click(function(){
		$(this).fadeOut(300);
		$('.createPopup').fadeOut(500);
		$('.editPopup').fadeOut(100);
		$('.createPopup_taxi').fadeOut(100);
		$('.createPopup_bus').fadeOut(100);
		$('.createPopup_bike').fadeOut(100);
	});

	$('.edit_button').click(function(){
		$('.createPopup1_Bg').fadeIn(50);
		$('.editPopup').fadeIn(100);
	});
	
	/*  Taxi Details Form  */
    $('.add_taxi').click(function(){
		$('.createPopup1_Bg').show();
		$('.createPopup_taxi').show();
	});
	
	/*  Bus Details Form  */
	/* Table Button Click Events */
	
	$('.edit_button').click(function(){
		
	});
	$('.delete_button').click(function(){
		
	//	if(selectedrow){
			confiirm_string="Are you sure you want to delete selected records ?";
			var delete_row=confirm(confiirm_string);
			if(delete_row){
				//alert(selectedrow);
				$(this).parent('a').parent('[class^="DyGrid-td"]').parent('.table_row').remove();
			}
		//}
	});
	$('#check_all').click(function(){
		  if($(this).is(":checked")){
			$('.checkbox').prop('checked', true);
		  }else{
			$('.checkbox').prop('checked', false);
		  }
	});
	$('.checkbox').click(function(){
		if($(this).is(":checked")){
			//$('#check_all').prop('checked', true);
		  }else{
			$('#check_all').prop('checked', false);
	    }
	});
});
function multidelete(){
//	$(document).ready(function() {     
		var selectedrow="";   
		$(".checkbox").each(function(){
			if(this.checked == true){
				selectedrow +="'"+$(this).val()+"',";
			}
			
		});
		if(selectedrow){
			confiirm_string="Are you sure you want to delete selected records ?";
			var ans=confirm(confiirm_string);
			if(ans){
				alert(selectedrow);
			}
		}
//	});
}

function addDriver(formId){
	var data = JSON.stringify({"formData":cab.getFormJson(formId)});
	var JsonData={"formData":data,"__eventid":eventId.add_driver,"dataType":"json","url":"/c"};
//	var res=cab.AJAXCall(JsonData);
	//alert(JSON.stringify(JsonData));
	//addDriverResponse(cab.AJAXCall(JsonData,addDriverResponse));
	cab.AJAXCall(JsonData,addDriverResponse);
	//alert("1");
}
function addDriverResponse(resData){
	alert("nitin res-->"+JSON.stringify(resData));
}
function editDriver(formId) {
	var data = JSON.stringify({"formData":cab.getFormJson(formId)});
	//alert("yes in editdata ---->>" + data);
	var JsonData = {"formData":data,"__eventid":eventId.edit_driver,"dataType":"json","url":"/c"};
	cab.AJAXCall(JsonData,editDriverRes);
}
function editDriverRes(resData){
	alert("edit res---->>"+JSON.stringify(resData));
}



