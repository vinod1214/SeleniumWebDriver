package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitConcept {

	public static void main(String[] args) {


		System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://spicejet.com");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(@id,'highlight-addons')]"))).build().perform();
		onClick(driver, driver.findElement(By.linkText("Friends and Family")), 20);
		//driver.findElement(By.xpath("//a[contains(text(),'Friends and Family')]")).click();

	}
	
	public static void onClick(WebDriver driver, WebElement locator, long Timeouts) {
		new WebDriverWait(driver, Timeouts).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
	}

}
