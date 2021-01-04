package com.freecrm.logintests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.freecrm.basetest.BaseTest;

public class LoginTest extends BaseTest {
    
    
    @Test
    public void loginTest1() {
        
        // Navigate to Free CRM home page and click on Login menu
        getPages().freeCrmHomePage().clickLoginButton();
        
        // Enter valid email and password on login page
        getPages().loginPage().enterEmailValue(propObj.getProperty("email"));      
        getPages().loginPage().enterPasswordValue(propObj.getProperty("password"));
        
        // Click on login button
        getPages().loginPage().clickLoginButton();
        
        // Verify user is logged in and a correct username is displayed on the user home page
        Assert.assertEquals(getPages().homePage().getUsernameValue(), propObj.getProperty("username"), "Incorrect username observed after login");
    }

}
