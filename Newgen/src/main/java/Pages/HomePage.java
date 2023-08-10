package Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import TestCase.ExtraContent;
import TestCase.ExtraLinks;
import TestCase.FindBrokenLink;
import basePackage.BaseClass;


public class HomePage extends BaseClass{
	
	public static String linkfilename="HomepageLinks";
	public static String contentfilename="Homepagecontent";
	
@Test
	public void Homepage() throws IOException {
	
	ExtraLinks el=new ExtraLinks();
	el.ExtraLinks(linkfilename).ExtraContent(contentfilename);
//	FindBrokenLink fb=new FindBrokenLink();
//	fb.FindBrokenLink();
	}


}
