// JavaScript Document

$('document').ready(function(){
	/* Page Load  */
	window.onload=loading();
	function loading(){
		setTimeout(function(){
			$('#pageloader').css('display','none');
		},1000);
	}		
	/* Pop up Form */
	$('.create_row').click(function(){
		$('.createPopup_Bg').fadeIn(50);
		$('.createPopup').fadeIn(100);
	});
	$('.close_button').click(function(){
		$('.createPopup_Bg').fadeOut(300);
		$('.createPopup').fadeOut(500);
		$('.editPopup').fadeOut(500);
	});
	$('.createPopup_Bg').click(function(){
		$(this).fadeOut(300);
		$('.createPopup').fadeOut(500);
		$('.editPopup').fadeOut(100);
	});

	$('.edit_button').click(function(){
		$('.createPopup_Bg').fadeIn(50);
		$('.editPopup').fadeIn(100);
	});
	
	/* Table Button Click Events */
	
	$('.edit_button').click(function(){
		
	});
	$('.delete_button').click(function(){
		
	//	if(selectedrow){
			confiirm_string="Are you sure you want to delete selected records ?";
			var delete_row=confirm(confiirm_string);
			if(delete_row){
				//alert(selectedrow);
				$(this).parent('a').parent('[class^="DyGrid-td"]').parent('.table_row').remove();
			}
		//}
	});
	$('#check_all').click(function(){
		  if($(this).is(":checked")){
			$('.checkbox').prop('checked', true);
		  }else{
			$('.checkbox').prop('checked', false);
		  }
	});
	$('.checkbox').click(function(){
		if($(this).is(":checked")){
			//$('#check_all').prop('checked', true);
		  }else{
			$('#check_all').prop('checked', false);
	    }
	});
});
function multidelete(){
//	$(document).ready(function() {     
		var selectedrow="";   
		$(".checkbox").each(function(){
			if(this.checked == true){
				selectedrow +="'"+$(this).val()+"',";
			}
			
		});
		if(selectedrow){
			confiirm_string="Are you sure you want to delete selected records ?";
			var ans=confirm(confiirm_string);
			if(ans){
				alert(selectedrow);
			}
		}
//	});
}



