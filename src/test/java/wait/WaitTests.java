package wait;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class WaitTests extends BaseTests{

//    @Test
//    public void testWaitUntilHidden(){
//        var loadingPage = homePage.clickDynamicLoading().clickExample1();
//        loadingPage.clickStartButton();
//        assertEquals(loadingPage.getLoadingText(),"Hello World!","The text does not match!!" );
//    }

    @Test
    public void testWaitUntilHidden() {
        System.out.println("Running test: Wait Until Hidden");

        var loadingPage = homePage.clickDynamicLoading().clickExample1();
        loadingPage.clickStartButton();

        assertEquals(loadingPage.getLoadingText(), "Hello World!");

        System.out.println("Test passed!");
    }
}
