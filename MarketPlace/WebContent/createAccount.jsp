<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"
            src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<title>Create Account</title>
</head>
<body>
<script type="text/javascript">
	$(document).ready(function() {
	alert("Fill in form then click Create Account.");
	
	$("#submit").click(function(){
		var username = $("#username").val();
		var password = $("#password").val();
		
		if($("#password2").val() != password) {
			alert("Error: The typed passwords don't match.");
			$("#password").val("");
			$("#password2").val("");
			return;
		}
		
			
		$.post("LoginAction",{ username: username, password: password },
		  function(data){
		    alert("Account created: " + data);
		  }
		);
	});
	});
</script>
<form>
Username: <input id="username" type="text" name="username" /><br />
Password: <input id ="password" type="password" name="pwd" /><br />
Retype Password: <input id ="password2" type="password" name="pwd2" /> <br/>
Submit: <button id = "submit" type="button">Create Account</button>
</form> 
</body>
</html>