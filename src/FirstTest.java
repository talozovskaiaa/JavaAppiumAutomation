import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.xml.dtm.ref.sax2dtm.SAX2RTFDTM;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.net.URL;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class FirstTest {

    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "8.1");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "/Users/tanya/Desktop/JavaAppiumAutomatoin/JavaAppiumAutomation/apks/Wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

//        @Test // Тест на поиск названия поисковой строки
//        public void FirstTest()
//        {
//            waitForElementAndClick(
//                    By.id("org.wikipedia:id/fragment_onboarding_skip_button"),
//                    "Cannot find Onbording",
//                    5
//            );
//
//            waitForElementAndClick(
//                    By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                    "Cannot find Search Wikipedia input",
//                    5
//            );
//
//            waitForElementAndSendKeys(
//                    By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                    "Java",
//                    "Cannot find search input",
//                    5
//            );
//
//            waitForElementPresent(
//                    By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
//                    "Cannot find 'Object-oriented programming language' topic searching by 'Java'",
//                    15
//            );
//        }
//
//        @Test // СТАРАЯ ВЕРСИЯ APK Тест по очистке введенного слова и возращения назад
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
//        @Test // СТАРАЯ ВЕРСИЯ APK Тест на открытие статьи
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
//        @Test // Тест скролл статьи
//        public void testSwipeArticle()
//        {
//            waitForElementAndClick(
//                By.id("org.wikipedia:id/fragment_onboarding_skip_button"),
//                "Cannot find Onbording",
//                5
//            );
//
//            waitForElementAndClick(
//                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                "Cannot find Search Wikipedia input",
//                5
//            );
//
//            waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                "Appium",
//                "Cannot find search input",
//                5
//            );
//
//            waitForElementAndClick(
//                By.xpath("//*[contains(@text,'Automation for Apps')]"),
//                "Cannot find 'Appium' input",
//                5
//            );
//
//            WebElement title_element = waitForElementPresent(
//                By.id("org.wikipedia:id/page_toolbar_button_search"),
//                "Cannot find acticle title",
//                15
//            );
//
//            swipeUpToFindElement(
//                By.xpath("//android.view.View[@content-desc='View article in browser']"),
//                "Cannot find the end of the article",
//                20
//            );
//        }
//
//        @Test // Создание папки сохраненных, добавление и удаление статьи
//        public void saveFirstArticleToMyList()
//        {
//            waitForElementAndClick(
//                By.id("org.wikipedia:id/fragment_onboarding_skip_button"),
//                "Cannot find Onbording",
//                5
//            );
//
//            waitForElementAndClick(
//                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                "Cannot find Search Wikipedia input",
//                5
//            );
//
//            waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                "Java",
//                "Cannot find search input",
//                5
//            );
//
//            waitForElementAndClick(
//                By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
//                "Cannot find 'Object-oriented programming language' topic searching by 'Java'",
//                15
//            );
//
//            waitForElementAndClick(
//                By.xpath("//*[contains(@text,'Save')]"),
//                "Cannot find Save",
//                5
//            );
//
//            waitForElementAndClick(
//                By.xpath("//*[contains(@text,'Add to list')]"),
//                "Cannot find Add to list",
//                5
//            );
//
//            waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text,'Name of this list')]"),
//                "New create list",
//                "Cannot put text into article folder input",
//                5
//            );
//
//            waitForElementAndClick(
//                By.xpath("//*[contains(@text,'OK')]"),
//                "Cannot press OK button",
//                5
//            );
//
//            waitForElementAndClick(
//                By.id("org.wikipedia:id/snackbar_action"),
//                "Cannot press snackbar_action",
//                5
//            );
//
//            waitForElementPresent(
//                By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
//                "Cannot find 'Object-oriented programming language' topic searching by 'Java'",
//                15
//            );
//
//            swipeElementToLeft(
//                By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
//                "Cannot swipe up"
//            );
//
//            waitForElementNotPresent(
//                By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
//                "Cannot delete",
//                10
//            );
//        }
//
//        @Test // Тест по добавлению Accert
//        public void testAmountOfNotEmptySearch()
//        {
//            waitForElementAndClick(
//                    By.id("org.wikipedia:id/fragment_onboarding_skip_button"),
//                    "Cannot find Onbording",
//                    5
//            );
//
//            waitForElementAndClick(
//                    By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                    "Cannot find Search Wikipedia input",
//                    5
//            );
//
//            String search_line = "Linkin Park Diskography";
//            waitForElementAndSendKeys(
//                    By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                    search_line,
//                    "Cannot find search input",
//                    5
//            );
//
//            String search_result_locator = "org.wikipedia:id/page_list_item_title";
//            waitForElementPresent(
//                    By.id(search_result_locator),
//                    "Cannot find anything by the request " + search_line,
//                    15
//            );
//
//            int amount_of_search_results = getAmountOfElements1(
//                    By.id(search_result_locator)
//            );
//
//            Assert.assertTrue(
//                    "We found too few results!",
//                    amount_of_search_results > 0
//            );
//        }
//
//        @Test
//        public void testAmountOfEmptySearch()
//        {
//            waitForElementAndClick(
//                    By.id("org.wikipedia:id/fragment_onboarding_skip_button"),
//                    "Cannot find Onbording",
//                    5
//            );
//
//            waitForElementAndClick(
//                    By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                    "Cannot find Search Wikipedia input",
//                    5
//            );
//
//            String search_line = "zxcvbnmddceh";
//            waitForElementAndSendKeys(
//                    By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                    search_line,
//                    "Cannot find search input",
//                    5
//            );
//
//            String search_result_locator = "org.wikipedia:id/page_list_item_title";
//            String empty_result_label = "//*[contains(@text,'No results')]";
//
//            waitForElementPresent(
//                    By.xpath(empty_result_label),
//                    "Cannot find empty result label by the request " +  search_line,
//                    15
//            );
//
//            assertElementNotPresent(
//                    By.id(search_result_locator),
//                    "We've found some results by request " + search_line
//            );
//        }
//
//        @Test // Тест на сравнение статей при повороте экране
//        public void testChangesScreenOrientationOnSearchResults()
//        {
//            waitForElementAndClick(
//                    By.id("org.wikipedia:id/fragment_onboarding_skip_button"),
//                    "Cannot find Onbording",
//                    5
//            );
//
//            waitForElementAndClick(
//                    By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                    "Cannot find Search Wikipedia input",
//                    5
//            );
//
//            String search_line = "Java";
//            waitForElementAndSendKeys(
//                    By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                    search_line,
//                    "Cannot find search input",
//                    5
//            );
//
//            waitForElementAndClick(
//                    By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
//                    "Cannot find 'Object-oriented programming language' topic searching by " + search_line,
//                    15
//            );
//
//            String title_before_rotation = waitForElementAndGetAttribute(
//                    By.xpath("//*[contains(@content-desc, 'Java (programming language)')]"),
//                    "text",
//                    "Cannot find title of article",
//                    15
//            );
//
//            driver.rotate(ScreenOrientation.LANDSCAPE);
//
//            String title_after_rotation = waitForElementAndGetAttribute(
//                    By.xpath("//*[contains(@content-desc, 'Java (programming language)')]"),
//                    "text",
//                    "Cannot find title of article",
//                    15
//            );
//
//            Assert.assertEquals(
//                    "Article title have been changed after screen rotation",
//                    title_before_rotation,
//                    title_after_rotation
//            );
//
//            driver.rotate(ScreenOrientation.PORTRAIT);
//
//            String title_after_second_rotation = waitForElementAndGetAttribute(
//                    By.xpath("//*[contains(@content-desc, 'Java (programming language)')]"),
//                    "text",
//                    "Cannot find title of article",
//                    15
//            );
//
//            Assert.assertEquals(
//                    "Article title have been changed after screen rotation",
//                    title_before_rotation,
//                    title_after_second_rotation
//            );
//        }
//
//        @Test //сворачивать приложение и возвращаться к нему снова
//        public void testCheckSearchArticleInBackround()
//        {
//            waitForElementAndClick(
//                    By.id("org.wikipedia:id/fragment_onboarding_skip_button"),
//                    "Cannot find Onbording",
//                    5
//            );
//
//            waitForElementAndClick(
//                    By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                    "Cannot find Search Wikipedia input",
//                    5
//            );
//
//            String search_line = "Java";
//            waitForElementAndSendKeys(
//                    By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                    search_line,
//                    "Cannot find search input",
//                    5
//            );
//
//            waitForElementPresent(
//                    By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
//                    "Cannot find 'Object-oriented programming language'",
//                    15
//            );
//
//            driver.runAppInBackground(Duration.ofSeconds(5));
//
//            waitForElementPresent(
//                    By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
//                    "Cannot find 'Object-oriented programming language' after returning from background",
//                    15
//            );
//        }
//
//
//
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
//

    /// / Тема 3, ДЗ 2
//        @Test
//        public void cancel_search()
//        {
//            waitForElementAndClick(
//                    By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                    "Cannot find Search Wikipedia input",
//                    5
//            );
//
//            waitForElementAndSendKeys(
//                    By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                    "Russia",
//                    "Cannot find search input",
//                    15
//            );
//
//            waitForElementPresent(
//                    By.xpath("//*[contains(@text,'Country in Eastern Europe and Northern Asia')]"),
//                    "Cannot find 'Country in Eastern Europe' input",
//                    5
//            );
//
//            waitForElementPresent(
//                    By.xpath("//*[contains(@text,'East Slavic language')]"),
//                    "Cannot find 'East Slavic language' input",
//                    5
//            );
//
//            waitForElementAndClear(
//                    By.id("org.wikipedia:id/search_src_text"),
//                    "Cannot find search clear",
//                    5
//            );
//
//            waitForElementNotPresent(
//                    By.xpath("//*[contains(@text,'Country in Eastern Europe and Northern Asia')]"),
//                    "X is still present on the page",
//                    10
//            );
//        }

    // Тема 4, ДЗ 1
//    @Test // Создание папки сохраненных, добавление и удаление статьи
//    public void saveToArticleToMyList()
//    {
//        waitForElementAndClick(
//                By.id("org.wikipedia:id/fragment_onboarding_skip_button"),
//                "Cannot find Onbording",
//                5
//        );
//
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                "Cannot find Search Wikipedia input",
//                5
//        );
//
//        waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                "Java",
//                "Cannot find search input",
//                5
//        );
//
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
//                "Cannot find 'Object-oriented programming language' topic searching by 'Java'",
//                15
//        );
//
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text,'Save')]"),
//                "Cannot find Save",
//                5
//        );
//
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text,'Add to list')]"),
//                "Cannot find Add to list",
//                5
//        );
//
//        waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text,'Name of this list')]"),
//                "New create list",
//                "Cannot put text into article folder input",
//                5
//        );
//
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text,'OK')]"),
//                "Cannot press OK button",
//                5
//        );
//
//        waitForElementAndClick(
//                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"), //локатор на кнопку назад
//                "Cannot Navigate up",
//                5
//        );
//
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text,'High-level programming language')]"), // локатор на другую статью
//                "Cannot find article 'High-level programming language'",
//                5
//        );
//
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text,'Save')]"), // не менять, локатор на save
//                "Cannot find Save",
//                5
//        );
//
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text,'Add to list')]"), // не менять, переходим в новый лист
//                "Cannot find Add to list",
//                5
//        );
//
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text,'New create list')]"), // выбрать локатор созданного списка
//                "Cannot find Save",
//                5
//        );
//
//        waitForElementAndClick(
//                By.id("org.wikipedia:id/snackbar_action"), // локатор на View List
//                "Cannot press snackbar_action",
//                5
//        );
//
//        swipeElementToLeft(
//                By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
//                "Cannot swipe up"
//        );
//
//        waitForElementPresent(
//                By.xpath("//*[contains(@text,'High-level programming language')]"), // проверить 2ую статью
//                "Cannot find 'Object-oriented programming language' topic searching by 'Java'",
//                15
//        );
//
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text,'High-level programming language')]"), // локатор на другую статью
//                "Cannot press OK button",
//                5
//        );
//
//        waitForElementPresent(
//                By.xpath("(//*[contains(@content-desc, 'JavaScript')])[1]"), // проверить title
//                "Cannot find content-desc, 'JavaScript'",
//                15
//        );
//    }

// Тема 4 ДЗ 2
    @Test // Тест на проверку title
    public void assertElementPresent() {
        waitForElementAndClick(
                By.id("org.wikipedia:id/fragment_onboarding_skip_button"),
                "Cannot find Onbording",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find Search Wikipedia input",
                5
        );

        String search_line = "Java";
        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                search_line,
                "Cannot find search input",
                10
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
                "Cannot find 'Object-oriented programming language' topic searching by 'Java'",
                15
        );

        By title_locator = By.xpath("//android.view.View[@content-desc='Java (programming language)']");
        assertElementPresent(title_locator);

    }


    private WebElement waitForElementPresent(By by, String error_message, long timeoutIntSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutIntSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    private WebElement waitForElementPresent(By by, String error_message) {
        return waitForElementPresent(by, error_message, 5);
    }

    private WebElement waitForElementAndClick(By by, String error_message, long timeOutInSecond) {
        WebElement element = waitForElementPresent(by, error_message, timeOutInSecond);
        element.click();
        return element;
    }

    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeOutInSecond) {
        WebElement element = waitForElementPresent(by, error_message, timeOutInSecond);
        element.sendKeys(value);
        return element;
    }

    private boolean waitForElementNotPresent(By by, String error_message, long timeOutInSecond) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }

    private WebElement waitForElementAndClear(By by, String error_message, long timeOutInSecond) {
        WebElement element = waitForElementPresent(by, error_message, timeOutInSecond);
        element.clear();
        return element;
    }

    // Тема 3, ДЗ N 1
    private WebElement assertElementHasText(By by, String value, String error_message) {
        WebElement element = waitForElementPresent(by, error_message);
        element.sendKeys(value);
        return element;
    }

    protected void swipeUp(int timeOfSwipe) {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width / 2;
        int start_y = (int) (size.height * 0.8);
        int end_y = (int) (size.height * 0.2);

        action
                .press(PointOption.point(x, start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeOfSwipe)))
                .moveTo(PointOption.point(x, end_y))
                .release()
                .perform();
    }

    // Пример метода swipUp

    protected void swipeUp1(int timeOfSwipe) {
        try {
            Dimension size = driver.manage().window().getSize();
            if (size == null || size.width <= 0 || size.height <= 0) {
                throw new RuntimeException("Unable to get screen size");
            }

            int x = size.width / 2;
            int start_y = (int) (size.height * 0.8);
            int end_y = (int) (size.height * 0.2);


            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 1)
                    .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, start_y))
                    .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(finger.createPointerMove(Duration.ofMillis(timeOfSwipe), PointerInput.Origin.viewport(), x, end_y))
                    .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));


            driver.perform(Collections.singletonList(swipe));
        } catch (Exception e) {
            throw new RuntimeException("Failed to perform swipe action", e);
        }
    }

    protected void swipeUpQuick() {
        swipeUp1(200);
    }

    protected void swipeUpToFindElement(By by, String error_message, int max_swipes) {
        int already_swiped = 0;
        while (driver.findElements(by).size() == 0) {
            if (already_swiped > max_swipes) {
                waitForElementPresent(by, "Cannot find element by swiping up. \n" + error_message, 0);
                return;
            }

            swipeUpQuick();
            ++already_swiped;
        }
    }

    protected void swipeElementToLeft(By by, String error_message) {
        try {
            // Находим элемент
            WebElement element = waitForElementPresent(by, error_message, 10);

            // Получаем координаты элемента
            int left_x = element.getLocation().getX();
            int right_x = left_x + element.getSize().getWidth();
            int upper_y = element.getLocation().getY();
            int lower_y = upper_y + element.getSize().getHeight();
            int middle_y = (upper_y + lower_y) / 2;


            // Выполняем свайп влево с использованием W3C Actions API
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 1)
                    .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), right_x, middle_y))
                    .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), left_x, middle_y))
                    .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Collections.singletonList(swipe));
        } catch (Exception e) {
            throw new RuntimeException("Failed to perform swipe left action", e);
        }
    }

    private int getAmountOfElements(By by) {
        List elements = driver.findElements(by);
        return elements.size();
    }

    private int getAmountOfElements1(By by) {
        try {
            // Используем явное ожидание для поиска элементов
            WebDriverWait wait = new WebDriverWait(driver, 10);
            List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));

            // Возвращаем количество найденных элементов
            return elements.size();
        } catch (Exception e) {
            // Если элементы не найдены или произошла ошибка, возвращаем 0
            System.out.println("Error while finding elements: " + e.getMessage());
            return 0;
        }
    }

    private void assertElementNotPresent(By by, String error_message) {
        int amount_of_elements = getAmountOfElements1(by);
        if (amount_of_elements > 0) {
            String default_message = "An element '" + by.toString() + "'supposed to be not present";
            throw new AssertionError(default_message + " " + error_message);
        }
    }

    private String waitForElementAndGetAttribute(By by, String attribute, String error_message, long timeoutInSecond) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSecond);
        return element.getAttribute(attribute);
    }

    //Тема 3, ДЗ 2
    private void assertElementPresent(By by) {
        try {
            WebElement element = driver.findElement(by);
        } catch (Exception e) {
            throw new AssertionError("Элемент не найден: " + by.toString(), e);
        }
    }
}
