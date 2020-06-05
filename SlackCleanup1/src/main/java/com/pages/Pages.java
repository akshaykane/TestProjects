package com.pages;

import org.openqa.selenium.WebDriver;
import com.pages.SlackLoginPage;

public class Pages {
    
    private WebDriver driver;
    
    private SlackLoginPage loginPage;
    
    private SlackApplicationPage applicationPage;
    
    public Pages(WebDriver webdriver) {
        this.driver = webdriver;
    }
    
    public SlackLoginPage loginPage() {
        if (null == loginPage) {
            loginPage = new SlackLoginPage(driver);
        }
        return loginPage;
    }
    
    public SlackApplicationPage applicationPage() {
        if (null == applicationPage) {
            applicationPage = new SlackApplicationPage(driver);
        }
        return applicationPage;
    }

}
