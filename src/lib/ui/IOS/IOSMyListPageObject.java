package lib.ui.IOS;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListPageObject;

public class IOSMyListPageObject extends MyListPageObject
{
    static
    {
        XPATHELEMENT = "xpath://XCUIElementTypeStaticText[contains(@name,'Diamond Rush')]";
        ARTICLE_BY_TITLE_TMP = "xpath://XCUIElementTypeStaticText[contains(@name,'{TITLE}')]";
    }

    public IOSMyListPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
