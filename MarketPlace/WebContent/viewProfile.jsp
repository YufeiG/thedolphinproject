<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="header.jsp"%>
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
			<tr>
				<td>Username:</td>
				<td><input id="username" type="text" name="username" disabled="disabled"/></td>
			</tr>
			<tr>
				<td>Old Password:</td>
				<td><input id="password" type="password" name="pwd" /></td>
			</tr>
			<tr>
				<td>New Password:</td>
				<td><input id="newPassword1" type="password" name="pwd" /></td>
			</tr>
			<tr>
				<td>Confirm New Password:</td>
				<td><input id="newPassword2" type="password" name="pwd" /></td>
			</tr>
			<tr>
				<td>First Name:</td>
				<td><input id="first" type="text" name="first" /> <br /></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input id="last" type="text" name="last" /> <br /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input id="email" type="text" name="email" /><br /></td>
			</tr>
			<tr>
				<td>Phone:</td>
				<td><input id="phone" type="text" name="phone" /><br /></td>
			</tr>
		</table>

		<button id="save" type="button">Save</button>

	</center>

	<script type="text/javascript">
	$(document).ready(function() {
		var id = '<%=session.getAttribute("currentSessionID")%>';
			if (!isNaN(id)) {
				var oldPassword = "";
				
				
				$.post("UserAction", {
					action : "get",
					userid : id
				}, function(data) {

					if (data != "false" && data != "error") {
						var dataArray = data.split(",");

						if (dataArray.length == 6) {
							oldPassword = dataArray[1];
							
							$("#username").val(dataArray[0]);
							$("#first").val(dataArray[2]);
							$("#last").val(dataArray[3]);
							$("#email").val(dataArray[4]);
							if (dataArray[5] != "null") {
								$("#phone").val(dataArray[5]);
							}
				
						}
					}
				});

				$("#save").click(function() {
					var username = $("#username").val();
					var password = $("#password").val();
					var newPassword1 = $("#newPassword1").val();
					var newPassword2 = $("#newPassword2").val();
					var firstName = $("#first").val();
					var lastName = $("#last").val();
					var phone = $("#phone").val();
					var email = $("#email").val();

					if (username == "") {
						alert("Error: User Name cannot be empty");
						return;
					}

					if (firstName == "") {
						alert("Error: First Name cannot be empty");
						return;
					}

					if (lastName == "") {
						alert("Error: Last Name cannot be empty");
						return;
					}

					if (email == "") {
						alert("Error: Email cannot be empty");
						return;
					}
					
					if(newPassword1 != "" || newPassword2 != ""){
						if(password == ""){
							alert("Error: Old password cannot be empty");
							return;
						}
						
						if(newPassword1 == ""){
							alert("Error: New password cannot be empty");
							return;
						}
						
						if(newPassword2 == ""){
							alert("Error: New password confirmation cannot be empty");
							return;
						}
						
						if(password != oldPassword){
							alert("Error: Invalid old password");
							return;
						}
						
						if(newPassword1 != newPassword2){
							alert("Error: New passwords does not match");
							return;
						}
					}

					
					
					
					$.post("UserAction", {
						action : "editProfile",
						userid : id,
						username: username,
						password: newPassword1 == "" ? oldPassword : newPassword1,
						email: email,
						phone: phone,
						firstName: firstName,
						lastName: lastName
					}, function(data) {

						if (data != "false" && data != "error") {
							alert("Your account has been updated.");
							window.location = "index.jsp";
						}
					});

					
					

				});

			}

		});
	</script>
</body>
</html>
