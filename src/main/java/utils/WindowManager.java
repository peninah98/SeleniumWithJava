package utils;

import org.openqa.selenium.WebDriver;

public class WindowManager {
    private WebDriver driver;
    private WebDriver.Navigation navigate;



    public WindowManager(WebDriver driver){
        this.driver = driver;
        navigate = driver.navigate();
    }

    public void goBack(){
        navigate.back();
    }

    public void goForward(){
        navigate.forward();
    }

    public void refreshPage(){
        navigate.refresh();
    }

    public void goTo(String url){
        navigate.to(url);
    }

    public void switchToTabs(String tabTitle){
      var windows =   driver.getWindowHandles();

        System.out.println("Number of tabs" + windows.size());
        System.out.println("Number of tabs" + windows.toArray().length);


        System.out.println("Win handlers");
        windows.forEach(System.out::println);

        for (String window: windows){
            System.out.println("Switching window" + window);
            driver.switchTo().window(window);
            System.out.println("Current window title" + driver.getTitle());

            if (tabTitle.equals(driver.getTitle())){
                break;
            }
        }

    }


}
