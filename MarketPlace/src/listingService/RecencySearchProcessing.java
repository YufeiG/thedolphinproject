package listingService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import model.Item;

public class RecencySearchProcessing implements SearchProcessing  {

	@Override
	public List<Item> process(List<Item> list) {
		
		if(list == null || list.size() <= 1){
			return list;
		}
		
		Collections.sort(list, new Comparator<Item>() {

			@Override
			public int compare(Item o1, Item o2) {
				if(o1.getTimePosted().before(o2.getTimePosted())){
					return -1;
				}
				else if(o1.getTimePosted().equals(o2.getTimePosted())){
					return 0;
				}
				else{
					return 1;
				}
			}
				
			});
		
		
		return list;
	}

}
