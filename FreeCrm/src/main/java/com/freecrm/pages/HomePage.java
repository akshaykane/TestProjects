package com.freecrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    
    private WebDriver driver;
    private WebDriverWait wait;
        
    @FindBy(xpath="//span[@class='user-display']")
    private WebElement usernameField;
    
    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }
    
    public String getUsernameValue()
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.usernameField));
        return this.usernameField.getText();
    }

}
