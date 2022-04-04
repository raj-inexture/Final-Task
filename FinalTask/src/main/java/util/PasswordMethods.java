package util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

public class PasswordMethods {

	public String hashPassword(String password) {

		String hashedPassword = "";
		MessageDigest crypt = null;

		try {

			crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(password.getBytes("UTF-8"));

		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();

		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();

		}

		Formatter formatter = new Formatter();

		for (byte b : crypt.digest()) {

			formatter.format("%2x", b);

		}

		hashedPassword = formatter.toString();

		return hashedPassword;
	}
}
