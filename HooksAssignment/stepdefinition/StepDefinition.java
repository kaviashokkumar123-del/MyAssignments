package stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseClass {

	@Given("launch the browser and load the URL")
	public void launch_the_browser_and_load_the_url() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
	}

	@When("Enter the username as {string}")
	public void enter_the_username_as_demo_sales_manager(String uName) {
		driver.findElement(By.id("username")).sendKeys(uName);
	}

	@When("Enter the password as {string}")
	public void enter_the_password_as_crmsfa(String pwd) {
		driver.findElement(By.id("password")).sendKeys(pwd);
	}

	@When("click on Login")
	public void click_on_login() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}

	@Then("Homepage is displayed")
	public void homepage_is_displayed() {
		String title = driver.getTitle();
		if (title.contains("Leaftaps")) {
			System.out.println("title matched");
		} else {
			System.out.println("title not matched");
		}

	}

	@When("Error msg should be displayed")
	public void error_msg_should_be_displayed() {
		String text = driver.findElement(By.id("errorDiv")).getText();
		if (text.contains("Errors")) {
			System.out.println("text matched");
		} else {
			System.out.println("text not matched");
		}
	}

}
