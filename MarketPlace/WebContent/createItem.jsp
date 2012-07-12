<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"
            src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<title>Create Item</title>
</head>
<body>
<script type="text/javascript">
	$(document).ready(function() {
	
	$("#submit").click(function(){
		var title = $("#title").val();
		var description = $("#description").val();
		var password2 = $("#password2").val();
		var firstName = $("#first").val();
		var lastName = $("#last").val();
		var phone = $("#phone").val();
		var quest = $("#quest").val();
		var quest2 = $("#quest2").val();
		if(title == ""){
			alert("Error: Title cannot be empty");
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
		
			
		$.post("ItemAction",{ action: "create", username: username, password: password, firstname: firstName, lastname: lastName, phone: phone, email: quest+"@uwaterloo.ca" },
		  function(data){
		    alert("Account result: " + data);
		  }
		);
	});
	});
</script>
<form>
Title: <input id="title" type="text" name="title" /><br />
Description: <input id ="description" type="text" name="description" height=300 /><br />

<button id = "submit" type="button">Create Item</button>
</form> 
</body>
</html>