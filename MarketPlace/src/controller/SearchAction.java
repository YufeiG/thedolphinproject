package controller;

import java.sql.SQLException;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import userManagementService.UserManagementService;
import userManagementService.UserManagementServiceImpl;

public class SearchAction extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws java.io.IOException {
		String category = req.getParameter("category");
		String sortType = req.getParameter("sortType");
		res.setContentType("text/html");
		
		
			res.getWriter().write("true");
		
			

		

	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws java.io.IOException {
		doPost(req, res);
	}
}
