package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {
    private WebDriver driver;

    private By triggerAlertButton = By.xpath(".//button[text()='Click for JS Alert");
    private By results =   By.id("result");


    public AlertsPage(){
        this.driver = driver;
    }

    public void trigglerAlert(){
        driver.findElement(triggerAlertButton).click();
    }

    public void acceptAlert( ){
        driver.switchTo().alert().accept();
    }

    public String getResult(){
        return driver.findElement(results).getText();
    }
}
