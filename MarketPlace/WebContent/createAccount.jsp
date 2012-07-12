<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="header.jsp" %>
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
	
	$("#submit").click(function(){
		var username = $("#username").val();
		var password = $("#password").val();
		var password2 = $("#password2").val();
		var firstName = $("#first").val();
		var lastName = $("#last").val();
		var phone = $("#phone").val();
		var quest = $("#quest").val();
		var quest2 = $("#quest2").val();
		if(username == ""){
			alert("Error: User Name cannot be empty");
			return;
		}
		
		if(firstName == ""){
			alert("Error: First Name cannot be empty");
			return;
		}
		
		if(lastName == ""){
			alert("Error: Last Name cannot be empty");
			return;
		}
		
		if(password2 == "" || password == "") {
			alert("Error: Password cannot be empty");
			return;
		}
		
		
		if(password2 != password) {
			alert("Error: The typed passwords don't match.");
			$("#password").val("");
			$("#password2").val("");
			return;
		}
		
		
		if(quest == "" || quest2 == ""){
			alert("Error: Quest ID cannot be empty. Only UW students can use the marketplace. You need this to verify your account. You can change this email after you verify your account.");
			return;
		}
		
		if(quest != quest2) {
			alert("Error: The typed Quest IDs don't match.");
			$("#quest").val("");
			$("#quest2").val("");
			return;
		}

			
		$.post("UserAction",{ action: "create", username: username, password: password, firstname: firstName, lastname: lastName, phone: phone, email: quest+"@uwaterloo.ca" },
		  function(data){
		    alert("Account result: " + data);
		  }
		);
	});
	});
</script>
<form>
Username: <input id="username" type="text" name="username" /><br />
Password: <input id ="password" type="password" name="pwd" /><br />
Retype Password: <input id ="password2" type="password" name="pwd2" /> <br/>
First Name: <input id ="first" type="text" name="first" /> <br/>
Last Name: <input id ="last" type="text" name="last" /> <br/>
Quest ID (for verification):<input id ="quest" type="text" name="quest" />@uwaterloo.ca<br/>
Retype Quest ID:<input id ="quest2" type="text" name="quest2" />@uwaterloo.ca<br/>
Phone (optional):<input id ="phone" type="text" name="phone" /><br/>
<button id = "submit" type="button">Create Account</button>
</form> 
</body>
</html>
