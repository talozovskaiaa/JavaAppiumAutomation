package lib;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import lib.ui.SearchPageObject;
import lib.ui.WelcomPageObject;
import org.openqa.selenium.ScreenOrientation;

import java.time.Duration;

public class CoreTestCase extends TestCase
{
    protected AppiumDriver driver;

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        driver = Platform.getInstance().getDriver();
        this.rotateScreenPortrait();
        this.skipWelcomePageForIOSApp();
        this.skipWelcomePageAndroidApp();
    }

    @Override
    protected void tearDown() throws Exception
    {
        if (driver != null) {
            driver.quit();
        }
        super.tearDown();
    }

    protected void rotateScreenPortrait()
    {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    protected void rotateScreenLandscape()
    {
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    protected void backgroundApp(int seconds)
    {
        driver.runAppInBackground(Duration.ofSeconds(seconds));
    }

    private void skipWelcomePageForIOSApp()
    {
        if (Platform.getInstance().isIOS()) {
            WelcomPageObject WelcomPageObject = new WelcomPageObject(driver);
            WelcomPageObject.clickSkip();
        }
    }

    private void skipWelcomePageAndroidApp()
    {
        if (Platform.getInstance().isAndroid()) {
            WelcomPageObject WelcomPageObject = new WelcomPageObject(driver);
            WelcomPageObject.initOndoardingInput();
        }
    }

}
