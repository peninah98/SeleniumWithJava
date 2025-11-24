package base;

import org.example.HomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseTests {
    private WebDriver  driver;
    protected HomePage homePage;

    @BeforeClass
    public void suppressWarnings() {
        Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
    }

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
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
}