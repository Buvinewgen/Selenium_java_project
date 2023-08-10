package TestCase;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import basePackage.BaseClass;


public class ExtraContent extends BaseClass{

	public  ExtraContent ExtraContent(String contentfilename){

		String pageContent = getDriver().findElement(By.xpath("/html/body")).getText();
		System.out.println(pageContent);

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("./Resource/"+contentfilename+".txt"));
			writer.write(pageContent);
			writer.newLine();// Add a new line after each link
			writer.close();
			System.out.println("Content saved to file successfully!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this;

	}

}
