package lib.ui.Android;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUI;

public class AndroidNavigationUI extends NavigationUI
{
    static {
        SNACKBAR_ACTION = "id:org.wikipedia:id/snackbar_action";
        BACK_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
    }

    public AndroidNavigationUI(AppiumDriver driver)
    {
        super(driver);
    }
}


