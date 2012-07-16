<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"
            src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<title>View Item</title>

</head>
<body>

<form>
<table class="input_table">
<tr><td>itemID:</td><td> <input id="id" type="text" name="id" /><button id = "populate" type="button">Get Item</button></td></tr>
</table>
</form>
<table>
<tr><td>Userid: </td><td> <input id="username" type="text" name="username" /></td></tr>
<tr><td>Title: </td><td><input id ="title" type="text" name="title" /></td></tr>
<tr><td>Description: </td><td><input id ="description" type="text" name="description" /> <br/>
</td></tr>
<tr><td>Availability: </td><td><input id ="date" type="text" name="date" /> <br/>
</td></tr>
<tr><td>Price: </td><td><input id ="price" type="text" name="price" /><br/>
</td></tr>
<tr><td>Phone: </td><td>
<input id ="phone" type="text" name="phone" /><br/>
</td></tr>
<tr><td>Email: </td><td>
<input id ="email" type="text" name="email" /><br/>
</td></tr>
</table>


<script type="text/javascript">
	$(document).ready(function() {
		$("#populate").click(function(){
			var id = $("#id").val();
			if(id != "" && !isNaN(id)){
		
				$.post("ItemAction",{ action: "get", itemid : id },
						  function(data){
					alert(data);
							if(data != "false" && data != "error"){
								var dataArray = data.split(",");
								
							//	if(dataArray.length == 6){
		
									$("#title").val(dataArray[0]);
									$("#description").val(dataArray[1]);
									$("#date").val(dataArray[2] + " to " +dataArray[3]);
									$("#price").val("$"+dataArray[3] + " to $" + dataArray[4]);
									//$("#email").val(dataArray[4]);
									//$("#phone").val(dataArray[5]);
								//}
							}
						  }
						);
			}
		
		});
	
	});
</script> 
</body>
</html>
