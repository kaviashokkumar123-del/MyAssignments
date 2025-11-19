package week6.homeassignment.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLead {

	@DataProvider(name = "fectingData")
	public String[][] dataMethod() {
		String[][] data = { { "Kavitha", "A", "TestLeaf" }, { "Kavya", "A", "TCS" }, { "Kalai", "B", "CTS" } };
		return data;
	}

	@Test(dataProvider = "fectingData", invocationCount=2)
	public void testLeaf_CL(String fName, String lName, String cmpName) {
		// To launch the application in the guest mode.
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		// Instantiate the object for the ChromDriver.
		ChromeDriver driver = new ChromeDriver(options);
		// launch the application.
		driver.get("http://leaftaps.com/opentaps/control/main");
		// maximize the window
		driver.manage().window().maximize();
		// Send username to the username text box
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		// Send password to the password text box
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		// Click on Login button
		driver.findElement(By.className("decorativeSubmit")).click();
		// Click on CRM/SFA
		driver.findElement(By.partialLinkText("M/SFA")).click();
		// click on Leads tab
		driver.findElement(By.linkText("Leads")).click();
		// Click on create lead
		driver.findElement(By.linkText("Create Lead")).click();
		// enter first name
		driver.findElement(By.xpath("(//input[@id='createLeadForm_firstName'])[1]")).sendKeys(fName);
		// enter last name
		driver.findElement(By.xpath("(//input[@id='createLeadForm_lastName'])[1]")).sendKeys(lName);
		// enter company name
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cmpName);
		// enter title name
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("TestLeafTitle");
		// click on create lead button.
		driver.findElement(By.name("submitButton")).click();
		// get the title
		String getTitle = driver.getTitle();
		System.out.println("The Title of the page :" + getTitle);
		// close the browser
		driver.close();

	}

}
