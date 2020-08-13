package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameHandling {

	public static void main(String[] args) throws InterruptedException {


		System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();//launch firefox
		
		driver.manage().window().maximize();//maximize window
		driver.manage().deleteAllCookies();//delete all the cookies
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//enter URL
		driver.get("https://classic.crmpro.com/index.html");
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("vinodd");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("test@123");
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		 WebElement element = driver.findElement(By.xpath("//input[@class='btn btn-small']")); 
		 Actions action = new Actions(driver); action.click(element).build().perform();
		 driver.switchTo().frame("mainpanel");
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		 
		

	}

}
