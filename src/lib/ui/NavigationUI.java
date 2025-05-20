package lib.ui;

import io.appium.java_client.AppiumDriver;

abstract public class NavigationUI extends MainPageObject {

    protected static String
            SNACKBAR_ACTION,
            BACK_BUTTON;


    public NavigationUI(AppiumDriver driver)
    {
        super(driver);
    }

    public void snackbarAction()
    {
        this.waitForElementAndClick(
                SNACKBAR_ACTION,
                "Cannot press snackbar_action",
                5
        );
    }

    public void backButton()
    {
        this.waitForElementAndClick(
                BACK_BUTTON, //локатор на кнопку назад
                "Cannot Navigate up",
                5
        );
    }
}
