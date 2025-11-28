package testcases;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import pages.WelcomePage;

public class RunLogin extends BaseClass {
	@Test
	public void runLogin() {
		System.out.println(driver);
		LoginPage lp = new LoginPage();
		lp.enterUname().enterPwd().clickLogin().clickCrmsfa().clickLead().clickCreateLead().enterFname().enterLname()
				.enterCname().enterTitlename().clickSubmit();

	}
}
