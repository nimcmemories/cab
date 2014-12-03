/**
 * 
 */
/*  Bus Details Form  */
	$(document).ready(function(){
		console.log(1);
		getBusDetails();
	});
    $('#addBus').click(function(){
		$('.createPopup1_Bg').show();
		$('.createPopup_bus').show();
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
    
    function addBusDetails(formId) {
    	var data = JSON.stringify({"formData":cab.getFormJson(formId)});
    	var JsonData = {"formData":data,"__eventid":eventId.add_bus_details,"dataType":"json","url":"/c"};
    	cab.AJAXCall(JsonData,addBusResponse);
    }
    function addBusResponse(resData){
    	alert("edit res---->>"+JSON.stringify(resData));
    	cab.setStatusMsg(data.response.msg,data.response.status);
    	getBuses();
    }
    function getBusDetails() {
    	var data = JSON.stringify({"formData":{}});
    	var JsonData = {"formData":data,"__eventid":eventId.get_buses,"dataType":"json","url":"/c"};
    	cab.AJAXCall(JsonData, getBusDetailsResponse);
    }
    function getBusDetailsResponse(data) {
    	console.log();
    	
	}
	