package lib.ui.IOS;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUI;

public class IOSNavigationUI extends NavigationUI {

    static {
        SNACKBAR_ACTION = "xpath://XCUIElementTypeButton[@name='{LIST_NAME}']";
        BACK_BUTTON = "xpath://XCUIElementTypeButton[contains(@name,'Назад')]";
    }

    public IOSNavigationUI(AppiumDriver driver)
    {
        super(driver);
    }
}
