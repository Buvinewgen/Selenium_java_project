package basePackage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.cucumber.testng.AbstractTestNGCucumberTests;

public class BaseClassOrm{



	private static final ThreadLocal<RemoteWebDriver> tlDriver=new ThreadLocal<RemoteWebDriver>();

	public RemoteWebDriver getDriver() {
		return tlDriver.get();
	}

	public void setDriver() {
		tlDriver.set(new ChromeDriver());
	}
//	public static RemoteWebDriver driver;
	public static ExtentReports extent;
	public String TestName,TestDescription,author,catagory;
	public static ExtentTest Test;

	@BeforeSuite
	public void startReoprt() {
		ExtentHtmlReporter report=new ExtentHtmlReporter("./Report/result.html");
		report.setAppendExisting(true);
		extent=new ExtentReports();
		extent.attachReporter(report);
	}

	@BeforeClass
	public void testCasedetails() {
		Test = extent.createTest(TestName,TestDescription);
		Test.assignAuthor(author);
		Test.assignCategory(catagory);
	}


	public void reportStep(String message,String status) throws Exception {
		if(status.equalsIgnoreCase("pass")) {
			Test.pass(message,MediaEntityBuilder.createScreenCaptureFromPath(".././snap/shot" + takeSnap() + ".jpg").build());
			//Test.pass(message);
		}
		else if(status.equalsIgnoreCase("fail")) 
		{
		Test.fail(message,MediaEntityBuilder.createScreenCaptureFromPath(".././snap/shot" + takeSnap() + ".jpg").build());
		//Test.fail(message);
		throw new Exception ("check your locator");  //this line for when you get exception it pause your execution
		}
	}
	public int takeSnap() throws IOException {
		int r = (int) (Math.random() * 999999);
		File screenshotAs = getDriver().getScreenshotAs(OutputType.FILE);
		File destn = new File("./snap/shot" + r + ".jpg");
		FileUtils.copyFile(screenshotAs, destn);
		return r;
	}
	
	@AfterSuite
	public void endRopert() {
		extent.flush();
	}


	@BeforeMethod
	public void precondition() {
		setDriver();
		getDriver();
		getDriver().manage().window().maximize();
		getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

	}

	@AfterMethod
	public void postcondition(){
		getDriver().quit();

	}

}
