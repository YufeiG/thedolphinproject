package controller;
import global.MarketplaceConfig;

import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import listingService.ListingService;
import listingService.ListingServiceImpl;
import model.Item;
import model.User;
import userManagementService.UserManagementService;
import userManagementService.UserManagementServiceImpl;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ItemAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7043942560364197113L;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws java.io.IOException {
		String action = req.getParameter("action");
		res.setContentType("text/html");
		
		HttpSession session = req.getSession(true);
		long userid = (Long)session.getAttribute("currentSessionID");
	
		
		if(action == null)
		{
			res.getWriter().write("error");
			return;
		}
		ListingService service = new ListingServiceImpl();
		
		if(action.equals("create") || action.equals("edit"))
		{
			String title = req.getParameter("title");
			String description = req.getParameter("description");
			String date1 = req.getParameter("date1");
			String date2 = req.getParameter("date2");
			
			Date date1Parsed = new Date();
			Date date2Parsed = new Date();
			try {
				date1Parsed = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH).parse(date1);
				date2Parsed = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH).parse(date2);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
			String price1 = req.getParameter("price1");
			String price2 = req.getParameter("price2");
			
			double price1Parsed = Double.valueOf(price1.trim()).doubleValue();
			double price2Parsed = Double.valueOf(price2.trim()).doubleValue();
			
			String user = req.getParameter("user");
			String cat = req.getParameter("category");
			
			int categoryID = MarketplaceConfig.Category.valueOf(cat).getValue();
			
			String userIDString = req.getParameter("userid");
			if(userIDString == null || userIDString.equals("null")||userIDString.equals(""))
			{
				// can't create item without logging in
				System.err.println("Item not created because null user");
				res.getWriter().write("error");
				return;
			}
			System.err.println("User exists "+userIDString +"-");
			long userID = Long.parseLong(userIDString);

			String tags = req.getParameter("tags");
			String[] tagsArray = tags.split(",");
			List<String> tagsList = Arrays.asList(tagsArray);
			
			String itemIDString = req.getParameter("itemid");
			
			long itemID = 0;
			if(itemIDString != null){
				itemID = Long.parseLong(itemIDString);
			}
			
			Item item = new Item(itemID, title, categoryID, userID, description, 0,
					date1Parsed, date2Parsed, price1Parsed, price2Parsed, 0, new Date(), new Date());
			
			try{
				if(action.equals("create")){
					if(!service.createItem(item, tagsList))
					{
						System.err.println("Item not created : " + title);
						res.getWriter().write("false");
					}
					else
					{
						System.err.println("Item created for : " + title);
						res.getWriter().write("true");
					}
				}
				else if(action.equals("edit")){
					if(!service.editItem(item, tagsList))
					{
						System.err.println("Item not edited : " + title);
						res.getWriter().write("false");
					}
					else
					{
						System.err.println("Item edited for : " + title);
						res.getWriter().write("true");
					}
				}
			}
			catch(SQLException e){
				e.printStackTrace();
				res.getWriter().write("error");
			}
			
		}
		else if(action.equals("get"))
		{
			String itemIDString = req.getParameter("itemid");
			
			long itemID = Long.parseLong(itemIDString);
			System.err.println("Getting item..."+itemID);

			Item item = service.getItem(itemID);
			
			UserManagementService userService = new UserManagementServiceImpl();
			try {
				User user = userService.getAccount(item.getUserid());
				

				if(item != null && user != null)
				{
					
					Iterator<String> tags = service.getItemTags(itemID);
					String tagsString = "";
					while(tags.hasNext())
					{
						String t = tags.next();
						if(tags.hasNext()) tagsString += t + ",";
						else tagsString += t;
					}
					
					
					System.err.println(item.getCategoryString());

					String data = item.getTitle() + "|" + item.getDescription() + "|" + item.getAvailStart() + "|" + item.getAvailEnd()
							+ "|" + item.getPriceLowString() + "|" + item.getPriceHighString() + "|" + user.getUsername() + "|"
							+ user.getEmail() + "|" + user.getPhoneNumber()+"|"+item.getCategoryString() +"|" +(userService.isInWatchList(itemID, userid) ? "true":"false") +"|" + (user.getUserid() == userid ? "true" : "false")
							+ "|" + tagsString;
					res.getWriter().write(data);
				}
				else
				{
					res.getWriter().write("false");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				res.getWriter().write("error");
			}			
		}
		else if(action.equals("delete")){
			String itemIDString = req.getParameter("itemid");
			
			long itemID = Long.parseLong(itemIDString);
			System.err.println("Deleting item..."+itemID);
			
			Item item = service.getItem(itemID);
			try{
				if(service.deleteItem(item)){
					res.getWriter().write("true");
				}
				else{
					res.getWriter().write("false");
				}
				
			}
			catch(SQLException e){
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
