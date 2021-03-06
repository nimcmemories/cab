/**
 * 
 */
//all funaction relating to index.html file goes here
//name should be proper
//set city drop down
$( document ).ready(function() {
   //console.log( "ready!" );
	
	//getCityList();
	setAirportList();
	setTaxiPackageList();
	//setBikePackage();
	setBusType();
	getBusTypeInRent();
});
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


function getCityList(){
	var data = JSON.stringify({"__eventid":eventId.get_city_list});
	var JsonData={"formData":data,"__eventid":eventId.get_city_list,"dataType":"json","url":"/c"};
	cab.AJAXCall(JsonData,getCityListResponse);
}
function getCityListResponse(cityData){
	cab.generateselect("taxiptopcity",cityData.cityArray);
}
// for taxi ticket pickupcity list
function getTaxiTicketPickCityList(cityName) {
	if(cityName.length>=3){
		var data = JSON.stringify({"formData":{"cityName":cityName}});
		var JsonData = {"formData":data,"__eventid":eventId.get_city_list,"dataType":"json","url":"/c"};
		cab.AJAXCall(JsonData, getTaxiTicketPickCityResponse);
	}
}
function getTaxiTicketPickCityResponse(data) {
	var keyValue=[];
	for(var i=0;i<data.cityArray.length;i++){
		var tem={"label":data.cityArray[i].name,"value":data.cityArray[i].id};
		keyValue.push(tem);
	}
	if($('#taxiticketdropcity').val()!=undefined && $('#taxiticketdropcity').val()!=""){
		keyValue = $.grep(keyValue, function(e){ return e.label!=$('#taxiticketdropcity').val()});
	}
	cab.autocomplete("taxiticketpickupcity", keyValue, "taxiticketpickupcityid");
}
//for taxiticket drop city
function getTaxiTicketDropCityList(cityName) {
	if(cityName.length>=3){
		var data = JSON.stringify({"formData":{"cityName":cityName}});
		var JsonData = {"formData":data,"__eventid":eventId.get_city_list,"dataType":"json","url":"/c"};
		cab.AJAXCall(JsonData, getTaxiTicketDropCityResponse);
	}
}
function getTaxiTicketDropCityResponse(data) {
	var keyValue=[];
	for(var i=0;i<data.cityArray.length;i++){
		var tem={"label":data.cityArray[i].name,"value":data.cityArray[i].id};
		keyValue.push(tem);
	}
	if($('#taxiticketpickupcity').val()!=undefined && $('#taxiticketpickupcity').val()!=""){
		keyValue = $.grep(keyValue, function(e){ return e.label!=$('#taxiticketpickupcity').val()});
	}
	cab.autocomplete("taxiticketdropcity", keyValue, "taxiticketdropcityid")
}
//for outstation from city
function getTaxiOutstationPickCity(cityName) {
	if(cityName.length>=3){
		var data = JSON.stringify({"formData":{"cityName":cityName}});
		var JsonData = {"formData":data,"__eventid":eventId.get_city_list,"dataType":"json","url":"/c"};
		cab.AJAXCall(JsonData, getTaxiOutstationPickCityResponse);
	}
}
var rowCount=0;
function getTaxiOutstationPickCityResponse(data) {
	var keyValue=[];
	for(var i=0;i<data.cityArray.length;i++){
		var tem={"label":data.cityArray[i].name,"value":data.cityArray[i].id};
		keyValue.push(tem);
	}
	var tmp=noOfTaxiRow;
	for(var i=0;i<tmp.length;i++){
		if($('#taxioutstationdropcity_'+tmp[i]).val()!=undefined && $('#taxioutstationdropcity_'+tmp[i]).val()!=""){
			keyValue = $.grep(keyValue, function(e){ return e.label.replace(" ","")!=$('#taxioutstationdropcity_'+tmp[i]).val().replace(" ","")});
		}
	}
	cab.autocomplete("taxioutstationpickupcity", keyValue, "taxioutstationpickupcityid")
}
//for bus on rent pickcity
function getBusOnRentPickCityList(cityName) {
	if(cityName.length>=3){
		var data = JSON.stringify({"formData":{"cityName":cityName}});
		var JsonData = {"formData":data,"__eventid":eventId.get_city_list,"dataType":"json","url":"/c"};
		cab.AJAXCall(JsonData, getBusOnRentPickCityResponse);
	}
}
var busRowCount=0;
function getBusOnRentPickCityResponse(data) {
	var keyValue=[];
	for(var i=0;i<data.cityArray.length;i++){
		var tem={"label":data.cityArray[i].name,"value":data.cityArray[i].id};
		keyValue.push(tem);
	}
	var tmp=noOfBusRow;
	for (var i = 0; i < tmp.length; i++) {
	if($('#busonrentdropcity_'+tmp[i]).val()!=undefined && $('#busonrentdropcity_'+tmp[i]).val()!=""){
		keyValue = $.grep(keyValue, function(e){ return e.label.replace(" ","")!=$('#busonrentdropcity_'+tmp[i]).val().replace(" ","")});
		}
	}
	cab.autocomplete("busonrentfromcity", keyValue, "busonrentpickupcityid");
}
//for bus on rent to(destination) city
function getBusOnRentDropCityList(cityName,count) {
	busRowCount=count;
	if(cityName.length>=3)
	var data = JSON.stringify({"formData":{"cityName":cityName}});
	var JsonData = {"formData":data,"__eventid":eventId.get_city_list,"dataType":"json","url":"/c"};
	cab.AJAXCall(JsonData, getBusOnRentDropCityListResponse);
}
function getBusOnRentDropCityListResponse(data) {
	var keyValue=[];
	for (var i = 0; i < data.cityArray.length; i++) {
		var tem={"label":data.cityArray[i].name,"value":data.cityArray[i].id};
		keyValue.push(tem);
	}
	if($('#busonrentfromcity').val()!=undefined && $('#busonrentfromcity').val()!=""){
		keyValue = $.grep(keyValue, function(e){ return e.label.replace(" ","")!=$('#busonrentfromcity').val().replace(" ","")});
	}
	var tmp=noOfBusRow;
	for(var i=0;i<tmp.length;i++){
		if(tmp[i]==busRowCount){
			continue;
		}else{
			if($('#busonrentdropcity_'+tmp[i]).val()!=undefined && $('#busonrentdropcity_'+tmp[i]).val()!=""){
				keyValue = $.grep(keyValue, function(e){ return e.label!=$('#busonrentdropcity_'+tmp[i]).val()});
			}
		}
	}
	cab.autocomplete("busonrentdropcity_"+busRowCount, keyValue, "busonrentdropcityid_0"+busRowCount);
}

//for oustation to drop city
var taxiRowCount=0;
function getTaxiOutstationDropCity(cityName,count) {
	taxiRowCount=count;
	if(cityName.length>=3){
		var data = JSON.stringify({"formData":{"cityName":cityName}});
		var JsonData = {"formData":data,"__eventid":eventId.get_city_list,"dataType":"json","url":"/c"};
		cab.AJAXCall(JsonData, getTaxiOutstationDropCityResponse);
	}
}
function getTaxiOutstationDropCityResponse(data) {
	var keyValue=[];
	for(var i=0;i<data.cityArray.length;i++){
		var tem={"label":data.cityArray[i].name,"value":data.cityArray[i].id};
		keyValue.push(tem);
	}
	if($('#taxioutstationpickupcity').val()!=undefined && $('#taxioutstationpickupcity').val()!=""){
		keyValue = $.grep(keyValue, function(e){ return e.label.replace(" ","")!=$('#taxioutstationpickupcity').val().replace(" ","")});
	}
	var tmp=noOfTaxiRow;
	for(var i=0;i<tmp.length;i++){
		if(tmp[i]==taxiRowCount){
			continue;
		}else{
			if($('#taxioutstationdropcity_'+tmp[i]).val()!=undefined && $('#taxioutstationdropcity_'+tmp[i]).val()!=""){
				keyValue = $.grep(keyValue, function(e){ return e.label!=$('#taxioutstationdropcity_'+tmp[i]).val()});
			}
		}
	}
	cab.autocomplete("taxioutstationdropcity_"+taxiRowCount, keyValue, "taxioutstationdropcityid_"+taxiRowCount);
}
//for bus ticket from city
function getBusTicketPickCityList(cityName) {
	if(cityName.length>=3){
		var data = JSON.stringify({"formData":{"cityName":cityName}});
		var JsonData = {"formData":data,"__eventid":eventId.get_city_list,"dataType":"json","url":"/c"};
		cab.AJAXCall(JsonData, getBusTicketPickCityResponse);
	}
}
function getBusTicketPickCityResponse(data) {
	var keyValue=[];
	for(var i=0;i<data.cityArray.length;i++){
		var tem={"label":data.cityArray[i].name,"value":data.cityArray[i].id};
		keyValue.push(tem);
	}
	if($('#busticketdropcity').val()!=undefined && $('#busticketdropcity').val()!=""){
		keyValue = $.grep(keyValue, function(e){ return e.label!=$('#busticketdropcity').val()});
	}
	cab.autocomplete("busticketpickupcity", keyValue, "busticketpickupcityid");
}
//for bus ticket drop city
function getBusTicketDropCityList(cityName) {
	if(cityName.length>=3){
		var data = JSON.stringify({"formData":{"cityName":cityName}});
		var JsonData = {"formData":data,"__eventid":eventId.get_city_list,"dataType":"json","url":"/c"};
		cab.AJAXCall(JsonData, getBusTicketDropCityResponse);
	}
}
function getBusTicketDropCityResponse(data) {
	var keyValue=[];
	for(var i=0;i<data.cityArray.length;i++){
		var tem={"label":data.cityArray[i].name,"value":data.cityArray[i].id};
		keyValue.push(tem);
	}
	if($('#busticketpickupcity').val()!=undefined && $('#busticketpickupcity').val()!=""){
		keyValue = $.grep(keyValue, function(e){ return e.label!=$('#busticketpickupcity').val()});
	}
	cab.autocomplete("busticketdropcity", keyValue, "busticketdropcityid");
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
//for bike pickup area per hour
function getBikePerHourAreaList(cityId,areaName){
	if(areaName.length>=3){
		var data = JSON.stringify({"formData":{"areaName":areaName,"cityId":cityId}});
		var JsonData = {"formData":data,"__eventid":eventId.get_area_list,"dataType":"json","url":"/c"};
		cab.AJAXCall(JsonData,getBikePerHourAreaListResponse);
	}
}
function getBikePerHourAreaListResponse(data){
	var keyValue=[];
	for(var i=0;i<data.areaList.length;i++){
		var tem={"label":data.areaList[i].areaName,"value":data.areaList[i].id};
		keyValue.push(tem);	
	}
	if($('#bikeperhourdropcity').val()!=undefined && $('#bikeperhourdropcity').val()!=""){
		keyValue = $.grep(keyValue, function(e) { return e.label!=$('#bikeperhourdropcity').val()});
	}
	cab.autocomplete("bikeperhourpickupcity", keyValue,"bikeperhourpickupcityid");
}
//for bike pickup area per day
function getBikePerDayPicKAreaList(cityId,areaName){
	if(areaName.length>=3){
		var data = JSON.stringify({"formData":{"areaName":areaName,"cityId":cityId}});
		var JsonData = {"formData":data,"__eventid":eventId.get_area_list,"dataType":"json","url":"/c"};
		cab.AJAXCall(JsonData,getBikePerDayPickAreaListResponse);
	}
}
function getBikePerDayPickAreaListResponse(data){
	var keyValue=[];
	for(var i=0;i<data.areaList.length;i++){
		var tem={"label":data.areaList[i].areaName,"value":data.areaList[i].id};
		keyValue.push(tem);	
	}
	if($('#bikeperdaydropcity').val()!=undefined && $('#bikeperdaydropcity').val()!=""){
		keyValue = $.grep(keyValue, function(e) { return e.label!=$('#bikeperdaydropcity').val()});
	}
	cab.autocomplete("bikeperdaypickupcity", keyValue,"bikeperdaypickupcityid");
}
//for drop area
//for bike drop area per hour
function getBikePerHourDropAreaList(cityId,areaName){
	if(areaName.length>=3){
		var data = JSON.stringify({"formData":{"areaName":areaName,"cityId":cityId}});
		var JsonData = {"formData":data,"__eventid":eventId.get_area_list,"dataType":"json","url":"/c"};
		cab.AJAXCall(JsonData,getBikePerHourDropAreaListResponse);
	}
}
function getBikePerHourDropAreaListResponse(data){
	var keyValue=[];
	for(var i=0;i<data.areaList.length;i++){
		var tem={"label":data.areaList[i].areaName,"value":data.areaList[i].id};
		keyValue.push(tem);	
	}
	if($('#bikeperhourpickupcity').val()!=undefined && $('#bikeperhourpickupcity').val()!=""){
		keyValue = $.grep(keyValue, function(e) { return e.label!=$('#bikeperhourpickupcity').val()});
	}
	cab.autocomplete("bikeperhourdropcity", keyValue,"bikeperhourdropcityid");
}
//for bike drop area per day
function getBikePerDayDropAreaList(cityId,areaName){
	if(areaName.length>=3){
		var data = JSON.stringify({"formData":{"areaName":areaName,"cityId":cityId}});
		var JsonData = {"formData":data,"__eventid":eventId.get_area_list,"dataType":"json","url":"/c"};
		cab.AJAXCall(JsonData,getBikePerDayAreaListResponse);
	}
}
function getBikePerDayAreaListResponse(data){
	var keyValue=[];
	for(var i=0;i<data.areaList.length;i++){
		var tem={"label":data.areaList[i].areaName,"value":data.areaList[i].id};
		keyValue.push(tem);	
	}
	if($('#bikeperdaypickupcity').val()!=undefined && $('#bikeperdaypickupcity').val()!=""){
		keyValue = $.grep(keyValue, function(e) { return e.label!=$('#bikeperdaypickupcity').val()});
	}
	cab.autocomplete("bikeperdaydropcity", keyValue,"bikeperdaydropcityid");
}

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
//for setAirportList
function setAirportList(){
	var data = JSON.stringify({"formData":{"cityId":$('#taxiairportcity').val()}});
	var JsonData = {"formData":data,"__eventid":eventId.get_airport_list,"dataType":"json","url":"/c"};
	cab.AJAXCall(JsonData,setAirportListResponse);
}
function setAirportListResponse(data){
	cab.generateselect("gotoairportname",data.airportList);
}
//for taxi package selectbox
function setTaxiPackageList() {
	var data = JSON.stringify({"formData":{"name":name}});
	var JsonData = {"formData":data,"__eventid":eventId.get_taxi_package_list,"dataType":"json","url":"/c"};
	cab.AJAXCall(JsonData, taxiPackageResponse);
}
function taxiPackageResponse(data) {
	cab.generateselect("taxipackage",data.packageList);
}
//truck pickup city in packers/movers
function truckPackerFromCity(cityName) {
	if(cityName.length>=3){
	var data=JSON.stringify({"formData":{"cityName":cityName}});
	var JsonData={"formData":data,"__eventid":eventId.get_city_list,"dataType":"json","url":"/c"};
	cab.AJAXCall(JsonData, truckPackerFromCityResponse);
	}
}
function truckPackerFromCityResponse(data) {
	var keyValue=[];
	for(var i=0;i<data.cityArray.length;i++){
		var tem={"label":data.cityArray[i].name,"value":data.cityArray[i].id};
		keyValue.push(tem);
	}
	if($('#truckpackerdropcity').val()!=undefined && $('#truckpackerdropcity').val()!=""){
		keyValue = $.grep(keyValue, function(e){ return e.label!=$('#truckpackerdropcity').val()});
	}
	cab.autocomplete("truckpackerpickupcity", keyValue, "truckpackerpickupcityid");
}
//truck drop city in packers/movers
function truckPackerToCity(cityName) {
	if(cityName.length>=3){
		var data=JSON.stringify({"formData":{"cityName":cityName}});
		var JsonData={"formData":data,"__eventid":eventId.get_city_list,"dataType":"json","url":"/c"};
		cab.AJAXCall(JsonData, truckPackerToCityResponse);
		}
	}
function truckPackerToCityResponse(data) {
		var keyValue=[];
		for(var i=0;i<data.cityArray.length;i++){
			var tem={"label":data.cityArray[i].name,"value":data.cityArray[i].id};
			keyValue.push(tem);
		}
		if($('#truckpackerpickupcity').val()!=undefined && $('#truckpackerpickupcity').val()!=""){
			keyValue = $.grep(keyValue, function(e){ return e.label!=$('#truckpackerpickupcity').val()});
		}
		cab.autocomplete("truckpackerdropcity", keyValue, "truckpackerdropcityid");
}
//truck from city in shipping 
function truckFromCityShipping(cityName) {
	if(cityName.length>=3){
		var data=JSON.stringify({"formData":{"cityName":cityName}});
		var JsonData={"formData":data,"__eventid":eventId.get_city_list,"dataType":"json","url":"/c"};
		cab.AJAXCall(JsonData, truckShippingFromCityResponse);
		}
	}
function truckShippingFromCityResponse(data) {
		var keyValue=[];
		for(var i=0;i<data.cityArray.length;i++){
			var tem={"label":data.cityArray[i].name,"value":data.cityArray[i].id};
			keyValue.push(tem);
		}
		if($('#truckshippingdropcity').val()!=undefined && $('#truckshippingdropcity').val()!=""){
			keyValue = $.grep(keyValue, function(e){ return e.label!=$('#truckshippingdropcity').val()});
		}
		cab.autocomplete("truckshippingpickupcity", keyValue, "truckshippingpickupcityid");
}
//truck from drop in shipping 
function truckToCityShipping(cityName) {
		if(cityName.length>=3){
			var data=JSON.stringify({"formData":{"cityName":cityName}});
			var JsonData={"formData":data,"__eventid":eventId.get_city_list,"dataType":"json","url":"/c"};
			cab.AJAXCall(JsonData, truckShippingToCityResponse);
			}
}
function truckShippingToCityResponse(data) {
			var keyValue=[];
			for(var i=0;i<data.cityArray.length;i++){
				var tem={"label":data.cityArray[i].name,"value":data.cityArray[i].id};
				keyValue.push(tem);
			}
			if($('#truckshippingpickupcity').val()!=undefined && $('#truckshippingpickupcity').val()!=""){
				keyValue = $.grep(keyValue, function(e){ return e.label!=$('#truckshippingpickupcity').val()});
			}
			cab.autocomplete("truckshippingdropcity", keyValue, "truckshippingdropcityid");
}
//bike package selectbox
function setBikePackage() {
	var data = JSON.stringify({"formData":{"name":name}});
	var JsonData = {"formData":data,"__eventid":eventId.get_bike_package_list,"dataType":"json","url":"/c"};
	cab.AJAXCall(JsonData, bikePackageResponseFunction)
}
function bikePackageResponseFunction(data) {
	cab.generateselect("bikepackage",data.bikePackageList);
}
//for bus type in bus ticket
function setBusType(){
	var data = JSON.stringify({"formData":{"name":name}});
	var JsonData = {"formData":data,"__eventid":eventId.get_bus_type_list,"dataType":"json","url":"/c"};
	cab.AJAXCall(JsonData, setBusTypeResponse);
}
function setBusTypeResponse(data) {
	cab.generateselect("busticketbustype", data.busPackageList);
}
//for bus type in bus on rent
function getBusTypeInRent(){
	var data = JSON.stringify({"formData":{"name":name}});
	var JsonData = {"formData":data,"__eventid":eventId.get_bus_type_list_InRent,"dataType":"json","url":"/c"};
	cab.AJAXCall(JsonData, setBusTypeInRentResponse);
}
function setBusTypeInRentResponse(data) {
	cab.generateselect("busonrentbustype", data.busRentPackageList);
}