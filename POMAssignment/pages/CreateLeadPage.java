package pages;

import org.openqa.selenium.By;

import base.BaseClass;

public class CreateLeadPage extends BaseClass{

	public CreateLeadPage enterFname()
	{
	// enter first name
			driver.findElement(By.xpath("(//input[@id='createLeadForm_firstName'])[1]")).sendKeys("Kavitha");
			return this;
	}
	public CreateLeadPage enterLname()
	{
			// enter last name
			driver.findElement(By.xpath("(//input[@id='createLeadForm_lastName'])[1]")).sendKeys("Kavitha");
			return this;
	}
	public CreateLeadPage enterCname()
	{
			// enter company name
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
			return this;
	}
	public CreateLeadPage enterTitlename()
	{
			// enter title name
			driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("TestLeafTitle");
			return this;
	}
	public ViewLeadsPage clickSubmit()
	{
			//click on create lead button.
			driver.findElement(By.name("submitButton")).click();
			return new ViewLeadsPage();
	}
}
