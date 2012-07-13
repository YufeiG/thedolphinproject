<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	$(document).ready(function() {
	
		$( "#date1" ).datepicker({
			minDate: 0,
			onSelect: function( selectedDate ) {
				$( "#date2" ).datepicker( "option", "minDate", selectedDate );
			}
		});
		$( "#date2" ).datepicker({
			minDate: 0, 
			onSelect: function( selectedDate ) {
				$( "#date1" ).datepicker( "option", "maxDate", selectedDate );
			}
		});
			
		$("#submit").click(function(){
			var title = $("#title").val();
			var description = $("#description").val();
			var price1 = $("#price1").val();
			var price2 = $("#price2").val();
			var date1 = $("#date1").val();
			var date2 = $("#date2").val();
	
			
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
		
		
			$.post("ItemAction",{ action: "create", title: title, description: description,
				date1: date1, date2: date2, price1: price1, price2: price2,
				userid: 0, category: "cathere" },
			  function(data){
			    if(data == "false"){
			    	alert("Item not created");
			    }
			    else{
			    	
			    }
			  }
			);
		});
	});
</script>
<form>
Title: <input id="title" type="text" name="title" /><br />
Description: <input id ="description" type="text" name="description" height=300 /><br />
Available from <input id ="date1" type="text" name="date1" height=300 /> to <input id ="date2" type="text" name="date2" height=300 /><br />
Price from $<input id ="price1" type="text" name="price1" height=300 /> to $<input id ="price2" type="text" name="price2" height=300 /><br />
<button id = "submit" type="button">Create Item</button>
</form> 
</body>
</html>
