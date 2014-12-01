/**
 * 
 */
$( document ).ready(function() {
   console.log( "bike is ready to go..!" );
	getBikeDetails();
});
$('#addbike').click(function(){
//	alert("------");
	$('.createPopup1_Bg').show();
	$('.createPopup_bike').show();
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
function addBikeDetails(formId){
	//if($('#'+formId).isValid()){
		var data = JSON.stringify({"formData":cab.getFormJson(formId)});
		var JsonData = {"formData":data,"__eventid":eventId.add_bike,"dataType":"json","url":"/c"};
		cab.AJAXCall(JsonData, addBikeDetailsResponse);
	//}
}
function addBikeDetailsResponse(data){
	cab.setStatusMsg(data.response.msg,data.response.status);
	getBikes();
}
function getBikeDetails(){
	var data = JSON.stringify({"formData":{}});
	var JsonData = {"formData":data,"__eventid":eventId.get_bikes,"dataType":"json","url":"/c"};
	cab.AJAXCall(JsonData, getBikeDetailsResponse);
}
function getBikeDetailsResponse(data){
	
	//console.log(data.response.bikrArray);
	$.each(data.response.bikrArray, function( index, bike ) {
		console.log( index + ": " + JSON.stringify(bike) );
		var bikeName = bike.bikeName!=""?bike.bikeName:"-";
		var bikeNo = bike.bikeNo!=""?bike.bikeNo:"=";
		var isEnable=bike.isEnable==1?"Enable":"Disable";
		var bikeImgPath = bike.bikeImgPath!=""?bike.bikeImgPath:"-";
		var description = bike.description!=""?bike.description:"-";
		var per_hour_rate = bike.per_hour_rate!=""?bike.per_hour_rate:"-";
		var per_day_rate = bike.per_day_rate!=""?bike.per_day_rate:"-";
		$('#bikerecords').append('<table class="table-Bike"><tr><td>'+bikeName+'</td></tr><tr><td>'+bikeNo+'</td></tr><tr><td>'+bikeImgPath+'</td></tr><tr><td>'+description+'</td></tr><tr><td class="switch">'+per_hour_rate+'</td></tr><tr><td class="switch">'+per_day_rate+'</td></tr><tr><td class="switch">'+isEnable+'</td></tr><tr><td class=""><input type="button" class="primary"value="Edit" /></td></tr></table>');
	});
}