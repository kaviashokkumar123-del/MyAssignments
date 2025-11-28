package stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteEditSD extends BaseClass {
	String leadId;

	@When("Capture the first result")
	public void capture_the_first_result() throws InterruptedException {
		// Due to stale element exception using the below wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(150));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("((//div[@class='x-panel-mc'])[7]/div/div/div/div[2]/div/div/table/tbody/tr/td)[1]")));
		Thread.sleep(3000);
		element.click();
		// capture the lead Id
		leadId = driver
				.findElement(
						By.xpath("((//div[@class='x-panel-mc'])[7]/div/div/div/div[2]/div/div/table/tbody/tr/td)[1]"))
				.getText();
		System.out.println(leadId);
		driver.findElement(
				By.xpath("((//div[@class='x-panel-mc'])[7]/div/div/div/div[2]/div/div/table/tbody/tr/td)[1]/div/a"))
				.click();

	}

	@When("click on Delete button")
	public void click_on_delete_button() {
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
	}

	@Then("Validate the lead is successfully deleted")
	public void validate_the_lead_is_successfully_deleted() {
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement element2 = wait1.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[@class='x-panel-bbar']/div/div[text()='No records to display']")));
		// get the message
		String message = driver
				.findElement(By.xpath("//div[@class='x-panel-bbar']/div/div[text()='No records to display']")).getText()
				.trim();
		System.out.println(message);
		// Validate the message details
		if (message.equals("No records to display")) {
			System.out.println("The lead record is deleted successfully");
		} else {
			System.out.println("The lead record is not successfully deleted");
		}

	}

}
