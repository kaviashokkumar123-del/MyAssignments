package marathon_3;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DeleteOppurtunity extends BaseClass{


	@Test
	public void delete_Oppor() throws InterruptedException {
		
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement element1 = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		wait.until(ExpectedConditions.elementToBeClickable(element1));
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement clickSales = driver.findElement(By.xpath("//p[text()='Sales']"));
		driver.executeScript("arguments[0].click();", clickSales);
		Thread.sleep(3000);
		WebElement clickOppurtunity = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		driver.executeScript("arguments[0].click();", clickOppurtunity);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[local-name()='svg' and @class='slds-button__icon'])[4]")).click();

		driver.findElement(By.xpath(("//span[contains(text(),'Kanban')]"))).click();

		driver.findElement(By.xpath("//span[(text()='Cancel')]")).click();
		List<WebElement> clickDropDown = driver
				.findElements(By.xpath("//button[@class='slds-button slds-button_neutral showActionsButton']"));

		int size = clickDropDown.size();
		if (size > 0) {

			for (int i = 1; i <= size; i++) {

				WebElement element = driver.findElement(
						By.xpath("(//button[@class='slds-button slds-button_neutral showActionsButton'])[" + i + "]"));
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
				WebElement clickDelete = driver.findElement(By.xpath("//div[text()='Delete']"));
				driver.executeScript("arguments[0].click();", clickDelete);

				WebElement dell = driver.findElement(By.xpath("//button[@title='Delete']"));

				wait.until(ExpectedConditions.elementToBeClickable(dell));
				dell.click();

			}
		}

		else {
			System.out.println("All Oppurtunties are deleted");
		}

	}

}
