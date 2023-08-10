package testCase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.Pg_01LoginPage;
import basePackage.BaseClassOrm;

public class VerifyEmployeeCreation extends BaseClassOrm {

	@BeforeTest	
	public void setValue() {

		TestName="Verify Employee Creation";
		TestDescription="Successfully created employee";
		author="Buvaneshwari";
		catagory="Functional";
	}


	@Test
	public void VerifyEmployeeCreation() throws Exception {

		Pg_01LoginPage Lp=new Pg_01LoginPage();
		Lp.enterUserName().enterPassword().clickLogin().clickPim().addemployee().
		emp_EnterUserFirst().emp_EnterUserMiddle().emp_EnterUserLastName().emp_getEmpId().Createemp();


	}



}
