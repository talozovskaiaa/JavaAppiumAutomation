package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject
{
    private static final String
            TITLE = "id:org.wikipedia:id/page_contents_container",
            FOOTER_ELEMENT = "xpath://android.view.View[@content-desc='View article in browser']",
            SAVE_BUTTON = "xpath://*[contains(@text,'Save')]",
            ADD_TO_LIST = "xpath://*[contains(@text,'Add to list')]",
            MY_LIST_NAME_INPUT = "xpath://*[contains(@text,'Name of this list')]",
            MY_LIST_OK_BUTTON = "xpath://*[contains(@text,'OK')]",
            MY_EXISTING_LIST= "xpath://*[contains(@text,'{LIST_NAME}')]";


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
        return this.waitForElementPresent(TITLE, "Cannot find article on page", 15);
    }

    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }

    public void swipeToFooter()
    {
        this.swipeUpToFindElement(
                FOOTER_ELEMENT,
                "Cannot find the end of article",
                20

        );
    }

    public void arcticleToMyList(String name_of_folder)
    {
        this.waitForElementAndClick(
                SAVE_BUTTON,
                "Cannot find Save",
                5
        );

        this.waitForElementAndClick(
                ADD_TO_LIST,
                "Cannot find Add to list",
                5
        );

        this.waitForElementAndSendKeys(
                MY_LIST_NAME_INPUT,
                name_of_folder,
                "Cannot put text into article folder input",
                5
        );

        this.waitForElementAndClick(
                MY_LIST_OK_BUTTON,
                "Cannot press OK button",
                5
        );
    }

    public void articleToExistingList(String name_of_folder)
    {
        this.waitForElementAndClick(
                SAVE_BUTTON,
                "Cannot find Save",
                5
        );

        this.waitForElementAndClick(
                ADD_TO_LIST,
                "Cannot find Add to list",
                5
        );

        String existing_list = getExistingListElement(name_of_folder);
        this.waitForElementAndClick(
                existing_list,
                "Cannot find 'New create list'",
                5
        );
    }
}
