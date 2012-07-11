package controller;

import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

import userManagementService.UserManagementService;

public class UserAction extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6034476842725458979L;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws java.io.IOException {
		String action = req.getParameter("action");
		
		if(action == "create")
		{
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String firstname = req.getParameter("firstname");
			String lastname = req.getParameter("lastname");
			String email = req.getParameter("email");
			String phone = req.getParameter("phone");
			
			
			User user = new User(0, username, password,
					firstname, lastname, email,
					phone,  new Date());
			
			UserManagementService service = new UserManagementService();
			if(!service.createAccount(user))
			{
				System.err.println("Account not created for username: " + username);
			}
			else
			{
				System.err.println("Account created for username: " + username);
			}
			
			
			
			
		}

		

	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws java.io.IOException {
		doPost(req, res);
	}
}
