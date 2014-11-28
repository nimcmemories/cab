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
	if($('#'+formId).isValid()){
		//alert("data is valid")
		var data = JSON.stringify(cab.getFormJson(formId));
		var JsonData={"formData":data,"__eventid":eventId.taxi_ptop,"dataType":"json","url":"/c"};
		var response=cab.AJAXCall(JsonData);
	}else{
		//alert("Please enter valid data.");
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
   //console.log( "ready!" );
	
	getCityList();
	
});

function getCityList(){
	var data = JSON.stringify({"__eventid":eventId.get_city_list});
	var JsonData={"formData":data,"__eventid":eventId.get_city_list,"dataType":"json","url":"/c"};
	cab.AJAXCall(JsonData,getCityListResponse);
}
function getCityListResponse(cityData){
	cab.generateselect("taxiptopcity",cityData.cityArray);
}
//for pickup area
//ptop pickup
function getPtopPickupAreaList(cityId,areaName){
	if(areaName.length>=3){
		var data = JSON.stringify({"formData":{"areaName":areaName,"cityId":cityId}});
		var JsonData = {"formData":data,"__eventid":eventId.get_area_list,"dataType":"json","url":"/c"};
		cab.AJAXCall(JsonData,getPtopPickupAreaListResponse);
	}
}
function getPtopPickupAreaListResponse(data){
	var keyValue=[];
	for(var i=0;i<data.areaList.length;i++){
		var tem={"label":data.areaList[i].areaName,"value":data.areaList[i].id};
		keyValue.push(tem);	
	}
	if($('#taxiptopdroparea').val()!=undefined && $('#taxiptopdroparea').val()!=""){
		keyValue = $.grep(keyValue, function(e) { return e.label!=$('#taxiptopdroparea').val()});
	}
	cab.autocomplete("taxiptoppickuparea", keyValue,"taxiptoppickupareaid");
}
//pickup airtport
function getGoingAirportPickupAreaList(cityId,areaName) {
	if(areaName.length>=3){
		var data = JSON.stringify({"formData":{"areaName":areaName,"cityId":cityId}});
		var JsonData = {"formData":data,"__eventid":eventId.get_area_list,"dataType":"json","url":"/c"};
		//console.log(cityId+"---"+areaName);
		cab.AJAXCall(JsonData, getGoingAirportPickupAreaListResponse);
	}
}
function getGoingAirportPickupAreaListResponse(data) {
	var keyValue=[];
	for(var i=0;i<data.areaList.length;i++){
		var tem={"label":data.areaList[i].areaName,"value":data.areaList[i].id};
		keyValue.push(tem);
	}
	console.log(keyValue);
	cab.autocomplete("airportdroparea", keyValue, "taxidropareaairportid");
}

// for package taxi
function getPackagePickupAreaList(cityId,areaName) {
	if(areaName.length>=3){
		var data = JSON.stringify({"formData":{"areaName":areaName,"cityId":cityId}});
		var jsonData = {"formData":data,"__eventid":eventId.get_area_list,"dataType":"json","url":"/c"};
		cab.AJAXCall(jsonData, getPackagePickupAreaResponse);
	}
}
function getPackagePickupAreaResponse(data) {
	var keyValue=[];
	for(i=0;i<data.areaList.length;i++){
		var tem={"label":data.areaList[i].areaName,"value":data.areaList[i].id};
		keyValue.push(tem);
	}
	cab.autocomplete("taxipackagepickuparea", keyValue, "taxipacakgepickupareaid");
}
//taxi per hour area
function getTaxiPerHourAreaList(cityId,areaName) {
	if(areaName.length>=3){
		var data = JSON.stringify({"formData":{"areaName":areaName,"cityId":cityId}});
		var jsonData = {"formData":data,"__eventid":eventId.get_area_list,"dataType":"json","url":"/c"};
		cab.AJAXCall(jsonData, taxiPerHourResponse);
	}
}
function taxiPerHourResponse(data) {
	var keyValue=[];
	for(i=0;i<data.areaList.length;i++){
		var tem={"label":data.areaList[i].areaName,"value":data.areaList[i].id};
		keyValue.push(tem);
	}
	cab.autocomplete("taxiperhourpickupareaid", keyValue, "taxiperhourpickuparea");
}
//for drop area
//for ptop drop area
function getPtopDropAreaList(cityId,areaName){
	if(areaName.length>=3){
		var data = JSON.stringify({"formData":{"areaName":areaName,"cityId":cityId}});
		var JsonData = {"formData":data,"__eventid":eventId.get_area_list,"dataType":"json","url":"/c"};
		cab.AJAXCall(JsonData,getPtopDropAreaListResponse);
	}
}
function getPtopDropAreaListResponse(data){
	var keyValue=[];
	for(var i=0;i<data.areaList.length;i++){
		var tem={"label":data.areaList[i].areaName,"value":data.areaList[i].id};
		keyValue.push(tem);
	}
	if($('#taxiptoppickuparea').val()!=undefined && $('#taxiptoppickuparea').val()!=""){
		keyValue = $.grep(keyValue, function(e) { return e.label!=$('#taxiptoppickuparea').val()});
	}
	cab.autocomplete("taxiptopdroparea", keyValue,"taxiptopdroparea");
}
//for airport drop area
function getDropAreaListAirport(cityId,areaName) {
	if(areaName.length>=3){
		var data = JSON.stringify({"formData":{"areaName":areaName,"cityId":cityId}});
		var JsonData = {"formData":data,"__eventid":eventId.get_area_list,"dataType":"json","url":"/c"};
		cab.AJAXCall(JsonData, getAirportDropAreaListResponse);
	}	
}
function getAirportDropAreaListResponse(data) {
	var keyValue=[];
	for(var i=0;i<data.areaList.length;i++){
		var tem = {"label":data.areaList[i].areaName,"value":data.areaList[i].id};
		keyValue.push(tem);
	}
	console.log(keyValue);
	cab.autocomplete("taxigoingairportpickuparea", keyValue, "taxigoingairportpickupareaid");
}
function addTaxiDetails(formId) {
	var data = JSON.stringify({"formData":cab.getFormJson(formId)});
	//alert("yes in editdata ---->>" + data);
	var JsonData = {"formData":data,"__eventid":eventId.add_taxi_details,"dataType":"json","url":"/c"};
	cab.AJAXCall(JsonData,addTaxiResponse);
}
function addTaxiResponse(resData){
	alert("add taxi res---->>"+JSON.stringify(resData));
}
function addBusDetails(formId) {
	var data = JSON.stringify({"formData":cab.getFormJson(formId)});
	//alert("yes in editdata ---->>" + data);
	var JsonData = {"formData":data,"__eventid":eventId.add_bus_details,"dataType":"json","url":"/c"};
	cab.AJAXCall(JsonData,addBusResponse);
}
function addBusResponse(resData){
	alert("edit res---->>"+JSON.stringify(resData));
}
function addBikeDetails(formId) {
	var data = JSON.stringify({"formData":cab.getFormJson(formId)});
	//alert("yes in editdata ---->>" + data);
	var JsonData = {"formData":data,"__eventid":eventId.add_bike_details,"dataType":"json","url":"/c"};
	cab.AJAXCall(JsonData,addBikeResponse);
}
function addBikeResponse(resData){
	alert("edit res---->>"+JSON.stringify(resData));
}

