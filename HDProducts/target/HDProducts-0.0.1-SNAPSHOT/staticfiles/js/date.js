/**
 * 
 */

  $( function() {
	 var date = new Date();
	    var currentMonth = date.getMonth();
	    var currentDate = date.getDate();
	    var currentYear = date.getFullYear();

    $( "#datepicker" ).datepicker({
        minDate: new Date(currentDate, currentMonth, currentYear),
       dateFormat:"d/m/yy"
    });
  } );
 
  
  