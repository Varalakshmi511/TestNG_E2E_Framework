package utilities;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class JsonUtils {
    public static JSONObject readJson(String path){
        try{
            JSONParser parser=new JSONParser();
            Object obj=parser.parse(new FileReader(path));
            return (JSONObject) obj;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
