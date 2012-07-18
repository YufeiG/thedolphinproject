package htmlGenerator;

import java.util.Iterator;
import java.util.List;

import model.Item;

public class SearchHtmlGenerator {
	/**
	 * Used for generating HTML table
	 * @return A html table
	 */
	
	public static String createItemTableHtml(Iterator<Item> searchResult){
		StringBuilder table = new StringBuilder();
		table.append("<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" class=\"display\" id=\"searchResultTable\" width=\"100%\">");
		table.append("<thead>");
		table.append("<tr>");
		table.append("<th>Name</th>");
		table.append("<th>Category</th>");
		table.append("<th>Description</th>");
		table.append("<th>Price Low</th>");
		table.append("<th>Price High</th>");
		table.append("<th>Time Posted</th>");
		table.append("</tr>");
		table.append("</thead>");
		table.append("<tbody>");
		Item item;
		while(searchResult.hasNext()){
			item = searchResult.next();
			table.append("<tr>");
			table.append("<td><a href=\"viewItem.jsp?itemid="+item.getItemid()+"\">" + item.getTitle()+"</a></td>");
			table.append("<td>" + item.getCategoryString()+"</td>");
			table.append("<td>" + item.getDescription()+"</td>");
			table.append("<td>" + item.getPriceLowString()+"</td>");
			table.append("<td>" + item.getPriceHighString()+"</td>");
			table.append("<td>" + item.getTimeAdded().toString()+"</td>");
			table.append("</tr>");
		}
		
		table.append("</tbody>");
		
		// Adding table footer
		
//		table.append("<tfoot>");
//		table.append("<tr>");
//		table.append("<th>Name</th>");
//		table.append("<th>Category</th>");
//		table.append("<th>Description</th>");
//		table.append("<th>Price Low</th>");
//		table.append("<th>Price High</th>");
//		table.append("<th>Time Posted</th>");
//		table.append("</tr>");
//		table.append("</tfoot>");
		
		// End of table
		table.append("</table>");
		
		return table.toString();
	
	}
}
