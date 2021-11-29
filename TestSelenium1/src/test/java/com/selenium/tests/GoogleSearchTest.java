package com.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.selenium.basetest.BaseTest;

public class GoogleSearchTest extends BaseTest{
	
  @Test
  public void typeInGoogleSearch() throws InterruptedException {
	  
	  WebElement googleSearchInputField = driver.findElement(By.xpath("//input[@title='Search']"));
	  
	  googleSearchInputField.sendKeys("Selenium");
	  
	  Thread.sleep(5000);
	  
  }
  
}
