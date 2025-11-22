package marathon_3;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class EditIndividuals extends BaseClass {

	@Test(dataProvider = "fetching", dependsOnMethods = "marathon_3.CreateIndividuals.create_Ind")
	public void edit_Ind(String cName, String eName) throws InterruptedException {

		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement element1 = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		wait.until(ExpectedConditions.elementToBeClickable(element1));
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement scroll = driver.findElement(By.xpath("//p[text()='Party Consent']"));
		driver.executeScript("arguments[0].scrollIntoView();", scroll);
		WebElement individual = driver.findElement(By.xpath("//p[text()='Individuals']"));
		driver.executeScript("arguments[0].click();", individual);
		Thread.sleep(3000);
		WebElement clk = driver.findElement(By.xpath("//span[text()='Name']"));
		driver.executeScript("arguments[0].click();", clk);
		Thread.sleep(2000);
		WebElement name = driver.findElement(By.xpath("//input[@name='Individual-search-input']"));
		name.sendKeys(cName);
		name.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		// .sendKeys("Kumars",Keys.ENTER);
		WebElement ele = driver.findElement(
				By.xpath("//button[@class='slds-button slds-button_icon-border slds-button_icon-x-small']"));
		driver.executeScript("arguments[0].click();", ele);
		Thread.sleep(3000);
		WebElement edit = driver.findElement(By.xpath("(//a[@class='highlightButton'])[1]"));
		driver.executeScript("arguments[0].click();", edit);
		driver.findElement(By.xpath("//a[@class='select']")).click();
		driver.findElement(By.xpath("//a[text()='Mr.']")).click();
		driver.findElement(By.xpath("//input[contains(@class,'firstName')]")).sendKeys(eName);
		driver.findElement(By.xpath("//span[text()='Save']")).click();
		Thread.sleep(2000);
		String msg = driver.findElement(By.xpath("//div[@class='slds-list--inline']")).getText();
		// Verify the first name as 'Ganesh'
		// Verify Whether Individual is Deleted using Individual last name"
		// Get the name alone
		String[] name1 = msg.split(" ");
		String name_User = name1[2];
		String name_UserRep = name_User.replaceAll("[^a-bA-z]", "");
		// verify Individuals Name
		SoftAssert sfassert = new SoftAssert();
		System.out.println(name_UserRep);
		sfassert.assertEquals(name_UserRep, eName);
		// Handle all assert
		sfassert.assertAll();
	}

	@DataProvider(name = "fetching")
	public String[][] sendData() throws IOException {
		return ReadExcel.readData1();
	}

}
