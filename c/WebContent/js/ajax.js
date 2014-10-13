/**
 * Nitin Vavdiya
 */
var cab={};
cab.contextPath="/c";

cab.AJAXCall = function(data){
	alert(JSON.stringify(data));
	var enetId = jsonFormData.eventId;
	$.ajax({
		type: data.method,
		url: cab.contextPath+data.url,
		data: data.formData,
		dataType:data.dataType,
		success: function(responseJson) {
			return responseJson;
		},
		error: function (data, status, e){
			return null;
			
		},timeout:30*60*1000
	});		

};