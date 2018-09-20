/**
 * 
 */

submit = function(){
	
	var obj={cfn:$("#cfn").val(),cln:$("#cln").val(),cafn:$('#cafn').val(),caln:$('#caln').val()};
	   
    $.ajax({
        url:'http://localhost:8089/HDProducts/pbpc/getIds',
        type:'GET',
        data:obj,
    });
}