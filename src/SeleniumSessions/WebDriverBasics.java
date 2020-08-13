package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverBasics {

	public static void main(String[] args) {


		System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
		System.out.println(driver.getTitle());
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Tom");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Curran");
		driver.findElement(By.xpath("//input[@id='sex-0']")).click();
		driver.findElement(By.xpath("//input[@id='exp-2']")).click();
		driver.findElement(By.xpath("//input[@id='profession-0']")).click();
		driver.findElement(By.xpath("//input[@id='tool-2']")).click();
		//select continent value from drop down
		WebElement option1 = driver.findElement(By.xpath("//select[@class='input-xlarge']"));
		Select select = new Select(option1);
		select.selectByIndex(3);
		//select multiple options from drop down
		Select select2 = new Select(driver.findElement(By.xpath("//select[@id='selenium_commands']")));
		select2.selectByVisibleText("Navigation Commands");
		select2.selectByIndex(4);
		//upload image file
		WebElement choosefile = driver.findElement(By.xpath("//input[@id='photo']"));
		choosefile.sendKeys("C:\\Users\\vdudduku\\Pictures\\Screenshots\\Screenshot (1).png");
		//click on a link
		driver.findElement(By.xpath("//a[contains(text(),'Selenium Webdriver Tutorials Series')]")).click();;
		String expected = driver.getTitle();
		//validating page title
		if(expected.equals("Selenium Tutorial - Learn Selenium from Comprehensive Series of 40 Coding Tutorials")) {
			System.out.println("correct title");
		}else {
			System.out.println("incorrect title");
		}

	}

}
