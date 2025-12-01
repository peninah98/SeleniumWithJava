package frames;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class FrameTests extends BaseTests {

    @Test
    public void testWysiwyg(){
      var editorPage =  homePage.clickWysiwygEditor();
      editorPage.clearTextArea();

      String text1 ="hello";
      String text2 = "world";

      editorPage.setextArea(text1);
      editorPage.decreaseIndention();
      editorPage.setextArea(text2);

      assertEquals(editorPage.getTextFormEditor(),text1+text2, "Text does not match");



    }

}
