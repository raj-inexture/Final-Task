$(document).ready(function() {

	//	var logstable = $('#logs_table_id').DataTable({
	//		"processing": true,
	//		"ajax": {
	//			"url": "UserLogsServlet",
	//			"dataSrc": "logsData",
	//			"type": "POST"
	//		},"columns": [{
	//                "logsData": "userid"
	//            },
	//            {
	//                "logsData": "startstamp"
	//            },
	//            {
	//                "logsData": "endstamp"
	//            }
	//        ]
	//	});

	//	var table = $('#logs_table_id').DataTable({
	//		"processing": true,
	//		"ajax": {
	//			"url": "UserLogsServlet",
	//			"dataSrc": "userLogs",
	//			"type": "GET"
	//		},
	//		"columnDefs": [{
	//			"targets": -1,
	//			"data": null,
	//		}]
	//	});

	//	var table = $('#logs_table_id').DataTable({
	//		"ajax": {
	//			"url": "UserLogsServlet",
	//			"type": "POST",
	//			"dataType": "JSON",
	//			success: function(response) {
	//				console.log(response);
	//			},
	//			error: function(response) {
	//				console.log(response);
	//			}
	//		}
	//	});

	//	//$('#example').DataTable();
	//	$.ajax({
	//		"url": "UserLogsServlet",
	//		"type": "POST",
	//		"datatype": 'JSON',
	//		"success": function(data) {
	//			$('#logs_table_id').DataTable({
	//				data: 'logsData',
	//				columns: [
	//					{ data: 'userid' },
	//					{ data: 'startstamp' },
	//					{ data: 'endstamp' },
	//				]
	//			});
	//			console.log(data);
	//		}
	//	});

	//	var table = $('#logs_table_id').DataTable({
	//		"processing": true,
	//		"ajax": {
	//			"url": "UserLogsServlet",
	//			"dataSrc": "logsData",
	//			"type": "GET",
	//			"datatype": 'JSON',
	//			"success": function(data) {
	//				data: "logsData";
	//				columns: [
	//					{ data: "userid" },
	//					{ data: "startstamp" },
	//					{ data: "endstamp" },
	//				]
	//				console.log(data);
	//			},
	//			error: function(response) {
	//				console.log(response);
	//			}
	//		}
	//	});

	var table = $('#logs_table_id').DataTable({
		ajax: {
			url: "UserLogsServlet",
			type: "GET",
			dataSrc: "logsData"
		},
//		"order": [[ 1, "desc" ]],
		dom: 'Bfrtip',
		buttons: [
            'copy', 'csv', 'excel', 'pdf', 'print'
        ],
		columns: [
			{ data: "userid" },
			{ data: "startstamp" },
			{ data: "endstamp" }
		]
	});
});

$.extend( true, $.fn.dataTable.defaults, {
    "searching": false,
    "ordering": false
} );