<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Login</title>

<!-- Bootstrap -->
<link href="resources/library/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Comic+Neue:wght@300;400;700&amp;display=swap"
	rel="stylesheet">

<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.2/css/all.css"
	integrity="sha384-/rXc/GQVaYpyDdyxK+ecHPVYJSN9bmVFBvjA/9eOB+pb3F2w2N6fc5qB9Ew5yIns"
	crossorigin="anonymous">

<!-- Custom Style CSS -->
<link href="resources/css/headerstyle.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<div class="site-mobile-menu">
		<div class="site-mobile-menu-header">
			<div class="site-mobile-menu-close mt-3">
				<span class="icon-close2 js-menu-toggle"></span>
			</div>
		</div>
		<div class="site-mobile-menu-body"></div>
	</div>

	<header class="site-navbar" role="banner">

		<div class="container">
			<div class="row align-items-center">

				<div class="col-11 col-xl-2">
					<h1 class="mb-0 site-logo">
						<a href="index.html" class="text-white mb-0"> <!-- <img
							src="resources/images/download.png"
							style="border-radius: 50%; width: 125px;" alt=""> -->INEXTURE
							SOLUTIONS LLP <!-- <p style="margin-top: 50px; color: black; text-decoration: none">INEXTURE SOLUTIONS LLP</p> -->
						</a>
					</h1>
				</div>
				<div class="col-12 col-md-10 d-none d-xl-block">
					<nav class="site-navigation position-relative text-right"
						role="navigation">
						<ul class="site-menu js-clone-nav mr-auto d-none d-lg-block">
							<li class="active"><a href="admin.jsp"><span>Home</span></a></li>
							<%-- 							<li><a href="ViewUsersServlet?email=${email}"><span>Profile</span></a></li> --%>
							<li><a href="userlogs.jsp"><span>User Logs</span></a></li>
							<li><a href="LogoutServlet"><span>Logout</span></a></li>
						</ul>
					</nav>
				</div>
				<div class="d-inline-block d-xl-none ml-md-0 mr-auto py-3"
					style="position: relative; top: 3px;">
					<a href="#" class="site-menu-toggle js-menu-toggle text-white"><span
						class="icon-menu h3"></span></a>
				</div>
			</div>
		</div>
	</header>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"
		type="text/javascript"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="resources/library/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>

	<!-- Custom Script Validation JavaScript -->
	<script src="resources/js/validation.js" type="text/javascript"></script>

	<!-- Header Popper JavaScript -->
	<script src="resources/js/popper.min.js" type="text/javascript"></script>

	<!-- Header jQuery Sticky JavaScript -->
	<script src="resources/js/jquery.sticky.js" type="text/javascript"></script>

	<!-- Custom Main Script JavaScript -->
	<script src="resources/js/main.js" type="text/javascript"></script>

</body>

</html>