/**
 * 
 */

function checkLogin(formId){
	//alert(formId)
	if($('#'+formId).isValid()){
		var data = JSON.stringify({"formData":cab.getFormJson(formId)});
		var JsonData = {"formData":data,"__eventid":eventId.partner_login,"dataType":"json","url":"/c"};
		//console.log(cityId+"---"+areaName);
		cab.AJAXCall(JsonData, checkLoginResponse);
	}
}
function checkLoginResponse(data){
	alert(JSON.stringify(data)+"====");
	$(location).attr('href', cab.contextPath+"/partner/partnerhome.html");
	
}