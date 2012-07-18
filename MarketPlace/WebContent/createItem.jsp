<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, java.lang.*,global.MarketplaceConfig,global.MarketplaceConfig.Category" %> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"
            src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1/jquery-ui.min.js"></script>
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/ui-lightness/jquery-ui.css" type="text/css" />
<title>Create Item</title>
</head>
<body>
<script type="text/javascript">
	function parseTag(){
		var tags = $("#tags").val();
		var noSpace = tags.split(' ').join('');
		var lowerCase = noSpace.toLowerCase();
		$("#tags").val(lowerCase);
	}

	$(document).ready(function() {
		 $("#price1").val("1");
		$("#price2").val("1000");
		
		var currentDate = new Date();
		
		$( "#date1" ).datepicker({
			minDate: 0,
			onSelect: function( selectedDate ) {
				$( "#date2" ).datepicker( "option", "minDate", selectedDate );
			}
		});
		
		$( "#date1" ).datepicker('setDate', currentDate);
		
		$( "#date2" ).datepicker({
			minDate: 0, 
			onSelect: function( selectedDate ) {
				$( "#date1" ).datepicker( "option", "maxDate", selectedDate );
			}
		});
		
		$( "#date2" ).datepicker('setDate', currentDate.getDate()+5);
		
		$("#submit").click(function(){
			parseTag();
			var title = $.trim($("#title").val());
			var description = $.trim($("#description").val());
			var price1 = $.trim($("#price1").val());
			var price2 = $.trim($("#price2").val());
			var date1 = $.trim($("#date1").val());
			var date2 = $.trim($("#date2").val());
			var cat = $.trim($("#categoryDropdownMenu").val());
			var tags = $.trim($("#tags").val());
			
			if(title == ""){
				alert("Error: Title cannot be empty");
				return;
			}
			if(description == ""){
				alert("Error: description cannot be empty");
				return;
			}
			
			if(date1 == "" || date2 == ""){
				alert("Error: Date cannot be empty");
				return;
			}
			
			if(price1 == "" || price2 == "") {
				alert("Error: Price cannot be empty");
				return;
			}
			
			if(isNaN(price1) || isNaN(price2)){
				alert("Error: price format not correct");
				return;
			}
			
			if(price1.indexOf("-") >= 0 || price2.indexOf("-") >= 0){
				alert("Error: Price cannot be negative.");
				return;
			}
			
			if(parseFloat(price1) > parseFloat(price2)){
				alert("Error: Max price cannot be lower than min price.");
				return;
			}
		
			var id = '<%=session.getAttribute("currentSessionID")%>';
			if(id == "null"){
				alert("Error! You must be logged in to create an item");
			}
			else{
				$.post("ItemAction",{ action: "create", title: title, description: description,
					date1: date1, date2: date2, price1: price1, price2: price2,
					userid: id, category: cat, tags: tags },
				  function(data){
				    if(data == "false"){
				    	alert("Item not created. There was an error.");
				    }
				    else if(data == "true"){
				    	alert("Item was successfully created");
				    	window.location = "index.jsp";
				    }
				    else{
				    	alert("Error! You must be logged in to create an item");
				    }
				  }
				);	
			}
			
		});
	});
</script>
<form>
Title: <input id="title" type="text" name="title"  size="60" /><br />
Description: <input id ="description" type="text" name="description" height=300 size="60"  /><br />
Available from <input id ="date1" type="text" name="date1" height=300 /> to <input id ="date2" type="text" name="date2" height=300 /><br />
Price from $<input id ="price1" type="text" name="price1" height=300 /> to $<input id ="price2" type="text" name="price2" height=300 /><br />
Categories: <select id="categoryDropdownMenu">
<% for(Category category: MarketplaceConfig.Category.values()){%>
	<option value="<%= category.name()%>"><%= category.name()%></option>		
	<%}%> 
	</select>
	<br/>
Tags will allow your item to show up with a higher priority when those tags are keywords.<br/>
Tags: <input id ="tags" type="text" name="tags" onkeydown="parseTag()" size="60" /><br />
<button id = "submit" type="button">Create Item</button>
</form> 
</body>
</html>
