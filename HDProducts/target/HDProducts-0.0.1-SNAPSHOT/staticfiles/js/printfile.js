/**
 * 
 */

   
    
    function printPage(id)
    {
    	alert("Are sure to print....");
    	
    	 var html="<html>";
    	   html+= document.getElementById(id).innerHTML;

    	   html+="</html>";

    	   var printWin = window.open('','','left=0,top=0,width=500,height=800,toolbar=0,scrollbars=0,status  =0');
    	   printWin.document.write(html);
    	   printWin.document.close();
    	   printWin.focus();
    	   printWin.print();
    	   printWin.close();
    }
    
    