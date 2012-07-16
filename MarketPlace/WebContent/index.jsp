
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="header.jsp" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--  <link rel="stylesheet" type="text/css" href="css/marketplace.css">
-->
<title>Market Place</title>
</head>

<body>

<p>current session user<%=session.getAttribute("currentSessionUser") %></p>

<p>current session user id<%=session.getAttribute("currentSessionID") %></p>

</body>

<!-- 
<body>

	<div id="main">
        <div id="header">
            <a href="login.jsp">Log In</a>
            |
            <a href="createAccount.jsp">Create Account</a>
            |
            <a href="createItem.jsp">New Item</a>
        </div>
		<div id="search">
            Search Bar bah
        </div>
        <div id="indexLeftColumn">
             Categories
        </div>

        <div id="indexRightColumn">
            Results
        </div>

        <div id="footer">
            Copyright(c)2012 UWAvengers
        </div>
    </div>


</body>
 -->
</html>