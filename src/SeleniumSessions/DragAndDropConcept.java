package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropConcept {

	public static void main(String[] args) {


		System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();//maximize window
		driver.manage().deleteAllCookies();//delete all the cookies
		driver.get("https://jqueryui.com/droppable/");
		
		driver.switchTo().frame(0);
		
		Actions action = new Actions(driver);
		action
		.clickAndHold(driver.findElement(By.xpath(".//*[contains(@id, 'draggable')]")))
		.moveToElement(driver.findElement(By.xpath(".//*[contains(@id, 'droppable')]")))
		.release()
		.build()
		.perform();

	}

}
