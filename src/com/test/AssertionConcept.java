package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AssertionConcept {

	WebDriver driver;

	
	  @BeforeMethod 
	  public void setUp() 
	  {
		  System.setProperty("webdriver.gecko.driver","D:\\Selenium\\drivers\\geckodriver.exe"); driver = new FirefoxDriver();
	      driver.manage().window().maximize(); driver.manage().deleteAllCookies();
	      driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	      driver.get("http://www.google.com");
	   }
	 
	
	
	  @Test
	  public void googleTitleTets() { 
		  String title = driver.getTitle();
	      System.out.println(title);
	      Assert.assertEquals(title, "Google123","title is not matched");
	  }
	  @Test
	  void googleImageTest() { 
		  boolean b = driver.findElement(By.xpath("//img[@id='hplogo']")).isDisplayed();
		  Assert.assertTrue(b);
	   }
	
	
	
	  @AfterMethod 
	  public void tearDown() { 
		  driver.quit(); 
	  }
	 
	
}
