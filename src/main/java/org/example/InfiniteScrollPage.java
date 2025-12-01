package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScrollPage {
    By                textBlocks = By.className("jscroll-added");
    private WebDriver driver;

    public InfiniteScrollPage(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToTextBlock(int index) {
        String script     = "window.scrollTo(0, document.body.scrollHeight)";
        var    jsExecutor = (JavascriptExecutor) driver;

        while (getNumberOfParagraphPresent() < index) {
            jsExecutor.executeScript(script);
        }
    }

    private int getNumberOfParagraphPresent() {
        return driver.findElements(textBlocks).size();
    }
}
