package week5.homeassignment.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class ActionClass_BigBasket {

	@Test
	public void bigBasket() throws InterruptedException, IOException {
		// Instantiate the Chormdriver
		ChromeDriver driver = new ChromeDriver();

		// launch the app
		driver.get("https://www.bigbasket.com/");

		// maximize the window
		driver.manage().window().maximize();

		// use wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// click on the select by category
		WebElement shp_Category = driver.findElement(By.xpath("(//span[text()='Shop by']/following-sibling::span)[2]"));
		Actions ac = new Actions(driver);
		ac.click(shp_Category).pause(Duration.ofSeconds(1)).perform();

		// Food grains click
		WebElement food_Granis = driver.findElement(By.xpath("(//a[text()='Foodgrains, Oil & Masala'])[2]"));
		ac.moveToElement(food_Granis).pause(Duration.ofSeconds(1)).perform();
		WebElement food_RiceProd = driver.findElement(By.xpath("(//a[text()='Rice & Rice Products'])[1]"));
		ac.moveToElement(food_Granis).pause(Duration.ofSeconds(1)).moveToElement(food_RiceProd).perform();
		WebElement boiled_Rice = driver.findElement(By.xpath("//a[text()='Boiled & Steam Rice']"));
		ac.moveToElement(food_RiceProd).pause(Duration.ofSeconds(1)).moveToElement(boiled_Rice)
				.pause(Duration.ofSeconds(1)).click(boiled_Rice).build().perform();

		// wait for page load
		Thread.sleep(3000);

		// click on the BRands text box.
		WebElement brand_TxtBx = driver.findElement(By.xpath("(//input[@placeholder='Search here'])[1]"));
		ac.scrollToElement(brand_TxtBx);
		ac.sendKeys(brand_TxtBx, "bb Royal");
		// click on the first selected item
		WebElement first_ChkBox = driver.findElement(By.xpath("//input[@id='i-bbRoyal']"));
		ac.click(first_ChkBox).perform();

		// wait for page load
		Thread.sleep(3000);

		// click on tamil ponni rice
		WebElement rice_TamilPonni = driver.findElement(By.xpath("//h3[text()='Tamil Ponni Boiled - Rice']"));
		ac.scrollToElement(rice_TamilPonni);
		ac.click(rice_TamilPonni).perform();

		// Now switch to window
		String parent_Window = driver.getWindowHandle();
		Set<String> all_Windowss = driver.getWindowHandles();
		List<String> all_Windows = new ArrayList<>(all_Windowss);
		String get__PriceVal = null;
		for (String child : all_Windows) {
			String chid = child;
			if (!(chid.equals(parent_Window))) {
				driver.switchTo().window(chid);
				// scroll to 5 kg option4
				Thread.sleep(5000);
				WebElement kg_Pack = driver.findElement(By.xpath("//span[text()='5 kg']"));
				ac.scrollToElement(kg_Pack);
				ac.click(kg_Pack).perform();

				// get the price
				WebElement price = driver.findElement(By.xpath("//td[contains(text(),'Price: ')]"));
				String get_Price = price.getText();
				get__PriceVal = get_Price.replaceAll("[^0-9.]", "");
				// click on add to basket
				WebElement add_Btn = driver.findElement(By.xpath("(//button[text()='Add to basket'])[1]"));
				ac.keyDown(Keys.PAGE_UP).keyUp(Keys.PAGE_UP).perform();
				add_Btn.click();

				// Validate the message
				String get_Msg = driver.findElement(By.xpath("//p[contains(text(),'basket successfully')]")).getText();
				if (get_Msg.equals("An item has been added to your basket successfully")) {
					System.out.println("The Item is added to the cart successfully");
				} else {
					System.out.println("The Item is not added to the cart successfully");
				}
				WebElement product = driver.findElement(By.xpath("//div[@class='h-full w-full']"));
				File source = product.getScreenshotAs(OutputType.FILE);
				File destination = new File("C:\\Users\\jaanv\\Screenshots\\product2.png");
				// Copy file to the destination
				FileHandler.copy(source, destination);
				System.out.println("✅ Product screenshot saved successfully!");
				driver.close();
			}
		}
		System.out.println("The price of the item is:" + get__PriceVal);
		driver.switchTo().window(parent_Window);
		driver.quit();
	}

}
