package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SlackLoginPage {
    
    private static WebDriver driver;

    public SlackLoginPage(WebDriver driver) {
        SlackLoginPage.driver = driver;
    }

    public WebElement emailField() {
        return driver.findElement(By.id("email"));
    }

    public WebElement passwordField() {
        return driver.findElement(By.id("password"));
    }

    public WebElement signInButton() {
        return driver.findElement(By.id("signin_btn"));
    }
    
}
