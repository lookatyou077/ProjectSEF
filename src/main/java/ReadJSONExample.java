import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import jdk.nashorn.api.scripting.ScriptUtils;
import jdk.nashorn.internal.ir.debug.JSONWriter;
import jdk.nashorn.internal.parser.Parser;
import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

import static application.Database.readFileAsString;
public class ReadJSONExample {
    static String file3 = "employees.json";
    static String json2;

    static {
        try {
            json2 = readFileAsString(file3);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static JSONObject obj2 = new JSONObject(json2);

    // public static String readFileAsString(String file)throws Exception
    //  {
    //     return new String(Files.readAllBytes(Paths.get(file)));
    // }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        String file3 = "employees.json";
        String json2 = readFileAsString(file3);
        JSONObject obj2 = new JSONObject(json2);

        //JSONArray arr = obj2.getJSONArray("Student");


    }
}
