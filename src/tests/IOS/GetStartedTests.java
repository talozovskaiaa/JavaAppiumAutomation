package tests.IOS;

import lib.IOSTestCase;
import lib.ui.WelcomPageObject;
import org.junit.Test;

public class GetStartedTests extends IOSTestCase {

    @Test
    public void testPassThroughWelcome()
    {
        WelcomPageObject WelcomPage = new WelcomPageObject(driver);

        WelcomPage.waitForLearnMoreLink();
        WelcomPage.clickNextButton();

        WelcomPage.waitForNewWayExploreText();
        WelcomPage.clickNextButton();

        WelcomPage.waitForAddOrEditPreferredLangText();
        WelcomPage.clickNextButton();

        WelcomPage.waitForLearnMoreAboutDataCollectedText();
        WelcomPage.clickGetStartedButton();

    }
}
