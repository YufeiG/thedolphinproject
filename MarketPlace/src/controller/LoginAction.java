package controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import authenticationService.AuthenticationService;
import authenticationService.AuthenticationServiceImpl;

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
		
		AuthenticationService as = new AuthenticationServiceImpl();

		res.setContentType("text/html");
		System.err.println("logging in..."+username+" "+password);
		
		try {
			long result = as.authenticate(username, password);
			if(result < 0)
			{
				res.getWriter().write("false");
				System.err.println("login failed");
				
			}
			else
			{
				res.getWriter().write(result + "");
				System.err.println("login succeed: "+result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			// redirect user to error page
			res.getWriter().write("error.jsp");
			System.err.println("sql exception");
		}
		

		
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws java.io.IOException {
		doPost(req, res);
	}

}
