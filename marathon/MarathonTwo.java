package marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class MarathonTwo {

	public static void main(String[] args) throws IOException, InterruptedException {
		//
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		// Instantiate the Chromdriver
		ChromeDriver driver = new ChromeDriver(options);

		// launch the application
		driver.get("https://dev273042.service-now.com/");

		// maximize the window
		driver.manage().window().maximize();

		// wait - global wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// User name
		WebElement user_Name = driver.findElement(By.id("user_name"));
		user_Name.sendKeys("admin");

		// Pass word
		WebElement passWord = driver.findElement(By.id("user_password"));
		passWord.sendKeys("*w6ndQP4vI$G");

		// click Login button
		WebElement login_Btn = driver.findElement(By.id("sysverb_login"));
		login_Btn.click();

		Shadow sh = new Shadow(driver);
		sh.setImplicitWait(30);
		sh.findElementByXPath("//div[text()='All']").click();
		sh.findElementByXPath("//span[text()='Service Catalog']").click();

		// Switch to frame
		WebElement findFrame = sh.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(findFrame);

		// 4. Click on mobiles
		driver.findElement(By.xpath("//h2[contains(text(),'Mobiles')]")).click();

		Thread.sleep(3000);

		// click on apple 13pro
		WebElement apple = driver.findElement(By.xpath("//strong[text()='Apple iPhone 13 pro']"));
		apple.click();

		// click on yes button
		WebElement yes_Btn = driver.findElement(By.xpath("(//label[@class='radio-label'])[1]"));
		yes_Btn.click();

		// Orignial phone
		WebElement ori_Phonenum = driver
				.findElement(By.xpath("//input[@class='cat_item_option sc-content-pad form-control']"));
		ori_Phonenum.sendKeys("99");

		// select
		Thread.sleep(3000);
		WebElement sct_Monthly = driver.findElement(By.xpath("//select[@id='IO:ff1f478e9747011021983d1e6253af68']"));
		Select sc = new Select(sct_Monthly);
		sc.selectByContainsVisibleText("Unlimited");

		// select the particualr color
		WebElement color_Blue = driver
				.findElement(By.xpath("//span[@class='input-group-radio']/label[text()='Sierra Blue']"));
		color_Blue.click();

		Actions ac = new Actions(driver);

		// click on order now option.
		WebElement orderNow = driver.findElement(By.id("oi_order_now_button"));
		ac.scrollToElement(orderNow).perform();
		ac.click(orderNow).perform();

		WebElement msg = driver.findElement(By.xpath("//div[@class='notification notification-success']/span[2]"));
		String act_Msg = msg.getText();
		String exp_Msg = "Thank you, your request has been submitted";
		if (act_Msg.equals(exp_Msg)) {
			System.out.println("Order is placed successfully");
		} else {
			System.out.println("Order is not placed successfully");
		}

		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\jaanv\\Screenshots\\product8.jpg");
		FileHandler.copy(source, destination);
		driver.quit();

	}

}
