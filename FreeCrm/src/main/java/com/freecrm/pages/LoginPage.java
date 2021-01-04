package com.freecrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    
    private WebDriver driver;
    private WebDriverWait wait;
        
    @FindBy(xpath="//input[@name='email']")
    private WebElement emailField;
    
    @FindBy(xpath="//input[@name='password']")
    private WebElement passwordField;
    
    @FindBy(xpath="//div[text()='Login']")
    private WebElement loginButton;
    
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }
    
    public void enterEmailValue(String email)
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.emailField));
        this.emailField.clear();
        this.emailField.sendKeys(email);
    }
    
    public void enterPasswordValue(String password)
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.passwordField));
        this.passwordField.clear();
        this.passwordField.sendKeys(password);
    }
    
    public void clickLoginButton() 
    {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.loginButton));
        this.loginButton.click();      
    }

}
