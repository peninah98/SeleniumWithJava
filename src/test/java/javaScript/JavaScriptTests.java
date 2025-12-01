package javaScript;

import base.BaseTests;
import org.testng.annotations.Test;

public class JavaScriptTests extends BaseTests {

    @Test
    public void testScrollToTable(){
        homePage.clickLargeDeepDom().scrollToTable();
    }

    @Test
    public void scrollToFifthParagraph(){
        homePage.clickInfiniteScroll().scrollToTextBlock(5);
    }
}
