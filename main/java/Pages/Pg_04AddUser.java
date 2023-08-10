package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

import basePackage.BaseClassOrm;

public class Pg_04AddUser extends BaseClassOrm{
	
	public Pg_04AddUser clickAddUser() {
		getDriver().findElement(By.xpath("(//button[contains(@class,'oxd-button oxd-button--medium')])[3]")).click();
		return this;
	}
	
	public Pg_04AddUser enterUserRole() {
		WebElement findElement = getDriver().findElement(By.xpath("//div[@class='oxd-select-text-input']"));
		findElement.click();
		findElement.sendKeys("ESS");
		return this;
	}
}
