$(document).ready(function() {
	var table = $('#table_id').DataTable({
		"processing": true,
		"ajax": {
			"url": "ViewAllUsersServlet",
			"dataSrc": "usersData",
			"type": "GET"
		},
		"columns": [{
			"usersData": "userid"
		},
		{
			"usersData": "firstname"
		},
		{
			"usersData": "lastname"
		},
		{
			"usersData": "email"
		},
		{
			"usersData": "gender"
		},
		{
			"usersData": "dob"
		},
		{
			"usersData": "phone"
		}
		]
	});

	$('#table_id tbody').on('click', 'tr', function() {
		var usersData = table.row($(this).parents('tr')).data();
		alert(table.row(this).data()[0]);
	});
});