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
function submitTaxiAirport(formId){
	if($("#airporttype").val()==jsconstant.going_to_airport){
		var JsonData={"formdata":cab.getFormJson(formId),"eventId":eventId.taxi_got_to_airport,"airporttype":jsconstant.going_to_airport,"dataType":"json","url":""};
		var response=cab.AJAXCall(JsonData); 
	}else{
		var JsonData={"formdata":cab.getFormJson(formId),"eventId":eventId.taxi_pickup_from_airport,"airporttype":jsconstant.pickup_from_airport,"dataType":"json","url":""};
		var response=cab.AJAXCall(JsonData);
	}
}
function changeCarRentType(){
	if($("#car_per_hours").attr('class')=="per_hours"){
		$("#carrenttype").val(jsconstant.car_rent_per_hour);
	}else{
		$("#carrenttype").val(jsconstant.car_rent_per_day);
	}
}
function onsubmitTaxiPerHour(formId) {
	if($("#carrenttype").val()==jsconstant.car_rent_per_hour){
		var JsonData={"formdata":cab.getFormJson(formId),"eventId":eventId.taxi_on_rent_per_hour,"carrenttype":jsconstant.car_rent_per_hour,"datatype":"json","url":""};
		var response=cab.AJAXCall(JsonData);
	}else{
		var JsonData={"formdata":cab.getFormJson(formId),"eventId":eventId.taxi_on_rent_per_day,"carrenttype":jsconstant.car_rent_per_day,"datatype":"json","url":""};
		var response=cab.AJAXCall(JsonData);
	}
}
function changeBikeRentType(){
	if($("#bike_per_hours").attr('class')=="per_hours active"){
		$("#bikerenttype").val(jsconstant.bike_rent_per_hour);
	}else{
		$("#bikerenttype").val(jsconstant.bike_rent_per_day);
	}
}
function submitBikeOnRent(formId) {
	if($("bikerenttype").val()==jsconstant.bike_rent_per_hour){
		var JsonData={"formdata":cab.getFormJson(formId),"eventId":eventId.bike_on_rent_per_hour,"bikerenttype":jsconstant.bike_rent_per_hour,"datatype":"json","url":""};
		var response=cab.AJAXCall(JsonData);
	}else{
		var JsonData={"formdata":cab.getFormJson(formId),"eventId":eventId.bike_on_rent_per_day,"bikerenttype":jsconstant.bike_rent_per_day,"datatype":"json","url":""};
		var response=cab.AJAXCall(JsonData);
	}
}
function submitTaxiPtop(formId){
	var data = cab.getFormJson(formId);
	var JsonData={"formData":data,"eventId":eventId.taxi_ptop,"dataType":"json","url":""};
	var response=cab.AJAXCall(JsonData);
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
function submitTaxiTicket(formId) {
	var data = cab.getFormJson(formId);
	var JsonData={"formData":data,"eventId":eventId.taxi_ticket,"dataType":"json","url":""};
	var response=cab.AJAXCall(JsonData);
}
function busTicket(formId) {
	var data = cab.getFormJson(formId);
	var JsonData={"formData":data,"eventId":eventId.bus_ticket,"dataType":"json","url":""};
	var response=cab.AJAXCall(JsonData);
} 
function busOnRent(formId) {
	var data = cab.getFormJson(formId);
	var Jsondata={"formData":data,"eventId":eventId.bus_on_rent,"dataType":"json","url":""};
	var response=cab.AJAXCall(Jsondata);	
}
function submitBikePackage(formId){
	var data = cab.getFormJson(formId);
	var JsonData={"formData":data,"eventId":eventId.bike_package,"dataType":"json","url":""};
	var response=cab.AJAXCall(JsonData);
}
function submitTruckPackersMovers(formId) {
	var data=cab.getFormJson(formId);
	var JsonData={"formData":data,"eventId":eventId.truck_packermovers,"dataType":"json","url":""};
	var response=cab.AJAXCall(JsonData);
}
function truckShipping(formId) {
	var data = cab.getFormJson(formId);
	var JsonData={"formData":data,"eventId":eventId.truck_shipping,"dataType":"json","url":""};
	var response=cab.AJAXCall(JsonData);
}
