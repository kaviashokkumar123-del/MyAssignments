package amazon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		//instantiate the Chrome browser
		ChromeDriver driver = new ChromeDriver();
		//launch the web browser
		driver.get("https://www.amazon.in/");
		//maximize the window
		driver.manage().window().maximize();
		//use implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//Enter value in the search text box
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bags for boys", Keys.ENTER);	
		//Choose the result
		//30,000 results for 
		String result = driver.findElement(By.xpath("//span[contains(text(),'results for')]")).getText();
		//Print the total Number of Results
		String[] res = result.split(" ");
		int length = res.length;
		//get the position at 3rd place from reverse order
		String get_Result = res[length-3];
		System.out.println(get_Result);
		//Click on the first brand
		driver.findElement(By.xpath("(//div[@id='brandsRefinements']/ul//span//li)[1]")).click();
		Thread.sleep(2000);
		//Clcik on the second brand
		driver.findElement(By.xpath("(//div[@id='brandsRefinements']/ul//span//li)[2]")).click();
		Thread.sleep(2000);
		//click on the sort by
		driver.findElement(By.xpath("//span[text()='Featured']")).click();
		//click New arrivals
		driver.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();
		Thread.sleep(3000);
		//get the first name of the bag
		String name = driver.findElement(By.xpath("(//h2[@class='a-size-base-plus a-spacing-none a-color-base a-text-normal'])[1]")).getText();
		System.out.println("The name of the brand is :"+name);
		//get the discoutn price
		String dis_Price = driver.findElement(By.xpath("(//div[@class='a-row']//span//span)[1]")).getText();
		System.out.println("The Discount Price is :"+dis_Price);
		//get the title
		String title = driver.getTitle();
		System.out.println("The title of the page is :"+title);
		driver.quit();
	}

}
