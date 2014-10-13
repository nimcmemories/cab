/**
 * 
 */
//all funaction relating to index.html file goes here
//name should be proper
function changeAirportType(){
	if($("#go_airport").attr('class')=="go_airport active"){
		$("#airporttype").val(jsconstant.going_to_airport);
	}else{
		$("#airporttype").val(jsconstant.pickup_from_airport);
	}
}

function changeCarRentType(){
	if($("#car_per_hours").attr('class')=="per_hours"){
		$("#carrenttype").val(jsconstant.car_rent_per_hour);
	}else{
		$("#carrenttype").val(jsconstant.car_rent_per_day);
	}
}

function changeBikeRentType(){
	alert(1);
	if($("#bike_per_hours").attr('class')=="per_hours active"){
		alert("if");
		$("#bikerenttype").val(jsconstant.bike_rent_per_hour);
	}else{
		alert("else");
		$("#bikerenttype").val(jsconstant.bike_rent_per_day);
	}
}
function submitTaxiPtop(formId){
	alert(formId);
	var data = JSON.stringify($("#"+formId+"").serializeArray());
	var JsonData={"formData":data,"eventId":eventId.taxi_ptop,"dataType":"json","url":""};
	cab.AJAXCall(JsonData);
	//alert(data);
}