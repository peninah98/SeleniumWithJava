package hover;

import base.BaseTests;
import org.testng.annotations.Test;

import java.sql.Driver;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class HoverTests extends BaseTests {

    @Test
    public void testHoverUser1(){
        var hoverPage = homePage.clickHovers();
        var caption = hoverPage.hoverOverFigure(1);
        assertTrue("Caption not displayed", caption.isCaptionDisplayed());
        assertEquals(caption.getTitle(), "name: user1", "Caption title incorrect");
        assertEquals(caption.getLinkText(),"View ");
        assertTrue("Link incorrect", caption.getLink().endsWith("/users/1"));
    }
}
