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
<title>Add tags to Wish List</title>
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
		
		$( "#date2" ).datepicker('setDate', currentDate.getDate()+14);
		
		$("#submit").click(function(){
			parseTag();
			var tags = $.trim($("#tags").val());
			
			if(tags == ""){
				alert("Tags cannot be empty!!");
				return;
			}
		
			var id = '<%=session.getAttribute("currentSessionID")%>';
			if(id == "null"){
				alert("Error! You must be logged in have a wish list!");
			}
			else{
				$.post("UserAction",{ action: "addWishList", userid: id, tags: tags },
				  function(data){
				    if(data == "false"){
				    	alert("Tags were not added.");
				    }
				    else if(data == "true"){
				    	alert("Tags were successfully added.");
				    	window.location = "index.jsp";
				    }
				    else{
				    	alert("Server error! Try again later.");
				    }
				  }
				);	
			}
			
		});
	});
</script>
<form>
Enter tags separated by commas i t he box below to add them to your account wish list.<br/>
When items with matching tags are created by other user, you will receive notification via email.<br/>
Tags: <input id ="tags" type="text" name="tags" onkeydown="parseTag()" size="60" /><br />
<button id = "submit" type="button">Add</button>
</form> 
</body>
</html>
