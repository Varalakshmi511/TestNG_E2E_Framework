package tests;

import base.TestBase;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultsPage;
import utilities.ScreenshotUtil;

import java.util.Locale;

public class AmazonSearchTest extends TestBase {
    @Test
            public void searchAndOpenProduct() {
        HomePage home = new HomePage(getDriver());
        home.searchProduct("iphone 14");

        SearchResultsPage results = new SearchResultsPage(getDriver());
        results.clickFirstNonSponsored();

        //screenshot for proof
        String path = ScreenshotUtil.takeScreenshot(getDriver(), "product_opened");
        System.out.println("screenshot saved:" + path);

        //Assert.assertTrue(getDriver().getTitle().toLowerCase().contains("iphone") || getDriver().getTitle().toLowerCase().contains("iphone 14"), "page title does not contain product name");

    }

}
