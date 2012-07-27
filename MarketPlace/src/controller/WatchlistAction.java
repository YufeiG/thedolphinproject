package controller;

import global.MarketplaceConfig;
import global.MarketplaceConfig.SortType;
import htmlGenerator.SearchHtmlGenerator;
import htmlGenerator.WishlistHtmlGenerator;

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
		UserManagementService service = new UserManagementServiceImpl();
		if("displayWatchlist".equals(action)){
			
			try {
				
				Iterator<Item> watchlist;
				watchlist = service.getWatchList((Long) req.getSession().getAttribute("currentSessionID"));
				System.out.println(watchlist.hasNext());

				res.setContentType("text/html");
				res.getWriter().write(WishlistHtmlGenerator.createItemTableHtml(watchlist));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if("remove".equals(action)){
			String userIDString = req.getParameter("userid");
			long userID = Long.parseLong(userIDString);
			
			String itemIDString = req.getParameter("itemid");
			long itemID = Long.parseLong(itemIDString);
			
			System.err.println("UserAction:addWatchList with ids "+userID+" item: "+itemID);
			try {
				if(service.deleteFromWatchList(itemID, userID)){
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
