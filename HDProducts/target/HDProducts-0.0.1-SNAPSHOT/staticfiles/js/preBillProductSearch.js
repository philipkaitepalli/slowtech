/**
 * 
 */

 var gtotal=0,obj=0,dt=0,pt=0,bId=0;
var res;

 date=function(){
	 var date=new Date();

	dt=date.getDate()+"/"+(date.getMonth()+1)+"/"+date.getFullYear();
	$("#printDate").text(dt);
 }
 
 submitx= function(){
	
	 date();
		var obj={dt:dt,fp:$('#fp').val(),sp:$('#sp').val(),fd:$('#fd').val(),sd:$('#sd').val(),nop:$('#nop').val(),percent:$('#percent').val()};
		 $.ajax({
		       
			      url:'getBill',
		        type:'POST',
		        data:obj,
		        success: function(response){
		      
		        	 
		        	var er=response.err
		        	$("#err").html(er); 
		        	        	load();
		        },
		        error:function(){
		        	alert('Please fill up all entries with proper values');
		        }
		    }); 
	}
 
edit = function (id){
	
	alert('response='+id);
		
	}
 
 load= function(){
	    date();
	    $.ajax({
	    url:'list',
	    type:'POST',
	    success:function(response){
	 	    	data=response.cs;
	    	if(response.cs.length==0){		
	    	}else{          
	    		$('.tr').remove();
	                               for(var i=0;i<(response.cs.length);i++){
	                	   $("#table").append("<tr class='tr'><td> <a href='#'onclick='delete_("+response.cs[i].pbId+");'>"+0+"</a>"
	                			         
	        			                  // +"<a href='editProduct?id'onclick='edit("+response.cs[i].pbId+");'>"+(i+1)+"</a>"
	        			                  +"<a href=editProduct?id="+response.cs[i].pbId+">"+(i+1)+"</a>"
	                			           +"</td><td> "+response.cs[i].pStandurdDimension
	                			           +"</td><td> "+response.cs[i].pName
	                			           +"</td><td> "+response.cs[i].pUnitType
	                  			           +"</td><td> "+response.cs[i].fd
	                			           +"</td><td> "+response.cs[i].sd
	                			           +"</td><td> "+response.cs[i].nop
	                			           +"</td><td align='right'> "+response.cs[i].ptotal.toFixed(2)          
	                			           +"</td></tr>"); 
	                               }
	                               bd=response.bId;
	                               cuid=response.cul;
	                               caid=response.cal;
	                               gtotal=response.gs;
	                                             $("#gtl").html((gtotal).toFixed(2)); 
	                                             $("#bId").html(bd);
	                                             $("#caId").html(caid);
	                                             $("#cuId").html(cuid);
	                                             $("#printDate").html(dt);                  
	    	}   
	    },
	    });        
	}

 
 

 delete_=function(id){
	 $.ajax({
		 url:'deleteProduct',
	type:'POST',
	data:{pbId:id},
	success:function(response){
		var er=response.err
    	$("#err").html(er); 
					load();
	}				
});
}
 
 amt=function (){
		
	 obj=$('#pamt').val();
	 $("#due").html((gtotal-obj).toFixed( 2 ));
	 $("#pmt").html(obj);		 
}

ids=function(){
 	date();
 		var objct={objs:obj,dts:dt};
 	  $.ajax({
 		url:'bill_Id_GeneratorSave',
         type:'POST',
         data:objct,
         success: function(response){
         	        	load();
         },
         error:function(){
         	alert('This Bill is already submited, you can not do it again, by the same Bill_Id...');
         }
     });      
 		
 }
 function printPage(id)
 {
  	ids();
    var html="<html>";
    html+= document.getElementById(id).innerHTML;
    html+="</html>";
    var printWin = window.open('','','left=0,top=0,width=800,height=1700,toolbar=0,scrollbars=0,status=0');
    printWin.document.write(html);
    printWin.document.close();
    printWin.focus();
    printWin.print();
    printWin.close(); 
    
 }
 
 
 
 

	
	