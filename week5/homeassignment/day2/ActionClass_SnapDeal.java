package week5.homeassignment.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class ActionClass_SnapDeal {

	@Test
	public void snapDeal() throws InterruptedException, IOException {
		// Instantiate the chrome driver
		ChromeDriver driver = new ChromeDriver();
		// launch the app
		driver.get("https://www.snapdeal.com/");

		// maximize the window
		driver.manage().window().maximize();

		// using impllicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Create object for actions class
		Actions ac = new Actions(driver);

		// Got to men's fashion
		WebElement go_Men = driver.findElement(By.xpath("(//a[@class='menuLinks leftCategoriesProduct ']/span[2])[1]"));
		ac.moveToElement(go_Men);

		// create a chain to
		WebElement sport_Shoes = driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]"));
		ac.click(sport_Shoes).perform();

		// get the count
		WebElement shoe_Count = driver.findElement(By.xpath("//h1[@class='category-name']/following-sibling::span"));
		String counts = shoe_Count.getText();
		String repl_Counts = counts.replaceAll("[^0-9]", "");
		System.out.println("The total numebr of items are :" + repl_Counts);

		// click on training shoes
		WebElement training_Shoes = driver.findElement(By.xpath("//div[text()='Training Shoes']"));
		ac.click(training_Shoes).perform();

		// sort by
		WebElement sort = driver.findElement(By.xpath("//span[text()='Sort by:']"));
		sort.click();

		// select the low to high
		WebElement sort_Option = driver.findElement(By.xpath("(//li[@class='search-li'])[1]"));
		sort_Option.click();

		Thread.sleep(3000);
		// get all the list of price
		List<WebElement> price = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));

		List<Integer> int_Price = new ArrayList<>();
		for (int i = 0; i < price.size(); i++) {

			WebElement pricess = price.get(i);
			String final_Price = pricess.getText();
			String rep_Final_Price = final_Price.replaceAll("[^0-9]", "");
			int int_Final_Pirce = Integer.parseInt(rep_Final_Price);
			int_Price.add(int_Final_Pirce);
		}
		System.out.println(int_Price);
		boolean b = false;
		// to check whether the number are in low to high order
		for (int i = 0; i < int_Price.size(); i++) {
			int temp = int_Price.get(0);
			if (temp < int_Price.get(i)) {
				b = true;
			} else {
				b = false;
			}
		}
		if (b) {
			System.out.println("All the price are listed in the low to high order");
		} else {
			System.out.println("All the price are not listed in the low to high order");
		}
		// enter from value
		WebElement from_Value = driver.findElement(By.name("fromVal"));
		from_Value.clear();
		from_Value.sendKeys("500");

		// enter to value
		WebElement to_Value = driver.findElement(By.name("toVal"));
		to_Value.clear();
		to_Value.sendKeys("700");

		// click go button
		WebElement go_btn = driver.findElement(By.xpath("//div[contains(text(),'GO')]"));
		go_btn.click();

		String color1 = "White";
		String color2 = "Blue";
		Thread.sleep(3000);
		WebElement color = driver.findElement(By.xpath("//a[contains(text(),'" + color1 + " & " + color2 + "')]"));
		ac.scrollToElement(color).perform();
		ac.click(color).perform();

		Thread.sleep(3000);
		List<WebElement> shoe_Names = driver.findElements(By.xpath("//p[@class='product-title']"));
		boolean b1 = false;
		for (int i = 0; i < shoe_Names.size(); i++) {
			WebElement namess = shoe_Names.get(i);
			String name_Shoes = namess.getText();

			if (name_Shoes.contains(color1) || name_Shoes.contains(color2)) {
				b1 = true;
			} else {
				b1 = false;
			}

		}
		if (b1) {
			System.out.println("The items are displayed based on the color selections");
		} else {
			System.out.println("The items are not displayed based on the color selections");
		}

		// hover on first product
		WebElement hover_FrstItem = driver.findElement(By.xpath("(//p[@class='product-title'])[1]"));
		ac.moveToElement(hover_FrstItem).perform();

		// Click on Quick Button
		WebElement quick_btn = driver.findElement(By.xpath("//div[contains(text(),'Quick View')]"));
		quick_btn.click();

		// get the actual price
		String actual_Price = driver.findElement(By.xpath("//span[@class='strikee ']")).getText();
		String repl_Actual_Price = actual_Price.replaceAll("[^0-9.]", "");

		// get the discount price of the element
		String dis_Price = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		String repl_Dis_Price = dis_Price.replaceAll("[^0-9.]", "");
		System.out.println("The actual price is " + repl_Actual_Price);
		System.out.println("The discount price is " + repl_Dis_Price);

		WebElement product = driver.findElement(By.xpath("//img[@class='cloudzoom']"));
		File source = product.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\jaanv\\Screenshots\\product10.png");
		FileHandler.copy(source, destination);
		driver.quit();
	}
}
