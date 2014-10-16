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
	var data = cab.getFormJson(formId);
	var JsonData={"formData":data,"eventId":eventId.taxi_ptop,"dataType":"json","url":""};
	var response=cab.AJAXCall(JsonData);
}
function submitTaxiAirport(formId){
	if($("#airporttype").val()==jsconstant.going_to_airport){
		var jsonData={"formdata":cab.getFormJson(formId),"eventId":eventId.taxi_got_to_airport,"airporttype":jsconstant.going_to_airport,"dataType":"json","url":""};
		var response=cab.AJAXCall(JsonData);
	}else{
		var jsonData={"formdata":cab.getFormJson(formId),"eventId":eventId.taxi_got_to_airport,"airporttype":jsconstant.pickup_from_airport,"dataType":"json","url":""};
		var response=cab.AJAXCall(JsonData);
	}
}
function submitTaxiPackage(formId){
	var data = cab.getFormJson(formId);
	var JsonData={"formData":data,"eventId":eventId.taxi_package,"dataType":"json","url":""};
	var response=cab.AJAXCall(JsonData);
}
function submitTaxiOutstation(formId){
	var data = cab.getFormJson(formId);
	var JsonData={"formData":data,"eventId":eventId.taxi_out_station,"dataType":"json","url":""};
	var response=cab.AJAXCall(JsonData);
}
function submitBikePackage(formId){
	alert('test1');
	var data = cab.getFormJson(formId);
	var JsonData={"formData":data,"eventId":eventId.bike_package,"dataType":"json","url":""};
	var response=cab.AJAXCall(JsonData);
}
function submitTruckPackersMovers(formId) {
	var data=cab.getFormJson(formId);
	var JsonData={"formData":data,"eventId":eventId.truck_packermovers,"dataType":"json","url":""};
	var response=cab.AJAXCall(JsonData);
}
