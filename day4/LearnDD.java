package week2.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class LearnDD {

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
		driver.findElement(By.xpath("(//input[@class='inputLogin'])[1]")).sendKeys("demosalesmanager");
		// Send password to the password text box
		driver.findElement(By.xpath("(//input[@class='inputLogin'])[2]")).sendKeys("crmsfa");
		// Click on Login button
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		// Click on CRM/SFA
		driver.findElement(By.xpath("//a[contains(text(),'M/SFA')]")).click();
		// Click Create Lead
		driver.findElement(By.xpath("//a[contains(text(),'Create Lead')]")).click();
		// Click on the companyname
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("TestLeaf");
		// FirstName
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("Kavitha");
		// lastName
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("Kavitha");
		// source DD:
		WebElement sourceDD = driver.findElement(By.xpath("//select[@name='dataSourceId']"));
		Select sel = new Select(sourceDD);
		sel.selectByIndex(4);
		// industryDD:
		WebElement industryDD = driver.findElement(By.xpath("//select[@id='createLeadForm_industryEnumId']"));
		Select sel1 = new Select(industryDD);
		sel1.selectByVisibleText("Computer Hardware");
	}

}
