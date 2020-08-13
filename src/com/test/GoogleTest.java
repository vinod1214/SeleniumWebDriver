package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
	}

	@Test(priority = 2, groups = "Title", invocationCount = 5)
	public void googleTitleTets() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	@Test(priority = 3, groups = "Logo", dependsOnMethods = "googleTitleTets")
	public void googleImageTest() {
		boolean b = driver.findElement(By.xpath("//img[@id='hplogo']")).isDisplayed();
	}

	@Test(priority = 1, groups = "LinkTest")
	public void mailLink() {
		boolean b = driver.findElement(By.xpath("//a[@id='gb_70']")).isDisplayed();
	}

	@Test(expectedExceptions = NumberFormatException.class)
	public void expectException() {
		String x = "100A";
		Integer.parseInt(x);
	}

	
	  @AfterMethod public void tearDown() { 
		  driver.quit(); 
	  }
	 
}
