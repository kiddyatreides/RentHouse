<%  
    if (session.getAttribute("token") == null){
%>
<%-- 
    Document   : Login
    Created on : Apr 9, 2017, 7:05:44 PM
    Author     : Kid
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<title>Rent House Admin Panel | Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Minimal Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="assets/backend/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="assets/backend/css/style.css" rel='stylesheet' type='text/css' />
<link href="assets/backend/css/font-awesome.css" rel="stylesheet"> 
<script src="assets/backend/js/jquery.min.js"> </script>
<script src="assets/backend/js/bootstrap.min.js"> </script>
</head>
<body>
	<div class="login">
		<h1><a href="#">Rent House Admin Panel </a></h1>
		<div class="login-bottom">
			<h2>Login</h2>
                         <%
                                                                                    String result = (String)request.getAttribute("return");
                                                                                    if(result != null){
                                                                                    out.println(result);
                                                                                    }
                                                                                %>
                        <form method="post" action="CekLogin">
			<div class="col-md-6">
            
				<div class="login-mail">
                                    <input type="text" name="username" placeholder="Username" required="">
					<i class="fa fa-user"></i>
				</div>
				<div class="login-mail">
                                    <input type="password" name="password" placeholder="Password" required="">
					<i class="fa fa-lock"></i>
				</div>
			</div>
			<div class="col-md-6 login-do">
                                    <button type="submit" class="btn-sm btn-danger" Text="Login">Sign In </button>
                    <br />
                    <br />
			</div>
			
			<div class="clearfix"> </div>
			</form>
		</div>
	</div>
		<!---->
<div class="copy-right">
            <p> &copy; 2016 M Hudya Ramadhana & Mutia Ayu Dianita. All Rights Reserved</p>	    </div>  
<!---->
<!--scrolling js-->
	<script src="assets/backend/js/jquery.nicescroll.js"></script>
	<script src="assets/backend/js/scripts.js"></script>
	<!--//scrolling js-->
</body>
</html>

<%
    }
    
    else {
    response.sendRedirect("Login");
    }
%>

