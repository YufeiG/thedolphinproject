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
<title>Wish List</title>
</head>
<body>
<script type="text/javascript">
	//function parseTag(){
		//var tags = $("#tags").val();
		//var noSpace = tags.split(' ').join('');
		//var lowerCase = noSpace.toLowerCase();
		//$("#tags").val(lowerCase);
	//}
	jQuery.fn.exists = function(){return this.length>0;};
	
	function createInput(n)
	{
		var k = n+1;
	
		if($("#tag"+k).exists() == false){
	
			$("#tagInputs").append("<li><input onkeydown=\"createInput("+k+");\"  id=\"tag"+k+"\"/></li>");
		}
		
	}

	$(document).ready(function() {
		var id = '<%=session.getAttribute("currentSessionID")%>';
		var existingTags = 0;
		if(id == null || id == "" || id == "null"){
			alert("You must be signed in.");
		}
		else{
	
		
			$.post("WishlistAction",{ action: "get", userid: id},
					  function(data){
						//alert(data);
						if(data != "false" && data != "error" && data != ""){
							var dataArray = data.split(",");
							existingTags = dataArray.length;
							for(var i = 0; i < existingTags; i++)
							{
							
								$("#tagInputs").append("<li><input id=\"tag"+(i)+"\" disabled=\"disabled\"/></li>");
				
								$("#tag"+i).val(dataArray[i]);
							}
						}
						$("#tagInputs").append("<li><input onkeydown=\"createInput("+existingTags+");\" id=\"tag"+existingTags+"\"/></li>");
			});
		}
		
		
		
		
		$("#save").click(function(){
			//parseTag();
			var tags = "";

			for(var i = existingTags; i < $("#tagInputs").children().length ; i++){
				var r = $("#tag"+i).val();
				if(r == null || r == "") continue;
				
				if(i == existingTags){
					tags += r ;
				
				}
				else{
					tags += ","+ r;
				}
			}
			
			if(tags == ""){
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
				    	window.location = "addWishList.jsp";
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

<ul id="tagInputs">
	
</ul>
<button id = "save" type="button">Save</button>
</body>
</html>
