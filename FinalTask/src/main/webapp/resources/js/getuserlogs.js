$(document).ready(function() {

	var table = $('#logs_table_id').DataTable({
		ajax: {
			url: "UserLogsServlet",
			type: "GET",
			dataSrc: "logsData",
		},
		//		"order": [[ 1, "desc" ]],
		dom: 'Bfrtip',
		buttons: [
			'copy', 'csv', 'excel', 'pdf', 'print'
		],
		columns: [{
			data: "userid"
		},
		{
			data: "startstamp"
		},
		{
			data: "endstamp"
		}
		]
	});

});

$("#fetchlogsbutton").click(function(event) {
	event.preventDefault();

	$('#logs_table_id').DataTable().destroy();

	var form = $('#userlogstable');

	/*debugger*/

	$.ajax({
		"url": "FetchUserLogsServlet",
		"type": "POST",
		"data": form.serialize(),
		"dataType": "JSON",
		success: function(data) {

			$('#logs_table_id').empty();

			var temp = "<thead><tr><th>User ID</th><th>Start TimeStamp</th><th>End TimeStamp</th></tr></thead><tbody></tbody>";

			$('#logs_table_id').html(temp);

			var table = $('#logs_table_id').DataTable({
				dom: 'Bfrtip',
				buttons: [
					'copy', 'csv', 'excel', 'pdf', 'print'
				]
			});

			$.each(data.fetchLogsData, function(key, val) {
				table.row.add([
					val.userid,
					val.startstamp,
					val.endstamp
				]).draw(false);
			});

			console.log(data);
		},
		error: function(response) {
			console.log(response);
		}
	});

});

$.extend(true, $.fn.dataTable.defaults, {
	"searching": false,
	"ordering": false
});