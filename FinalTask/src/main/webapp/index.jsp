<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>User Registration</title>

    <!-- Bootstrap -->
    <link href="resources/library/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Comic+Neue:wght@300;400;700&display=swap" rel="stylesheet">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.2/css/all.css"
        integrity="sha384-/rXc/GQVaYpyDdyxK+ecHPVYJSN9bmVFBvjA/9eOB+pb3F2w2N6fc5qB9Ew5yIns" crossorigin="anonymous">

    <!-- Custom Style CSS -->
    <link href="resources/css/style.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

    <div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
        <div class="wrapper wrapper--w790">
            <div class="card card-5">
                <div class="card-heading">
                    <h2 class="title">User Registration Form</h2>
                </div>
                <div class="card-body">
                    <form method="POST" action="">
                        <div class="form-row m-b-55">
                            <div class="name">Name</div>
                            <div class="value">
                                <div class="row row-space">
                                    <div class="col-2">
                                        <div class="input-group-desc">
                                            <input class="input--style-5" type="text" name="first_name">
                                            <label class="label--desc">First Name</label>
                                        </div>
                                    </div>
                                    <div class="col-2">
                                        <div class="input-group-desc">
                                            <input class="input--style-5" type="text" name="last_name">
                                            <label class="label--desc">Last Name</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-row m-b-55">
                            <div class="name">Email ID</div>
                            <div class="value">
                                <div class="row row-refine">
                                    <div class="col-9">
                                        <div class="input-group-desc">
                                            <input class="input--style-5" type="email" name="email">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Gender</div>
                            <div class="value">
                                <div class="input-group">
                                    <label class="radio-container m-r-55">Male <input type="radio" name="exist"> <span
                                            class="checkmark"></span>
                                    </label> <label class="radio-container m-r-55">Female <input type="radio"
                                            name="exist"> <span class="checkmark"></span>
                                    </label> <label class="radio-container">Other <input type="radio" name="exist">
                                        <span class="checkmark"></span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="form-row m-b-55">
                            <div class="name">Date of Birth</div>
                            <div class="value">
                                <div class="row row-refine">
                                    <div class="col-9">
                                        <div class="input-group-desc">
                                            <input class="input--style-5" type="date" name="dob">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-row m-b-55">
                            <div class="name">Phone</div>
                            <div class="value">
                                <div class="row row-refine">
                                    <div class="col-3">
                                        <div class="input-group-desc">
                                            <input class="input--style-5" type="text" name="area_code" value="+91"
                                                readonly> <label class="label--desc">Area
                                                Code</label>
                                        </div>
                                    </div>
                                    <div class="col-9">
                                        <div class="input-group-desc">
                                            <input class="input--style-5" type="text" name="phone" maxlength="10">
                                            <label class="label--desc">Phone
                                                Number</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div id="addresssection">
                            <div class="addressclass">
                                <fieldset>
                                    <div class="form-row m-b-55">
                                        <div class="name">Address</div>
                                        <div class="value">
                                            <div class="row row-refine">
                                                <div class="col-12">
                                                    <div class="input-group-desc">
                                                        <input class="input--style-5" type="text" name="addressline1">
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
                                                        <input class="input--style-5" type="text" name="addressline2">
                                                        <label class="label--desc">Address Line 2</label>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="name">City</div>
                                        <div class="value">
                                            <div class="row row-refine">
                                                <div class="col-6">
                                                    <div class="input-group-desc">
                                                        <input class="input--style-5" type="text" name="city">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="name">State</div>
                                        <div class="value">
                                            <div class="input-group">
                                                <div class="rs-select2 js-select-simple select--no-search">
                                                    <select class="stateselect" name="subject" id="states">
                                                        <option disabled="disabled" selected="selected">Choose
                                                            option</option>
                                                    </select>
                                                    <div class="select-dropdown"></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="name">ZIP/PIN Code</div>
                                        <div class="value">
                                            <div class="row row-refine">
                                                <div class="col-6">
                                                    <div class="input-group-desc">
                                                        <input class="input--style-5" type="text" name="zipcode">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="input-group addremovebtn">
                                        <input type="button" class="btn btn--radius-2 btn--red m-b-55 remove"
                                            value="Remove Address Block" onclick="location.href='#'">
                                    </div>
                                </fieldset>
                            </div>
                        </div>
                        <div class="input-group addremovebtn">
                            <input type="button" class="btn btn--radius-2 btn--red m-b-55 addsection"
                                value="Add New Address Block" onclick="location.href='#'">
                        </div>
                        <div class="form-row">
                            <div class="name">Technologies</div>
                            <div class="value">
                                <div class="input-group">
                                    <table class="table table-striped table-condensed">
                                        <tr>
                                            <td>
                                                <label class="checkbox-container m-r-150">HTML<input type="checkbox"
                                                        name="exist">
                                                    <span class="checkspan"></span>
                                                </label>
                                            </td>
                                            <td><label class="checkbox-container m-r-55">Core Java<input type="checkbox"
                                                        name="exist"> <span class="checkspan"></span>
                                                </label></td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <label class="checkbox-container">CSS<input type="checkbox"
                                                        name="exist">
                                                    <span class="checkspan"></span>
                                                </label>
                                            </td>
                                            <td><label class="checkbox-container">JDBC<input type="checkbox"
                                                        name="exist"> <span class="checkspan"></span>
                                                </label></td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <label class="checkbox-container">JavaScript<input type="checkbox"
                                                        name="exist">
                                                    <span class="checkspan"></span>
                                                </label>
                                            </td>
                                            <td><label class="checkbox-container">Servlet<input type="checkbox"
                                                        name="exist"> <span class="checkspan"></span>
                                                </label></td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <label class="checkbox-container">Bootstrap<input type="checkbox"
                                                        name="exist">
                                                    <span class="checkspan"></span>
                                                </label>
                                            </td>
                                            <td><label class="checkbox-container">JSP<input type="checkbox"
                                                        name="exist"> <span class="checkspan"></span>
                                                </label></td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <label class="checkbox-container">jQuery<input type="checkbox"
                                                        name="exist">
                                                    <span class="checkspan"></span>
                                                </label>
                                            </td>
                                            <td><label class="checkbox-container">MySQL<input type="checkbox"
                                                        name="exist"> <span class="checkspan"></span>
                                                </label></td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <label class="checkbox-container">AJAX<input type="checkbox"
                                                        name="exist">
                                                    <span class="checkspan"></span>
                                                </label>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Password</div>
                            <div class="value">
                                <div class="row row-refine">
                                    <div class="col-6">
                                        <div class="input-group-desc">
                                            <input class="input--style-5" type="password" name="password">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Confirm Password</div>
                            <div class="value">
                                <div class="row row-refine">
                                    <div class="col-6">
                                        <div class="input-group-desc">
                                            <input class="input--style-5" type="password" name="password">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Security Question</div>
                            <div class="value">
                                <div class="input-group">
                                    <div class="rs-select2 js-select-simple select--no-search">
                                        <select class="stateselect" name="subject" id="securityquestion">
                                            <option disabled="disabled" selected="selected">Choose
                                                Security Question</option>
                                        </select>
                                        <div class="select-dropdown"></div>
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
                                            <input class="input--style-5" type="text" name="security">
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
                                        Terms of Services above. <input type="checkbox" name="exist">
                                        <span class="checkspan"></span>
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
                        <div class="form-group col-md-6">
                            <label for="email-addresses">Email Address</label>
                            <input class="form-control form-control-sm" type="text" id="email-addresses">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="resources/library/bootstrap/js/bootstrap.min.js"></script>

    <!-- Multi Email JS -->
    <script src="resources/js/jquery.multi-emails.js"></script>

    <!-- Call for Multi Email JS -->
    <script>
        $("#email-addresses").multiEmails()
    </script>

    <!-- Custom Script JavaScript -->
    <script src="resources/js/script.js"></script>

</body>

</html>