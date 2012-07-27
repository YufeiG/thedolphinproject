package email;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import model.Item;
import model.User;

public class EmailNotification {

	public void sendMessageToUser(HashMap<User, List<Item>> list){
		Iterator<User> it = list.keySet().iterator();
		
		while(it.hasNext()){
			User currentUser = it.next();
			List<Item> items = list.get(currentUser);
			
			StringBuffer sb = new StringBuffer();
			
			Iterator<Item> itemIt = items.iterator();
			while(itemIt.hasNext()){
				Item curItem = itemIt.next();
				sb.append(curItem.getTitle() + " : " + curItem.getDescription());
			}
			
			try {
				SimpleEmail email = new SimpleEmail();
				email.addTo(currentUser.getEmail());
				email.setMsg(sb.toString());
				email.setSubject("Wish List Match");
				email.setFrom("uwaterloo.marketplace@gmail.com", "UW Marketplace");
				//email.setHostName("smtp.googlemail.com");
				//email.setSmtpPort(465);
				//email.setAuthenticator(new DefaultAuthenticator("uwaterloo.marketplace@gmail.com", "cs446avenger"));
				email.send();
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
