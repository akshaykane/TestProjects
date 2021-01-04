package com.freecrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FreeCrmHomePage {
    
    private WebDriver driver;
    private WebDriverWait wait;
    
    @FindBy(xpath="//span[text()='Log In']")
    private WebElement loginButton;
    
    
    public FreeCrmHomePage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }

    public void clickLoginButton() 
    {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.loginButton));
        this.loginButton.click();      
    }
}
