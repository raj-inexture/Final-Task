$(document).ready(function() {
	
	var table = $('#table_id').DataTable({
		"processing": true,
		"ajax": {
			"url": "ViewAllUsersServlet",
			"dataSrc": "usersData",
			"type": "GET",
			success: function() {
				console.log("Success");
			},
			error: function() {
				console.log("Error");
			}
		},
		"columnDefs": [{
			"targets": -1,
			"data": null,
			"defaultContent": "<input type='button' id='editUser' value='Edit User' style='width: auto; padding: 2.5px; /*background-color: white; color: #ff4b5a; border: #ff4b5a 0.5px solid;*/ border-radius: 10px; margin-right: 20px'> <input type='button' id='deleteUser' value='Delete User' style='width: auto; padding: 2.5px; /*background-color: white; color: #ff4b5a; border: #ff4b5a 0.5px solid;*/ border-radius: 10px'>"
		}]
	});

	$('#table_id tbody').on('click', '[id*=editUser]', function() {
		var usersData = table.row($(this).parents('tr')).data();
		window.location = "ViewUsersServlet?email="+usersData[3];
		/*alert(usersData[3]);*/
	});

	$('#table_id tbody').on('click', '[id*=deleteUser]', function() {
		var usersData = table.row($(this).parents('tr')).data();
		/*window.location = "DeleteUserServlet?userid="+usersData[0];*/
		console.log(usersData[0]);
	});
});