package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindAllLinks {

	public static void main(String[] args) {


		System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.techlistic.com/");
		 // Store all link elements (anchor tag elements in html) in a list
		 List<WebElement> links = driver.findElements(By.tagName("a"));

		 // Print no. of links stored in list
		 System.out.println(links.size());

		 for (int i = 1; i<=links.size(); i=i+1)
		  {

		  // Print text of all the links
		  System.out.println(links.get(i).getText());

		  }

	}

}
