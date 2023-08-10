package TestCase;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import basePackage.BaseClass;

import basePackage.CheckBrokenLink;

public class FindBrokenLink extends BaseClass {

	public  FindBrokenLink  FindBrokenLink() throws IOException {

		List<WebElement> allLinks = getDriver().findElements(By.tagName("a"));
		System.out.println("The Total number of the links ; "+allLinks.size());
		ArrayList<String> allLink=new ArrayList<String>();

		for(WebElement ele:allLinks) {
			String url = ele.getAttribute("href");
			allLink.add(url);
			ChecBrokenlink(url);
		}
		return this;	
	}

	private void ChecBrokenlink(String linkurl) throws IOException   {

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



