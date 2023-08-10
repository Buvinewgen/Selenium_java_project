package basePackage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;

public class BaseClass {
	
private static final ThreadLocal<RemoteWebDriver> tlDriver=new ThreadLocal<RemoteWebDriver>();
    
    public RemoteWebDriver getDriver() {
        return tlDriver.get();
    }
    
    public void setDriver() {
        tlDriver.set(new ChromeDriver());
    }

@BeforeMethod
	public void precondition() {
	setDriver();
	getDriver();
	getDriver().manage().window().maximize();
	getDriver().get("https://www.fastfacts.co.in/");
	getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			
		}

@AfterMethod
	public void postcondition(){
	getDriver().quit();
		
	}

}
