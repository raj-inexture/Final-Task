package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

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
		String[] addressid = request.getParameterValues("addressid");
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

		List<AddressBeanModel> listAddress = new LinkedList<AddressBeanModel>();

		listAddress = viewUsers.viewUserAddress(user.getUserid());

		List<AddressBeanModel> newAddressList = new LinkedList<AddressBeanModel>();

		int blankId = 1;

		for (int loop = 0; loop < city.length; loop++) {
			AddressBeanModel address = new AddressBeanModel();

			if (addressid[loop].equals("")) {
				address.setId(blankId);
				blankId++;
			} else {
				address.setId(Integer.parseInt(addressid[loop]));
			}

			address.setUserid(user.getUserid());
			address.setAddressline1(addressline1[loop]);
			address.setAddressline2(addressline2[loop]);
			address.setCity(city[loop]);
			address.setState(states[loop]);
			address.setZipcode(zipcode[loop]);

			newAddressList.add(address);
		}

		for (int x = 0; x < newAddressList.size(); x++) {
			out.println("New Address List" + newAddressList.get(x).getId());
		}
		for (int y = 0; y < listAddress.size(); y++) {
			out.println("Old Address List" + listAddress.get(y).getId());
		}

		UserRegistrationInterface userRegistration = new UserRegistrationImpl();

		List<AddressBeanModel> deleteAddressList = new LinkedList<AddressBeanModel>(listAddress);
		List<AddressBeanModel> updateAddressList = new LinkedList<AddressBeanModel>();
		List<AddressBeanModel> insertAddressList = new LinkedList<AddressBeanModel>(newAddressList);

		for (int x = 0; x < deleteAddressList.size(); x++) {
			for (int y = 0; y < newAddressList.size(); y++) {
				if (deleteAddressList.get(x).getId() == newAddressList.get(y).getId()) {
					deleteAddressList.remove(x);
				}
			}
			out.println("Delete" + deleteAddressList.get(x).getId());

			int result2 = userUpdate.deleteUserAddress(deleteAddressList.get(x));
		}

		for (int x = 0; x < listAddress.size(); x++) {
			for (int y = 0; y < newAddressList.size(); y++) {
				if (listAddress.get(x).getId() == newAddressList.get(y).getId()) {
					out.println("Update" + listAddress.get(x).getId());

					AddressBeanModel address = new AddressBeanModel();

					address.setId(listAddress.get(x).getId());
					address.setAddressline1(newAddressList.get(x).getAddressline1());
					address.setAddressline2(newAddressList.get(x).getAddressline2());
					address.setCity(newAddressList.get(x).getCity());
					address.setState(newAddressList.get(x).getState());
					address.setZipcode(newAddressList.get(x).getZipcode());

					updateAddressList.add(address);

					int result3 = userUpdate.updateUserAddress(updateAddressList.get(x));
				}
			}
		}

		for (int x = 0; x < insertAddressList.size(); x++) {
			for (int y = 0; y < updateAddressList.size(); y++) {
				if (insertAddressList.get(x).getId() == updateAddressList.get(y).getId()) {
					insertAddressList.remove(x);
				}
			}
			out.println("Insert" + insertAddressList.get(x).getId());

			int result4 = userRegistration.registerUserAddress(insertAddressList.get(x));
		}

		List<TechnologiesBeanModel> listTechnologies = new LinkedList<TechnologiesBeanModel>();

		listTechnologies = viewUsers.viewUserTechnology(user.getUserid());

		List<TechnologiesBeanModel> newTechnologiesList = new LinkedList<TechnologiesBeanModel>();

		for (int loop = 0; loop < technologies.length; loop++) {
			TechnologiesBeanModel techhnology = new TechnologiesBeanModel();

			techhnology.setUserid(user.getUserid());
			techhnology.setTechnology(technologies[loop]);

			newTechnologiesList.add(techhnology);
		}

		for (int x = 0; x < newAddressList.size(); x++) {
			out.println("New Technologies List" + newTechnologiesList.get(x).getId());
		}
		for (int y = 0; y < listAddress.size(); y++) {
			out.println("Old Technologies List" + listTechnologies.get(y).getId());
		}

		List<TechnologiesBeanModel> deleteTechnologiesList = new LinkedList<TechnologiesBeanModel>(listTechnologies);
		List<TechnologiesBeanModel> updateTechnologiesList = new LinkedList<TechnologiesBeanModel>();
		List<TechnologiesBeanModel> insertTechnologiesList = new LinkedList<TechnologiesBeanModel>(newTechnologiesList);

		for (int x = 0; x < deleteTechnologiesList.size(); x++) {
			for (int y = 0; y < newTechnologiesList.size(); y++) {
				if (deleteTechnologiesList.get(x).getId() == newTechnologiesList.get(y).getId()) {
					deleteTechnologiesList.remove(x);
				}
			}
			out.println("Delete" + deleteTechnologiesList.get(x).getId());

			int result5 = userUpdate.deleteUserTechnologies(deleteTechnologiesList.get(x));
		}

		for (int x = 0; x < listTechnologies.size(); x++) {
			for (int y = 0; y < newTechnologiesList.size(); y++) {
				if (listTechnologies.get(x).getId() == newTechnologiesList.get(y).getId()) {
					out.println("Update" + listTechnologies.get(x).getId());

					TechnologiesBeanModel technology = new TechnologiesBeanModel();

					technology.setUserid(user.getUserid());
					technology.setTechnology(newTechnologiesList.get(x).getTechnology());

					updateTechnologiesList.add(technology);
				}
			}
		}

		for (int x = 0; x < insertTechnologiesList.size(); x++) {
			for (int y = 0; y < updateTechnologiesList.size(); y++) {
				if (insertTechnologiesList.get(x).getId() == updateTechnologiesList.get(y).getId()) {
					insertTechnologiesList.remove(x);
				}
			}
			out.println("Insert" + insertTechnologiesList.get(x).getId());

			int result6 = userRegistration.registerUserTechnologies(insertTechnologiesList.get(x));
		}

	}
}
