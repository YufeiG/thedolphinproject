package controller;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import listingService.ListingService;
import model.Item;
import model.User;
import userManagementService.UserManagementService;


public class ItemAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7043942560364197113L;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws java.io.IOException {
		String action = req.getParameter("action");
		if(action.equals("create"))
		{
			String title = req.getParameter("title");
			String description = req.getParameter("description");
			String date1 = req.getParameter("date1");
			String date2 = req.getParameter("date2");
			String price1 = req.getParameter("price1");
			String price2 = req.getParameter("price2");
			String user = req.getParameter("user");
			String cat = req.getParameter("category");
			
			Item item = new Item(0, title, 0, 0.0, description, false,
					date1, date2, 0.0, 1.0, 0, new Date(), new Date());
			
			ListingService service = new ListingService();
			if(!service.createItem(item))
			{
				System.err.println("Item not created : " + title);
			}
			else
			{
				System.err.println("Item created for : " + title);
			}
			
			
			
			
		}

		

	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws java.io.IOException {
		doPost(req, res);
	}
}
