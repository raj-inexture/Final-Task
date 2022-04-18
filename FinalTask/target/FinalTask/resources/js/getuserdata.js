$(document).ready(function () {

	var input_email = $("#input_email").val();

	$.ajax({
		"url": "ViewUsersServlet",
		"type": "POST",
		"data": ({
			email: input_email,
		}),
		"dataType": "JSON",
		success: function (response) {
			$('#firstname').val(response.data[0].firstname);
			$('#lastname').val(response.data[0].lastname);
			$('#email').val(response.data[0].email);
			$('#email').prop("readonly", true);
			$('#dob').val(response.data[0].dob);
			$('#phone').val(response.data[0].phone);
			$('#phone').prop("readonly", true);
			$('#password').val(response.data[0].password);
			$('#confirmpassword').val(response.data[0].password);
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
		error: function (response) {
			console.log(response);
		}
	});

	$.ajax({
		"url": "ViewUserAddress",
		"type": "POST",
		"data": ({
			email: input_email,
		}),
		"dataType": "JSON",
		success: function (response) {
			var count = response.addressData.length;

			var addressno = 1;

			$.each(response.addressData, function (key, value) {

				/*$(':input[name=addressid]').val(response.addressData[key].id);*/

				if (addressno == 1) {
					$(':input[name=addressid]').val(response.addressData[key].id);
					$(':input[name=addressline1]').val(response.addressData[key].addressline1);
					$(':input[name=addressline2]').val(response.addressData[key].addressline2);
					$(':input[name=city]').val(response.addressData[key].city);
					$('#states').val(response.addressData[key].state).change();
					$(':input[name=zipcode]').val(response.addressData[key].zipcode);
				} else {
					$(':input[name=addressid][id=addressid' + addressno + ']').val(response.addressData[key].id);
					$(':input[name=addressline1][id=addresslineone' + addressno + ']').val(response.addressData[key].addressline1);
					$(':input[name=addressline2][id=addresslinetwo' + addressno + ']').val(response.addressData[key].addressline2);
					$(':input[name=city][id=city' + addressno + ']').val(response.addressData[key].city);
					$('#states' + addressno).val(response.addressData[key].state).change();
					$(':input[name=zipcode][id=zipcode' + addressno + ']').val(response.addressData[key].zipcode);
				}

				if (addressno < count) {
					$('#addbutton').click();
					addressno++;
				}
			});
			console.log(response);
		},
		error: function (response) {
			console.log(response);
		}
	});

	$.ajax({
		"url": "ViewUserTechnology",
		"type": "POST",
		"data": ({
			email: input_email,
		}),
		"dataType": "JSON",
		success: function (response) {
			var count = $(response.technologies.length);

			var values = [];

			$.each($("input[name=technology]"), function () {
				values.push($(this).val());
			});

			$.each(response.technologies, function (key, value) {
				for (let loop = 0; loop < values.length; loop++) {
					if (response.technologies[key].technology == values[loop]) {
						$('input[name=technology][value="' + response.technologies[key].technology + '"]').prop('checked', true);
					}
				}
			});
			console.log(response);
		},
		error: function (response) {
			console.log(response);
		}
	});
});