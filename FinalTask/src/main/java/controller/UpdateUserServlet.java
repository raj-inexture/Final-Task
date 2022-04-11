package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AddressBeanModel;
import model.TechnologiesBeanModel;
import model.UserDetailsBeanModel;
import service.UpdateUserImpl;
import service.UpdateUserInterface;
import service.UserRegistrationImpl;
import service.UserRegistrationInterface;
import service.ViewUsersImpl;
import service.ViewUsersInterface;
import util.PasswordMethods;

/**
 * Servlet implementation class UpdateUserServlet
 */
public class UpdateUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String gender = request.getParameter("genderradio");
		String dob = request.getParameter("dob");
		String phone = request.getParameter("phone");
		String[] addressline1 = request.getParameterValues("addressline1");
		String[] addressline2 = request.getParameterValues("addressline2");
		String[] city = request.getParameterValues("city");
		String[] states = request.getParameterValues("states");
		String[] zipcode = request.getParameterValues("zipcode");
		String[] technologies = request.getParameterValues("technology");
		String password = request.getParameter("password");
		String confirmpassword = request.getParameter("confirmpassword");
		String securityquestion = request.getParameter("securityquestion");
		String securityanswer = request.getParameter("securityanswer");

		UserDetailsBeanModel user = new UserDetailsBeanModel();

		user.setEmail(email);

		ViewUsersInterface viewUsers = new ViewUsersImpl();

		user = viewUsers.viewUserDetails(user);

		PasswordMethods pass = new PasswordMethods();

		String encryptedPassword = pass.encrypt(password);

		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setEmail(email);
		user.setGender(gender);
		user.setDob(dob);
		user.setPhone(phone);
		user.setPassword(encryptedPassword);
		user.setSecurityquestion(securityquestion);
		user.setSecurityanswer(securityanswer);

		UpdateUserInterface userUpdate = new UpdateUserImpl();

		int result1 = userUpdate.updateUser(user);

		int addressloop = 0;

		UserRegistrationInterface userRegistration = new UserRegistrationImpl();

		while (addressloop < city.length) {

			AddressBeanModel address = new AddressBeanModel();

			address.setUserid(user.getUserid());
			address.setAddressline1(addressline1[addressloop]);
			address.setAddressline2(addressline2[addressloop]);
			address.setCity(city[addressloop]);
			address.setState(states[addressloop]);
			address.setZipcode(zipcode[addressloop]);

			int addressResult = userRegistration.registerUserAddress(address);

			addressloop++;

		}

		int result2 = userUpdate.deleteDuplicateAddress();

		TechnologiesBeanModel technology = new TechnologiesBeanModel();

		int technologyloop = 0;

		while (technologyloop < technologies.length) {

			technology.setUserid(user.getUserid());
			technology.setTechnology(technologies[technologyloop]);

			int technologiesresult = userRegistration.registerUserTechnologies(technology);

			technologyloop++;

		}

		int result3 = userUpdate.deleteDuplicateTechnology();

	}
}
