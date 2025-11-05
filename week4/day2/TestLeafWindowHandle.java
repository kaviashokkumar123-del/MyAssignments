package week4.day2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestLeafWindowHandle {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		// Instantiate the chromedriver
		ChromeDriver driver = new ChromeDriver(options);
		// launch the browser
		driver.get("http://leaftaps.com/opentaps/control/login");
		// Maximize the window
		driver.manage().window().maximize();
		// Enter username.
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		// Enter password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		// click login button
		driver.findElement(By.className("decorativeSubmit")).click();
		// click link
		driver.findElement(By.xpath("//a[contains(text(),' CRM/SFA')]")).click();
		// click on contact button
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		// click on Merge contact
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		// click on img
		driver.findElement(By.xpath("(//table[@class='twoColumnForm']//tr/td[2]/a/img)[1]")).click();
		Thread.sleep(2000);
		// Window Handle
		String parentWindow = driver.getWindowHandle();
		// create a set
		Set<String> set_ChildWindows = driver.getWindowHandles();
		// store the set in list
//		
		List<String> list_ChildWindows = new ArrayList<String>(set_ChildWindows);
		for (int i = 0; i < set_ChildWindows.size(); i++) {
			String chil_Win = list_ChildWindows.get(i);
			if (!(parentWindow.equals(chil_Win))) {

				driver.switchTo().window(chil_Win);
				Thread.sleep(2000);
				// click on the first result
				driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
			}
		}
		driver.switchTo().window(parentWindow);
		// click on img
		driver.findElement(By.xpath("(//table[@class='twoColumnForm']//tr/td[2]/a/img)[2]")).click();
		String part_Windo = driver.getWindowHandle();
		Set<String> set_ChilWin = driver.getWindowHandles();
		List<String> list_ChilWin = new ArrayList<String>(set_ChilWin);
		for (int i = 0; i < set_ChilWin.size(); i++) {
			String chl_Win = list_ChilWin.get(i);
			driver.switchTo().window(chl_Win);
			Thread.sleep(2000);
			// click on the second result
			driver.findElement(By.xpath("(//a[@class='linktext'])[5]")).click();

		}
		driver.switchTo().window(part_Windo);
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		// Accept the alert - simple alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
		// get title
		String get_Title = driver.getTitle();
		System.out.println(get_Title);
		// Close the browser
		driver.close();
	}

}
