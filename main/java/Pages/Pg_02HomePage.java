package Pages;

import org.openqa.selenium.By;

import basePackage.BaseClassOrm;

public class Pg_02HomePage extends BaseClassOrm {
	
	public Pg_03PimPage clickPim() throws InterruptedException {
		getDriver().findElement(By.xpath("(//ul[@class='oxd-main-menu']/li[2]/a)")).click();
		System.out.println(getDriver().getTitle());
		Thread.sleep(1000);
		return new Pg_03PimPage();
	}
 public Pg_04AddUser clickAdmin() throws InterruptedException {
	 getDriver().findElement(By.xpath("//li[@class='oxd-main-menu-item-wrapper']//a")).click();
		Thread.sleep(1000);
	return new Pg_04AddUser();
 }
}
