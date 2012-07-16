<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
session.removeAttribute("currentSessionUser");
session.removeAttribute("currentSessionID");
%>

<script type="text/javascript"
            src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>


<script type="text/javascript">
	$(document).ready(function() {
		window.location = "index.jsp";
	});
	
	</script>