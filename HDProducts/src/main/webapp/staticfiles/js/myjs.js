/**
 * 
 */



  var i=0,j=1;
  var Due=0,pa=0,Dis=0;
  data = "";
  
  
  
  
  alert('sdAndName.js....');
    submit = function(){
    	
            $.ajax({
                url:'billingById',
                type:'POST',
                data:{pId:$("#pId").val(),fd:$('#fd').val(),sd:$('#sd').val(),nop:$('#nop').val()},
                success: function(response){
                	
                                           console.log(response);
                                           $("#error").html(response.s);
                            	   $("#table").append("<tr><td>"+j
                           			           +"</td><td> "+response.pds.pId
                            			          
                            			           +"</td><td> "+response.pds.pStandurdDimension
                            			           +"</td><td> "+response.pds.pName
                            			           +"</td><td> "+response.pds.pUnitType
                            			          
                            			           +"</td><td> "+response.cs.fd
                            			           +"</td><td> "+response.cs.sd
                            			           +"</td><td> "+response.cs.nop
                            			           +"</td><td> "+response.cs.total                            			           +"</td></tr>"); 
                            	   i=i+response.cs.total;
                               	   $("#gt").html(i);
                            	   
                                 j++;                     
                },
                error:function(){
                	alert('error....');
                }
            });        
    }
     
    delete_ = function(id){     
         $.ajax({
            url:'',
            type:'POST',
            data:{user_id:id},
            success: function(response){
                    alert(response.message);
                       
                    
                   
            }              
        });
}
     
 
    edit = function (index){
        $("#user_id").val(data[index].user_id);
        $("#name").val(data[index].user_name);
        $("#email").val(data[index].email);
         
    }
     
    
     
    
    
    
    function printPage(id)
    {
       var html="<html>";
       html+= document.getElementById(id).innerHTML;

       html+="</html>";

       var printWin = window.open('','','left=0,top=0,width=1,height=1,toolbar=0,scrollbars=0,status  =0');
       printWin.document.write(html);
       printWin.document.close();
       printWin.focus();
       printWin.print();
       printWin.close();
    }
                