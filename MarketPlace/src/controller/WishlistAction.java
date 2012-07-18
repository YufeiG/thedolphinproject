package controller;

import global.MarketplaceConfig;
import global.MarketplaceConfig.SortType;
import htmlGenerator.SearchHtmlGenerator;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import listingService.ListingService;
import listingService.ListingServiceImpl;
import model.Item;
import model.Tag;
import model.User;
import userManagementService.UserManagementService;
import userManagementService.UserManagementServiceImpl;

public class WishlistAction extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws java.io.IOException {
		
		// Track user id session
		HttpSession session = req.getSession(true);
		String userIDString = (String)session.getAttribute("currentUserID");
		long userID = Long.parseLong(req.getParameter("userid"));
		
		String action = req.getParameter("action");
		res.setContentType("text/html");
		
		UserManagementService service = new UserManagementServiceImpl();
		
		
		if("get".equals(action)){
			
			
			try {
				Iterator<Tag> tags = service.getWishList(userID);
	
				String ret = "";
				while(tags.hasNext())
				{
					Tag t = tags.next();
					//System.err.println(t.getName());
					ret += t.getName();
					if(tags.hasNext()) ret += ",";
				}

				res.getWriter().write(ret);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			

		}
		else if("set".equals(action)){
			String tags = req.getParameter("tags");
			List<String> tagsTokens = Arrays.asList(tags.split(","));

			try {
				if(service.addToWishList(tagsTokens, userID)){
					res.getWriter().write("true");
				}
				else{
					res.getWriter().write("false");
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				res.getWriter().write("error");
			}
		}
				
			

		

	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws java.io.IOException {
		doPost(req, res);
	}
}
