package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {
    private WebDriver driver;
    private HomePage homePage;
    private String linkXPath_format = ".//a[contains(text(),'%s')]";
    private By link_Example1 = By.xpath(String.format(linkXPath_format, "Example 1: Element on page that is hidden"));


    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }


    public  DynamicLoadingExample1Page clickExample1(){
        driver.findElement(link_Example1).click();
        return new DynamicLoadingExample1Page(driver);
    }
}
