function activate(pos) {
	$('.active').removeClass('active');
	$('#tabmenu li').eq(pos).find('a').addClass('active');
	return false;
}

function hideTab(pos) {
	$('#tabmenu li').eq(pos).find('a').hide();
	return false;
}

function showTab(pos) {
	$('#tabmenu li').eq(pos).find('a').show();
	return false;
}

function showOpaque(divId) {
	/*
	 * $(divId).show('fast').animate({opacity: '+=0'}, 2500).hide('fast');
	 * $(divId).fadeIn('fast').animate({opacity: '+=0'}, 2500).fadeOut('slow');
	 */
	if (divId == "success"){
		$('#opaque').show(0).animate({opacity: '+=0'}, 2500).hide(1);
		$("#" + divId).show(0).animate({opacity: '+=0'}, 2500).hide(1);
	} else {	
		$('#opaque').css('display', 'inline');
		$("#" + divId).fadeIn(1);
	}
}

function hideOpaque() {
	$('#opaque').css('display', 'none');
	$('#success').css('display', 'none');
	$('#error').css('display', 'none');
}

/* Make a zebra table */
$(document).ready(function(){
	
  var hasCoBorrower = $('#hasCoborrower:checked').val();
  if (hasCoBorrower == 'true')
	  $('#divCoBorrower').show('fast');

	
    $('.stripeMe tr').mouseover(function(){
         $(this).addClass("over");        
    }); 
    $('.stripeMe tr').mouseout(function(){
        $(this).removeClass("over");        
   }); 
    $('.stripeMe tr:even').addClass('alt'); 
 });
