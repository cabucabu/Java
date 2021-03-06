import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class GetPriceOil {
	public static BufferedReader BR;


	public static void main(String args[]){
		String price = "";
		init(); 
//		price = GetPriceOil.getGasoline95();
//		price = GetPriceOil.getGasohol91();
//		price = GetPriceOil.getGasohol95();
//		price = GetPriceOil.getGasoholE20();
//		price = GetPriceOil.getGasoholE85();
//		price = GetPriceOil.getDiesel();
//		price = GetPriceOil.getHyForcePremiumDiesel();
		price = GetPriceOil.getNGV();
		end();
		System.out.println("getNGV : "+price);
	}
	

	public static String getNGV() {
		return getPrice("uxNGVPrice");
	}
	
	public static String getHyForcePremiumDiesel() {
		return getPrice("HyForcePremiumDiesel");
	}

	public static String getDiesel() {
		return getPrice("uxDieselPrice");
	}

	public static String getGasoholE85() {
		return getPrice("uxGasoholE85Price");
	}
	
	public static String getGasoline95(){
		return (getPrice("uxGasoline95Price"));
	}
	
	public static String getGasoholE20(){
		return (getPrice("uxGasoholE20Price"));
	}

	public static String getGasohol91() {
		return (getPrice("uxGasohol91Price"));
	}

	public static String getGasohol95() {
		return (getPrice("uxGasohol95Price"));
	}


	private static String getPrice(String key) {
		String inputLine,price;
		try {
			while((inputLine = BR.readLine()) != null){
				if(inputLine.contains(key)){
					price = inputLine.split("title=\"")[1].split("\"")[0];
					return price;
				}
			}
		} catch (IOException e) {
			System.out.println("error getPrice");
			e.printStackTrace();
		}
		return "";
	}
	
	private static void init() {
		URL url;
		try {
			// get URL content
			String a = "http://www.pttplc.com/th/getoilprice.aspx";
			url = new URL(a);
			URLConnection conn = url.openConnection();
			// open the stream and put it into BufferedReader
			BR = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void end(){
		try {
			BR.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
