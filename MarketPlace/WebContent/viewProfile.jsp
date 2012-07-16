<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"
            src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<title>View Profile</title>

</head>
<body>

<form>
<table class="input_table">
<tr><td>userID:</td><td> <input id="id" type="text" name="id" /><button id = "populate" type="button">Get Profile</button></td></tr>
</table>
</form>
<table>
<tr><td>Username:</td><td> <input id="username" type="text" name="username" /></td></tr>
<tr><td>Password:</td><td><input id ="password" type="password" name="pwd" /></td></tr>
<tr><td>First Name:</td><td><input id ="first" type="text" name="first" /> <br/>
</td></tr>
<tr><td>Last Name: </td><td><input id ="last" type="text" name="last" /> <br/>
</td></tr>
<tr><td>Email: </td><td><input id ="email" type="text" name="email" /><br/>
</td></tr>
<tr><td>Phone: </td><td>
<input id ="phone" type="text" name="phone" /><br/>

</td></tr>
</table>


<script type="text/javascript">
	$(document).ready(function() {
		$("#populate").click(function(){
			var id = $("#id").val();
			if(id != "" && !isNaN(id)){
		
				$.post("UserAction",{ action: "get", userid : id },
						  function(data){
					
							if(data != "false" && data != "error"){
								var dataArray = data.split(",");
								
								if(dataArray.length == 6){
		
									$("#username").val(dataArray[0]);
									$("#password").val(dataArray[1]);
									$("#first").val(dataArray[2]);
									$("#last").val(dataArray[3]);
									$("#email").val(dataArray[4]);
									$("#phone").val(dataArray[5]);
								}
							}
						  }
						);
			}
		
		});
	
	});
</script> 
</body>
</html>
