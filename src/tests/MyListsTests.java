package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MyListPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class MyListsTests extends CoreTestCase {

    @Test // Создание папки сохраненных, добавление и удаление статьи
    public void testSaveFirstArticleToMyList()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initOndoardingInput();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        String article_title = ArticlePageObject.getArticleTitle();
        String name_of_folder = "New create list";

        ArticlePageObject.arcticleToMyList(name_of_folder);

        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.snackbarAction();

        MyListPageObject MyListPageObject = new MyListPageObject(driver);
        MyListPageObject.HasElement();
        MyListPageObject.swipeByArticleToDelete("Java (programming language)");
    }

    // Ex5 (Тема 5)
    @Test // Создание папки сохраненных, добавление и удаление статьи
    public void testSaveToArticleToMyList()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initOndoardingInput();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        String article_title = ArticlePageObject.getArticleTitle();
        String name_of_folder = "New create list";

        ArticlePageObject.arcticleToMyList(name_of_folder);

        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.backButton();

        SearchPageObject.clickByArticleWithSubstring("High-level programming language");

        ArticlePageObject.articleToExistingList(name_of_folder);

        NavigationUI.snackbarAction();

        MyListPageObject MyListPageObject = new MyListPageObject(driver);
        MyListPageObject.HasElement();
        MyListPageObject.swipeByArticleToDelete("Java (programming language)");

    }
}
