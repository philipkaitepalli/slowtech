/**
 * deitVoucher.js
 */


$(document).ready(function(){
	
	$("#dcfn").autocomplete({
		source:'custFirstName',
		});
	  $("#dcln").autocomplete({
		source:'custLastName',
	    });
});