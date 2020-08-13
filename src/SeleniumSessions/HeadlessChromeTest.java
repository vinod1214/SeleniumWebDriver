package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeadlessChromeTest {

	public static void main(String[] args) {


		ChromeOptions options = new ChromeOptions();
		options.addArguments("window-size=1400,800");
		options.addArguments("headless");
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://classic.crmpro.com/index.html");
		System.out.println("Before Login Title is: " +driver.getTitle());
		driver.findElement(By.xpath("//input[contains(@name,'username')]")).sendKeys("vinodd");
		driver.findElement(By.xpath("//input[contains(@name,'password')]")).sendKeys("test@123");
		onClick(driver, driver.findElement(By.xpath("//input[contains(@type,'submit')]")), 20);
		System.out.println("After Login Title is: " +driver.getTitle());

	}
	
	public static void onClick(WebDriver driver,WebElement locator, long Timeouts) {
		new WebDriverWait(driver, Timeouts).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	

}
