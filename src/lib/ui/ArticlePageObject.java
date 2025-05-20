package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.WebElement;

import static tests.MyListsTests.name_of_folder;

abstract public class ArticlePageObject extends MainPageObject
{
    protected static String
            TITLE,
            FOOTER_ELEMENT,
            SAVE_BUTTON,
            ADD_TO_LIST,
            ADD_NEW_LIST,
            MY_LIST_NAME_INPUT,
            MY_LIST_OK_BUTTON,
            MY_EXISTING_LIST,
            CLOSE,
            LATER;


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
        if (Platform.getInstance().isAndroid()) {
            return title_element.getAttribute("text");
        } else {
            return title_element.getAttribute("name");
        }
    }

    public void swipeToFooter()
    {
        if (Platform.getInstance().isAndroid()) {
            this.swipeUpToFindElement(
                    FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    40
            );
        } else {
            this.swipeUpTillElementAppear(FOOTER_ELEMENT,
                "Cannot find the end of article",
                40
            );
        }
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

    public void addArticleToNySaved(String name_of_folder)
    {
        this.waitForElementAndClick(
                SAVE_BUTTON,
                "Cannot find Save",
                5
        );

        this.waitForElementAndClick(
                ADD_TO_LIST,
                "Cannot find option to add article to reading list",
                5
        );

        this.waitForElementAndClick(
                ADD_NEW_LIST,
                "Cannot find button 'Add new list'",
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
                "Cannot find 'OK' button",
                5
        );

//        this.waitForElementAndClick(
//                LATER,
//                "Cannot find Later button",
//                5
//        );
    }
}
