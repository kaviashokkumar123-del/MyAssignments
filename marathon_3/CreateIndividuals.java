package marathon_3;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateIndividuals extends BaseClass {

	@Test(dataProvider = "fetchData")
	public void create_Ind(String cname) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(5000);
		WebElement element1 = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		wait.until(ExpectedConditions.elementToBeClickable(element1));
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(5000);
		List<WebElement> elements = driver.findElements(By.xpath("//p[text()='Service']"));
		if (!(elements.isEmpty())) {
			WebElement scroll = driver.findElement(By.xpath("//p[text()='Party Consent']"));
			driver.executeScript("arguments[0].scrollIntoView();", scroll);
			WebElement element2 = driver.findElement(By.xpath("//p[text()='Individuals']"));
			wait.until(ExpectedConditions.elementToBeClickable(element2));
			WebElement individual = driver.findElement(By.xpath("//p[text()='Individuals']"));
			driver.executeScript("arguments[0].click();", individual);
			Thread.sleep(5000);
			WebElement element3 = driver.findElement(By.xpath("//a[@class='forceActionLink']"));
			wait.until(ExpectedConditions.elementToBeClickable(element3));
			WebElement clk = driver.findElement(By.xpath("//a[@class='forceActionLink']"));

			driver.executeScript("arguments[0].click();", clk);

			driver.findElement(By.xpath("//input[contains(@class,'lastName compound')]")).sendKeys(cname);
			driver.findElement(By.xpath("(//span[text()='Save'])[1]")).click();
			String message = driver
					.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"))
					.getText();

			// Get the name alone
			String[] name = message.split(" ");
			String name_User = name[1];
			String name_UserRep = name_User.replaceAll("[^a-bA-z]", "");
			// verify Individuals Name
			SoftAssert sfassert = new SoftAssert();
			System.out.println(name_UserRep);
			sfassert.assertEquals(name_UserRep, cname);

			// Handle all assert
			sfassert.assertAll();
		} else {
			driver.findElement(By.xpath("//*[local-name()='svg' and @class='slds-button__icon slds-button__icon_large']")).click();
			Thread.sleep(10000);
			wait.until(ExpectedConditions.elementToBeClickable(element1));
			driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
			driver.findElement(By.xpath("//button[text()='View All']")).click();
			Thread.sleep(5000);
			WebElement scroll = driver.findElement(By.xpath("//p[text()='Party Consent']"));
			driver.executeScript("arguments[0].scrollIntoView();", scroll);
			WebElement element2 = driver.findElement(By.xpath("//p[text()='Individuals']"));
			wait.until(ExpectedConditions.elementToBeClickable(element2));
			WebElement individual = driver.findElement(By.xpath("//p[text()='Individuals']"));
			driver.executeScript("arguments[0].click();", individual);
			Thread.sleep(5000);
			WebElement element3 = driver.findElement(By.xpath("//a[@class='forceActionLink']"));
			wait.until(ExpectedConditions.elementToBeClickable(element3));
			WebElement clk = driver.findElement(By.xpath("//a[@class='forceActionLink']"));
			driver.executeScript("arguments[0].click();", clk);

			driver.findElement(By.xpath("//input[contains(@class,'lastName compound')]")).sendKeys(cname);
			driver.findElement(By.xpath("(//span[text()='Save'])[1]")).click();
			String message = driver
					.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"))
					.getText();

			// Get the name alone
			String[] name = message.split(" ");
			String name_User = name[1];
			String name_UserRep = name_User.replaceAll("[^a-bA-z]", "");
			// verify Individuals Name
			SoftAssert sfassert = new SoftAssert();
			System.out.println(name_UserRep);
			sfassert.assertEquals(name_UserRep, cname);

			// Handle all assert
			sfassert.assertAll();
		}
//		driver.findElement(By.xpath("//*[local-name()='svg' and @data-key='settings']")).click();
//		Actions ac = new Actions(driver);
//		ac.sendKeys(Keys.ESCAPE);

	}

	@DataProvider(name = "fetchData")
	public String[][] sendData() throws IOException {
		return ReadExcel.readData();
	}

}
