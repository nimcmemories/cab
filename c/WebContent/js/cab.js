/**
 * 
 */

var cab={};
cab.contextPath="/c";

cab.AJAXCall = function(data){
	var jsonFormDate = JSON.parse(data);
	$.ajax({
		type: jsonFormDate.method,
		url: cab.contextPath+jsonFormDate.url,
		data: jsonFormDate.query,
		dataType:jsonFormDate.dataType,
		success: function(responseJson) {
			return responseJson;
		},
		error: function (data, status, e){
			return null;
			
		},timeout:30*60*1000
	});		

};
cab.getFormJson=function(data){
	var formId = data;
	return JSON.stringify($("#"+formId+"").serializeArray());
};