package stepdefinition;

import org.openqa.selenium.By;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MultipleAccounts extends BaseClass {

	@When("Click on New button to add new account user")
	public void click_on_new_button_to_add_new_account_user() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("(//a[@class='forceActionLink'])[1]")).click();
	}

	@When("Enter the Account Name (.*)$")
	public void enter_the_account_name_account_name(String aName) {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(aName);
	}

	@Then("Verify User Created Successfully (.*)$")
	public void verify_user_created_successfully(String aName) {
		String getAcctName = driver.findElement(By.xpath("(//a[@data-aura-class='forceActionLink'])[4]")).getText()
				.trim().strip();
		String rep_AcctName = getAcctName.replaceAll("[^a-zA-Z]", getAcctName);
		if (rep_AcctName.equals(aName.strip())) {
			System.out.println("The account is created successfully");
		} else {
			System.out.println("The account is not created successfully");
		}
	}

}
