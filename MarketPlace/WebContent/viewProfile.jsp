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
<center>
<h4>- User Profile -</h4>

<table>
<tr><td>Username:</td><td> <input disabled="disabled" id="username" type="text" name="username" /></td></tr>
<tr><td>Password:</td><td><input disabled="disabled" id ="password" type="password" name="pwd" /></td></tr>
<tr><td>First Name:</td><td><input disabled="disabled" id ="first" type="text" name="first" /> <br/>
</td></tr>
<tr><td>Last Name: </td><td><input disabled="disabled" id ="last" type="text" name="last" /> <br/>
</td></tr>
<tr><td>Email: </td><td><input disabled="disabled" id ="email" type="text" name="email" /><br/>
</td></tr>
<tr><td>Phone: </td><td>
<input disabled="disabled" id ="phone" type="text" name="phone" /><br/>

</td></tr>
</table>
</center>

<script type="text/javascript">
	$(document).ready(function() {
		var id = '<%=session.getAttribute("currentSessionID")%>';
			if(!isNaN(id)){
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
									if(dataArray[5] != "null"){
										$("#phone").val(dataArray[5]);
									}
								}
							}
						  }
						);
			}
		
		
	
	});
</script> 
</body>
</html>

<%@ include file="footer.jsp" %>
