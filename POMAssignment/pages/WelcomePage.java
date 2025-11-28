package pages;

import org.openqa.selenium.By;

import base.BaseClass;

public class WelcomePage extends BaseClass {

	public HomePage clickCrmsfa() {
		driver.findElement(By.linkText("CRM/SFA")).click();
		return new HomePage();
	}
}
