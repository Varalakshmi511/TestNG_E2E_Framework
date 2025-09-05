package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop=new Properties();
    static
    {
        try{
            FileInputStream fis=new FileInputStream("src/main/resources/config.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties");
        }
    }
    public static String get(String key){
        return prop.getProperty(key);
    }
    public static int getInt(String key){
        return Integer.parseInt(prop.getProperty(key));
    }
}
