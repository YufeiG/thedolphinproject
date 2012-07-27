package controller;

import global.MarketplaceConfig;
import global.MarketplaceConfig.SortType;
import htmlGenerator.SearchHtmlGenerator;

import java.sql.SQLException;
import java.util.ArrayList;
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

public class WatchlistAction extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws java.io.IOException {
		System.out.println("ENTERED WATCHLIST");

		String action = req.getParameter("action");
		
		if("displayWatchlist".equals(action)){
			
			try {
				UserManagementService userManagementService = new UserManagementServiceImpl();
				Iterator<Item> watchlist;
				watchlist = userManagementService.getWatchList((Long) req.getSession().getAttribute("currentSessionID"));
				System.out.println(watchlist.hasNext());

				res.setContentType("text/html");
				res.getWriter().write(SearchHtmlGenerator.createItemTableHtml(watchlist));
			} catch (Exception e) {
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
