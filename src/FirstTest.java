import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class FirstTest {

        private AppiumDriver driver;

        @Before
        public void setUp() throws Exception
        {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "AndroidTestDevice");
            capabilities.setCapability("platformVersion", "8.0");
            capabilities.setCapability("automationName", "UiAutomator2");
            capabilities.setCapability("appPackage", "org.wikipedia");
            capabilities.setCapability("appActivity", ".main.MainActivity");
            capabilities.setCapability("app", "/Users/tanya/Desktop/JavaAppiumAutomatoin/JavaAppiumAutomation/apks/org.wikipedia.apk");

            driver = new AndroidDriver(new URL ("http://127.0.0.1:4723"), capabilities);
        }

        @After
        public void tearDown()
        {
            driver.quit();
        }

//        @Test // Тест на поиск названия поисковой строки
//        public void FirstTest()
//        {
//            waitForElementAndClick(
//                    By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                    "Cannot find Search Wikipedia input",
//                    5
//            );
//
//            waitForElementAndSendKeys(
//                    By.xpath("//*[contains(@text,'Search…')]"),
//                    "Java",
//                    "Cannot find search input",
//                    5
//            );
//
//            waitForElementPresent(
//                    By.xpath("//*[contains(@resource-id,'org.wikipedia:id/page_list_item_container')]//*[contains(@text,'Object-oriented programming language')]"),
//                    "Cannot find 'Object-oriented programming language' topic searching by 'Java'",
//                    15
//            );
//        }
//
//        @Test // Тест по очистке введенного слова и возращения назад
//        public void testCancelSearch()
//        {
//            waitForElementAndClick(
//                    By.id("org.wikipedia:id/search_container"),
//                    "Cannot find 'Search Wikipedia' input",
//                    5
//            );
//
//            waitForElementAndSendKeys(
//                    By.xpath("//*[contains(@text,'Search…')]"),
//                    "Java",
//                    "Cannot find search input",
//                    5
//            );
//
//            waitForElementAndClear(
//                    By.id("org.wikipedia:id/search_src_text"),
//                    "Cannot find search clear",
//                    5
//            );
//
//            waitForElementAndClick(
//                    By.id("org.wikipedia:id/search_close_btn"),
//                    "Cannot find X to cancel search",
//                    5
//            );
//
//            waitForElementNotPresent(
//                    By.id("org.wikipedia:id/search_close_btn"),
//                    "X is still present on the page",
//                    5
//            );
//        }
//
//        @Test // Тест на открытие статьи
//        public void testCompareArticelTitle()
//        {
//            waitForElementAndClick(
//                    By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                    "Cannot find Search Wikipedia input",
//                    5
//            );
//
//            waitForElementAndSendKeys(
//                    By.xpath("//*[contains(@text,'Search…')]"),
//                    "Java",
//                    "Cannot find search input",
//                    5
//            );
//
//            waitForElementAndClick(
//                    By.xpath("//*[contains(@resource-id,'org.wikipedia:id/page_list_item_container')]//*[contains(@text,'Object-oriented programming language')]"),
//                    "Cannot find 'Search Wikipedia' input",
//                    5
//            );
//
//            WebElement title_element = waitForElementPresent(
//                    By.id("org.wikipedia:id/view_wiki_error_text"),
//                    "Cannot find acticle title",
//                    15
//            );
//
//            String acticle_title = title_element.getAttribute("text");
//
//            Assert.assertEquals(
//                    "We see unexpected title",
//                    "An error occurred",
//                    acticle_title
//            );
//        }
//
//// Тема 3, ДЗ 1
//        @Test
//        public void article_has_test()
//        {
//            waitForElementAndClick(
//                    By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                    "Cannot find Search Wikipedia input",
//                    5
//            );
//
//            assertElementHasText(
//                    By.xpath("//*[contains(@text,'Search…')]"),
//                    "",
//                    "Cannot find search input"
//            );
//
//        }

// Тема 3, ДЗ 2
        @Test
        public void cancel_search()
        {
            waitForElementAndClick(
                    By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                    "Cannot find Search Wikipedia input",
                    5
            );

            waitForElementAndSendKeys(
                    By.xpath("//*[contains(@text,'Search…')]"),
                    "Russia",
                    "Cannot find search input",
                    15
            );

            waitForElementPresent(
                    By.xpath("//*[contains(@text,'Country in Eastern Europe and Northern Asia')]"),
                    "Cannot find 'Country in Eastern Europe' input",
                    5
            );

            waitForElementPresent(
                    By.xpath("//*[contains(@text,'East Slavic language')]"),
                    "Cannot find 'East Slavic language' input",
                    5
            );

            waitForElementAndClear(
                    By.id("org.wikipedia:id/search_src_text"),
                    "Cannot find search clear",
                    5
            );

            waitForElementNotPresent(
                    By.xpath("//*[contains(@text,'Country in Eastern Europe and Northern Asia')]"),
                    "X is still present on the page",
                    10
            );
        }

        private WebElement waitForElementPresent(By by, String error_message, long timeoutIntSeconds)
        {
            WebDriverWait wait = new WebDriverWait(driver, timeoutIntSeconds);
            wait.withMessage(error_message + "\n");
            return wait.until(
                    ExpectedConditions.presenceOfElementLocated(by)
            );
        }
        private WebElement waitForElementPresent(By by, String error_message)
        {
        return waitForElementPresent(by, error_message, 5);
        }

        private WebElement waitForElementAndClick(By by, String error_message, long timeOutInSecond)
        {
          WebElement element = waitForElementPresent(by, error_message, timeOutInSecond);
          element.click();
          return element;
        }

        private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeOutInSecond)
        {
            WebElement element = waitForElementPresent(by, error_message, timeOutInSecond);
            element.sendKeys(value);
            return element;
        }

         private boolean waitForElementNotPresent(By by, String error_message, long timeOutInSecond)
        {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
            wait.withMessage(error_message + "\n");
            return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
            );
        }

        private WebElement waitForElementAndClear(By by, String error_message, long timeOutInSecond)
        {
            WebElement element = waitForElementPresent(by, error_message, timeOutInSecond);
            element.clear();
            return element;
        }
// Тема 3, ДЗ N 1
        private WebElement assertElementHasText(By by, String value, String error_message)
        {
            WebElement element = waitForElementPresent(by, error_message);
            element.sendKeys(value);
            return element;
        }
}
