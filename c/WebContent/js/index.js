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
		var JsonData={"formdata":cab.getFormJson(formId),"__eventid":eventId.taxi_got_to_airport,"airporttype":jsconstant.going_to_airport,"dataType":"json","url":""};
		var response=cab.AJAXCall(JsonData); 
	}else{
		var JsonData={"formdata":cab.getFormJson(formId),"__eventid":eventId.taxi_pickup_from_airport,"airporttype":jsconstant.pickup_from_airport,"dataType":"json","url":""};
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
		var JsonData={"formdata":cab.getFormJson(formId),"__eventid":eventId.taxi_on_rent_per_hour,"carrenttype":jsconstant.car_rent_per_hour,"datatype":"json","url":""};
		var response=cab.AJAXCall(JsonData);
	}else{
		var JsonData={"formdata":cab.getFormJson(formId),"__eventid":eventId.taxi_on_rent_per_day,"carrenttype":jsconstant.car_rent_per_day,"datatype":"json","url":""};
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
		var JsonData={"formdata":cab.getFormJson(formId),"__eventid":eventId.bike_on_rent_per_hour,"bikerenttype":jsconstant.bike_rent_per_hour,"datatype":"json","url":""};
		var response=cab.AJAXCall(JsonData);
	}else{
		var JsonData={"formdata":cab.getFormJson(formId),"__eventid":eventId.bike_on_rent_per_day,"bikerenttype":jsconstant.bike_rent_per_day,"datatype":"json","url":""};
		var response=cab.AJAXCall(JsonData);
	}
}
function submitTaxiPtop(formId){
	if($('#'+formId).validateForm()){
		alert("data is valid")
		var data = cab.getFormJson(formId);
		var JsonData={"formData":data,"__eventid":eventId.taxi_ptop,"dataType":"json","url":""};
		var response=cab.AJAXCall(JsonData);
	}else{
		alert("Please enter valid data.");
		return;
	}
	
}

function submitTaxiPackage(formId){
	var data = cab.getFormJson(formId);
	var JsonData={"formData":data,"__eventid":eventId.taxi_package,"dataType":"json","url":""};
	var response=cab.AJAXCall(JsonData);
}
function submitTaxiOutstation(formId){
	var data = cab.getFormJson(formId);
	var JsonData={"formData":data,"__eventid":eventId.taxi_out_station,"dataType":"json","url":""};
	var response=cab.AJAXCall(JsonData);
}
function submitTaxiTicket(formId) {
	var data = cab.getFormJson(formId);
	var JsonData={"formData":data,"__eventid":eventId.taxi_ticket,"dataType":"json","url":""};
	var response=cab.AJAXCall(JsonData);
}
function busTicket(formId) {
	var data = cab.getFormJson(formId);
	var JsonData={"formData":data,"__eventid":eventId.bus_ticket,"dataType":"json","url":""};
	var response=cab.AJAXCall(JsonData);
} 
function busOnRent(formId) {
	var data = cab.getFormJson(formId);
	var Jsondata={"formData":data,"__eventid":eventId.bus_on_rent,"dataType":"json","url":""};
	var response=cab.AJAXCall(Jsondata);	
}
function submitBikePackage(formId){
	var data = cab.getFormJson(formId);
	var JsonData={"formData":data,"__eventid":eventId.bike_package,"dataType":"json","url":""};
	var response=cab.AJAXCall(JsonData);
}
function submitTruckPackersMovers(formId) {
	var data=cab.getFormJson(formId);
	var JsonData={"formData":data,"__eventid":eventId.truck_packermovers,"dataType":"json","url":""};
	var response=cab.AJAXCall(JsonData);
}
function truckShipping(formId) {
	var data = cab.getFormJson(formId);
	var JsonData={"formData":data,"__eventid":eventId.truck_shipping,"dataType":"json","url":""};
	var response=cab.AJAXCall(JsonData);
}

//set city drop down
$( document ).ready(function() {
   // console.log( "ready!" );
	
	getCityList();
});

function getCityList(){
	var data = JSON.stringify({"__eventid":eventId.get_city_list});
	var JsonData={"formData":data,"__eventid":eventId.get_city_list,"dataType":"json","url":"/c"};
	cab.AJAXCall(JsonData,getCityListResponce);
}
function getCityListResponce(cityData){
	alert(JSON.stringify(cityData));
}
function getPickupAreaList(cityId,areaName){
	console.log(areaName);
	if(areaName.length>3){
		var data = JSON.stringify({"formData":{"areaName":areaName,"cityId":cityId}});
		var JsonData = {"formData":data,"__eventid":eventId.get_area_list,"dataType":"json","url":"/c"};
		cab.AJAXCall(JsonData,getAreaListResponse);
	}
}
function getAreaListResponse(data){
	var areaNameList=[];
	var areaIdList=[];
	for(var i=0;i<data.areaList.length;i++){
		areaNameList.push(data.areaList[i].areaName);
		areaIdList.push(data.areaList[i].id);
	}
	console.log(areaNameList);
	$( "#taxiptoppickuparea").autocomplete({
	      source: areaNameList,
	      delay: 500
	});
}

