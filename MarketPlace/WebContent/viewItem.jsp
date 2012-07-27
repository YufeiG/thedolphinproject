<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*,java.lang.*,global.MarketplaceConfig,global.MarketplaceConfig.SortType,userManagementService.*,model.*" %> 
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
<tr><td>Seller name: </td><td> <input id="username" type="text" name="username" disabled="disabled"/></td></tr>
<tr><td>Title: </td><td><input id ="title" type="text" name="title" disabled="disabled"/></td></tr>
<tr><td>Description: </td><td><input id ="description" type="text" name="description" disabled="disabled"/> <br/>
</td></tr>
<tr><td>Category: </td><td>
<input id ="cat" type="text" name="cat" disabled="disabled"/><br/>
</td></tr>
<tr><td>Availability: </td><td><input id ="date" type="text" name="date" disabled="disabled"/> <br/>
</td></tr>
<tr><td>Price: </td><td><input id ="price" type="text" name="price" disabled="disabled"/><br/>
</td></tr>
<tr><td>Phone: </td><td>
<input id ="phone" type="text" name="phone" disabled="disabled"/><br/>
</td></tr>
<tr><td>Email: </td><td>
<input id ="email" type="text" name="email" disabled="disabled"/><br/>
</td></tr>

</table>
<p></p>
<div id ="watchArea">
</div>		 
		

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
					
					
								$("#title").val(dataArray[0]);
								$("#description").val(dataArray[1]);
								$("#date").val(dataArray[2] + " to " +dataArray[3]);
								$("#price").val(dataArray[4] + " to " + dataArray[5]);
								$("#username").val(dataArray[6]);
								if(dataArray[8] != "null")
									$("#phone").val(dataArray[8]);
								$("#email").val(dataArray[7]);
								$("#cat").val(dataArray[9]);
								var watch = dataArray[10];
								var edit = dataArray[11];
								
								if(edit == "true"){
									$("#watchArea").html("<button id = \"edit\" type=\"button\">Edit Item</button><button id = \"delete\" type=\"button\">Delete Item</button>");
								}
								else if(watch == "true"){
									$("#watchArea").html("<button id = \"unwatch\" type=\"button\">Unwatch Item</button>");
								}
								else{
									$("#watchArea").html("<button id = \"watch\" type=\"button\">Watch Item</button>");
								}

						
							
						}
					  }
					);
		}
		
		$("#edit").live('click', function(){
			window.location = "createItem.jsp?itemid="+itemID;
		});
		
		$("#delete").live('click', function(){
			
		});
		$("#watch").live('click', function(){

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
		
		$("#unwatch").live('click', function(){
			alert("click");
			var id = '<%=session.getAttribute("currentSessionID")%>';
			if(id != null && !isNaN(id)){
				//add to watch list
				
				if(itemID != "" && !isNaN(itemID)){
					$.post("WatchlistAction",{ action: "remove", userid: id, itemid : itemID },
							  function(data){
						if(data == "true"){
							alert("Item was removed");
							window.location = "watchlist.jsp";
						}
						else{
							alert("Item remove failed");
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
