// JavaScript Document
$(document).ready(function (){
    validate();
    $('#txt-pickup, #txt-drop, #txt-date, #txt-time').change(validate);
});
function validate(){
    /*if ($('.pickup').val().length   >   0   &&
        $('.drop').val().length  >   0   &&
		$('#txt-date').val().length  >   0   &&
        $('#txt-time').val().length    >   0) {
        $('input[type="submit"]').removeClass('disabled');
	    $('input[type="submit"]').addClass('info');
        $('input[type="button"]').removeClass('disabled');
	    $('input[type="button"]').addClass('info');
	    $('input[type="submit"]').removeAttr('disabled','disable');
	    $('input[type="button"]').removeAttr('disabled','disable');
    }
    else {
        $('input[type="submit"]').addClass('disabled');
	    $('input[type="submit"]').removeClass('info');
        $('input[type="button"]').addClass('disabled');
	    $('input[type="button"]').removeClass('info');
	    $('input[type="submit"]').attr('disabled','disable');
	    $('input[type="button"]').attr('disabled','disable');
    }*/
}

$('document').ready(function(){	
    /*  Top and Sidebar Tab */
			/* Page Load  */
	window.onload=loading();
	function loading(){
		setTimeout(function(){
			$('#pageloader').css('display','none');
		},1000);
	}	
	$('.topMenu [class^="tab-"] a').click(function(){
		topTabDeactive();
		$(this).addClass('active');
	});
	$('.sideMenu [class^="tab-"] a').click(function(){
		sideTabDeactive();
		$(this).addClass('active');
		$(this).addClass('left');
	});
	/*  Taxi Design  */
	$('.point-to-point').click(function(){
		$('[class^="taxi-"]').hide();
		$('[class^="bus-"]').hide();
		$('.taxi-pop').fadeIn(300);
		$('.bus-pop').fadeIn(300);
	});
	$('.airport').click(function(){
		$('[class^="taxi-"]').hide();
		$('.taxi-airport').fadeIn(300);
		$('.taxi-go_airport').fadeIn(300);
		$('[class^="bus-"]').hide();
		$('.bus-airport').fadeIn(300);
	});
	$('.package').click(function(){
		$('[class^="taxi-"]').hide();
		$('.taxi-package').fadeIn(300);
	});
	$('.outstation').click(function(){
		$('[class^="taxi-"]').hide();
		$('.taxi-outstation').fadeIn(300);
	});
	$('.car-on-rent').click(function(){
		$('[class^="taxi-"]').hide();
		$('.taxi-caronrent').fadeIn(300);
		$('.taxi-per_hours').fadeIn(300);
	});
	$('.taxi-ticket').click(function(){
		$('[class^="taxi-"]').hide();
		$('.taxi-taxiticket').fadeIn(300);
	});
	
	/* Airport Tab */
	$('.airport_tab [class^="tab"] a').click(function(){
		airportTabDeactive();
		$(this).addClass('active');
	});
	$('.airport_tab [class^="tab"] a.go_airport').click(function(){
		$('.taxi-pickup_airport').hide();
		$('.taxi-go_airport').fadeIn(300);
	});
	$('.airport_tab [class^="tab"] a.pick_airport').click(function(){
		$('.taxi-pickup_airport').fadeIn(300);
		$('.taxi-go_airport').hide();
	});
	
	/* Car on rent Tab*/
	$('.caronrent_tab [class^="tab"] a').click(function(){
		caronrentTabDeactive();
		$(this).addClass('active');
	});
	$('.caronrent_tab [class^="tab"] a.per_hours').click(function(){
		$('.taxi-day_wise').hide();
		$('.taxi-per_hours').fadeIn(300);
	});
	$('.caronrent_tab [class^="tab"] a.day_wise').click(function(){
		$('.taxi-day_wise').fadeIn(300);
		$('.taxi-per_hours').hide();
	});
	/* bus Design  */
	$('.busticket').click(function(){
		$('[class^="bus-"]').hide();
		$('.bus-ticket').fadeIn(300);
	});
	$('.busesonrent').click(function(){
		$('[class^="bus-"]').hide();
		$('.bus-on-rent').fadeIn(300);
	});
	/* truck Design  */
	$('.truckpacker').click(function(){
		$('[class^="truck-"]').hide();
		$('.truck-packer').fadeIn(300);
	});
	$('.truckshipping').click(function(){
		$('[class^="truck-"]').hide();
		$('.truck-shipping').fadeIn(300);
	});
	/* bike Design  */
	$('.bikepackage').click(function(){
		$('[class^="bike-"]').hide();
		$('.bike-package').fadeIn(300);
	});
	$('.bikeonrent').click(function(){
		$('[class^="bike-"]').hide();
		$('.bike-on_Rent').fadeIn(300);
		$('.bike-per_hours').fadeIn(300);
		bikeonrentTabDeactive();
		$('.bikeonrent_tab [class^="tab"] a.bike_per_hours').addClass('active');
	});
	$('.bikeonrent_tab [class^="tab"] a').click(function(){
		bikeonrentTabDeactive();
		$(this).addClass('active');
	});
	$('.bikeonrent_tab [class^="tab"] a.bike_per_hours').click(function(){
		$('.bike-day_wise').hide();
		$('.bike-per_hours').fadeIn(300);
	});
	$('.bikeonrent_tab [class^="tab"] a.bike_day_wise').click(function(){
		$('.bike-day_wise').fadeIn(300);
		$('.bike-per_hours').hide();
	});

	
	/*Taxi Left Sidebar
	 For Partner */
	$('.partner-seemore').click(function(){
		if($(this).hasClass('less')){
			document.getElementById('partner-more').innerHTML="See More";
			$('.partner_name').css('max-height','55px');
		    $('.partner-seemore i').addClass('fa-long-arrow-down');
		    $('.partner-seemore i').removeClass('fa-long-arrow-up');
			$('.partner-seemore').removeClass('less');
		}
		else{
			$('.partner_name').css('max-height','inherit');
			$('.partner-seemore i').removeClass('fa-long-arrow-down');
			$('.partner-seemore i').addClass('fa-long-arrow-up');
			$(this).addClass('less');
			document.getElementById('partner-more').innerHTML="Less";
		}
	});
	
	/* For Amenities  */
	$('.amenities-seemore').click(function(){
		if($(this).hasClass('less')){
			document.getElementById('amenities-more').innerHTML="See More";
			$('.amenities-type').css('max-height','58px');
		    $('.amenities-seemore i').addClass('fa-long-arrow-down');
		    $('.amenities-seemore i').removeClass('fa-long-arrow-up');
			$('.amenities-seemore').removeClass('less');
		}
		else{
			$('.amenities-type').css('max-height','inherit');
			$('.amenities-seemore i').removeClass('fa-long-arrow-down');
			$('.amenities-seemore i').addClass('fa-long-arrow-up');
			$(this).addClass('less');
			document.getElementById('amenities-more').innerHTML="Less";
		}
	});
	/* For Taxi type */
	$('.type-taxi-seemore').click(function(){
		if($(this).hasClass('less')){
			document.getElementById('type-taxi-more').innerHTML="See More";
			$('.type-taxi').css('max-height','58px');
		    $('.type-taxi-seemore i').addClass('fa-long-arrow-down');
		    $('.type-taxi-seemore i').removeClass('fa-long-arrow-up');
			$('.type-taxi-seemore').removeClass('less');
		}
		else{
			$('.type-taxi').css('max-height','inherit');
			$('.type-taxi-seemore i').removeClass('fa-long-arrow-down');
			$('.type-taxi-seemore i').addClass('fa-long-arrow-up');
			$(this).addClass('less');
			document.getElementById('type-taxi-more').innerHTML="Less";
		}
	});
});
function topTabDeactive(){
	$('.topMenu [class^="tab-"] a').removeClass('active');
}
function sideTabDeactive(){
	$('.sideMenu [class^="tab-"] a').removeClass('active');
	$('.sideMenu [class^="tab-"] a').removeClass('left');
}
function airportTabDeactive(){
	$('.airport_tab [class^="tab"] a').removeClass('active');
}
function caronrentTabDeactive(){
	$('.caronrent_tab [class^="tab"] a').removeClass('active');
}
function bikeonrentTabDeactive(){
	$('.bikeonrent_tab [class^="tab"] a').removeClass('active');
}


/* Taxi outStation */
var taxiOutRowCount=1;
var busOutRowCount=1;
var noOfBusRow	=[0];
var noOfTaxiRow=[0];
function addTaxiRow(){
	var addrow1="";
	    addrow1='<tr class="taxirow_'+taxiOutRowCount+'">';
        addrow1+='<td><label>To :</label></td>';
        addrow1+='<td><input type="text" placeholder="via city" name="dropcity_'+taxiOutRowCount+'" id="taxioutstationdropcity_'+taxiOutRowCount+'" data-validation="custom" data-validation-regexp="^([a-zA-Z\\s]+)$" data-validation-error-msg="please enter valid via city" onkeyup="getTaxiOutstationDropCity(this.value,'+taxiOutRowCount+')"></td>';
        addrow1+='<td><label class="fa fa-minus-square lm20 fa-lg fg-red" id="'+taxiOutRowCount+'" onclick="removeTaxiRow(this.id)"></label></td>';
        addrow1+='<input type="hidden" id="taxioutstationdropcityid_'+taxiOutRowCount+'" name="taxioutstationdropcityname"></td>';
        addrow1+='</tr>';
		$('.addtexirow').append(addrow1);
		noOfTaxiRow.push(taxiOutRowCount);
		$('#taxirowarray').val(noOfTaxiRow);
		taxiOutRowCount++;
		cab.reloadValidation();
}
function addBusRow(){
	var addrow="";
	    addrow='<tr id=busrowtr_"'+busOutRowCount+'" class="busrow_'+busOutRowCount+'">';
        addrow+='<td><label>To :</label></td>';
        addrow+='<td><input type="text" placeholder="via city" name="dropcity_'+busOutRowCount+'" id="busonrentdropcity_'+busOutRowCount+'" data-validation="custom" data-validation-regexp="^([a-zA-Z\\s]+)$" data-validation-error-msg="please enter valid via city" onkeyup="getBusOnRentDropCityList(this.value,'+busOutRowCount+')"></td>';
        addrow+='<td><label class="fa fa-minus-square lm20 fa-lg fg-red" id="'+busOutRowCount+'" onclick="removeBusRow(this.id)"></label></td>';
        addrow+='<input type="hidden" id="busonrentdropcity_'+busOutRowCount+'" name="busonrentdropcityname"></td>';
        addrow+='</tr>';
		$('.addbusrow').append(addrow);
		noOfBusRow.push(busOutRowCount);
		$('#busrowarray').val(noOfBusRow);
		busOutRowCount++;
		cab.reloadValidation();
}

function removeBusRow(rowId){
	$('.busrow_'+rowId).remove();
		noOfBusRow=jQuery.grep(noOfBusRow, function(value) {
			return value != rowId;
			});
		$('#busrowarray').val(noOfBusRow);
}
function removeTaxiRow(rowId){
	$('.'+rowId).remove();
	$('.taxirow_'+rowId).remove();
	noOfTaxiRow=jQuery.grep(noOfTaxiRow, function(value) {
		return value != rowId;
		});
	$('#taxirowarray').val(noOfTaxiRow);
}
/*  SideBar Menu */

$('document').ready(function(){
	$('.sideMenu-taxi').click(function(){
		topmenuHide();
	  	$('.topmenu-taxi').show();
   	   	$('.taxi-section').show();
		$('[class^="taxi-"]').hide();
		$('.taxi-pop').fadeIn(300);
		$('.topmenu-taxi li a').removeClass('active');	
		$('.topmenu-taxi li:first-child a').addClass('active');	
	});
    $('.sideMenu-bus').click(function(){
		topmenuHide();
		$('[class^="taxi-"]').hide();
		$('[class^="bus-"]').hide();
		$('.topmenu-bus').show();
		$('.bus-section').show();
		$('.bus-ticket').fadeIn(300);
		$('.topmenu-bus li a').removeClass('active');			
		$('.topmenu-bus li:first-child a').addClass('active');		
	});
	$('.sideMenu-truck').click(function(){
		topmenuHide();
		$('[class^="truck-"]').hide();
 	    $('.topmenu-truck').show();
		$('.truck-section').show();	
		$('.truck-packer').fadeIn(300);
	//	$('[class^="truck-"]').hide();	   
		$('.topmenu-truck li a').removeClass('active');					
		$('.topmenu-truck li:first-child a').addClass('active');	
	});
	$('.sideMenu-motorCycle').click(function(){
		topmenuHide();
	    $('.topmenu-motorCycle').show();
		$('[class^="bike-"]').hide();
		$('.bike-section').show();	
		$('.bike-package').fadeIn(300);
//		$('[class^="bike-"]').hide();	   
		$('.topmenu-motorCycle li a').removeClass('active');					
		$('.topmenu-motorCycle li:first-child a').addClass('active');	
	});
});
function topmenuHide(){
	$('.topmenu-taxi').hide();
	$('.topmenu-bus').hide();
	$('.topmenu-truck').hide();
	$('.topmenu-motorCycle').hide();
		
	$('.taxi-section').hide();
	$('.bus-section').hide();
	$('.truck-section').hide();	
	$('.bike-section').hide();	
}
/* End  */


/* Time Picker */
	$(function() {
   		$('.timeformatExample1').timepicker({ 'timeFormat': 'H:i:s', constrainInput: false });
        $('.timeformatExample2').timepicker({ 'timeFormat': 'h:i A' , constrainInput: false});
	});
/* Date Picker  */
	$('.datePairExample').datepicker({
		dateFormat: "dd-mm-yy",
		minDate:new Date(),
		maxDate:"+1w"
	});
//	$('.datePairExample').datepair();