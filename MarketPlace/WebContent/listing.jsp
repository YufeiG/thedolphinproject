<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Listing</title>
</head>

<body>
<center>
<h4>- Listings and Available Items -</h4>
	<div id="mainPane"></div>
</center>
</body>
<script type="text/javascript" charset="utf-8">
	function getUrlVars() {
		var vars = {};
		var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi,
				function(m, key, value) {
					vars[key] = value;
				});
		return vars;
	}
	var headerSearchInput = getUrlVars()["search"];
	var category = getUrlVars()["category"];

	
	$('#example').dataTable();

	$.post("SearchAction", {
		action : "searchFromHeader",
		"headerSearchInput" : headerSearchInput,
		"category" : category
	}, function(data) {
		if (data != null) {
			//Set the main Pane to datatable as given by SearchAction
			$("#mainPane").html(data);
			$('#searchResultTable').dataTable();
		}
	});
</script>

</html>
<%@ include file="footer.jsp"%>