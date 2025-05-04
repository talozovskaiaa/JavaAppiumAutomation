package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject {

    private static final String
            SEARCH_ONBOARDING_ELEMENT = "org.wikipedia:id/fragment_onboarding_skip_button",
            SEARCH_INPUT_ELEMENT = "//*[contains(@text,'Search Wikipedia')]",
            SEARCH_CANCEL_BUTTON = "//android.widget.ImageButton[@content-desc='Navigate up']",
            SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[contains(@text,'{SUBSTRING}')]",
            SEARCH_RESULT_ELEMENT = "org.wikipedia:id/page_list_item_title",
            SEARCH_EMPTY_RESULT_ELEMENT = "//*[contains(@text,'No results')]",
            SEARCH_RESULT = "org.wikipedia:id/navigation_drawer";


    public SearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    /* TEMPLATES METHODS */
    public static String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    /* TEMPLATES METHODS */

    public void initOndoardingInput() {
        this.waitForElementPresent((By.id(SEARCH_ONBOARDING_ELEMENT)), "Cannot find onboarding skip button");
        this.waitForElementAndClick((By.id(SEARCH_ONBOARDING_ELEMENT)), "Cannot find and click onboarding skip button", 5);
    }

    public void initSearchInput() {
        this.waitForElementPresent((By.xpath(SEARCH_INPUT_ELEMENT)), "Cannot find search skip button");
        this.waitForElementAndClick((By.xpath(SEARCH_INPUT_ELEMENT)), "Cannot find and click search skip button", 5);
    }

    public void waitForCancelToAppear()
    {
        this.waitForElementPresent(By.xpath(SEARCH_CANCEL_BUTTON), "Cannot find search button", 5);
    }

    public void waitForCancelToDisappear()
    {
        this.waitForElementNotPresent(By.xpath(SEARCH_CANCEL_BUTTON), "Search canceled button is still present", 5);
    }

    public void clickCancelSearch()
    {
        this.waitForElementAndClick((By.xpath(SEARCH_CANCEL_BUTTON)),"Cannot find and click search cancel button", 5);
    }

    public void typeSearchLine(String search_line)
    {
        this.waitForElementAndSendKeys(By.xpath(SEARCH_INPUT_ELEMENT), search_line, "Cannot find and type into search input", 5);
    }

    public void waitForSearchResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent((By.xpath(search_result_xpath)), "Cannot find search result with substring " + substring);
    }

    public void clickByArticleWithSubstring(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick((By.xpath(search_result_xpath)), "Cannot find and click search result with substring " + substring, 10);
    }

    public int getAmountOfFoundArticles()
    {
        this.waitForElementPresent(
                By.id(SEARCH_RESULT_ELEMENT),
                "Cannot find anything by the request ",
                15
        );
        return this.getAmountOfElements(By.id(SEARCH_RESULT_ELEMENT));
    }

    public void waitForEmptyResultsLabel()
    {
        this.waitForElementPresent(By.xpath(SEARCH_EMPTY_RESULT_ELEMENT), "Cannot find empty result label by the request ", 15);
    }

    public void waitForResultArticle()
    {
        this.testAssertElementPresent(By.id(SEARCH_RESULT));
    }

    public void assertThereIsNotResultOfSearch()
    {
        this.assertElementNotPresent((By.xpath(SEARCH_EMPTY_RESULT_ELEMENT)), "We supposed not to find any result");
    }
}
