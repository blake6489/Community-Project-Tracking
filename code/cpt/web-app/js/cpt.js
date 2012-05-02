//give header the same appearance of jquery tabs, but without the functionality
function createHeader() {
	$('#header').addClass('ui-tabs ui-widget')
	$('#header ul').addClass('ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header')
	$('#header li')
		.addClass('ui-state-default ui-corner-top')
		.mouseover(function(){$(this).addClass('ui-state-hover')})
		.mouseout(function(){$(this).removeClass('ui-state-hover')})
	$('#header a')
		.focus(function(){$(this).closest('li').addClass('ui-state-focus')})
		.blur(function(){$(this).closest('li').removeClass('ui-state-focus')})
		//select tab based on url
		.each(function(){
			if($(this).attr('href').split('/')[2] == location.pathname.split('/')[2])
				$(this).closest('li').addClass('ui-tabs-selected ui-state-active')
	})
}

//style jquery ui onready
$(function(){
	createHeader()
	$('.jq-button').button()
	$('.jq-date').datepicker({changeMonth:true, changeYear:true})
	$('.jq-active-button').button().unbind().addClass('ui-state-active')
	$('.read .w').addClass('ui-helper-hidden')
	$('.write .r').addClass('ui-helper-hidden')
	$('.rwbutton').click(function(event) {
		$(event.target).closest('.read, .write').find('.r, .w').toggleClass('ui-helper-hidden')
	});
});