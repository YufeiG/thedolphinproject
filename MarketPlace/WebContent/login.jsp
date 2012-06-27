<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"
            src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<title>Login to UW Marketplace</title>
</head>
<body>
<script type="text/javascript">
	$(document).ready(function() {
	alert("Document Ready!");
	
	$("#submit").click(function(){
		alert("Clicked on Submit!");
		$("#username").val("new user");
		
		var username = $("#username").val();
		//var password = $("#password").val();
		/*
		$.post("/login.jsp", { username: username, password: password },function(data){
		    alert("Data Loaded: " + data);
		  } );
		*/
		
			
		$.post("LoginAction",{ username: "John", password: "2pm" },
		  function(data){
		    alert("Data Loaded: " + data);
		  }
		);
	});
	});
</script>
<form>
Username: <input id="username" type="text" name="username" /><br />
Password: <input id ="password" type="password" name="pwd" />
Submit: <button id = "submit" type="button">submit</button>
</form> 
</body>
</html>