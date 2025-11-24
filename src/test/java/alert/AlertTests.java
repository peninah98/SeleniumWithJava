package alert;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import base.BaseTests;

public class AlertTests extends BaseTests {
    @Test
    public void acceptAlertTest() {
        var alertsPage = homePage.clickJavaScriptAlerts();

        alertsPage.alert_clickToAccept();
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(), "You successfuly clicked an alert", "Results text incorrect");
    }

    @Test
    public void testGetTextFromAlert() {
        var alertsPage = homePage.clickJavaScriptAlerts();

        alertsPage.trigglerConfirm();
        String text = alertsPage.alert_getText();
        alertsPage.alert_clickToAccept();
        assertEquals(text, "I am a JS Confirm", "Alerts text incorrect");
    }

    @Test
    public void testSetInputInAlert(){
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerPrompt();

        // UNCOMMENTED - Now actually sending the text!
        String text = "TAU rocks!";
        alertsPage.alert_setInputText(text);
        alertsPage.alert_clickToAccept();

        // Fixed expected value to include "You entered: " prefix
        assertEquals("You entered: TAU rocks!", alertsPage.getResult());
//        assertTrue(alertsPage.getResult().contains(text));
        assertEquals( alertsPage.getResult(),text, "TAU rocks!");
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
