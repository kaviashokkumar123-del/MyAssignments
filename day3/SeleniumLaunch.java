package week2.day3;

import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumLaunch {

	public static void main(String[] args) {
		// Create object for the chromedriver class.=
		ChromeDriver driver = new ChromeDriver();
		// launch the browser
		driver.get("https://www.facebook.com/");
		// maximize the window
		driver.manage().window().maximize();
		// close the window.
		driver.close();
	}

}
