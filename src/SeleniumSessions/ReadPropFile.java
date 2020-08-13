package SeleniumSessions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class ReadPropFile {

	static WebDriver driver;
	public static void main(String[] args) throws IOException {


		
		Properties prop = new Properties();
		FileInputStream fi = new FileInputStream("C:\\Users\\vdudduku\\eclipse-workspace\\SeleniumWebDriver\\src\\SeleniumSessions\\config.properties");
		prop.load(fi);
		System.out.println(prop.getProperty("name"));
		System.out.println(prop.getProperty("age"));
		
		String browser = prop.getProperty("browser");
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if(browser.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		String url = prop.getProperty("URL");
		driver.get(url);
		driver.findElement(By.xpath(prop.getProperty("FirstName_xpath"))).sendKeys(prop.getProperty("FirstName"));
		driver.findElement(By.xpath(prop.getProperty("LastName_xpath"))).sendKeys(prop.getProperty("LastName"));
		driver.findElement(By.xpath(prop.getProperty("Email_xpath"))).sendKeys(prop.getProperty("Email"));

	}

}
