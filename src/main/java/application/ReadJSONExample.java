package application;

;
import org.json.JSONArray;
import org.json.JSONObject;


import java.nio.file.Files;
import java.nio.file.Paths;

import static application.Database.readFileAsString;

public class ReadJSONExample
{
    static String file3 = "UserData.json";
    static String json2;

    static {
        try {
            json2 = readFileAsString(file3);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static JSONObject obj2 = new JSONObject(json2);
    public static String readFileAsString(String file)throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(file)));
    }

    public static void main(String[] args) throws Exception {
        String file3 = "UserData.json";
        String json2 = readFileAsString(file3);
        JSONObject obj2 = new JSONObject(json2);

    }

}