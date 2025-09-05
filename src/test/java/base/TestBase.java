package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import utilities.ConfigReader;
import utilities.ReportManager;

import java.time.Duration;

public class TestBase {
    private static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<>();

   public WebDriver getDriver() {
    return tlDriver.get();
}
 @BeforeSuite
public void beforeSuite(){
     ReportManager.getInstance(); //initialize report
 }
 @BeforeMethod
@Parameters(value={"browser"})
public void setup(@Optional("chrome")String browser) {
     if (browser.equalsIgnoreCase("chrome")) {
         WebDriverManager.chromedriver().setup();
         ChromeOptions options = new ChromeOptions();
         options.addArguments("--Start-maximised");
         tlDriver.set(new ChromeDriver(options));
     } else {
         //future: add firefox, edge

         WebDriverManager.chromedriver().setup();
         tlDriver.set(new ChromeDriver());
     }
     getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigReader.getInt("implicit.wait")));
     getDriver().get(ConfigReader.get("base.url"));
 }
 @AfterMethod
    public void tearDown(){
       if(getDriver()!=null){
           getDriver().quit();
           tlDriver.remove();
       }
 }
 @AfterSuite
    public void afterSuite()
 {
     ReportManager.getInstance().flush();
 }
}

