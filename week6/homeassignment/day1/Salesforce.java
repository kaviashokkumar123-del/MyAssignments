package week6.homeassignment.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.*;

public class Salesforce {

	public static void main(String[] args) throws InterruptedException {
		// Instantaite the ChromeOptions
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("user-data-dir=C:\\Users\\jaanv\\Sessions");
		// Instantiate the browser
		ChromeDriver driver = new ChromeDriver(options);

		// launch the broswer
		driver.get("https://login.salesforce.com");

		// global wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		// maximize window
		driver.manage().window().maximize();

		// username - kaviashokkumar123118@agentforce.com
		// Enter user name
		WebElement u_Name = driver.findElement(By.id("username"));
		u_Name.sendKeys("kaviashokkumar123118@agentforce.com");

		// Enter password
		WebElement pWord = driver.findElement(By.id("password"));
		pWord.sendKeys("Kalai12#Arvind", Keys.ENTER);

		Thread.sleep(3000);

		// Click on the toggle
		WebElement toogle = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		toogle.click();

		// Click on the View All
		WebElement view_All = driver.findElement(By.xpath("//button[text()='View All']"));
		view_All.click();

		WebElement legal_Entities = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		Actions ac = new Actions(driver);
		ac.scrollToElement(legal_Entities).pause(Duration.ofSeconds(5)).click(legal_Entities).build().perform();

		// click on NEw
		WebElement new_Btn = driver.findElement(By.xpath("//a[@class='forceActionLink']"));
		new_Btn.click();

		// Enter Legal Entity name
		WebElement legal_Name = driver.findElement(By.xpath("//input[@name='CompanyName']"));
		legal_Name.sendKeys("TestLeaf");

		// Enter description
		WebElement descrption = driver.findElement(By.xpath("(//textarea[@part='textarea'])[2]"));
		descrption.sendKeys("Salesforces");

		Thread.sleep(1000);

		// Select the status
		WebElement status = driver.findElement(By.xpath("//button[@part='input-button']"));
		status.sendKeys(Keys.TAB);

		// select active status
		status.click();
		WebElement status_Active = driver.findElement(By.xpath("//span[text()='Active']"));
		status_Active.click();

		// click save button
		WebElement save = driver.findElement(By.xpath("//button[text()='Save']"));
		save.click();

		// get the msg
		ac.scrollToElement(legal_Name).perform();
		String get_Msg = driver.findElement(By.xpath("//div[contains(text(),'Complete this field.')]")).getText()
				.trim();
		String repl_Msg = get_Msg.replaceAll("Legal Entity Name", "").trim();
		System.out.println(repl_Msg);
		String expect_Msg = "Complete this field.";
		System.out.println(expect_Msg);
		SoftAssert sf = new SoftAssert();
		sf.assertEquals(repl_Msg, expect_Msg, "Alert Message is validation and it is displayed as expected");

		sf.assertAll();

		driver.quit();

	}

}