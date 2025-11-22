package marathon_3;

import java.io.IOException;
import java.time.Duration;

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

public class DeleteIndividuals extends BaseClass {

	@Test(dataProvider = "fetching")
	public void delete_Ind(String cName) throws InterruptedException {

		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(5000);
		WebElement element1 = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
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
		WebElement clk = driver.findElement(By.xpath("//span[text()='Name']"));
		driver.executeScript("arguments[0].click();", clk);
		Thread.sleep(2000);
		WebElement name = driver.findElement(By.xpath("//input[@name='Individual-search-input']"));
		name.sendKeys(cName);
		name.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		WebElement pop = driver.findElement(
				By.xpath("//button[@class='slds-button slds-button_icon-border slds-button_icon-x-small']"));
		driver.executeScript("arguments[0].click();", pop);//// div[@class='uiPopupTrigger']
		// Thread.sleep(2000);
		WebElement delete = driver.findElement(By.xpath("//div[text()='Delete']"));
		driver.executeScript("arguments[0].click();", delete);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@title='Delete']")).click();
		String msg = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		System.out.println(msg);
		Thread.sleep(3000);
		String verify = driver
				.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"))
				.getText();
		// Verify Whether Individual is Deleted using Individual last name"
		// Get the name alone
		String[] name1 = verify.split(" ");
		String name_User = name1[1];
		String name_UserRep = name_User.replaceAll("[^a-bA-z]", "");
		// verify Individuals Name
		SoftAssert sfassert = new SoftAssert();
		System.out.println(name_UserRep);
		sfassert.assertEquals(name_UserRep, cName);

		// Handle all assert
		sfassert.assertAll();
	}

	@DataProvider(name = "fetching")
	public String[][] sendData() throws IOException {
		return ReadExcel.readData();
	}

}
