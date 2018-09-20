/**
 * 
 */


$(document).ready(function(){
	
	$("#cfn").autocomplete({
		source:'/HDProducts/pbpc/custFirstName',
		});
	  $("#cln").autocomplete({
		source:'/HDProducts/pbpc/custLastName',
		});
	  $("#cafn").autocomplete({
		  source:'carpFirstName',
			});
		  $("#caln").autocomplete({
			source:'carpLastName',
		    }); 
 
});