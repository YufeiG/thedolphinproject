package controller;

import global.MarketplaceConfig;
import global.MarketplaceConfig.SortType;
import htmlGenerator.SearchHtmlGenerator;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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

public class SearchAction extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws java.io.IOException {
		
		// Track user id session
		HttpSession session = req.getSession(true);
		String userID = (String)session.getAttribute("currentUserID");
		
		
		
		String action = req.getParameter("action");
		
		String categoryString = req.getParameter("category");
		SortType sortType =  MarketplaceConfig.SortType.valueOf(categoryString);
		
		String longTag = req.getParameter("headerSearchInput");
		
		List<String> tokens = Arrays.asList(longTag.split(" "));

		

		//Possible Search Actions
		
	 
		if("searchFromHeader".equals(action)){
			
			
			//String category = req.getParameter("category");
			//String sortType = req.getParameter("sortType");
	
			
			
			try {
				
				ListingService listingService = new ListingServiceImpl();
				List<Item> searchResult;
				
				searchResult = listingService.findItems(tokens, null, sortType);
	
				System.err.println("items: "+searchResult);
				res.setContentType("text/html");
				res.getWriter().write(SearchHtmlGenerator.createItemTableHtml(searchResult));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			

		}
				
			

		

	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws java.io.IOException {
		doPost(req, res);
	}
}
