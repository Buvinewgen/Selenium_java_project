package Pages;

import java.io.IOException;

import org.openqa.selenium.By;

import basePackage.BaseClassOrm;

public class Pg_01LoginPage extends BaseClassOrm {

	public Pg_01LoginPage enterUserName() throws Exception {
		try {
		getDriver().findElement(By.name("username")).sendKeys("Admin");
		reportStep("Username is entered successfully","pass");
		}catch (Exception e) {
		reportStep("Username is not entered successfully " + e,"fail");
		}
		return this;
	}
	public Pg_01LoginPage enterPassword() throws Exception {
		try {
		getDriver().findElement(By.name("password")).sendKeys("admin123");
		reportStep("Password is enterd successfully","pass");
		}catch (Exception e) {
			reportStep("password is not entered successfully " + e,"fail");
			}
		return this;
	}
	
	public Pg_02HomePage clickLogin() throws Exception {
		try {
		getDriver().findElement(By.xpath("//button[@type='submit']")).click();
		reportStep("login successully","pass");
	}catch (Exception e) {
		reportStep("login not  successfully " + e,"fail");
		}
		return new Pg_02HomePage();
	}
}
