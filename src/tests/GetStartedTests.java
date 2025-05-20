package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.WelcomPageObject;
import org.junit.Test;

import java.lang.foreign.PaddingLayout;

public class GetStartedTests extends CoreTestCase {

    @Test
    public void testPassThroughWelcome()
    {
        if (Platform.getInstance().isAndroid()) {
            return;
        }

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
