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
		    	alert("You are logged in. Redirecting...");
		    	window.location = "index.jsp";
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
<center>
<h4>- Sign In -</h4>
Please sign in below with a valid username and password.

<form>
<table class="input_table">
<tr><td>Username:</td><td><input id="username" type="text" name="username" /><br /></td></tr>
<tr><td>Password:</td><td><input id ="password" type="password" name="pwd" /><br/></td></tr>
</table>
<p></p>
<button id = "submit" type="button">Sign In</button>
</form>

</center> 
</body>
</html>

<%@ include file="footer.jsp" %>
