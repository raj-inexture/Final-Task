$("#email").blur(function () {
	
    $.ajax({
        "url": "EmailVerificationServlet",
        "type": "POST",
        "dataType": "JSON",
        success: function (response) {

            var input_email = $("#email").val();

            $.each(response.emailData, function (key, value) {

                if (input_email == response.emailData[key].email) {
                    alert("Email ID has Already Been Taken\r\nEnter Another Email ID");
                    return false;
                }
            });

            console.log(response);
        },
        error: function (response) {
            console.log(response);
        }
    })
})

$("#phone").blur(function () {
	
    $.ajax({
        "url": "EmailVerificationServlet",
        "type": "POST",
        "dataType": "JSON",
        success: function (response) {

            var input_phone = $("#phone").val();

            $.each(response.emailData, function (key, value) {
                
                if (input_phone == response.emailData[key].phone) {
                    alert("Phone Number has Already Been Taken\r\nEnter Another Phone Number");
                    return false;
                }
            });

            console.log(response);
        },
        error: function (response) {
            console.log(response);
        }
    })
})