/**
 * 
 */



$(document).ready(function(){

	$("#fp").autocomplete({
		source:'http://localhost:8080/HDProducts/pbpc/fristProperty',
		
		});
	  $("#sp").autocomplete({
		source:'http://localhost:8080/HDProducts/pbpc/secondProperty',
	    });
	
});

