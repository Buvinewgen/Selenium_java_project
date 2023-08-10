package testCase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.Pg_01LoginPage;
import basePackage.BaseClassOrm;

public class VerifyLogin extends BaseClassOrm{
	@BeforeTest	
	public void setValue() {

		TestName="Verify login";
		TestDescription="Login with valid credential";
		author="Buvaneshwari";
		catagory="Functional";
	}
@Test	
	public void verifyLogin() throws Exception {
		
		Pg_01LoginPage Lp=new Pg_01LoginPage();
		Lp.enterUserName().enterPassword().clickLogin();
}

}
