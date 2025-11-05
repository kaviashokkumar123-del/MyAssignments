package week4.day2;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyntraWebSite {

	public static void main(String[] args) throws InterruptedException {
		// Instantiate ChromeOptions
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		// Instantiate the ChromeDriver
		ChromeDriver driver = new ChromeDriver(options);
		// launch the application
		driver.get("https://www.myntra.com/");
		// Implicit wait to wait for the page to load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		// send keys to the search text box
		driver.findElement(By.className("desktop-searchBar")).sendKeys("bags", Keys.ENTER);
		Thread.sleep(3000);
		//
		WebElement men_RadioBtn = driver.findElement(By.xpath("//input[@value='men,men women']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView(true);", men_RadioBtn);
		js.executeScript("arguments[0].click();", men_RadioBtn);
//		driver.findElement(By.xpath("//input[@value='men,men women']")).click();
		// click on laptop bags
		WebElement men_LaptopBag = driver.findElement(By.xpath("//input[@value='Laptop Bag']"));
//		js.executeScript("arguments[0].scrollIntoView(true);", men_LaptopBag);
		js.executeScript("arguments[0].click();", men_LaptopBag);
//		driver.findElement(By.xpath("//input[@value='Laptop Bag']")).click();
		Thread.sleep(3000);
		// get the list of item
		List<WebElement> products = driver.findElements(By.xpath("//h3[@class='product-brand']"));
		List<WebElement> names = driver.findElements(By.xpath("//h4[@class='product-product']"));
		List<String> getList_Product = new ArrayList<String>();
		List<String> getList_Names = new ArrayList<String>();
		for (WebElement prod : products) {
			String product = prod.getText();
			getList_Product.add(product);
		}
		for (WebElement namess : names) {
			String name = namess.getText();
			getList_Names.add(name);

		}
		System.out.println("The product names are :" + getList_Product);
		System.out.println("The Bags names are :" + getList_Names);
		driver.close();
	}

}
