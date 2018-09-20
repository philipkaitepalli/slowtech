/**
 * 
 */

 var gtotal=0,obj=0,dt=0,pt=0,bId=0;
var res;

 date=function(){
	 var date=new Date();
	 dt=(date.getMonth()+1)+"/"+date.getDate()+"/"+date.getFullYear();
	$("#printDate").text(dt);
 }
 
 submitx= function(){
	 date();
		var obj={dt:dt,fp:$('#fp').val(),sp:$('#sp').val(),fd:$('#fd').val(),sd:$('#sd').val(),nop:$('#nop').val(),percent:$('#percent').val()};
		 $.ajax({
		        url:'http://localhost:8080/HDProducts/pbpc/getBill',
		        type:'POST',
		        data:obj,
		        success: function(response){
		        	//alert('response='+response.cs[0].sd);
		        	 
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
	
	//alert('response='+res+'  id='+id);
		/*
	    $("#user_id").val(data[index].user_id);
		$("#name").val(data[index].user_name);
		$("#email").val(data[index].email);*/
		
	}
 
 load= function(){
	
		date();
	    $.ajax({
	    url:'http://localhost:8080/HDProducts/pbpc/list',
	    type:'POST',
	    success:function(response){
	 	    	data=response.cs;
	    	if(response.cs.length==0){		
	    	}else{          
	    		$('.tr').remove();
	                               for(var i=0;i<(response.cs.length);i++){
	                	   $("#table").append("<tr class='tr'><td> <a href='#'onclick='delete_("+response.cs[i].pbId+");'>"+0+"</a>"
	        			                  //+"<a href='editProduct?id'onclick='edit("+response.cs[i].pbId+");'>"+(i+1)+"</a>"
	        			                  +"<a href=editProduct?id="+response.cs[i].pbId+">"+(i+1)+"</a>"
	                			           +"</td><td> "+response.cs[i].pStandurdDimension
	                			           +"</td><td> "+response.cs[i].pName
	                			           +"</td><td> "+response.cs[i].pUnitType
	                  			           +"</td><td> "+response.cs[i].fd
	                			           +"</td><td> "+response.cs[i].sd
	                			           +"</td><td> "+response.cs[i].nop
	                			           +"</td><td align='right'> "+response.cs[i].ptotal          
	                			           +"</td></tr>"); 
	                               }
	                               bd=response.bId;
	                               cuid=response.cul;
	                               caid=response.cal;
	                               gtotal=response.gs;
	                                             $("#gtl").html(gtotal); 
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
	url:'http://localhost:8080/HDProducts/pbpc/deleteProduct',
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
	 $("#due").html(gtotal-obj);
	 $("#pmt").html(obj);		 
}

ids=function(){
 	date();
 		var objct={objs:obj,dts:dt};
 	  $.ajax({
         url:'http://localhost:8080/HDProducts/pbpc/bill_Id_GeneratorSave',
         type:'POST',
         data:objct,
         success: function(response){
         	        	load();
         },
         error:function(){
         	alert('errors from idsubmit of preBillProductSearch.js file');
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
 
 
 
 
/*
submit= function(){
	date();
	var obj={fp:$('#fp').val(),sp:$('#sp').val(),fd:$('#fd').val(),sd:$('#sd').val(),nop:$('#nop').val(),percent:$('#percent').val()};
	    $.ajax({
        url:'http://localhost:8080/HDProducts/pbpc/getBill',
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

load= function(){
	date();
	
    $.ajax({
    url:'http://localhost:8080/HDProducts/pbpc/list',
    type:'POST',
    success:function(response){
    	console.log('response='+response);
    	data=response.cs;
    	if(response.cs.length==0){
    		
    	}else{          
    		$('.tr').remove();
                               for(var i=0;i<(response.cs.length);i++){
                	   $("#table").append("<tr class='tr'><td> <a href='#'onclick='delete_("+response.cs[i].pbId+");'>*</a>"
        			                   +"</td><td> <a href='#'onclick='edit("+response.cs[i].pbId+");'>-</a>"
        			                   +"</td><td>"+(i+1)
               			               +"</td><td> "+response.cs[i].pbId
                			           +"</td><td> "+response.cs[i].pStandurdDimension
                			           +"</td><td> "+response.cs[i].pName
                			           +"</td><td> "+response.cs[i].pUnitType
                  			           +"</td><td> "+response.cs[i].fd
                			           +"</td><td> "+response.cs[i].sd
                			           +"</td><td> "+response.cs[i].nop
                			           +"</td><td align='right'> "+response.cs[i].ptotal          
                			           +"</td></tr>"); 
                	  
                               }
                               bd=response.bId;
                               cuid=response.cul;
                               caid=response.cal;
                               gtotal=response.gs;
                                             $("#gtl").html(gtotal); 
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
		url:'http://localhost:8080/HDProducts/pbpc/deleteProduct',
		type:'POST',
		data:{pbId:id},
		success:function(response){
		
			var er=response.err
        	$("#err").html(er); 
						load();
		}				
	});
}

edit = function (id){
	alert('id='+id);
	fd:$("#fd").val(response.cs[id].fd);
	sd:$("#sd").val(response.cs[id].sd);
	nop:$("#nop").val(response.cs[id].nop);
	percent:$("#percent").val(response.cs[id].percent);
	alert('id='+id+'=='+fd+'=='+sd+'=='+nop+'=='+percent);
}

amt=function (){
	
	 obj=$('#pamt').val();
	 $("#due").html(gtotal-obj);
	 $("#pmt").html(obj);
		 
}



idsubmt=function(){
	date();
		var objct={obj,dt};
	  $.ajax({
        url:'http://localhost:8080/HDProducts/pbpc/bill_Id_GeneratorSave',
        type:'POST',
        data:objct,
        success: function(response){
        	        	load();
        },
        error:function(){
        	alert('errors from idsubmit of preBillProductSearch.js file');
        }
    });        
		
}



function printPage(id)
{
	
	idsubmt();
	
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
*/

	
	