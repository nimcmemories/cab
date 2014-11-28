/**
 * 
 */
$( document ).ready(function() {
   console.log( "ready!" );
   alert("----test");
	//ajax
});
$('#addbike').click(function(){
	alert("------");
	$('.createPopup1_Bg').show();
	$('.createPopup_bike').show();
});
$('.close_button').click(function(){
	$('.createPopup1_Bg').fadeOut(300);
	$('.createPopup').fadeOut(500);
	$('.editPopup').fadeOut(500);
	$('.createPopup1_Bg').fadeOut(500);
	$('.createPopup_taxi').fadeOut(500);
	$('.createPopup_bus').fadeOut(500);
	$('.createPopup_bike').fadeOut(100);
});