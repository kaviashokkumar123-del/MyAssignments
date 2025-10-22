package week2.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestLeafCreateAccount {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		// Instantiate the chromeDriver
		ChromeDriver driver = new ChromeDriver(options);
		// launch the browser and navigate the URL
		driver.get("http://leaftaps.com/opentaps/control/main");
		// Maximize the window
		driver.manage().window().maximize();
		// Send username to the username text box
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		// Send password to the password text box
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		// Click on Login button
		driver.findElement(By.className("decorativeSubmit")).click();
		// Click on CRM/SFA
		driver.findElement(By.partialLinkText("M/SFA")).click();
		// Click Accounts Tab
		driver.findElement(By.linkText("Accounts")).click();
		// Click on Create Account
		driver.findElement(By.linkText("Create Account")).click();
		// Enter the Account Name
		driver.findElement(By.id("accountName")).sendKeys("TestLeaf");
		// Description
		driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester");
		// Number of Employees
		driver.findElement(By.id("numberEmployees")).sendKeys("10");
		// Site Name
		driver.findElement(By.id("officeSiteName")).sendKeys("LeafTaps");
		// Click Create Account button
		driver.findElement(By.className("smallSubmit")).click();
		// get the title name
		String titleName = driver.getTitle();
		System.out.println("The title Name is: " + titleName);
		// Close the Browser
		driver.close();
	}

}
