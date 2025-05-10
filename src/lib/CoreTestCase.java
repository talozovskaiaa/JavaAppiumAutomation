package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;

public class CoreTestCase extends TestCase
{
    private static final String PLATFORM_IOS = "ios";
    private static final String PLATFORM_ANDROID = "android";

    protected AppiumDriver driver;
    private static String AppiumURL = "http://127.0.0.1:4723";

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();

        driver = this.createDriver();

//        DesiredCapabilities capabilities = this.getCapabilitiesByPlatformEvn();
//        driver = new AndroidDriver(new URL(AppiumURL), capabilities);
        this.rotateScreenPortrait();
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

    private AppiumDriver createDriver() throws Exception {

        String platform = System.getenv("PLATFORM");

        if (platform == null || platform.isEmpty()) {
            throw new IllegalArgumentException("PLATFORM environment variable is not set");
        }

        DesiredCapabilities capabilities = getCapabilitiesByPlatformEvn(platform);

        if (platform.equalsIgnoreCase(PLATFORM_ANDROID)) {
            return new AndroidDriver(new URL(AppiumURL), capabilities);
        } else if (platform.equalsIgnoreCase(PLATFORM_IOS)) {
            return new IOSDriver(new URL(AppiumURL), capabilities);
        } else {
            throw new Exception("Unsupported platform: " + platform);
        }
    }

    private DesiredCapabilities getCapabilitiesByPlatformEvn(String platform) throws Exception {

        String platform1 = System.getenv("PLATFORM");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (platform.equals(PLATFORM_ANDROID)) {

            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "AndroidTestDevice");
            capabilities.setCapability("platformVersion", "8.1");
            capabilities.setCapability("automationName", "UiAutomator2");
            capabilities.setCapability("appPackage", "org.wikipedia");
            capabilities.setCapability("appActivity", ".main.MainActivity");
            capabilities.setCapability("app", "/Users/tanya/Desktop/JavaAppiumAutomatoin/JavaAppiumAutomation/apks/Wikipedia.apk");

        } else if (platform.equals(PLATFORM_IOS)) {

            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("deviceName", "Appium Simulator");
            capabilities.setCapability("platformVersion", "18.4");
            capabilities.setCapability("automationName", "XCUITest");
            capabilities.setCapability("app", "/Users/tanya/Desktop/JavaAppiumAutomatoin/JavaAppiumAutomation/apks/Wikipedia745.app");

        } else {
            throw new Exception("Cannot get run platform from env variable. Platform value " + platform1);
        }
        return capabilities;
    }

}
