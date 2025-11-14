package marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class MarathonOne {

	public static void main(String[] args) throws InterruptedException, IOException {
		//
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		// Instantiate the Chromdriver
		ChromeDriver driver = new ChromeDriver(options);

		// launch the application
		driver.get("https://www.tatacliq.com/");

		// maximize the window
		driver.manage().window().maximize();

		// wait - global wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Instantiate the actions class
		Actions ac = new Actions(driver);
		WebElement brands = driver.findElement(By.xpath("//div[text()='Brands']"));
		ac.moveToElement(brands).perform();

		// Hover to Watches
		WebElement watches = driver.findElement(By.xpath("//div[text()='Watches & Accessories']"));
		ac.moveToElement(brands).pause(Duration.ofSeconds(1)).moveToElement(watches).pause(Duration.ofSeconds(1))
				.build().perform();

		// Hover to Casino brand
		WebElement first_Option = driver.findElement(By.xpath("(//div[@class='DesktopHeader__brandsDetails'])[1]"));
		ac.moveToElement(brands).pause(Duration.ofSeconds(1)).moveToElement(watches).pause(Duration.ofSeconds(1))
				.click(first_Option).build().perform();

		// Wait for page load
		Thread.sleep(3000);

		// Use select class
		WebElement sort_By = driver.findElement(By.xpath("//select[@class='SelectBoxDesktop__hideSelect']"));
//		sort_By.click();
		Select slct = new Select(sort_By);
		slct.selectByVisibleText("New Arrivals");

		// select Men
		WebElement men = driver.findElement(By.xpath("(//div[text()='Men'])[1]"));
		men.click();

		// Wait for page load
		Thread.sleep(3000);

		// List to get watch price
		List<WebElement> watches_Price = driver
				.findElements(By.xpath("//div[@class='ProductDescription__priceHolder']/h3"));
		List<String> wat_Prices = new ArrayList<>();

		for (WebElement watch_Prices : watches_Price) {
			WebElement prices = watch_Prices;
			String rpl_All_Prices = prices.getText();
			String all_Prices = rpl_All_Prices.replaceAll("[^0-9]", "");
			wat_Prices.add(all_Prices);
		}
		Thread.sleep(3000);
		System.out.println(wat_Prices);
		// click on first watches
		WebElement first_Watch = driver.findElement(By.xpath("(//div[@class='ProductModule__dummyDiv'])[1]"));
		ac.scrollToElement(first_Watch).perform();
		first_Watch.click();

		// Window handling
		String parent_Window = driver.getWindowHandle();
		Set<String> all_Window = driver.getWindowHandles();
		List<String> list_AllWindow = new ArrayList<>(all_Window);

		for (String windows : list_AllWindow) {
			String child_Window = windows;
			if (!(parent_Window.equals(child_Window))) {
				driver.switchTo().window(child_Window);
				WebElement get_Price = driver.findElement(By.xpath("//div[@class='ProductDetailsMainCard__price']/h3"));
				String actual_Price = get_Price.getText();
				String act_Price = actual_Price.replaceAll("[^0-9]", "");
				String expect_Prices = wat_Prices.get(0);
				if (expect_Prices.equals(act_Price)) {
					System.out.println("The Price are similar");
				} else {
					System.out.println("The Price are not similar");
				}
				Thread.sleep(3000);
				// Add to Bag
				WebElement add_Bag = driver.findElement(By.xpath("//span[text()='ADD TO BAG']"));
				ac.scrollToElement(add_Bag).perform();
				ac.click(add_Bag).perform();
				// get the bag count
				WebElement item_Count = driver.findElement(By.xpath("//span[@class='DesktopHeader__cartCount']"));
				String itm_Counts = item_Count.getText();
				System.out.println(itm_Counts);
				// Take the screenshots
				WebElement page = driver.findElement(By.xpath("//div[@class='ProductDescriptionPage__base']"));
				File source = page.getScreenshotAs(OutputType.FILE);
				File destination = new File("C:\\Users\\jaanv\\Screenshots\\product9.jpg");
				FileHandler.copy(source, destination);
				driver.close();
			}
		}
		// switch to parent window
		driver.switchTo().window(parent_Window);
		driver.quit();
	}

}
