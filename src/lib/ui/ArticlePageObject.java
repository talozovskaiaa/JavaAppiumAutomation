package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject
{
    private static final String
            TITLE = "org.wikipedia:id/page_contents_container",
            FOOTER_ELEMENT = "//android.view.View[@content-desc='View article in browser']",
            SAVE_BUTTON = "//*[contains(@text,'Save')]",
            ADD_TO_LIST = "//*[contains(@text,'Add to list')]",
            MY_LIST_NAME_INPUT = "//*[contains(@text,'Name of this list')]",
            MY_LIST_OK_BUTTON = "//*[contains(@text,'OK')]",
            MY_EXISTING_LIST= "//*[contains(@text,'{LIST_NAME}')]";


    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    /* TEMPLATES METHODS */
    public static String getExistingListElement(String substring)
    {
        return MY_EXISTING_LIST.replace("{LIST_NAME}", substring);
    }
    /* TEMPLATES METHODS */

    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(By.id(TITLE), "Cannot find article on page", 15);
    }

    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }

    public void swipeToFooter()
    {
        this.swipeUpToFindElement(
                By.xpath(FOOTER_ELEMENT),
                "Cannot find the end of article",
                20

        );
    }

    public void arcticleToMyList(String name_of_folder)
    {
        this.waitForElementAndClick(
                By.xpath(SAVE_BUTTON),
                "Cannot find Save",
                5
        );

        this.waitForElementAndClick(
                By.xpath(ADD_TO_LIST),
                "Cannot find Add to list",
                5
        );

        this.waitForElementAndSendKeys(
                By.xpath(MY_LIST_NAME_INPUT),
                name_of_folder,
                "Cannot put text into article folder input",
                5
        );

        this.waitForElementAndClick(
                By.xpath(MY_LIST_OK_BUTTON),
                "Cannot press OK button",
                5
        );
    }

    public void articleToExistingList(String name_of_folder)
    {
        this.waitForElementAndClick(
                By.xpath(SAVE_BUTTON),
                "Cannot find Save",
                5
        );

        this.waitForElementAndClick(
                By.xpath(ADD_TO_LIST),
                "Cannot find Add to list",
                5
        );

        String existing_list = getExistingListElement(name_of_folder);
        this.waitForElementAndClick(
                By.xpath(existing_list),
                "Cannot find 'New create list'",
                5
        );
    }
}
