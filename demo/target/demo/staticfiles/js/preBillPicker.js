/**
 * 
 */


$(document).ready(function(){
	
	$("#cfn").autocomplete({
		source:'http://localhost:8080/HDProducts/pbpc/custFirstName',
		});
	  $("#cln").autocomplete({
		source:'http://localhost:8080/HDProducts/pbpc/custLastName',
	    });
	  $("#cafn").autocomplete({
			source:'http://localhost:8080/HDProducts/pbpc/carpFirstName',
			});
		  $("#caln").autocomplete({
			source:'http://localhost:8080/HDProducts/pbpc/carpLastName',
		    }); 
 
});