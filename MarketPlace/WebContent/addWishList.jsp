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
<center>
<h4>- Wish List -</h4>
Below are the existing tags in your Wish List.<br/>
To add new tags, simply enter a tag and save.<br/>
To delete old tags, check the box and save.

<script type="text/javascript">
	function parseTag(n){
		var tags = $("#tag"+n).val();
		var noSpace = tags.split(' ').join('');
		var noComma = noSpace.split(',').join('');
		var lowerCase = noComma.toLowerCase();
		$("#tag"+n).val(lowerCase);
	
	}
	jQuery.fn.exists = function(){return this.length>0;};
	
	function createInput(n)
	{
		var k = n+1;
	
		if($("#tag"+k).exists() == false){
	
			$("#tagInputs").append("<li><input onkeydown=\"createInput("+k+");\"  id=\"tag"+k+"\"/></li>");
		}
		
			parseTag(n);
		
		
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
			
						if(data != "false" && data != "error" && data != ""){
							var dataArray = data.split(",");
							existingTags = dataArray.length;
							for(var i = 0; i < existingTags; i++)
							{
							
								$("#tagInputs").append("<li><input style=\"background-color:#AAAAAA; \" id=\"tag"+(i)+"\" disabled=\"disabled\"/><input id=\"cb"+(i)+"\" type=\"checkbox\"  /></li>");
				
								$("#tag"+i).val(dataArray[i]);
							}
						}
						$("#tagInputs").append("<li><input onkeydown=\"createInput("+existingTags+");\" id=\"tag"+existingTags+"\"/></li>");
			});
		}
		
		
		
		
		$("#save").click(function(){
			//parseTag();
			var tags = "";
			var deleteTags = "";

			for(var i = 0; i < existingTags ; i++){
				var r = $("#cb"+i).is(':checked');
				if(r == false) continue;
				
				var v = $("#tag"+i).val();

				if(deleteTags == ""){
					deleteTags += v ;
				
				}
				else{
					deleteTags += ","+ v;
				}
			}
			
			for(var i = existingTags; i < $("#tagInputs").children().length ; i++){
				var r = $("#tag"+i).val();
				if(r == null || r == "") continue;
				
				if(tags == ""){
					tags += r ;
				
				}
				else{
					tags += ","+ r;
				}
			}
			
			if(tags == "" && deleteTags == ""){
				alert("Nothing to add or delete");
				return;
			}

			var id = '<%=session.getAttribute("currentSessionID")%>';
			if(id == "null"){
				alert("Error! You must be logged in have a wish list!");
			}
			else{
				if(tags != ""){
					$.post("WishlistAction",{ action: "set", userid: id, tags: tags },
					  function(data){
					    if(data == "false"){
					    	alert("Tags were not added.");
					    }
					    else if(data == "true"){
					    	alert("Tags were successfully added.");
					    	
					    }
					    else{
					    	alert("Server error! Try again later.");
					    }
				  }
					);	
				}
				

				if(deleteTags!=""){
		
					$.post("WishlistAction",{ action: "delete", userid: id, tags: deleteTags },
							  function(data){
							    if(data == "false"){
							    	alert("Tags were not deleted.");
							    }
							    else if(data == "true"){
							    	alert("Tags were successfully deleted.");
							 
							    }
							    else{
							    	alert("Server error! Try again later.");
							    }
							  }
							);	
				}
				window.location = "addWishList.jsp";
			}
			
		});
	});
</script>
<p></p>
<ul id="tagInputs">
	
</ul>
<p></p>
<button id = "save" type="button">Save</button>
</center>
</body>
</html>