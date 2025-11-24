package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickFormAuthenticationLink() {
        clickLink("Form Authentication");
        return new LoginPage(driver);
    }
    public DropdownPage clickDropdown() {
        clickLink("Dropdown");
        return new DropdownPage(driver);
    }
    public HoverPage clickHovers(){
        clickLink("Hovers");
        return new HoverPage(driver);
    }

    public KeyPressPage clickKeyPress(){
        clickLink("Key Presses");
        return new KeyPressPage(driver);

    }

    public AlertsPage clickJavaScriptAlerts(){
        clickLink("JavaScript Alerts");
        return  new AlertsPage();
    }

    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();

    }
}


