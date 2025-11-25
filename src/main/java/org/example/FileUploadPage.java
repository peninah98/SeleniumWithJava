package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {

    private WebDriver driver;
    private By inputField = By.id("file-upload");
    private By uploadButton = By.id("file-submit");
    private By uploadFiles = By.id("upload-files");

    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickUploadButton() {
        driver.findElement(uploadButton).click();
    }

    public void uploadFile(String absolutePathOfFile){
        driver.findElement(inputField).sendKeys(absolutePathOfFile);
        clickUploadButton();
    }

    public String getUploadedFile(){
        return driver.findElement(uploadFiles).getText();
    }
}
