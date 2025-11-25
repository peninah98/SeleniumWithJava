package alert;

import org.testng.annotations.Test;

import base.BaseTests;

import static org.testng.AssertJUnit.assertEquals;

public class FileUploadTests extends BaseTests {
    @Test
    public void testFileUpload() {
        var uploadPage = homePage.clickFileUpload();

        uploadPage.uploadFile("C:\\Users\\penin\\IdeaProjects\\Selenium\\src\\main\\resources\\chromedriver.exe");
//        uploadPage.clickUploadButton();
        assertEquals(uploadPage.getUploadedFile(), "chromedriver.exe", "File Uploaded!");
    }
}
