package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SlackApplicationPage {
    
    private static WebDriver driver;

    public SlackApplicationPage(WebDriver driver) {
        SlackApplicationPage.driver = driver;
    }

    // Elements used in delete channel steps
    
    public WebElement generalChannel() {
        return driver.findElement(By.xpath("//span[text()='general']"));
    }
    
    public WebElement channelAboveGeneralChannel() {
        return driver.findElement(By.xpath("//span[text()='general']//preceding::span[@class='p-channel_sidebar__name'][1]"));
    }
    
    public WebElement channelInfoIcon() {
        return driver.findElement(By.xpath("//i[@type='info-circle']"));
    }
    
    public WebElement channelMoreButton() {
        return driver.findElement(By.xpath("//div[text()='More']"));
    }
    
    public WebElement channelAdditionalOptional() {
        return driver.findElement(By.xpath("//div[@class='c-menu_item__label'][text()='Additional options…']"));
    }
    
    public WebElement deleteChannelOption() {
        return driver.findElement(By.xpath("//button[@data-qa='delete']"));
    }
    
    public WebElement permanentDeleteCheckbox() {
        return driver.findElement(By.xpath("//input[@type='checkbox'][@id='delete_channel_cb']"));
    }
    
    public WebElement deleteButton() {
        return driver.findElement(By.xpath("//button[text()='Delete Channel']"));
    }
    
    // Elements used in un-archive channel steps
    
    public WebElement channelAddButton() {
        return driver.findElement(By.xpath("//button[@data-qa='channel_sidebar__plus__channels']"));
    }
    
    public WebElement browseChannelsMenuButton() {
        return driver.findElement(By.xpath("//div[@class='c-menu_item__label']"));
    }
    
    public WebElement filterMenuButton() {
        return driver.findElement(By.xpath("//button[@aria-label='Filter']"));
    }
  
    public WebElement channelTypeDropdown() {
        return driver.findElement(By.xpath("//div[@id='channel_filter_type_button']"));
    }
  
    public WebElement archivedChannelsMenu() {
        return driver.findElement(By.xpath("//span[@class='c-select_options_list__option_label'][text()='Archived channels']"));
    }
                     
    public WebElement firstArchivedChannel() {
        return driver.findElement(By.xpath("(//span[@class='c-channel_entity__name c-channel_entity__name--bold'])[contains(text(),'archived')][1]"));
    }
  
    public WebElement unarchiveChannelButton() {
        return driver.findElement(By.xpath("//i[@class='c-icon p-ia__channel_details__action_icon c-icon--unarchive']"));
    }
    
    public WebElement nextPageButton() {
        return driver.findElement(By.xpath("//i[@class='c-icon c-icon--chevron-right']"));
    }

    
}
