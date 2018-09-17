<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import = "web.servlets.*" %>
<%@ page import = "web.db.*" %>
<%@ page import = "java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>LMS</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/dojo/1.13.0/dojo/dojo.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
/* Style the buttons */
.menu {
    border: none;
    outline: none;
    padding:0px 0px;
    background-color: #f1f1f1;
    cursor: pointer;
    font-size: 18px;
}

/* Style the active class, and buttons on mouse-over */
.active, .menu:hover {
    background-color: #ffccee;
    color: white;
    
}
</style>
</head>
<body style="background-color: #e1f3fc;">
<%
	ControllerData cd = new ControllerData();
	ArrayList <String> userInfo = new ArrayList <String>();
	userInfo = (ArrayList) request.getAttribute("userInfo");
	Iterator it = userInfo.iterator();
	String surname = "";
	String name = "";
	String email = "";
	while(it.hasNext()){
		HashMap row = (HashMap) it.next();
		surname = (String) row.get("surname");
		name = (String) row.get("name");
		email = (String) row.get("email");
	}
	
%>
	<div>
		<i>Welcome, <%=surname %> <%=name %></i>
		<a style="float: right; padding-right: 50px; cursor: pointer"><span class="glyphicon glyphicon-off" id="icon">Logout</span></a>
	</div>
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a id="home1" class="navbar-brand" style = "cursor: pointer">Library Management System</a>
		</div>
		<ul id = "nav" class="nav navbar-nav">
			<li class="menu active"><a id="home" style = "cursor: pointer">Home</a></li>
			<li class="menu" style = "cursor: pointer"><a id="add" >Add books</a></li>
			<li class="menu" style = "cursor: pointer"><a id="search" >Search book</a></li>
			<li class="menu" style = "cursor: pointer"><a id="delete" >Delete book</a></li>
			<li class="menu" style = "cursor: pointer"><a id="rename" >Rename book</a></li>
		</ul>
	</div>
	</nav>
	<div class="main_info"></div>


</body>
<script type="text/javascript">
var header = document.getElementById("nav");
var btns = header.getElementsByClass("menu");
for (var i = 0; i < btns.length; i++) {
  btns[i].addEventListener("click", function() {
    var current = document.getElementsByClassName("active");
    current[0].className = current[0].className.replace(" active", "");
    this.className += " active";
  });
}
</script>
<script>


	$('#home').ready(function(e) {
		$('.main_info').load('jsp/library_actions/home.jsp');
	});
	
	$('#home,#home1').on('click', function(e) {
		$('.main_info').load('jsp/library_actions/home.jsp');
	});

	$('#add').on('click',function(e) {
		$('.main_info').load('jsp/library_actions/addBook.jsp');
	});
	
	$('#search').on('click',function(e) {
		$('.main_info').load('jsp/library_actions/searchBook.jsp');
	});
	
	$('#delete').on('click',function(e) {
		$('.main_info').load('jsp/library_actions/deleteBook.jsp');
	});
	
	$('#rename').on('click',function(e) {
		$('.main_info').load('jsp/library_actions/renameBook.jsp');
	});
</script>

</html>