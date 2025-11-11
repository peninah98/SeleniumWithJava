package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTests {
    private WebDriver driver;
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver    = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        System.out.println("Get driver title: " + driver.getTitle());
        driver.quit();
    }

    public static void main(String args[]){
        BaseTests tests = new BaseTests();
        tests.setUp();
    }
}