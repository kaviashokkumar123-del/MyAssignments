package stepdefinition;

import org.openqa.selenium.By;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateLeadSD extends BaseClass {
	@When("click on crmsfa link")
	public void click_on_crmsfa_link() {
		driver.findElement(By.linkText("CRM/SFA")).click();
	}

	@When("click on leads button")
	public void click_on_leads_button() {
		driver.findElement(By.linkText("Leads")).click();
	}

	@When("click on Create leadLink")
	public void click_on_create_lead_link() {
		driver.findElement(By.linkText("Create Lead")).click();
	}

	@When("enter the companyname as (.*)$")
	public void enter_the_companyname_as_testleaf(String cName) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
	}

	@When("enter the phoneNumber as (.*)$")
	public void enter_the_phonenumber_as_8939299360(String pNum) {
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(pNum);
	}

	@When("Enter the first name as (.*)$")
	public void enter_the_first_name_as_saranya(String fName) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
	}

	@When("enter the last name as (.*)$")
	public void enter_the_last_name_as_s(String lName) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
	}

	@When("Click on create lead button")
	public void click_on_create_lead_button() {
		driver.findElement(By.name("submitButton")).click();
	}

	@Then("View leads page is displayed")
	public void view_leads_page_is_displayed() throws InterruptedException {
		Thread.sleep(4000);
		String text = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		if (text.contains("saranya")) {
			System.out.println("name matched");
		} else {
			System.out.println("name not matched");
		}
	}

}
