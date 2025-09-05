package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class ScreenshotUtil {
    public static String takeScreenshot(WebDriver driver, String name){
      try{
          String folder=ConfigReader.get("screenshots.path");

          if(!folder.endsWith("/") && !folder.endsWith("\\"))
          {
              folder=folder+File.separator;
          }
          Files.createDirectories(Path.of(folder));
          String path=folder+name+"_"+System.currentTimeMillis()+".png";
          File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
          Files.copy(src.toPath(),Path.of(path));
          return path;
      } catch (Exception e) {
          e.printStackTrace();
          return null;
      }
    }
}
