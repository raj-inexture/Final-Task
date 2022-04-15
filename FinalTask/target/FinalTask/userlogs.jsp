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
<title>User Logs</title>

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

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/buttons/2.2.2/css/buttons.dataTables.min.css">

<!-- Custom Style CSS -->
<link href="resources/css/footerstyle.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<jsp:include page="adminheader.jsp" />

	<table id="logs_table_id" class="display"
		style="width: 100%; padding: 10px">
		<thead>
			<tr>
				<th>User ID</th>
				<th>Start TimeStamp</th>
				<th>End TimeStamp</th>
			</tr>
		</thead>
		<tbody></tbody>
	</table>

	<label>Start Date</label>
	<input class="input--style-5 js-datepicker" type="date"
		name="startdate" id="startdate">

	<label>End Date</label>
	<input class="input--style-5 js-datepicker" type="date" name="enddate"
		id="enddate">

	<label>Start Time</label>
	<input class="input--style-5 js-datepicker" type="date"
		name="starttime" id="starttime">

	<label>End Time</label>
	<input class="input--style-5 js-datepicker" type="date" name="endtime"
		id="endtime">

	<jsp:include page="footer.jsp" />

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="resources/library/bootstrap/js/bootstrap.min.js"></script>

	<script type="text/javascript" charset="utf8"
		src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript" charset="utf8"
		src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" charset="utf8"
		src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.js"></script>
	<script type="text/javascript" charset="utf8"
		src="https://cdn.datatables.net/buttons/2.2.2/js/dataTables.buttons.min.js"></script>
	<script type="text/javascript" charset="utf8"
		src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
	<script type="text/javascript" charset="utf8"
		src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
	<script type="text/javascript" charset="utf8"
		src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
	<script type="text/javascript" charset="utf8"
		src="https://cdn.datatables.net/buttons/2.2.2/js/buttons.html5.min.js"></script>
	<script type="text/javascript" charset="utf8"
		src="https://cdn.datatables.net/buttons/2.2.2/js/buttons.print.min.js"></script>

	<script src="resources/js/date.js"></script>
	<script src="resources/js/daterangepicker.js"></script>

	<!-- Custom Script JavaScript -->
	<script src="resources/js/getuserlogs.js"></script>

</body>

</html>