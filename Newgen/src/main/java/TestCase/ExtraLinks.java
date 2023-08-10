package TestCase;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Pages.HomePage;
import basePackage.BaseClass;


public class ExtraLinks extends BaseClass  {
	
	

	public  ExtraContent ExtraLinks(String linkfilename) throws IOException {

		List<WebElement> allLinks = getDriver().findElements(By.tagName("a"));
		System.out.println("The Total number of the links ; "+allLinks.size());
		

		try{
			
			BufferedWriter writer = new BufferedWriter(new FileWriter("./Resource/"+linkfilename+".txt"));
			
	for (WebElement link : allLinks) {
				//System.out.println(link.getText() + " - " + link.getAttribute("href"));
				String text = link.getText() + " - " + link.getAttribute("href");

				writer.write(text);
				writer.newLine();// Add a new line after each link

			}
			writer.close();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return new ExtraContent();
	}

}


