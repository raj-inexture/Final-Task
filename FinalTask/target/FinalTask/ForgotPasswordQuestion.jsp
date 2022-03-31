<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>User Registration</title>

<!-- Bootstrap -->
<link href="assets/library/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Comic+Neue:wght@300;400;700&display=swap"
	rel="stylesheet">

<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.2/css/all.css"
	integrity="sha384-/rXc/GQVaYpyDdyxK+ecHPVYJSN9bmVFBvjA/9eOB+pb3F2w2N6fc5qB9Ew5yIns"
	crossorigin="anonymous">

<!-- Custom Style CSS -->
<link href="resources/css/daterangepicker.css" rel="stylesheet"
	media="all">
<link href="resources/css/style.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div class="page-wrapper bg-gra-03 p-t-45 p-b-20">
		<div class="wrapper wrapper--w790">
			<div class="card card-5">
				<div class="card-heading">
					<h2 class="title">User Registration Form</h2>
				</div>
				<div class="card-body">
					<form method="POST" action="ForgotPasswordQuestionServlet">
						<div class="form-row m-b-55" style="display: none">
							<div class="name requiredsign">Email ID</div>
							<div class="value">
								<div class="row row-refine">
									<div class="col-9">
										<div class="input-group-desc">
											<input class="input--style-5" type="email" name="email"
												value="<%= request.getAttribute("email") %>" readonly>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="form-row">
							<div class="name requiredsign">
								Security <br> Question
							</div>
							<div class="value">
								<div class="input-group">
									<div class="rs-select2 js-select-simple select--no-search">
										<select class="stateselect" name="securityquestion"
											id="securityquestion">
											<option disabled="disabled" selected="selected">Choose
												Security Question</option>
										</select>
										<div class="select-dropdown"></div>
									</div>
								</div>
							</div>
						</div>
						<div class="form-row">
							<div class="name requiredsign">
								Security <br> Answer
							</div>
							<div class="value">
								<div class="row row-refine">
									<div class="col-12">
										<div class="input-group-desc">
											<input class="input--style-5" type="text"
												name="securityanswer">
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="form-row">
							<div class="centeralign">
								<div class="input-group">
									<button class="btn btn--radius-2 btn--red" type="submit">
										Verify <i class="fa fa-chevron-circle-right"
											aria-hidden="true"></i>
									</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="resources/library/bootstrap/js/bootstrap.min.js"></script>

	<!-- Select jQuery -->
	<script src="resources/js/select2.min.js"></script>

	<!-- Custom Script Validation JavaScript -->
	<script src="resources/js/validation.js"></script>

	<!-- Custom Script JavaScript -->
	<script src="resources/js/forgotpasswordquestion.js"></script>

</body>

</html>