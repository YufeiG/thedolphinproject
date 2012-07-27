<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*, java.lang.*,global.MarketplaceConfig,global.MarketplaceConfig.SortType" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html  lang="en"><!--<![endif]--><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
  
  <meta http-equiv="X-UA-Compatible" content="chrome=1">

  <link href="http://themeforest.net/images/favicons/themeforest.ico" rel="shortcut icon">
  <title>UWMarketplace Header</title>


<meta name="csrf-param" content="authenticity_token">
<meta name="csrf-token"
	content="yn3XBl2kDGWMhdk0lJof3ovHLgWLAh/q4Avu7wy9Fi4=">
<link rel="stylesheet" type="text/css" media="screen"
	href="themeforest.css">
<link rel="stylesheet" type="text/css" media="screen"
	href="1818400_files/widget.css">
<link rel="apple-touch-icon"
	href="http://themeforest.net/images/webclip-icons/themeforest.png">
<meta name="WT.ad" content="item_portfolio;item_more_thumb">

<script type="text/javascript"
            src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
        <script type="text/javascript"  src="js/jquery.dataTables.min.js"></script>
	<script type="text/javascript">
	
	$(document).ready(function() {
	
	$("#headerSearchButton").click(function(){
		window.location = "listing.jsp?search="+$("#headerSearchBox").val()+"&category="+$("#categoryDropdown").val() ;
	});
	});
</script>

</head>

<body data-twttr-rendered="true" id="" class="" itemscope="" itemtype="http://schema.org/CreativeWork">

<% 
String currSessionUser = (String)session.getAttribute("currentSessionUser"); %>

  <header style="height:100px">
  <div class="container">

  <a href="index.jsp" class="marketplace"><img alt="UW MarketPlace" src="css/logo.png" title="UW MarketPlace"></a>

  <div class="account-wrapper">
    <ul id="user-account-nav">
    <% if(currSessionUser != null) 
    { %>
    	<li><a href="viewProfile.jsp">Welcome, <%= currSessionUser %></a></li>
    	<li>
    	  <a href="logout.jsp">Logout</a>
    	</li>
    <% } else { %>
    
        <li><a href="createAccount.jsp"><span>Create Account</span></a></li>
        <li>
          <a href="login.jsp">Sign In</a>
        </li>
        <% } %>
    </ul>
  </div>

  <ul class="info-nav">
    <li><a href="index.jsp">Home</a></li>
    <li><a href="">Help</a>
      <div class="dropdown">
        <ul>
          <li><a href="">Getting Started</a></li>
          <li><a href="">FAQs</a></li>
          <li><a href="">Support Center</a></li>
          <li><a href="">Sitemap</a></li>
        </ul>
      </div>
    </li>
    
    <% if(currSessionUser != null) 
    { %>
    <li><a href="">Categories</a>
      <div class="dropdown">
        <ul>
          <li><a href="listing.jsp?search=&itemType=BOOKS&category=RECENCY">Books</a></li>
          <li><a href="listing.jsp?search=&itemType=HOUSING&category=RECENCY">Housing</a></li>
          <li><a href="listing.jsp?search=&itemType=SERVICES&category=RECENCY">Services</a></li>
          <li><a href="listing.jsp?search=&itemType=FURNITURE&category=RECENCY">Furniture</a></li>
        </ul>
      </div>
    </li>
    <li><a href="">Your Items</a>
      <div class="dropdown">
        <ul>
            <li> <a href="createItem.jsp">Create an Item</a></li>
            <li> <a href="viewItem.jsp">View an Item</a></li>
        </ul>
      </div>
    </li>
    <li><a href="">Your Lists</a>
      <div class="dropdown">
        <ul>
          <li><a href="watchlist.jsp">Watch List</a></li>
          <li><a href="addWishList.jsp">Wish List</a></li>
        </ul>
      </div>
    </li>
    <% } %>

  </ul>

  </div> <!-- end .container -->
  <select id="categoryDropdown" style="float:right">
  
  <% for(SortType sortType : MarketplaceConfig.SortType.values()){%>
	<option value="<%= sortType.name()%>"><%= sortType.name()%></option>		
	<%}%>
</select> 

  <input id="headerSearchBox" type="text" value="" placeholder="Start Searching..." name="term" autocomplete="off" style="float:right" size="30">
<button id= "headerSearchButton" class="image-button search no-margin" type="submit" style="float:right">Search</button>
</header> <!-- end role main header -->

</html>
