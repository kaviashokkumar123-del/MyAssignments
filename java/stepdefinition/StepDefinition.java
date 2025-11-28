package stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseClass {

	@Given("Launch the browser and open the URL")
	public void launch_the_browser_and_open_the_url() {
		driver.get("https://login.salesforce.com");

	}

	@Then("Verify User Created Successfully {string}")
	public void verify_user_created_successfully(String acctName) {
		// Write code here that turns the phrase above into concrete actions
		String getAcctName = driver.findElement(By.xpath("(//a[@data-aura-class='forceActionLink'])[4]")).getText().trim();
		String repl_GetAcctName = getAcctName.replaceAll("[^a-bA-Z]", getAcctName);
		System.out.println(getAcctName);
		System.out.println(repl_GetAcctName);
		if(getAcctName.equals(repl_GetAcctName))
		{
			System.out.println("The account is saved successfully");
		}
		else
		{
			System.out.println("The account is not saved successfully");
		}
	}

	@When("Enter the username {string}")
	public void enter_the_username(String uName) {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("username")).sendKeys(uName);
	}

	@When("Enter the password {string}")
	public void enter_the_password(String passWord) {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("password")).sendKeys(passWord);
	}

	@When("Click on Login button")
	public void click_on_login_button() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("Login")).click();
	}

	@When("Click on the App Launcher Icon next to Setup")
	public void click_on_the_app_launcher_icon_next_to_setup() {
		// Write code here that turns the phrase above into concrete actions
		WebElement app_Launcher = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		wait.until(ExpectedConditions.elementToBeClickable(app_Launcher));
		driver.executeScript("arguments[0].click();", app_Launcher);
	}

	@When("Search for the account.")
	public void search_for_the_account() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement element1 = driver.findElement(By.xpath("//input[@class='slds-input']"));
		wait.until(ExpectedConditions.visibilityOf(element1));
		WebElement srchAcct = driver.findElement(By.xpath("//input[@class='slds-input']"));
		srchAcct.sendKeys("Accounts");
		srchAcct.sendKeys(Keys.ENTER);
	}

	@When("Click on the drop down.")
	public void click_on_the_drop_down() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_icon-border slds-button_icon-x-small']"))
				.click();
	}

	@When("Select Edit button")
	public void select_edit_button() {

		// Write code here that turns the phrase above into concrete actions
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		WebElement element1 = driver.findElement(By.xpath("//div[text()='Edit']"));
		wait.until(ExpectedConditions.elementToBeClickable(element1));
		driver.executeScript("arguments[0].click();", element1);
	}

	@When("Select Type value as {string}")
	public void select_type_value_as(String tech) {
		// Write code here that turns the phrase above into concrete actions

		WebElement tech1 = driver.findElement(By.xpath("(//span[@part='input-button-value'])[2]"));
		as.scrollToElement(tech1).perform();
		driver.executeScript("arguments[0].click();", tech1);
		as.sendKeys(tech1, tech).sendKeys(Keys.ENTER).perform();

	}

	@When("Select Industry value as {string}")
	public void select_industry_value_as(String healthcare) {
		// Write code here that turns the phrase above into concrete actions
		WebElement healthCar = driver.findElement(By.xpath("(//span[@part='input-button-value'])[4]"));
		as.scrollToElement(healthCar).perform();
		driver.executeScript("arguments[0].click();", healthCar);
		as.sendKeys(healthCar, healthcare).sendKeys(Keys.ENTER).build().perform();
	}

	@When("Enter the Billing Address {string}")
	public void enter_the_billing_address(String b_Addr) {
		WebElement bill_ctry = driver.findElement(By.xpath("//input[@aria-label='Billing Country']"));
		as.scrollToElement(bill_ctry).perform();
		driver.executeScript("arguments[0].click();", bill_ctry);
		as.sendKeys(bill_ctry, "India").sendKeys(Keys.ENTER).perform();
		driver.findElement(By.xpath("(//textarea[@name='street'])[1]")).sendKeys(b_Addr);
		driver.findElement(By.xpath("(//input[@name='city'])[1]")).sendKeys("Chennai");
		driver.findElement(By.xpath("(//input[@name='postalCode'])[1]")).sendKeys("600074");
	}

	@When("Enter the Shipping Address {string}")
	public void enter_the_shipping_address(String s_Addr) {
		WebElement sbill_ctry = driver.findElement(By.xpath("//input[@aria-label='Shipping Country']"));
		driver.executeScript("arguments[0].click();", sbill_ctry);
		as.sendKeys(sbill_ctry, "India").sendKeys(Keys.ENTER).perform();
		driver.findElement(By.xpath("(//textarea[@name='street'])[2]")).sendKeys(s_Addr);
		driver.findElement(By.xpath("(//input[@name='city'])[2]")).sendKeys("Chennai");
		driver.findElement(By.xpath("(//input[@name='postalCode'])[2]")).sendKeys("600074");
	}

	@When("Select Customer priority as {string}")
	public void select_customer_priority_as(String cust_Priority) {
		// Write code here that turns the phrase above into concrete actions
		WebElement cust = driver.findElement(By.xpath("//button[@aria-label='Customer Priority']"));
		as.scrollToElement(cust).perform();
		driver.executeScript("arguments[0].click();", cust);
		as.sendKeys(cust, cust_Priority).sendKeys(Keys.ENTER).build().perform();
	}

	@When("Select SLA as {string}")
	public void select_sla_as(String sla) {
		WebElement sla1 = driver.findElement(By.xpath("//button[@aria-label='SLA']"));
		as.scrollToElement(sla1).perform();
		driver.executeScript("arguments[0].click();", sla1);
		as.sendKeys(sla1, sla).sendKeys(Keys.ENTER).build().perform();
	}

	@When("Select Active as {string}")
	public void select_active_as(String act) {

		WebElement act1 = driver.findElement(By.xpath("//button[@aria-label='Active']"));
		as.scrollToElement(act1).perform();
		as.click(act1).build().perform();
		as.sendKeys(act1, act);
	}

	@When("Enter Unique Phone number {string}")
	public void enter_unique_phone_number(String ph) {
		WebElement phone = driver.findElement(By.xpath("//input[@name='Phone']"));
		as.scrollToElement(phone).perform();
		phone.sendKeys(ph);
	}

	@When("Select upsell Opportunity as {string}")
	public void select_upsell_opportunity_as(String no) {
		WebElement nos = driver.findElement(By.xpath("//button[@aria-label='Upsell Opportunity']"));
		as.scrollToElement(nos).perform();
		as.sendKeys(nos, no);
	}

	@When("Click on Save button")
	public void click_on_save_button() {
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
	}

	@Then("Verify Phone number")
	public void verify_phone_number() {
		String getPh = driver.findElement(By.xpath("(//div[@class='slds-truncate'])[4]")).getText();
		if (getPh.equals("7658943789")) {
			System.out.println("The phone is verified and it is updated correctly.");
		} else {
			System.out.println("The phone is verified and it is updated correctly.");
		}
	}

}
