package week2.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FaceBookLogin {

	public static void main(String[] args) {
		// Instantiate Browser
		ChromeDriver driver = new ChromeDriver();
		// launch the application
		driver.get("https://www.facebook.com/");
		//maimize the window
		driver.manage().window().maximize();
		// Enter the email id
		driver.findElement(By.id("email")).sendKeys("testleaf.2023@gmail.com");
		// Enter the password
		driver.findElement(By.id("pass")).sendKeys("Tuna@321");
		// Click on Login button
		driver.findElement(By.linkText("Log in")).click();
		// get the title of the web page.
		String getTitle = driver.getTitle();
		System.out.println(getTitle);

	}

}
