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

<form>
<table class="input_table">
<tr><td>Username:</td><td> <input id="username" type="text" name="username" /></td></tr>
<tr><td>Password:</td><td><input id ="password" type="password" name="pwd" /></td></tr>
<tr><td>Retype Password: </td><td><input id ="password2" type="password" name="pwd2" /> <br/>
</td></tr>
<tr><td>First Name:</td><td><input id ="first" type="text" name="first" /> <br/>
</td></tr>
<tr><td>Last Name: </td><td><input id ="last" type="text" name="last" /> <br/>
</td></tr>
<tr><td>Quest ID (for verification):</td><td><input id ="quest" type="text" name="quest" />@uwaterloo.ca<br/>
</td></tr>
<tr><td>Retype Quest ID:</td><td><input id ="quest2" type="text" name="quest2" />@uwaterloo.ca<br/>
</td></tr>
<tr><td>Phone (optional):</td><td>
<input id ="phone" type="text" name="phone" /><br/>

</td></tr>
</table>
<button id = "submit" type="button">Create Account</button>
</form>
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
		
		if(lastName == ""){
			alert("Error: Last Name cannot be empty");
			return;
		}
		
		if(password2 == "" || password == "") {
			alert("Error: Password cannot be empty");
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
		
		if(password2 != password) {
			alert("Error: The typed passwords don't match.");
			$("#password").val("");
			$("#password2").val("");
			return;
		}
		
			
		$.post("UserAction",{ action: "create", username: username, password: password, firstname: firstName, lastname: lastName, phone: phone, email: quest+"@uwaterloo.ca" },
		  function(data){
			if(data == "false"){
		   	 	alert("Username already exists.");
			}
			else{
				alert("Your account has been created. Please sign in to test.");
				window.location = "index.jsp";
			}
		  }
		);
	});
	});
</script> 
</body>
</html>
