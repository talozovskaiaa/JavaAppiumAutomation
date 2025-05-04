package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import org.junit.Assert;
import org.junit.Test;

public class SearchTests extends CoreTestCase {

    @Test // Тест на поиск названия поисковой строки
    public void testSearch()
    {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initOndoardingInput();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
    }

    @Test // Тест по очистке введенного слова и возращения назад
    public void testCancelSearch()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initOndoardingInput();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForCancelToAppear();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelToDisappear();
    }


    @Test // Тест по добавлению Accert
    public void testAmountOfNotEmptySearch()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initOndoardingInput();
        SearchPageObject.initSearchInput();
        String search_line = "Linkin Park Diskography";
        SearchPageObject.typeSearchLine(search_line);
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();

        Assert.assertTrue(
                "We found too few results!",
                amount_of_search_results > 0
        );
    }

    @Test
    public void testAmountOfEmptySearch()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initOndoardingInput();
        SearchPageObject.initSearchInput();
        String search_line = "zxcvbnmddceh";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForEmptyResultsLabel();
        SearchPageObject.assertThereIsNotResultOfSearch();
    }

    // Ex3 (5 Тема)
    @Test
    public void testCancel_search()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initOndoardingInput();
        SearchPageObject.initSearchInput();
        String search_line = "Russia";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForSearchResult("Country spanning Europe and Asia");
        SearchPageObject.waitForSearchResult("East Slavic language");
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelToDisappear();

    }

    // Ex6 (5 Тема)
    @Test // Тест на проверку title
    public void testAssertElementPresent() {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initOndoardingInput();
        SearchPageObject.initSearchInput();
        String search_line = "Java";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        SearchPageObject.waitForResultArticle();


    }

}
