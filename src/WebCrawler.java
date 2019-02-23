import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class WebCrawler {
	
	private HashSet<String> links;
	private String URL;
	
	public WebCrawler() {
		links = new HashSet<String>();
	}
	
	public void getApartments(String URL) {
		getPricing();
		getApartmentInfo();
	}

	public void getPricing() {
		try {
			
			if(links.add(URL))
				System.out.println(URL);
			
			Document document = Jsoup.connect(URL).get();

			Elements priceSpanTag = document.select("span.zsg-photo-card-unit");
			
			String output, strongID, text;
			HashMap<String, String> pricePerRoom = new HashMap<String, String>();
			
			for(Iterator<Element> iterator = priceSpanTag.iterator(); iterator.hasNext();) {
				Element element = iterator.next();
				text = element.text();
				strongID = element.select("strong").text();
				output = text.replaceFirst(strongID,"");
				pricePerRoom.put(strongID, output);
				
				Set set = pricePerRoom.entrySet();
				Iterator item = set.iterator();
				while(item.hasNext()) {
					Map.Entry me = (Map.Entry)item.next();
					System.out.println(me.getKey() + "bdr " + me.getValue());
				}
			}
			
			
			
		} 
		
		catch (IOException e) {
			System.out.println("For '" + URL + "': " + e.getMessage());
		}
	}
	
	//extract apartment complex name and address
	public void getApartmentInfo() {
		
		try {
			
			Document document = Jsoup.connect(URL).get();

			Elements apartmentSpanTag = document.select("zsg-icon-for-rent");
			Elements addressSpanTag = document.select("zsg-photo-card-address");
			
			String output, text;
			HashMap<String, String> pricePerRoom = new HashMap<String, String>();
			
			for(Iterator<Element> iterator = apartmentSpanTag.iterator(); iterator.hasNext();) {
				Element element = iterator.next();
				text = element.text();
				
				Set set = pricePerRoom.entrySet();
				Iterator item = set.iterator();
				while(item.hasNext()) {
					Map.Entry me = (Map.Entry)item.next();
					System.out.println(me.getKey() + "bdr " + me.getValue());
				}
			}
			
			
			
		} catch (IOException e) {
			System.out.println("For '" + URL + "': " + e.getMessage());
		}
	}
	}
}
