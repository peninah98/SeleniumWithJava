package base;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.common.io.Files;
import org.example.HomePage;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.ITestResult;
import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.WindowManager;

public class BaseTests {
    private WebDriver  driver;
    protected HomePage homePage;

    @BeforeMethod
    public void goHome() {
        driver.get("https://the-internet.herokuapp.com/");
    }


    public static void main(String[] args) {
        TestNG testNG = new TestNG();
        List<Class> testClasses = new ArrayList<>();

        testClasses.add(login.LoginTests.class);
        testNG.setTestClasses(testClasses.toArray(new Class[0]));
        testNG.run();
    }

    @BeforeClass
    public void suppressWarnings() {
        Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
    }

    @BeforeClass
    public void setUp() {
        goHome();
        homePage = new HomePage(driver);
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
    @AfterMethod
    public WindowManager  getWindowManager(){
        return new WindowManager(driver);
    }
    public void recorFailure(ITestResult result) {
        if(ITestResult.FAILURE == result.getStatus()){
        var camera = (TakesScreenshot)driver;
        File screenShot = camera.getScreenshotAs(OutputType.FILE);

try {
    Files.move(screenShot, new File("resources/screenshots/test.png"));

} catch (IOException e) {
    e.printStackTrace();
}
    }


}}