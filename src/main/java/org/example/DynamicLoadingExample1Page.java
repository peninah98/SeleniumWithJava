package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadingExample1Page {
    private WebDriver driver;
    private By        startButton      = By.cssSelector("#start button");
    private By        loadingIndicator = By.id("loading");
    private By        loadedText       = By.id("finish");
    private By        textBox          = By.cssSelector("#finish h4");

    public DynamicLoadingExample1Page(WebDriver driver) {
        this.driver = driver;
    }

    public void clickStartButton() {
        driver.findElement(startButton).click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingIndicator)));
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIndicator));
    }

    public String getLoadingText() {
        return driver.findElement(textBox).getText();
    }
}
