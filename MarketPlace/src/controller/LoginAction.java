package controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import authenticationService.AuthenticationService;

public class LoginAction extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7380668445206437625L;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws java.io.IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.err.println("username: " + username);
		System.err.println("password: " + password);
		
		AuthenticationService as = new AuthenticationService();
		
		res.setContentType("text/html");
		res.getWriter().write(as.authenticate(username, password) + "");
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws java.io.IOException {
		doPost(req, res);
	}

}
