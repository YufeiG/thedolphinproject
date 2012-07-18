<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"
            src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<title>View Item</title>

</head>
<body>
<center>
<h4>- View Items -</h4>

<table>
<tr><td>Seller name: </td><td> <input id="username" type="text" name="username" /></td></tr>
<tr><td>Title: </td><td><input id ="title" type="text" name="title" /></td></tr>
<tr><td>Description: </td><td><input id ="description" type="text" name="description" /> <br/>
</td></tr>
<tr><td>Category: </td><td>
<input id ="cat" type="text" name="cat" /><br/>
</td></tr>
<tr><td>Availability: </td><td><input id ="date" type="text" name="date" /> <br/>
</td></tr>
<tr><td>Price: </td><td><input id ="price" type="text" name="price" /><br/>
</td></tr>
<tr><td>Phone: </td><td>
<input id ="phone" type="text" name="phone" /><br/>
</td></tr>
<tr><td>Email: </td><td>
<input id ="email" type="text" name="email" /><br/>
</td></tr>

</table>
<p></p>
<button id = "watch" type="button">Watch Item</button>

</center>


<script type="text/javascript">
	function getUrlVars() {
		var vars = {};
		var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi,
				function(m, key, value) {
					vars[key] = value;
				});
		return vars;
	}
	
	var itemID = getUrlVars()["itemid"];
	
	$(document).ready(function() {
		
		if(itemID != "" && !isNaN(itemID)){
		
			$.post("ItemAction",{ action: "get", itemid : itemID },
					  function(data){
		
						if(data != "false" && data != "error"){
							var dataArray = data.split("|");
					
							if(dataArray.length == 10){
								
								$("#title").val(dataArray[0]);
								$("#description").val(dataArray[1]);
								$("#date").val(dataArray[2] + " to " +dataArray[3]);
								$("#price").val(dataArray[4] + " to " + dataArray[5]);
								$("#username").val(dataArray[6]);
								if(dataArray[8] != "null")
									$("#phone").val(dataArray[8]);
								$("#email").val(dataArray[7]);
								$("#cat").val(dataArray[9]);
						
							}
						}
					  }
					);
		}
		
		$("#watch").click(function(){
			var id = '<%=session.getAttribute("currentSessionID")%>';
			if(id != null && !isNaN(id)){
				//add to watch list
				
				if(itemID != "" && !isNaN(itemID)){
					$.post("UserAction",{ action: "addWatchList", userid: id, itemid : itemID },
							  function(data){
						if(data == "true"){
							alert("item was added");
						}
						else{
							alert("adding failed");
						}
					});
				}
				else
				{
					alert("invalid item id");
				}
				
			}
			else{
				alert("You are not signed in!");
			}
		
		});

	
	});
</script> 
</body>
</html>
<%@ include file="footer.jsp" %>
