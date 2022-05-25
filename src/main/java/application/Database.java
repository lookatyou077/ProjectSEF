package application;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;


public class Database {
    @SuppressWarnings("unchecked")
    public static String readFileAsString(String file)throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(file)));
    }

    public static void main( String[] args ) throws Exception {


        String file2 = "UserData.json";
        String json = readFileAsString(file2);
        JSONObject obj = new JSONObject(json);
        System.out.println(obj.toString());
        obj.put("UserName"+0, "admin");
        obj.put("Password"+0, "admin");
        //First Employee
        //JSONObject employeeDetails = new JSONObject();
        //employeeDetails.put("ID:",2);
       // employeeDetails.put("UserName"+2, "Vlad");
       // employeeDetails.put("Password"+2, "Vlad");


        //JSONArray employeeList = new JSONArray();
        //employeeList.put(employeeObject);

        //Add employees to list
        //JSONArray employeeList = JSONArray.createArrayBuilder();
        //JSONArray employeeList = new JSONArray();
        //employeeList.add(employeeObject);
        //employeeList.add(employeeObject2);

        //Write JSON file
        try (FileWriter file = new FileWriter("UserData.json",false)) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(obj.toString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
