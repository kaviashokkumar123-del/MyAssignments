package marathon_3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass {
	public ChromeDriver driver;

	@Parameters({ "url", "username", "password" })
	@BeforeMethod
	public void preCond(String url, String uName, String passWord) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--user-data-dir=C:\\Users\\jaanv\\Sessions");

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.id("username")).sendKeys(uName);
		driver.findElement(By.id("password")).sendKeys(passWord);
		driver.findElement(By.id("Login")).click();
	}

	@AfterMethod
	public void postCond() {
		driver.quit();
	}
}
