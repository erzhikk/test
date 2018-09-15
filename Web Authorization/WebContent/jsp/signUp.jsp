<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="jsp/css/login.css">
  	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<title>Sign up</title>
</head>
<body class="bg-primary">
<div class="container"><br>
<h1 class="form-heading"><center>Registration page<br> to Library Management System</center></h1>
<div class="login-form">
<div class="bg-light main-div">
   <div class="panel">
   <p>Please enter your info</p>
   </div>
    <form id="Login" action="signUp" method ="POST">

        <div class="form-group">
            <input type="email" name ="signup_email" class="form-control" id="inputEmail" placeholder="Email Address" required>
        </div>    
        <div class="form-group">
            <input type="text" name ="signup_name" class ="form-control" id="inputName" placeholder="Name" required>
        </div>    
        <div class="form-group">
            <input type="text" name ="signup_surname" class="form-control" id="inputSurname" placeholder="Surname" required>
        </div>
        <div class="form-group">
            <input type="password" name = "signup_password" class="form-control" id="inputPassword" placeholder="Password" required>
        </div>

        <button type="submit" class="btn btn-primary">Sign up</button>

    </form>
        <div class="forgot">
        	Already have an account? <a href="/Web_Authorization/login">Sign in</a>
		</div>
    </div>
<p class="botto-text"> Designed by erzhikk</p>
</div></div></div>


</body>
</html>