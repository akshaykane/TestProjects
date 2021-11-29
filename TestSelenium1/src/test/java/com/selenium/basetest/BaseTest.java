package com.selenium.basetest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    
    public WebDriver driver;
    
    public Properties propObj;
    
    @BeforeMethod
    public void init() throws IOException {
        
        FileInputStream file = new FileInputStream(new File("files/config.properties"));
        propObj = new Properties();
        propObj.load(file);
        
        String chromedriverPath = propObj.getProperty("webdriver.chrome.driver");
        
        String applicationUrl = propObj.getProperty("app.url");
        
        System.setProperty("webdriver.chrome.driver", chromedriverPath);
        
        ChromeOptions options = new ChromeOptions();
        
        
        // Comment the line below when you don't want to run the tests in headless mode
        //options.addArguments("headless");
        
        driver = new ChromeDriver(options);
        
        driver.manage().window().maximize();
        driver.navigate().to(applicationUrl);
        
    }
    
    
    @AfterMethod
    public void closeBrowser() throws IOException {
        
        // Close the browser
        driver.quit();
        
    }
    

    

}
