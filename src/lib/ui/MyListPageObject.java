package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MyListPageObject extends MainPageObject {

    public static final String
            XPATHELEMENT = "//*[contains(@text,'Object-oriented programming language')]",
            ARTICLE_BY_TITLE_TMP = "//*[contains(@text,'{TITLE}')]";

    /* TEMPLATES METHODS */
    private static String getSaveArticleXpathByArticle(String article_title) {
        String escapedTitle = article_title.replace("'", "\\'"); // Экранирование одинарных кавычек
        return ARTICLE_BY_TITLE_TMP.replace("{TITLE}", escapedTitle);
    }
    /* TEMPLATES METHODS */

    public MyListPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void HasElement()
    {
        this.waitForElementPresent(
                By.xpath(XPATHELEMENT),
                "Cannot find element",
                15
        );
    }

    public void waitForArticleToAppearByTitle(String article_title)
    {
        String article_xpath = getSaveArticleXpathByArticle(article_title);
        this.waitForElementPresent(
                By.xpath(article_xpath),
                "Cannot find article by title" + article_title,
                15
        );
    }

    public void waitForArticleToDisappearByTitle(String article_title)
    {
        String article_xpath = getSaveArticleXpathByArticle(article_title);
        this.waitForElementNotPresent(
                By.xpath(article_xpath),
                "Saved article still" + article_title,
                15
        );
    }

    public void swipeByArticleToDelete(String article_title) {
        if (article_title == null || article_title.isEmpty()) {
            throw new IllegalArgumentException("Article title cannot be null or empty");
        }

        String article_xpath = getSaveArticleXpathByArticle(article_title);
        System.out.println("Generated XPath: " + article_xpath);

        this.waitForArticleToAppearByTitle(article_title); // Передаем текст, а не XPath
        this.swipeElementToLeft(By.xpath(article_xpath), "Cannot swipe up");
        this.waitForArticleToDisappearByTitle(article_title);
    }
}
