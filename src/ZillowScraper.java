// This class is used for HTML parsing from URL using Jsoup.
// @author Andrew Schwartz
import webscraper.Scraper;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ZillowScraper {

		public static void main(String args[]){
			print("running...");
			WebCrawler wc = new WebCrawler();
			wc.getApartments("https://www.zillow.com/homes/for_rent/Laurel-MD/apartment_duplex_type"
					+ "/35593_rid/1-_beds/1-_baths/760-_size/1_parking/1_laundry/39.191553,-76.702767,38.995173,-76.988755_rect/11_zm/");
//			Document document;
//			Elements price1, houses, apartments;
//			String price2; 
//			String[] price2List;
//			try {
//				//Get Document object after parsing the html from given url.
//				document = Jsoup.connect("https://www.zillow.com/homes/for_rent/Laurel-MD/apartment_duplex_type/35593_rid/1-_beds/1-_baths/760-_size/1_parking/1_laundry/39.191553,-76.702767,38.995173,-76.988755_rect/11_zm/").get();
//				price1 = document.select(".zsg-photo-card-price:contains($)");  //Get price
//				price2 = document.select(".zsg-photo-card-unit:contains($)").text();  //Picks up on pricing for apartments
//				apartments = document.select(".zsg-photo-card-address:contains(Laurel)");
//				houses = document.select("span[itemprop]:contains(Laurel)");
//				
//				String title = document.title(); //Get title
//				print("  Title: " + title); //Print title.
//				
//				price2List = splitStringEvery(price2, 26);
//				
//				FileOutputStream fout = new FileOutputStream("output_zillow.csv");
//				PrintStream csv = new PrintStream(fout);
//				csv.println("name    price");
//				
////				for(int i = 0; i < price1.size(); i++) {
////					print(houses.get(i).text() + "    " + price1.get(i).text());
////					csv.println(houses.get(i).text() + "    " + price1.get(i).text());
////				}
//				
//				//will print out prices with leading digits
//				//these digits refer to "strong" tagged elements in the html
//				//they refer to the amount of rooms (i.e. 1 bdr $1,200+ => 1$1,200+)
//				for(int i = 0; i < price2List.length; i++) {
//					print(apartments.get(i).text() + "    " + price2List[i]);   
//					csv.println(apartments.get(i).text() + "    " + price2List[i]);    
//				}
//				csv.close();
//				fout.close();
//
//
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			print("done");
//			
//			Scraper scraper = new Scraper("https://washingtondc.craigslist.org/d/free-stuff/search/zip");
//			Elements itemTitle;
//			
//			try {
//				String title = scraper.getDoc().title();
//				print("   Title: " + title);
//				
//				itemTitle = scraper.getDoc().select()  //select the a.result-title.hdrlink
//			}
		}

		public static void print(String string) {
			System.out.println(string);
		}
		
		public static String[] splitStringEvery(String s, int interval) {
		    int arrayLength = (int) Math.ceil(((s.length() / (double)interval)));
		    String[] result = new String[arrayLength];

		    int j = 0;
		    int lastIndex = result.length - 1;
		    for (int i = 0; i < lastIndex; i++) {
		        result[i] = s.substring(j, j + interval);
		        j += interval;
		    } //Add the last bit
		    result[lastIndex] = s.substring(j);

		    return result;
		}
	}
