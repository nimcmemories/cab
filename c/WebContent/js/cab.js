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
cab.autocomplete=function(feildId,data,hiddenFeildId){
	//data=[{label:"nitin",value:"nitin"}]
	console.log("1");
	$("#"+feildId).autocomplete({
	      source: data,
	      select: function( event, ui ) {
	    	  if($('#'+hiddenFeildId).val()!=undefined){
	    		  $('#'+hiddenFeildId).val(ui.item.value)
	    	  }
	    	  event.preventDefault();
	    	  $(this).val(ui.item.label);
	      },
	      focus: function(event, ui) {	
	          event.preventDefault();
	          $(this).val(ui.item.label);
	      },
	      change: function(event,ui){
	    	  if(ui.item==undefined){
	    		  $(this).val("");
		    	  $(this).focus();
	    	  }
	    }
	});
	
};
cab.generateselect=function(fieldId,data){
	//data=[{id:"nitin",name:"nitin"}]
	 $.each(data, function(key, value) {
         $("#"+fieldId).append($('<option></option>').val(value.id).html(value.name));
     });
};