package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultsPage;
import utilities.ReportManager;
import utilities.ScreenshotUtil;

public class AmazonCartTest extends TestBase {
   @Test
   public void addProductToCart() throws InterruptedException{
       HomePage home=new HomePage(getDriver());
       home.searchProduct("iphone 12");

       SearchResultsPage results=new SearchResultsPage(getDriver());
       results.clickFirstNonSponsored();

       ProductPage product=new ProductPage(getDriver());
       product.addToCart();

       Thread.sleep(2000);

       String cartCount=product.getCartCount();
       System.out.println("cart count"+cartCount);
       Assert.assertTrue(Integer.parseInt(cartCount)>0,"cart count is 0 after adding product");

       getDriver().get("https://www.amazon.in/gp/cart/view.html");
       CartPage cart=new CartPage(getDriver());
       Assert.assertTrue(cart.getNumberOfItems()>0,"No items in cart");
        if(cart.getNumberOfItems()==0){
            throw new RuntimeException("cart is empty-add items first");
        }
        cart.proceedToCheckout();

   }
   @AfterMethod
    public void tearDown(ITestResult result)
   {
       String screenshotPath= ScreenshotUtil.takeScreenshot(getDriver(),result.getName());

       if(result.getStatus()==ITestResult.FAILURE) {
           ReportManager.getInstance().createTest(result.getName()).fail("Test failed. screenshot attached").addScreenCaptureFromPath(screenshotPath);
       }
       else if(result.getStatus()==ITestResult.SUCCESS) {
           ReportManager.getInstance().createTest(result.getName()).pass("Test passed. screenshot attached").addScreenCaptureFromPath(screenshotPath);

       }
//       if(getDriver()!=null){
//           getDriver().quit();
//           tlDriver.remove();
//       }
   }
}
