package pvrcinemas;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PvrTicketBooking {

	public static void main(String[] args) throws InterruptedException {
//		ChromeOptions option = new ChromeOptions();
//		option.addArguments("guest");
		// Instantiate the Chrome driver
		ChromeDriver driver = new ChromeDriver();
		// launch the browser
		driver.get("https://www.pvrcinemas.com");
		// maximize the window
		driver.manage().window().maximize();
		// store the web element in chennai
//		WebElement chennai = driver.findElement(By.xpath("//h6[contains(text(),'Chennai')]"));
		// if the element is enabled then click on it.
//		if (chennai.isEnabled()) {
//			chennai.click();
//		}
		// click on the cinema
		WebElement cinema = driver.findElement(By.xpath("//span[text()='Cinema']"));
		cinema.click();
		// click on the select cinema
		driver.findElement(By.xpath("//span[text()='Select Cinema']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// click on the first selected option
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Virugambakkam Chennai')]")).click();
		// select trwm from the list
		driver.findElement(By.xpath("//div[@class='p-dropdown-items-wrapper']//li/span[contains(text(),'Tomorrow')]"))
				.click();
		// select the movie
		driver.findElement(By.xpath("(//span[text()='AARYAN'])[2]")).click();
		// select the time
		Thread.sleep(3000);
		List<WebElement> Time = driver.findElements(By.xpath("//ul[@role='listbox']/li//span/span[1]"));
		for (WebElement times : Time) {
			String time_List = times.getText();
			System.out.println(time_List);
			if (times.isEnabled()) {
				driver.findElement(By.xpath("//span[contains(text(),'" + time_List + "')]")).click();
				break;
			} else {
				continue;
			}

		}
		// click on the Book button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		// click on Accept in the pop up
		driver.findElement(By.xpath("//button[text()='Accept']")).click();
		// selecting the first avaialble seat
		driver.findElement(By.xpath("(//span[@class='seat-current-pvr'])[1]")).click();
		// click on proceed button
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		// get the seat info
		String seat_No = driver.findElement(By.xpath("//div[@class='select-seat-number']//p")).getText();
		System.out.println("The Seat Number is :" + seat_No);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// get grand total
		Thread.sleep(3000);
		String get_total = driver.findElement(By.xpath("(//div[@class='all-grand']//h6)[2]")).getText();
		System.out.println("The grand Total is :" + get_total);
		// click on continue
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		// close the popup
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
		driver.findElement(By.xpath("(//div[@class='p-dialog-content']/div//div/div[3]/div[2]//div//i)[2]")).click();
		// get the title
		String get_title = driver.getTitle();
		System.out.println("The Title of the page is: " + get_title);
		// close the browser
		driver.close();
	}

}
