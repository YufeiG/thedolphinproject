<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp" %>
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
	
	$("#submit").click(function(){
		//$("#username").val("new user");
		
		var username = $("#username").val();
		var password = $("#password").val();
			
		$.post("LoginAction",{ username: username, password: password },
		  function(data){
			var currentSessionUser = '<%=session.getAttribute("currentSessionUser")%>';
			
		    if(data == "false")
		    {
		    	alert("Wrong username or password!");
		    }
		    else if(currentSessionUser != null){
		    	// save userid in cookies	
		    	alert("You have successfully logged in. Welcome, " + currentSessionUser);
		    }
		    else{
		    	alert("Error! Probably an SQLException or a typo somewhere.");
		    	//display error page
		    }
		  }
		);
	});
	});
</script>
<form>
Username: <input id="username" type="text" name="username" /><br />
Password: <input id ="password" type="password" name="pwd" /><br/>
<button id = "submit" type="button">submit</button>
</form> 
</body>
</html>
