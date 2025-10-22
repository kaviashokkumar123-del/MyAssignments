package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestLeafDeleteLead {

	public static void main(String[] args) {
		// Chrome Options to login as guest
		ChromeOptions option = new ChromeOptions();
		option.addArguments("guest");
		// Instantiate Chrome driver
		ChromeDriver driver = new ChromeDriver(option);
		// launch the application
		driver.get("http://leaftaps.com/opentaps/.");
		// Maximize the browser window.
		driver.manage().window().maximize();
		// Send username to the username text box
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demosalesmanager");
		// Send password to the password text box
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		// Click on Login button
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		// Click on CRM/SFA
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		// click on leads
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		// click on Find Leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		// Click on Phone tab
		driver.findElement(By.xpath("(//form[@class=' x-form'])[7]/div/div/div/ul/li[2]")).click();
		// enter country code
		driver.findElement(By.name("phoneCountryCode")).click();
		driver.findElement(By.name("phoneCountryCode")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.name("phoneCountryCode")).sendKeys("1");
		// enter phone area code
		driver.findElement(By.name("phoneAreaCode")).sendKeys("408");
		// Enter phone number
		driver.findElement(By.name("phoneNumber")).sendKeys("5551234");
		// click on find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		//Due to stale element exception using the below wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("((//div[@class='x-panel-mc'])[7]/div/div/div/div[2]/div/div/table/tbody/tr/td)[1]")));
		element.click();
		// capture the lead Id
		String leadId = driver
				.findElement(
						By.xpath("((//div[@class='x-panel-mc'])[7]/div/div/div/div[2]/div/div/table/tbody/tr/td)[1]"))
				.getText();
		System.out.println(leadId);
		// click on the first resulting lead
		driver.findElement(
				By.xpath("((//div[@class='x-panel-mc'])[7]/div/div/div/div[2]/div/div/table/tbody/tr/td)[1]/div/a")).click();
		// click on delete button
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		// click on Find Leads again
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		// Click on Phone tab again
		driver.findElement(By.xpath("(//form[@class=' x-form'])[7]/div/div/div/ul/li[2]")).click();
		// enter country code again
		driver.findElement(By.name("phoneCountryCode")).click();
		driver.findElement(By.name("phoneCountryCode")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.name("phoneCountryCode")).sendKeys("1");
		// enter phone area code again
		driver.findElement(By.name("phoneAreaCode")).sendKeys("408");
		// Enter phone number again
		driver.findElement(By.name("phoneNumber")).sendKeys("5551234");
		// click on find leads button again
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='x-panel-bbar']/div/div[text()='No records to display']")));
		// get the message
		String message = driver.findElement(By.xpath("//div[@class='x-panel-bbar']/div/div[text()='No records to display']")).getText().trim();
		System.out.println(message);
		// Validate the message details
		if (message.equals("No records to display")) {
			System.out.println("The lead record is deleted successfully");
		} else {
			System.out.println("The lead record is not successfully deleted");
		}

	}

}
