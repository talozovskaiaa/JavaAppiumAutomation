package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class MyListsTests extends CoreTestCase
{
    public static final String name_of_folder = "New create list";

    @Test // Создание папки сохраненных, добавление и удаление статьи
    public void testSaveFirstArticleToMyList()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java Rush");
        SearchPageObject.clickByArticleWithSubstring("Компьютерная игра 2006 года"); // Object-oriented programming language

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        String article_title = ArticlePageObject.getArticleTitle();

        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.arcticleToMyList(name_of_folder);

            NavigationUI NavigationUI = NavigationUIFactory.get(driver);
            NavigationUI.snackbarAction();
        } else {
            ArticlePageObject.addArticleToNySaved(name_of_folder);
        }

        MyListPageObject MyListPageObject = MyListPageObjectFactory.get(driver);
        MyListPageObject.HasElement();
        MyListPageObject.swipeByArticleToDelete("Diamond Rush"); // Java (programming language)
    }

    // Ex5 (Тема 5) (Тема 7)
    @Test // Создание папки сохраненных, добавление и удаление статьи
    public void testSaveToArticleToMyListAndDeleteOne()
    {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);

        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java Rush"); // Java
        searchPageObject.clickByArticleWithSubstring("Компьютерная игра 2006 года"); // Object-oriented programming language

        ArticlePageObject articlePage = ArticlePageObjectFactory.get(driver);
        String firstArticleTitle = articlePage.getArticleTitle();

        if (Platform.getInstance().isAndroid()) {

            articlePage.arcticleToMyList(name_of_folder);
        } else {

            articlePage.addArticleToNySaved(name_of_folder);
        }
        NavigationUI navigationUI = NavigationUIFactory.get(driver);
        navigationUI.backButton(); // нажать "Назад"

        searchPageObject.clickByArticleWithSubstring("Фреймворк"); // выбрать др статью

        articlePage.articleToExistingList(name_of_folder);

        navigationUI.snackbarAction();

        MyListPageObject myListPageObject = MyListPageObjectFactory.get(driver);
        myListPageObject.HasElement();

        if (Platform.getInstance().isAndroid()) {

            myListPageObject.swipeByArticleToDelete("Фреймворк");
        } else {
            myListPageObject.swipeByArticleToDeleteForIOS("Фреймворк");
            myListPageObject.hasFootersTextByArticle();
        }
    }
}
