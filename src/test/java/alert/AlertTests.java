package alert;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class AlertTests extends BaseTests {
@Test
    public void acceptAlertTest(){
    var alertsPage = homePage.clickJavaScriptAlerts();
    alertsPage.acceptAlert();
    alertsPage.acceptAlert();
    assertEquals(alertsPage.getResult(), "You successfuly clicked an alert","Results text incorrect");

}
}
