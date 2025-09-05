package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
//searching product and clicking on search
public class HomePage {
    private WebDriver driver;

    private By searchBox=By.id("twotabsearchtextbox");
    private By searchButton=By.id("nav-search-submit-button");

    public HomePage(WebDriver driver)
    {
        this.driver=driver;
    }
    public void searchProduct(String product){
       WebElement box=driver.findElement(searchBox);
       box.clear();
       box.sendKeys(product);
       box.sendKeys(Keys.ENTER);
    }
}
