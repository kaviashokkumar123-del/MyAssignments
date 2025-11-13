package week5.homeassignment.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameLearn {

	public static void main(String[] args) {
		// Instantiate the chromdriver
		ChromeDriver driver = new ChromeDriver();
		// launch the URL
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		// maximize the window
		driver.manage().window().maximize();

		// Wait for the page to load for the specified time
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Switch to Frame
		driver.switchTo().frame("iframeResult");
		// switch to the frame
		WebElement frame_One = driver.findElement(By.xpath("//button[text()='Try it']"));

		// Action class to click on the frame
		Actions ac = new Actions(driver);
		ac.click(frame_One).perform();

		// Switch to Alert
		Alert alt = driver.switchTo().alert();
		alt.accept();

		// get the text and validate the message is successfull
		String getText = driver.findElement(By.id("demo")).getText();

		String expected_Msg = "Hello Harry Potter! How are you today?";

		if (getText.equals(expected_Msg)) {
			System.out.println("The Ok button is clicked and alert is accepted");
		} else {
			System.out.println("The Cancel button is clicked and alert is dimissed");
		}

		// To Quit the browser window
		driver.quit();
	}

}
