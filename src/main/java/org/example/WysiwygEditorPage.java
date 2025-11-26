package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WysiwygEditorPage {
    private WebDriver driver;
    private String editorIframeId = "mce_0_ifr";
    private By textArea = By.id("tinymce");

    public void WysiwygEditorPage(WebDriver driver){
        this.driver = driver;
    }
    public void clearTextArea(){
        switchToFrame();
        driver.findElement(textArea).clear();
        switchToMainArea();
    }
    public void setextArea(String text){
        switchToFrame();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }
    private void switchToFrame(){
        driver.switchTo().frame(editorIframeId);
    }

    private void switchToMainArea(){
        driver.switchTo().parentFrame();
    }
}
