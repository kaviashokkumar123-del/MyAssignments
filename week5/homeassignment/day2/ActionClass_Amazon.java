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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class ActionClass_Amazon {
	@Test
	public void amzon() throws IOException, InterruptedException {
		/// instantiate the chrome driver
		ChromeDriver driver = new ChromeDriver();
		// launch the application
		driver.get("https://www.amazon.in/");
		// maximize the application
		driver.manage().window().maximize();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// SendKeys to search text box
		WebElement srch_TxtBx = driver.findElement(By.id("twotabsearchtextbox"));
		Actions ac = new Actions(driver);
		ac.sendKeys(srch_TxtBx, "oneplus 9 pro", Keys.ENTER).perform();
		// List of Webelement to find the price of all the items
		List<WebElement> price = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		List<WebElement> rating = driver
				.findElements(By.xpath("//span[@class='a-size-mini puis-normal-weight-text s-underline-text']"));
		String frst_Price = null;
		String frst_Rating = null, frst_Rating_Alone = null;
		// Loop to enhance for future, but getting the first element.
		for (int i = 0; i < price.size(); i++) {
			// To get the first price alone
			WebElement first_Price = price.get(1);
			// Store it in a string
			frst_Price = first_Price.getText();

		}
		System.out.println("The price of the first product: " + frst_Price);
		// Loop to enhance for future, but getting the first element.
		for (int i = 0; i < rating.size(); i++) {
			// To get the first price alone
			WebElement first_Rating = rating.get(1);
			// Store it in a string
			frst_Rating = first_Rating.getText();
			// replace all the 'out of 5 starts with no values
			frst_Rating_Alone = frst_Rating.replaceAll("[^0-9.]", "");

		}
		System.out.println("The rating of the first product: " + frst_Rating_Alone);
		Thread.sleep(3000);
		// using action class to click on the first img
		WebElement frst_image = driver.findElement(By.xpath("//h2[contains(@class,'a-size-medium a-spacing')]/span"));
		ac.click(frst_image).perform();
		// Switch to the child window which has opened the screen shot
		String parent_Window = driver.getWindowHandle();
		Set<String> all_Windowss = driver.getWindowHandles();

		List<String> all_Windows = new ArrayList<>(all_Windowss);
		for (String childs : all_Windows) {
			String child = childs;
			if (!(child.equals(parent_Window))) {
				driver.switchTo().window(child);

				WebElement product = driver.findElement(By.id("imgTagWrapperId"));
				File source = product.getScreenshotAs(OutputType.FILE);
				File destination = new File("C:\\Users\\jaanv\\Screenshots\\product.png");
				// Copy file to the destination
				FileHandler.copy(source, destination);
				System.out.println("✅ Product screenshot saved successfully!");
				// click on Add to Cart
				WebElement add_Cart = driver.findElement(By.id("add-to-cart-button"));
				ac.scrollToElement(add_Cart).perform();
				ac.click(add_Cart).perform();
				Thread.sleep(1000);
				// Get the cart total
				String cart_Total = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
				System.out.println("The cart price is : " + cart_Total);
				driver.close();
			}
		}
		driver.switchTo().window(parent_Window);
		driver.quit();
	}

}
