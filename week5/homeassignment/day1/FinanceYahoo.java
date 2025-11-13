package week5.homeassignment.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FinanceYahoo {

	public static void main(String[] args) throws InterruptedException {
		// Instantiate the ChromeDiver%=
		ChromeDriver driver = new ChromeDriver();

		// launch the url
		driver.get("https://finance.yahoo.com/");

		// maximize the window
		driver.manage().window().maximize();

		// implict wait=
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		Thread.sleep(5000);
		// mouse hover more
		WebElement more = driver.findElement(By.xpath("//span[text()='More']"));
		Actions ac = new Actions(driver);
		ac.scrollToElement(more).pause(Duration.ofSeconds(1)).moveToElement(more).build().perform();

		// Hover crypto
		WebElement crypto = driver.findElement(By.xpath("(//a[contains(text(),'Crypto ')])[3]"));
		ac.moveToElement(more).pause(Duration.ofSeconds(1)).moveToElement(crypto).pause(Duration.ofSeconds(1))
				.moveToElement(crypto).click().build().perform();

		Thread.sleep(10000);
		// Get crypto elements
		List<WebElement> crypto_Names = driver
				.findElements(By.xpath("//table[@class='yf-14a4l34 bd']/tbody/tr/td[2]/div"));
		for (WebElement names : crypto_Names) {
			String names_Cryto = names.getText();
			System.out.println(names_Cryto);
		}
		driver.quit();
	}
}

