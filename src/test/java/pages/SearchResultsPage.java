package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
//clicking on first item
public class SearchResultsPage {
    private WebDriver driver;
    private By productResults=By.xpath("//div[@data-component-type='s-search-result']");

    public SearchResultsPage(WebDriver driver){
        this.driver=driver;
    }
    public void clickFirstNonSponsored()
    {
        List<WebElement> items=driver.findElements(productResults);
        if(items.isEmpty()) throw new RuntimeException("No search results found");
        //clicking on first item
        items.get(0);
        //WebElement item=items.get(0);
        //item.click();

    }
}
