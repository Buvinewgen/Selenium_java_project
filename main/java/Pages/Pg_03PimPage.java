package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import basePackage.BaseClassOrm;

public class Pg_03PimPage extends BaseClassOrm{

	public Pg_03PimPage addemployee() throws InterruptedException {

		getDriver().findElement(By.xpath("//i[@class='oxd-icon bi-plus oxd-button-icon']")).click();
		Thread.sleep(2000);
		return this;
	}
	public Pg_03PimPage emp_EnterUserFirst() {

		getDriver().findElement(By.name("firstName")).sendKeys("Test");
		return this;
	}
	public Pg_03PimPage emp_EnterUserMiddle() {

		getDriver().findElement(By.name("middleName")).sendKeys("S");
		return this;
	}
	public Pg_03PimPage emp_EnterUserLastName() throws InterruptedException {

		getDriver().findElement(By.name("lastName")).sendKeys("Buvi");
		Thread.sleep(2000);

		return this;
	}
	
	  public Pg_03PimPage emp_getEmpId() {
	  
	  WebElement text = getDriver().findElement(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]"));
	   System.out.println("emp id : "+text.getText()); 
	   return this;
	 
	  }
	 
	public void Createemp() throws InterruptedException {
		getDriver().findElement(By.xpath("//button[@type=\"submit\"]")).click();
		Thread.sleep(2000);

     System.out.println("EMP created ");
	}
	
}
