package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUI extends MainPageObject {

    private static final String
            SNACKBAR_ACTION = "org.wikipedia:id/snackbar_action",
            BACK_BUTTON = "//android.widget.ImageButton[@content-desc='Navigate up']";

    public NavigationUI(AppiumDriver driver)
    {
        super(driver);
    }

    public void snackbarAction()
    {
        this.waitForElementAndClick(
                By.id(SNACKBAR_ACTION),
                "Cannot press snackbar_action",
                7
        );
    }

    public void backButton()
    {
        this.waitForElementAndClick(
                By.xpath(BACK_BUTTON), //локатор на кнопку назад
                "Cannot Navigate up",
                5
        );
    }
}
