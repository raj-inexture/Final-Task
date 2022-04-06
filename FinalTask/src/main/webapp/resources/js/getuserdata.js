$(document).ready(function() {

	$.ajax({
		"url": "ViewUsersServlet",
		"type": "POST",
		"data": ({
			email: 'shahraj.20.12.2000@gmail.com',
		}),
		"dataType": "JSON",
		success: function(response) {
			$('#firstname').val(response.data[0].firstname);
			$('#lastname').val(response.data[0].lastname);
			$('#email').val(response.data[0].email);
			$('#email').prop("readonly",true);
			$('#dob').val(response.data[0].dob);
			$('#phone').val(response.data[0].phone);
			$('#phone').prop("readonly",true);
			$('#securityquestion').val(response.data[0].securityquestion);
			$('#securityanswer').val(response.data[0].securityanswer);
			if (response.data[0].gender == 'Male') {
				$('input[name=genderradio][value=Male]').prop('checked', true);
			} else if (response.data[0].gender == 'Female') {
				$('input[name=genderradio][value=Female]').prop('checked', true);
			} else if (response.data[0].gender == 'Other') {
				$('input[name=genderradio][value=Other]').prop('checked', true);
			}
			console.log(response);
		},
		error: function(response) {
			console.log(response);
		}
	});

	$.ajax({
		"url": "ViewUserAddress",
		"type": "POST",
		"data": ({
			email: 'shahraj.20.12.2000@gmail.com',
		}),
		"dataType": "JSON",
		success: function(response) {
			var count = $(response.addressData.length);
			
			$.each(response.addressData, function(key, value) {
				$(':input[name=addressline1]').val(response.addressData[key].addressline1);
				$(':input[name=addressline2]').val(response.addressData[key].addressline2);
				$(':input[name=city]').val(response.addressData[key].city);
				$('#states').val(response.addressData[key].state).change();
				$(':input[name=zipcode]').val(response.addressData[key].zipcode);

                if(count > 1) {
                    count--;
                }
			});
			console.log(response);
		},
		error: function(response) {
			console.log(response);
		}
	});
	
	debugger
	
		$.ajax({
		"url": "ViewUserTechnology",
		"type": "POST",
		"data": ({
			email: 'shahraj.20.12.2000@gmail.com',
		}),
		"dataType": "JSON",
		success: function(response) {
			var count = $(response.technologies.length);
			
			$.each(response.technologies, function(key, value) {
				$(':input[type=checkbox][name=technology][value='+response.technologies[key].technology+']' == response.technologies[key].technology).prop('checked',true);
			});
			console.log(response);
		},
		error: function(response) {
			console.log(response);
		}
	});
});