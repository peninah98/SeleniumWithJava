package org.example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTests {
    private WebDriver  driver;
    protected HomePage homePage;

    public static void main(String args[]) {
        BaseTests tests = new BaseTests();

        tests.setUp();
    }

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
        driver.quit();
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
