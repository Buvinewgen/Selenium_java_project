package basePackage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import TestCase.FindBrokenLink;

public class CheckBrokenLink extends BaseClass  {

//	public static void main(String[] args) throws IOException { 
//		ChromeDriver driver=new ChromeDriver();
//		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
//		System.out.println("The Total number of the links ; "+allLinks.size());
//		ArrayList<String> allLink=new ArrayList<String>();
//
//		for(WebElement ele:allLinks) {
//			String url = ele.getAttribute("href");
//			allLink.add(url);
//			ChecBrokenlink(url);
//		}
//
//	}

	private static void ChecBrokenlink(String linkurl) throws IOException   {

		try {
			URL url=new URL(linkurl);
	           HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
	           httpURLConnect.setConnectTimeout(3000);
	           httpURLConnect.connect();
	           if(httpURLConnect.getResponseCode() >= 400) {
	        	   System.out.println(linkurl+" ---"+httpURLConnect.getResponseMessage()+"is Broken Link");
	           }else {
	        	   System.out.println(linkurl+" ---"+httpURLConnect.getResponseMessage());
   
	           }

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
