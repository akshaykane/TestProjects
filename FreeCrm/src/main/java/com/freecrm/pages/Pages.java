package com.freecrm.pages;

import org.openqa.selenium.WebDriver;

public class Pages {
    
    private WebDriver driver;
    
    private FreeCrmHomePage freeCrmHomePage;
    
    private HomePage homePage;
    
    private LoginPage loginPage;
    
    public Pages(WebDriver driver)
    {
        this.driver = driver; 
    }
    
    public FreeCrmHomePage freeCrmHomePage() {
        freeCrmHomePage = new FreeCrmHomePage(driver);
        return freeCrmHomePage;
    }
    
    public HomePage homePage() {
        homePage = new HomePage(driver);
        return homePage;
    }
    
    public LoginPage loginPage() {
        loginPage = new LoginPage(driver);
        return loginPage;
    }

}
