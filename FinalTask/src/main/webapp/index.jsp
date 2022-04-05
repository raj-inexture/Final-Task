<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
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
<link href="resources/library/bootstrap/css/bootstrap.min.css"
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
					<form method="POST" action="RegistrationServlet"
						enctype="multipart/form-data">
						<div class="form-row m-b-55">
							<div class="name requiredsign">Name</div>
							<div class="value">
								<div class="row row-space">
									<div class="col-2">
										<div class="input-group-desc">
											<input class="input--style-5" type="text" name="firstname"
												value="${user.firstname}"> <label
												class="label--desc">First Name</label>
										</div>
									</div>
									<div class="col-2">
										<div class="input-group-desc">
											<input class="input--style-5" type="text" name="lastname"
												value="${user.lastname}"> <label class="label--desc">Last
												Name</label>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="form-row m-b-55">
							<div class="name requiredsign">Email ID</div>
							<div class="value">
								<div class="row row-refine">
									<div class="col-9">
										<div class="input-group-desc">
											<input class="input--style-5" type="email" name="email"
												value="${user.email}">
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="form-row">
							<div class="name requiredsign">Gender</div>
							<div class="value">
								<div class="input-group">
									<label class="radio-container m-r-55">Male <input
										type="radio" name="genderradio" value="Male"
										${user.gender == 'Male'?'checked':''}> <span
										class="checkmark"></span>
									</label> <label class="radio-container m-r-55">Female <input
										type="radio" name="genderradio" value="Female"
										${user.gender == 'Female'?'checked':''}> <span
										class="checkmark"></span>
									</label> <label class="radio-container">Other <input
										type="radio" name="genderradio" value="Other"
										${user.gender == 'Other'?'checked':''}> <span
										class="checkmark"></span>
									</label>
								</div>
							</div>
						</div>
						<div class="form-row m-b-55">
							<div class="name requiredsign">Date of Birth</div>
							<div class="value">
								<div class="row row-refine">
									<div class="col-6">
										<div class="input-group-desc">
											<!-- <input class="input--style-5" type="date" name="dob" id="dob">
											<input class="input--style-5 js-select-simple" type="text" name="datepicker"> -->
											<input class="input--style-5 js-datepicker js-select-simple"
												type="text" name="dob" id="dob" value="${user.dob}">
											<i class="zmdi zmdi-calendar-note input-icon js-btn-calendar"></i>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="form-row m-b-55">
							<div class="name requiredsign">Phone</div>
							<div class="value">
								<div class="row row-refine">
									<div class="col-3">
										<div class="input-group-desc">
											<input class="input--style-5" type="text" name="area_code"
												value="+91" readonly> <label class="label--desc">Area
												Code</label>
										</div>
									</div>
									<div class="col-9">
										<div class="input-group-desc">
											<input class="input--style-5" type="text" name="phone"
												value="${user.phone}" maxlength="10"> <label
												class="label--desc">Phone Number</label>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div id="addresssection">
						<c:forEach items="${addresslist}" var="address">
							<div class="addressclass">
								<fieldset>
									<div class="form-row m-b-55">
										<div class="name requiredsign">Address</div>
										<div class="value">
											<div class="row row-refine">
												<div class="col-12">
													<div class="input-group-desc">
														<input class="input--style-5" type="text"
															name="addressline1" value="${address.addressline1}">
														<label class="label--desc">Address Line 1</label>

													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="form-row m-b-55">
										<div class="name"></div>
										<div class="value">
											<div class="row row-refine">
												<div class="col-12">
													<div class="input-group-desc">
														<input class="input--style-5" type="text"
															name="addressline2" value="${address.addressline2}">
														<label class="label--desc">Address Line 2</label>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="form-row">
										<div class="name requiredsign">City</div>
										<div class="value">
											<div class="row row-refine">
												<div class="col-9">
													<div class="input-group-desc">
														<input class="input--style-5" type="text" name="city"
															value="${address.city}">
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="form-row">
										<div class="name requiredsign">State</div>
										<div class="value">
											<div class="input-group">
												<div class="rs-select2 js-select-simple select--no-search">
													<select class="stateselect" name="states" id="states">
														<option disabled="disabled" selected="selected">Choose
															option</option>
														<option value="Andaman and Nicobar Islands"
															${address.state == 'Andaman and Nicobar Islands'?'selected="selected"':''}>Andaman
															and Nicobar Islands</option>
														<option value="Andhra Pradesh"
															${address.state == 'Andhra Pradesh'?'selected="selected"':''}>Andhra
															Pradesh</option>
														<option value="Arunachal Pradesh"
															${address.state == 'Arunachal Pradesh'?'selected="selected"':''}>Arunachal
															Pradesh</option>
														<option value="Assam"
															${address.state == 'Assam'?'selected="selected"':''}>Assam</option>
														<option value="Bihar"
															${address.state == 'Bihar'?'selected="selected"':''}>Bihar</option>
														<option value="Chandigarh"
															${address.state == 'Chandigarh'?'selected="selected"':''}>Chandigarh</option>
														<option value="Chhattisgarh"
															${address.state == 'Chhattisgarh'?'selected="selected"':''}>Chhattisgarh</option>
														<option value="Dadra and Nagar Haveli"
															${address.state == 'Dadra and Nagar Haveli'?'selected="selected"':''}>Dadra
															and Nagar Haveli</option>
														<option value="Daman and Diu"
															${address.state == 'Daman and Diu'?'selected="selected"':''}>Daman
															and Diu</option>
														<option value="Delhi"
															${address.state == 'Delhi'?'selected="selected"':''}>Delhi</option>
														<option value="Goa"
															${address.state == 'Goa'?'selected="selected"':''}>Goa</option>
														<option value="Gujarat"
															${address.state == 'Gujarat'?'selected="selected"':''}>Gujarat</option>
														<option value="Haryana"
															${address.state == 'Haryana'?'selected="selected"':''}>Haryana</option>
														<option value="Himachal Pradesh"
															${address.state == 'Himachal Pradesh'?'selected="selected"':''}>Himachal
															Pradesh</option>
														<option value="Jammu and Kashmir"
															${address.state == 'Jammu and Kashmir'?'selected="selected"':''}>Jammu
															and Kashmir</option>
														<option value="Jharkhand"
															${address.state == 'Jharkhand'?'selected="selected"':''}>Jharkhand</option>
														<option value="Karnataka"
															${address.state == 'Karnataka'?'selected="selected"':''}>Karnataka</option>
														<option value="Kerala"
															${address.state == 'Kerala'?'selected="selected"':''}>Kerala</option>
														<option value="Lakshadweep"
															${address.state == 'Lakshadweep'?'selected="selected"':''}>Lakshadweep</option>
														<option value="Madhya Pradesh"
															${address.state == 'Madhya Pradesh'?'selected="selected"':''}>Madhya
															Pradesh</option>
														<option value="Maharashtra"
															${address.state == 'Maharashtra'?'selected="selected"':''}>Maharashtra</option>
														<option value="Manipur"
															${address.state == 'Manipur'?'selected="selected"':''}>Manipur</option>
														<option value="Meghalaya"
															${address.state == 'Meghalaya'?'selected="selected"':''}>Meghalaya</option>
														<option value="Mizoram"
															${address.state == 'Mizoram'?'selected="selected"':''}>Mizoram</option>
														<option value="Nagaland"
															${address.state == 'Nagaland'?'selected="selected"':''}>Nagaland</option>
														<option value="Odisha"
															${address.state == 'Odisha'?'selected="selected"':''}>Odisha</option>
														<option value="Puducherry"
															${address.state == 'Puducherry'?'selected="selected"':''}>Puducherry</option>
														<option value="Punjab"
															${address.state == 'Punjab'?'selected="selected"':''}>Punjab</option>
														<option value="Rajasthan"
															${address.state == 'Rajasthan'?'selected="selected"':''}>Rajasthan</option>
														<option value="Sikkim"
															${address.state == 'Sikkim'?'selected="selected"':''}>Sikkim</option>
														<option value="Tamil Nadu"
															${address.state == 'Tamil Nadu'?'selected="selected"':''}>Tamil
															Nadu</option>
														<option value="Telangana"
															${address.state == 'Telangana'?'selected="selected"':''}>Telangana</option>
														<option value="Tripura"
															${address.state == 'Tripura'?'selected="selected"':''}>Tripura</option>
														<option value="Uttar Pradesh"
															${address.state == 'Uttar Pradesh'?'selected="selected"':''}>Uttar
															Pradesh</option>
														<option value="Uttarakhand"
															${address.state == 'Uttarakhand'?'selected="selected"':''}>Uttarakhand</option>
														<option value="West Bengal"
															${address.state == 'West Bengal'?'selected="selected"':''}>West
															Bengal</option>
													</select>
													<div class="select-dropdown"></div>
												</div>
											</div>
										</div>
									</div>
									<div class="form-row">
										<div class="name requiredsign">ZIP/PIN Code</div>
										<div class="value">
											<div class="row row-refine">
												<div class="col-6">
													<div class="input-group-desc">
														<input class="input--style-5" type="text" name="zipcode"
															value="${address.zipcode}">
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="input-group addremovebtn">
										<input type="button"
											class="btn btn--radius-2 btn--red m-b-55 remove delete"
											value="Remove Address Block">
									</div>
								</fieldset>
							</div>
							</c:forEach>
						</div>
						<div class="input-group addremovebtn">
							<input type="button"
								class="btn btn--radius-2 btn--red m-b-55 addsection clone"
								value="Add New Address Block">
						</div>
						<div class="form-row">
							<div class="name requiredsign">Technologies</div>
							<div class="value">
								<div class="input-group">
									<table class="table table-striped table-condensed">
										<tr>
											<td><label class="checkbox-container m-r-150">HTML<input
													type="checkbox" name="exist" value="HTML"> <span
													class="checkspan"></span>
											</label></td>
											<td><label class="checkbox-container m-r-55">Core
													Java<input type="checkbox" name="exist" value="Core Java">
													<span class="checkspan"></span>
											</label></td>
										</tr>
										<tr>
											<td><label class="checkbox-container">CSS<input
													type="checkbox" name="exist" value="CSS"> <span
													class="checkspan"></span>
											</label></td>
											<td><label class="checkbox-container">JDBC<input
													type="checkbox" name="exist" value="JDBC"> <span
													class="checkspan"></span>
											</label></td>
										</tr>
										<tr>
											<td><label class="checkbox-container">JavaScript<input
													type="checkbox" name="exist" value="JavaScript"> <span
													class="checkspan"></span>
											</label></td>
											<td><label class="checkbox-container">Servlet<input
													type="checkbox" name="exist" value="Servlet"> <span
													class="checkspan"></span>
											</label></td>
										</tr>
										<tr>
											<td><label class="checkbox-container">Bootstrap<input
													type="checkbox" name="exist" value="Bootstrap"> <span
													class="checkspan"></span>
											</label></td>
											<td><label class="checkbox-container">JSP<input
													type="checkbox" name="exist" value="JSP"> <span
													class="checkspan"></span>
											</label></td>
										</tr>
										<tr>
											<td><label class="checkbox-container">jQuery<input
													type="checkbox" name="exist" value="jQuery"> <span
													class="checkspan"></span>
											</label></td>
											<td><label class="checkbox-container">MySQL<input
													type="checkbox" name="exist" value="MySQL"> <span
													class="checkspan"></span>
											</label></td>
										</tr>
										<tr>
											<td><label class="checkbox-container">AJAX<input
													type="checkbox" name="exist" value="AJAX"> <span
													class="checkspan"></span>
											</label></td>
										</tr>
									</table>
								</div>
							</div>
						</div>
						<div class="form-row">
							<div class="name requiredsign">Password</div>
							<div class="value">
								<div class="row row-refine">
									<div class="col-9">
										<div class="input-group-desc">
											<input class="input--style-5" type="password" name="password"
												value="${user.password}">
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="form-row">
							<div class="name requiredsign">Confirm Password</div>
							<div class="value">
								<div class="row row-refine">
									<div class="col-9">
										<div class="input-group-desc">
											<input class="input--style-5" type="password"
												name="confirmpassword" value="${user.password}">
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="form-row">
							<div class="name requiredsign">Security Question</div>
							<div class="value">
								<div class="input-group">
									<div class="rs-select2 js-select-simple select--no-search">
										<select class="stateselect" name="securityquestion"
											id="securityquestion">
											<option disabled="disabled" selected="selected">Choose
												Security Question</option>
											<option value="What is your nickname?"
												${user.securityquestion == 'What is your nickname?'?'selected="selected"':''}>What
												is your nickname?</option>
											<option value="What is the name of your first pet?"
												${user.securityquestion == 'What is the name of your first pet?'?'selected="selected"':''}>What
												is the name of your first pet?</option>
											<option value="What was your first car?"
												${user.securityquestion == 'What was your first car?'?'selected="selected"':''}>What
												was your first car?</option>
											<option value="What elementary school did you attend?"
												${user.securityquestion == 'What elementary school did you attend?'?'selected="selected"':''}>What
												elementary school did you attend?</option>
											<option
												value="What is the name of the town where you were born?"
												${user.securityquestion == 'What is the name of the town where you were born?'?'selected="selected"':''}>What
												is the name of the town where you were born?</option>
										</select>
										<!-- <div class="select-dropdown"></div> -->
									</div>
								</div>
							</div>
						</div>
						<div class="form-row">
							<div class="name"></div>
							<div class="value">
								<div class="row row-refine">
									<div class="col-12">
										<div class="input-group-desc">
											<input class="input--style-5" type="text"
												name="securityanswer" value="${user.securityanswer}">
											<label class="label--desc">Your Security Answer</label>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="form-row m-b-55">
							<div class="name">Profile Photo</div>
							<div class="value">
								<div class="row row-refine">
									<div class="col-9">
										<div class="input-group-desc">
											<input class="input--style-5" type="file" name="profilephoto">
											<label class="label--desc">Types of Images Allowed</label>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="form-row">
							<div class="name"></div>
							<div class="value">
								<div class="input-group">
									<label class="checkbox-container m-r-55">I agree to the
										Terms of Services above. <input type="checkbox" name="exist"
										required="required"> <span class="checkspan"></span>
									</label>
								</div>
							</div>
						</div>
						<div class="form-row">
							<div class="name"></div>
							<div class="value">
								<div class="input-group">
									<button class="btn btn--radius-2 btn--red" type="submit">Register</button>
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

	<!-- Multiple Address jQuery Plugin -->
	<script src="resources/js/jquery-cloneya.js"></script>

	<script>
		$("#addresssection").cloneya();
	</script>

	<!-- DatePicker jQuery -->
	<script src="resources/js/moment.min.js"></script>
	<script src="resources/js/daterangepicker.js"></script>

	<!-- Custom Script Validation JavaScript -->
	<script src="resources/js/validation.js"></script>

	<!-- Custom Date Script JavaScript -->
	<script src="resources/js/date.js"></script>

	<!-- <script>
		$(document).ready(function() {
			var currentDate = new Date();
			$('.js-datepicker').datepicker({
				endDate : "currentDate",
				maxDate : currentDate
			}).on('changeDate', function(ev) {
				$(this).datepicker('hide');
			});
			$('.js-datepicker').keyup(function() {
				if (this.value.match(/[^0-9]/g)) {
					this.value = this.value.replace(/[^0-9^-]/g, '');
				}
			});
		});
	</script> -->

	<!-- Custom Script JavaScript -->
	<script src="resources/js/script.js"></script>

</body>

</html>