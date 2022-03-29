// ---------------FIRST NAME---------------

function firstname() {

    let firstname = document.getElementsByName('firstname').values;

    if (firstname == "") {
        document.getElementById('first-name-error').innerHTML = "*Required Field";
        return false;
    } else if (!isNaN(firstname)) {
        document.getElementById('first-name-error').innerHTML = "Enter Correct First Name";
        return false;
    } else {
        document.getElementById('first-name-error').innerHTML = "";
    }
}

// ---------------LAST NAME---------------

function lastname() {

    let lastname = document.getElementByName('lastname').value;

    if (lastname == "") {
        document.getElementById('last-name-error').innerHTML = "*Required Field";
        return false;
    } else if (!isNaN(lastname)) {
        document.getElementById('last-name-error').innerHTML = "Enter Correct Last Name";
        return false;
    } else {
        document.getElementById('last-name-error').innerHTML = "";
    }
}

// ---------------EMAIL ID---------------

function email() {

    var email = document.getElementById('email').value;

    var atSymbol = email.indexOf("@");
    var sub_str = email.substring(atSymbol + 1);
    var dotSymbol = sub_str.indexOf(".");

    if (email == "") {
        document.getElementById('email-error').innerHTML = "*Required Field";
        return false;
    } else if (atSymbol < 3) {
        document.getElementById('email-error').innerHTML = "Enter Correct Email ID 1";
    } else if (dotSymbol <= atSymbol + 2) {
        document.getElementById('email-error').innerHTML = "Enter Correct Email ID 2";
    } else if (dotSymbol <= email.length - 1) {
        document.getElementById('email-error').innerHTML = "Enter Correct Email ID 3";
    } else {
        document.getElementById('email-error').innerHTML = "";
    }
}

// ---------------PHONE NUMBER---------------

function phone() {

    var phone = document.getElementById('phone-no').value;

    if (phone == "") {
        document.getElementById('phone-error').innerHTML = "*Required Field";
        return false;
    } else if (isNaN(phone)) {
        document.getElementById('phone-error').innerHTML = "Enter Correct Phone No.";
        return false;
    } else if ((phone.length < 10) || (phone.length > 10)) {
        document.getElementById('phone-error').innerHTML = "Enter 10 Digits Only";
        return false;
    } else if ((phone.charAt(0) != 9) && (phone.charAt(0) != 8) && (phone.charAt(0) != 7)) {
        document.getElementById('phone-error').innerHTML = "Phone No. must start with 9/8/7 Only";
        return false;
    } else {
        document.getElementById('phone-error').innerHTML = "";
    }
}

// ---------------URL---------------

function url() {

    var url = document.getElementById('url').value;

    if (url == "") {
        document.getElementById('url-error').innerHTML = "";
        return false;
    } else if ((url.indexOf('https://') != 0) && (url.indexOf('http://') != 0)) {
        document.getElementById('url-error').innerHTML = "Enter Correct URL";
        return false;
    } else {
        document.getElementById('url-error').innerHTML = "";
    }
}

// ---------------PASSWORD---------------

function password() {

    var password = document.getElementById('password').value;

    // var upper = false;
    // var lower = false;
    // var number = false;
    // var special_character = false;

    if (password == "") {
        document.getElementById('password-error').innerHTML = "*Required Field";
    } else if ((password.length < 8) || (password.length > 14)) {
        document.getElementById('password-error').innerHTML = "Min 8 & Max 14 Characters Allowed";
    }
    // else if ((password.length > 8) || (password.length < 14)) {

    //     for (let i = 0; i < password.length; i++) {

    //         var charCode = pass.charCodeAt(i);

    //         if (charCode > 64 && charCode < 91)
    //             upper = true;
    //         if (charCode > 96 && charCode < 123)
    //             lower = true;
    //         if (charCode > 47 && charCode < 58)
    //             number = true;
    //         if (charCode > 32 && charCode < 48)
    //             special_character = true;
    //     }

    //     if (upper && lower && number && special_character) {
    //         document.getElementById('password-error').innerHTML = "Password must contain 1 Uppercase, 1 Lowercase, 1 Number and 1 Special Character";
    //     }
    // }
    else {
        document.getElementById('password-error').innerHTML = "";
    }
}

// ---------------CONFIRM PASSWORD---------------

function confirmpassword() {

    var password = document.getElementById('password').value;
    var confirm_password = document.getElementById('confirm-password').value;

    if (confirm_password == "") {
        document.getElementById('confirm-password-error').innerHTML = "*Required Field";
        return false;
    } else if ((password) != (confirm_password)) {
        document.getElementById('confirm-password-error').innerHTML = "Password does not match";
        return false;
    } else {
        document.getElementById('confirm-password-error').innerHTML = "";
    }
}

// ---------------GENDER---------------

function gender() {

    var male = document.getElementById('radio-male');
    var female = document.getElementById('radio-female');

    if ((!(male.checked)) && (!(female.checked))) {
        document.getElementById('gender-error').innerHTML = "*Required Field";
        return false;
    } else {
        document.getElementById('gender-error').innerHTML = "";
    }
}

// ---------------ADDRESS---------------

function address() {

    var address = document.getElementById('address').value;

    if (address == "") {
        document.getElementById('address-error').innerHTML = "*Required Field";
        return false;
    } else if (address.length > 125) {
        document.getElementById('address-error').innerHTML = "Max 125 Characters Allowed";
    } else {
        document.getElementById('address-error').innerHTML = "";
    }
}

// ---------------HOBBY---------------

function hobby() {

    var hobby = document.getElementById('hobby').value;

    if (hobby == "Select Hobby") {
        document.getElementById('hobby-error').innerHTML = "*Required Field";
        return false;
    } else {
        document.getElementById('hobby-error').innerHTML = "";
    }
}

// ---------------IMAGE FILE---------------

function imagefilevalidation() {

    // var fileInput = document.getElementById('image-file');

    // var filePath = fileInput.value;

    // var allowedExtensions = (/(\.jpg|\.jpeg|\.png)$/i);

    // if (!allowedExtensions.exec(filePath)) {
    //     document.getElementById('image-error').innerHTML = "*Required Field";
    //     fileInput.value = '';
    //     return false;
    // } else {
    //     if (fileInput.files && fileInput.files[0]) {
    //         var reader = new FileReader();
    //         reader.onload = function (e) {
    //             document.getElementById(
    //                     'imagePreview').innerHTML =
    //                 '<img src="' + e.target.result +
    //                 '"/>';
    //         };

    //         reader.readAsDataURL(fileInput.files[0]);
    //     }
    // }

    var image = document.getElementById('image-file').value;

    if (image == "") {
        document.getElementById('image-error').innerHTML = "*Required Field";
        return false;
    } else {
        document.getElementById('image-error').innerHTML = "";
    }
}