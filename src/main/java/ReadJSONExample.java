//package loose.oose.fis.lab.student.manager.controllers;

//import static loose.oose.fis.lab.student.manager.model.Database.readFileAsString;

public class ReadJSONExample
{
    static String file3 = "employees.json";
    static String json2;

    static {
        try {
            json2 = readFileAsString(file3);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String readFileAsString(String file3) {
        return file3;
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