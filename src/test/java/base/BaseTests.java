package base;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.example.HomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTests {
    private WebDriver  driver;
    protected HomePage homePage;

    @BeforeMethod
    public void goHome() {
        driver.get("https://the-internet.herokuapp.com/");
    }

    public static void main(String[] args) {
        TestNG testNG = new TestNG();

        // Add test classes
        List<Class> testClasses = new ArrayList<>();

        testClasses.add(login.LoginTests.class);
        testNG.setTestClasses(testClasses.toArray(new Class[0]));

        // Run tests
        testNG.run();
    }

    @BeforeClass
    public void suppressWarnings() {
        Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
//        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        goHome();
        homePage = new HomePage(driver);
    }
}