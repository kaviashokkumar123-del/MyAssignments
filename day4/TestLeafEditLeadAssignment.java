package week2.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class TestLeafEditLeadAssignment {

	public static void main(String[] args) {
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
		driver.findElement(By.xpath("(//input[@id='createLeadForm_firstName'])[1]")).sendKeys("Kavitha");
		// enter last name
		driver.findElement(By.xpath("(//input[@id='createLeadForm_lastName'])[1]")).sendKeys("Kavitha");
		// enter company name
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("TestLeaf");
		// enter first name (local)
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstNameLocal']"))
				.sendKeys("TestLeafTitleLastNameLocal");
		// enter department name
		driver.findElement(By.xpath("//input[@id='createLeadForm_departmentName']"))
				.sendKeys("TestLeafTitle Department");
		// enter the description
		driver.findElement(By.id("createLeadForm_description")).sendKeys("TestLeafTitle Department");
		// enter email Id
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("TestLeafTitle@gmail.com");
		// Select state
		WebElement state = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select st = new Select(state);
		st.selectByVisibleText("New York");
		// click on create lead button.
		driver.findElement(By.name("submitButton")).click();
		// click on edit button
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		// clear the description field
		driver.findElement(By.id("updateLeadForm_description")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.id("updateLeadForm_description")).sendKeys(Keys.chord(Keys.DELETE));
		// fill important note field:
		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("Important notes added now");
		// click on update button
		driver.findElement(By.xpath("(//input[@name='submitButton'])[1]")).click();
		// get title:
		String getTitle = driver.getTitle();
		System.out.println("The Title of the page :" + getTitle);
		// close the browser
		driver.close();

	}

}
