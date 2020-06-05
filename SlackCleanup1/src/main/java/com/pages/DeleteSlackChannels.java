package com.pages;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DeleteSlackChannels 
{
    protected static WebDriver driver;
    
    public static Pages pages;
    
    @Test(alwaysRun = true)
    public static void deleteSlackChannels() throws Exception
    {  

        FileInputStream file = new FileInputStream(new File("files/default.properties"));
        Properties propObj = new Properties();
        propObj.load(file);
        
        System.setProperty("webdriver.chrome.driver", propObj.getProperty("chromedriverpath"));
        driver = new ChromeDriver();
        driver.get(propObj.getProperty("test.url"));
        driver.manage().window().maximize();
        
        Pages pages = new Pages(driver);
        
        
        // Sign in to Slack application
        pages.loginPage().emailField().clear();
        pages.loginPage().emailField().sendKeys(propObj.getProperty("test.username"));
        
        pages.loginPage().passwordField().clear();
        pages.loginPage().passwordField().sendKeys(propObj.getProperty("test.password"));
        
        pages.loginPage().signInButton().click();
        Thread.sleep(5000);

        
        // Delete the channels 
        pages.applicationPage().generalChannel().click();
        Thread.sleep(3000);
    
        pages.applicationPage().channelAboveGeneralChannel().click();
        Thread.sleep(2000);
        
        pages.applicationPage().channelInfoIcon().click();
        Thread.sleep(1000);
        
        pages.applicationPage().channelMoreButton().click();
        Thread.sleep(1000);
       
        // click on channel additional options button
        pages.applicationPage().channelAdditionalOptional().click();
        Thread.sleep(1000);
        
        // click on delete channel
        pages.applicationPage().deleteChannelOption().click();
        Thread.sleep(1000);
        
        // click on permanent delete
        pages.applicationPage().permanentDeleteCheckbox().click();
        Thread.sleep(1000);
        
        // click on delete
        pages.applicationPage().deleteButton().click();
        Thread.sleep(3000);
        
        int deleteCounter = 1;
        
        while(true)
        {
            pages.applicationPage().channelAboveGeneralChannel().click();
            Thread.sleep(2000);

            pages.applicationPage().channelMoreButton().click();
            Thread.sleep(1000);

            pages.applicationPage().channelAdditionalOptional().click();
            Thread.sleep(1000);

            pages.applicationPage().deleteChannelOption().click();
            Thread.sleep(1000);

            pages.applicationPage().permanentDeleteCheckbox().click();
            Thread.sleep(1000);

            pages.applicationPage().deleteButton().click();
            Thread.sleep(3000);
            
            deleteCounter++;
            
            System.out.println("Number of slack channels deleted - " + deleteCounter);
        }
        
        
        
    }

        
}
