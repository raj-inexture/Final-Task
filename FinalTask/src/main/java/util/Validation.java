package util;

public class Validation {

	public static boolean validateUser(String firstname, String lastname, String email, String gender, String dob,
			String phone, String role, String password, String confirmpassword, String securityquestion,
			String securityanswer) {

		if (checkName(firstname) && checkName(lastname) && checkEmail(email) && checkGender(gender) && checkDOB(dob)
				&& checkPhone(phone) && checkUserRole(role) && checkPassword(password) && checkPassword(confirmpassword)
				&& checkConfirmPassword(password, confirmpassword) && checkSecurityQuestion(securityquestion)
				&& checkSecurityAnswer(securityanswer)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkName(String name) {
		return ((name != null) && (!name.equals("")) && (name.matches("^[a-zA-Z\\\\s]*$")));
	}

	public static boolean checkEmail(String email) {
		return ((email != null) && (!email.equals("")) && (email.matches("^(.+)@(.+)$")));
	}

	public static boolean checkGender(String gender) {
		return ((gender != null) && (!gender.equals("")));
	}

	public static boolean checkDOB(String dob) {
		return ((dob != null) && (!dob.equals("")));
	}

	public static boolean checkPhone(String phone) {
		return ((phone != null) && (!phone.equals("")) && (phone.matches("[7-9][0-9]{9}")));
	}

	public static boolean checkUserRole(String role) {
		return ((role != null) && (!role.equals("")));
	}

	public static boolean checkPassword(String password) {
		return ((password != null) && (!password.equals(""))
				&& (password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")));
	}

	public static boolean checkSecurityQuestion(String securityquestion) {
		return ((securityquestion != null) && (!securityquestion.equals("")));
	}

	public static boolean checkSecurityAnswer(String securityanswer) {
		return ((securityanswer != null) && (!securityanswer.equals("") && (securityanswer.matches("^[a-zA-Z]*$"))));
	}

	public static boolean checkConfirmPassword(String password, String confirmpassword) {
		return (confirmpassword.equals(password));
	}

	public static boolean isStringOnlyAlphabet(String str) {
		return ((!str.equals("")) && (str != null) && (str.matches("^[a-zA-Z]*$")));
	}

	public static boolean isStringOnlyAlphabetTextDesc(String str) {
		return ((!str.equals("")) && (str != null) && (str.matches("^[a-zA-Z0-9_.-]+( [a-zA-Z0-9_.-]+)*$")));
	}

	public static boolean checkDemo(String[] str) {
		int i = 0;
		boolean flag = true;

		while (i < str.length) {

			if ((!str.equals("")) && (str != null) && (!str[i].matches("^[a-zA-Z]*$"))) {
				flag = false;
			}
			i++;
		}
		return flag;
	}
}
