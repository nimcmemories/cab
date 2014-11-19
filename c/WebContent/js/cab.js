/**
 * 
 */
var cab={};
cab.contextPath="/c";

cab.AJAXCall = function(data,responseFunction){
	
	$.ajax({
		type: data.method,
		url: cab.contextPath+data.url,
		data: data,
		dataType:data.dataType,
		success: function(responseJson) {
			debugger;
			responseFunction(responseJson);
		},
		error: function (data, status, e){
			return null;
			
		},timeout:30*60*1000
	});		

};
cab.getFormJson=function(formId){
	alert(">"+formId+"<");
	return $("#"+formId+"").serializeArray();
};

cab.reloadValidation=function(){
	$.validate({
		modules : 'location, date, security, file',
		onModulesLoaded : function() {
		  $('#country').suggestCountry();
		}
	 });
};