/**
 * 
 */




var j=1;
var gtotal=0;

submit = function(){
	var obj={date:$("#date").val(),fp:$("#fp").val(),sp:$('#sp').val(),fd:$('#fd').val(),sd:$('#sd').val(),nop:$('#nop').val(),percent:$('#percent').val()};
   
    $.ajax({
        url:'xxxx',
        type:'POST',
        data:obj,
        success: function(response){
        	if(response.pds.length==0){
        		alert('You can not find this');
        	}else{          
                                   for(i=0;i<response.pds.length;i++){
                    	   $("#table").append("<tr><td>"+j
                   			               +"</td><td> "+response.pds[i].pId
                    			           +"</td><td> "+response.pds[i].pStandurdDimension
                    			           +"</td><td> "+response.pds[i].pName
                    			           +"</td><td> "+response.pds[i].pUnitType
                      			           +"</td><td> "+response.cs.fd
                    			           +"</td><td> "+response.cs.sd
                    			           +"</td><td> "+response.cs.nop
                    			           +"</td><td> "+response.cs.total.toFixed(2)
                    			           +"</td></tr>"); 
                    	   gtotal=gtotal+response.cs.total;
                                   }
                                   var rgt=gtotal.toFixed(2);
                                   $("#gtotal").html(rgt); 
                         j++; 
        	}   
        },
        error:function(){
        	alert('Please fill up all entries with proper values');
        }
    });        
}


