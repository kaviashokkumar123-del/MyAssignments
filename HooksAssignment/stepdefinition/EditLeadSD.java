package stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.When;

public class EditLeadSD extends BaseClass {

	@When("click on Find leadLink")
	public void click_on_find_lead_link() throws InterruptedException {
		driver.findElement(By.linkText("Find Leads")).click();
		Thread.sleep(3000);
	}

	@When("click on phone tab")
	public void click_on_phone_tab() {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
	}

	@When("enter the phone number (.*)$")
	public void enter_the_phone_number(String pHNo) {
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(pHNo);
	}

	@When("click Find leads button")
	public void click_find_leads_button() {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	}

	@When("click on the first element that was found")
	public void click_on_the_first_element_that_was_found() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	}

	@When("cliik on edit button")
	public void cliik_on_edit_button() {
		driver.findElement(By.linkText("Edit")).click();
	}

	@When("Update the company Name to (.*)$")
	public void update_the_company_name_to_company_nam(String cName) {
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(cName);
	}

	@When("click on submit button")
	public void click_on_submit_button() {
		driver.findElement(By.name("submitButton")).click();
	}

}
