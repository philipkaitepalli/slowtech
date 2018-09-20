/**
 * 
 */


dateBillfind=function(){
	alert('phphphphp....');
	 $.ajax({
		 url:'dateWise',
	data:{dp:$('#datepicker').val()},
	 success: function(response){
		 alert('EMPTY....ppppp.....')	
		 loadDate();
	/*	 if(response.li.length==0){	
	    		alert('EMPTY.........')	
	    	}else{          
	    		alert(' NOT EMPTY.........')	
	    		$('.tr').remove();
	                               for(var i=0;i<(response.li.length);i++){
	                	   $("#table").append("<tr class='tr'><td>"+response.li[i].Id
	                			           +"</td><td> "+response.li[i].billId
	                			           +"</td><td> "+response.li[i].date
	                			           +"</td><td> "+response.li[i].customerId
	                			           +"</td><td> "+response.li[i].carpId
	                  			           +"</td><td> "+response.li[i].billTotal
	                			           +"</td><td> "+response.li[i].paidAmount
	                			           +"</td></tr>"); 
	                               }
	                                               
	    	} */  
     },
     error:function(){
     	alert('..Please fill up all entries with proper values');
     }
				
});
}

loadDate=function(){
	alert('load Date....')
	
	$.ajax({
	    url:'dateWise',
	 
	    success:function(response){
	    	alert("===pp===");
	 	    	
	    	if(response.length==0){	
	    		alert('EMPTY.........')	
	    	}else{          
	    		
	    		$('.tr').remove();
	    		alert(' NOT EMPTY....ppp.....=='+response.length)
	                               for(var i=0;i<(response.length);i++){
	                            	   
	                	   $("#table").append("<tr class='tr'><td>"+response[i].Id
	                			           +"</td><td> "+response[i].billId
	                			           +"</td><td> "+response[i].date
	                			           +"</td><td> "+response[i].customerId
	                			           +"</td><td> "+response[i].carpId
	                  			           +"</td><td> "+response[i].billTotal
	                			           +"</td><td> "+response[i].paidAmount
	                			           +"</td></tr>"); 
	                               }
	                                               
	    	}   
	    },
	    });        
}