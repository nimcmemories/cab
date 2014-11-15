/**
 * 
 */
var cab={};
cab.contextPath="/c";

cab.AJAXCall = function(data){
alert("inside ajax ccall data---->"+data);
	
	$.ajax({
		type: data.method,
		url: cab.contextPath+data.url,
		data: data,
		dataType:data.dataType,
		success: function(responseJson) {
			return responseJson;
		},
		error: function (data, status, e){
			return null;
			
		},timeout:30*60*1000
	});		

};
cab.getFormJson=function(formId){
	alert(">"+formId+"<");
	return JSON.stringify($("#"+formId+"").serializeArray());
};

cab.reloadValidation=function(){
	$.validate({
		modules : 'location, date, security, file',
		onModulesLoaded : function() {
		  $('#country').suggestCountry();
		}
	 });
};