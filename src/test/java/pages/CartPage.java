package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//clicking on proccedto buy option and cart items size
public class CartPage {
    private WebDriver driver;
    private By proceedToBuy=By.name("proceedToRetailCheckout");
    private By cartItems=By.cssSelector("div.sc-list-item");

    public CartPage(WebDriver driver){
        this.driver=driver;
    }
    public int getNumberOfItems(){
        try{
            return driver.findElements(cartItems).size();
        }catch(Exception e){
            return 0;
        }
    }
    public void proceedToCheckout(){
        driver.findElement(proceedToBuy).click();
    }
}
