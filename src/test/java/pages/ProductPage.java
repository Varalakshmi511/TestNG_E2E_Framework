package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;

import java.time.Duration;

//adding product to cart and getting cart count
public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By addToCartBtn=By.id("a-autoid-3-announce");
    private By noThanksBtn=By.id("attachSiNoCoverage");
    private By cartCount=By.id("nav-cart-count");

    public ProductPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getInt("implicit.wait")));
    }
    public void addToCart(){
        //switch tab if opened in new tab
        for(String handle : driver.getWindowHandles()){
            driver.switchTo().window(handle);
        }
        driver.findElement(addToCartBtn).click();
        try {
            WebElement noThanks = driver.findElement(noThanksBtn);
            if (noThanks.isDisplayed()) noThanks.click();
        } catch (Exception ignored) {}
    }

    public String getCartCount() {
        try {
            return driver.findElement(cartCount).getText();
        } catch (Exception e) {
            return "0";
        }

    }
}
