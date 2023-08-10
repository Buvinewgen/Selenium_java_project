package testCase;

import java.io.IOException;

import org.testng.annotations.Test;

import Pages.Pg_01LoginPage;
import basePackage.BaseClassOrm;

public class VerifyAddUser extends BaseClassOrm {
@Test	
	public void verifyLogin() throws Exception {
	
	Pg_01LoginPage Lp=new Pg_01LoginPage();
	Lp.enterUserName().enterPassword().clickLogin().clickAdmin().clickAddUser().enterUserRole();
	}
	
	

}