package com.pages;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UnarchiveAndDeleteSlackChannels 
{
    protected static WebDriver driver;
    
    public static Pages pages;
    
    @Test(alwaysRun = true)
    public static void unarchiveSlackChannels() throws Exception
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
        
        int i = 1;
        while(true)
        {
            // click on channel add button
            pages.applicationPage().channelAddButton().click();
            Thread.sleep(1000);
            
            // Click on Browse Channels menu
            pages.applicationPage().browseChannelsMenuButton().click();
            Thread.sleep(3000);
            
            // Click on Filter button
            pages.applicationPage().filterMenuButton().click();
            Thread.sleep(2000);
            
            // Click channel type dropdown
            pages.applicationPage().channelTypeDropdown().click();
            Thread.sleep(2000);
            
            // Select Archived Channels menu
            pages.applicationPage().archivedChannelsMenu().click();
            Thread.sleep(3000);   
            
            // Click first archived channel from the list
            Thread.sleep(2000);
            pages.applicationPage().firstArchivedChannel().click();
            Thread.sleep(2000);
            
            if(i == 1)
            {
                // Click on Channel Info (Details) button from top right corner
                pages.applicationPage().channelDetailsButton().click();
                Thread.sleep(2000);
            }
            
            // Click Unarchive button for the channel
            pages.applicationPage().unarchiveChannelButton().click();
            Thread.sleep(3000); 
            
            // Click on more button for channel
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
                    
            System.out.println("Number of channels unarchived and deleted - " + i);
            i++;
        }
        
        
    }

        
}