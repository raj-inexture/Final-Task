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
import service.RegisterUser;
import service.RegisterUserAddress;
import service.RegisterUserTechnologies;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationServlet() {
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
		String userrole = request.getParameter("role");
		String[] technologies = request.getParameterValues("exist");
		String password = request.getParameter("password");
		String confirmpassword = request.getParameter("confirmpassword");
		String securityquestion = request.getParameter("subject");
		String securityanswer = request.getParameter("security");

//		boolean validate = Validation.validateUser(firstname, lastname, email, gender, dob, phone, userrole, password,
//				confirmpassword, securityquestion, securityanswer);

//		boolean validate = Validation.checkDemo(city);
//
//		out.println("ans" + validate);

		out.println("firstname :" + firstname);
		out.println("lastname :" + lastname);
		out.println("email :" + email);
		out.println("gender :" + gender);
		out.println("dob :" + dob);
		out.println("phone :" + phone);

		int i = 0;

		while (i < addressline1.length) {
			out.println(addressline1[i] + " " + addressline2[i] + " " + city[i] + " " + states[i] + " " + zipcode[i]
					+ " id" + i + "<br>");
			i++;
		}

		out.println("userrole :" + userrole);

		int j = 0;

		while (j < technologies.length) {
			out.println(technologies[j] + " id" + j + "<br>");
			j++;
		}

		out.println("password :" + password);
		out.println("confirmpassword :" + confirmpassword);
		out.println("securityquestion :" + securityquestion);
		out.println("securityanswer :" + securityanswer);

		UserDetailsBeanModel user = new UserDetailsBeanModel();

		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setEmail(email);
		user.setGender(gender);
		user.setDob(dob);
		user.setPhone(phone);
		user.setPassword(password);
		user.setUserrole(userrole);
		user.setSecurityquestion(securityquestion);
		user.setSecurityanswer(securityanswer);

		int result = RegisterUser.registerUser(user);

		int addressloop = 0;

		while (addressloop < city.length) {
			AddressBeanModel address = new AddressBeanModel();

			address.setUserid(user.getUserid());
			address.setAddressline1(addressline1[addressloop]);
			address.setAddressline2(addressline2[addressloop]);
			address.setCity(city[addressloop]);
			address.setState(states[addressloop]);
			address.setZipcode(zipcode[addressloop]);

			int addressesresult = RegisterUserAddress.registerUserAddress(address);

			addressloop++;
		}

		int technologyloop = 0;

		while (technologyloop < technologies.length) {
			TechnologiesBeanModel technology = new TechnologiesBeanModel();

			technology.setUserid(user.getUserid());
			technology.setTechnology(technologies[technologyloop]);

			int technologiesresult = RegisterUserTechnologies.registerUserTechnology(technology);

			technologyloop++;
		}

	}
}
