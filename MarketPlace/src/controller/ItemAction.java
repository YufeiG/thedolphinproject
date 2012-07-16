package controller;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import listingService.ListingService;
import listingService.ListingServiceImpl;
import model.Item;
import model.User;
import userManagementService.UserManagementService;
import userManagementService.UserManagementServiceImpl;

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
		
		if(action == null)
		{
			res.getWriter().write("error");
			return;
		}
		ListingService service = new ListingServiceImpl();
		
		if(action.equals("create"))
		{
			String title = req.getParameter("title");
			String description = req.getParameter("description");
			String date1 = req.getParameter("date1");
			String date2 = req.getParameter("date2");
			System.err.println("DATE IS ");
			System.err.println("DATE IS "+date1+" "+date2);
			
			
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

			Item item = new Item(0, title, 0, userID, description, 0,
					date1Parsed, date2Parsed, price1Parsed, price2Parsed, 0, new Date(), new Date());
			

				
			if(!service.createItem(item))
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
		else if(action.equals("get"))
		{
			String itemIDString = req.getParameter("itemid");
			System.err.println("Getting item..."+itemIDString);
			long itemID = Long.parseLong(itemIDString);
			

			Item item = service.getItem(itemID);
			
			UserManagementService userService = new UserManagementServiceImpl();
			try {
				User user = userService.getAccount(item.getUserid());
				
				if(item != null && user != null)
				{
					String data = item.getTitle() + "," + item.getDescription() + "," + item.getAvailStart() + "," + item.getAvailEnd()
							+ "," + item.getPriceLow() + "," + item.getPriceHigh() + "," + user.getUsername() + ","
							+ user.getEmail() + "," + user.getPhoneNumber();
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

		

	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws java.io.IOException {
		doPost(req, res);
	}
}
