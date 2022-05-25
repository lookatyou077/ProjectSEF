package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

import static application.ReadJSONExample.obj2;
import static application.Database.readFileAsString;

public class RegisterController {

   // @FXML
    //public Text loginMessage;
    static int index=1;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    public PasswordField passwordFieldR;
    @FXML
    public TextField usernameFieldR;
    @FXML
    public CheckBox isTeacher;

    public String EncryptPassword(String password) {
        String encryptedPassword = "";
        for (int i = password.length() - 1 ; i >= 0 ; i--) {
            encryptedPassword = encryptedPassword + password.charAt(i);
        }
        return encryptedPassword;
    }

    @FXML
    public void handleRegisterButtonAction(ActionEvent event) throws Exception {
        String username = usernameFieldR.getText();
        String password = EncryptPassword(passwordFieldR.getText());
        String role = "";

        if (isTeacher.isSelected()) role = "Teacher";
        else role = "Student";

        String jsonFile="";
        int count =0 ;
        String file2 = "UserData.json";
        String json = readFileAsString(file2);
        JSONObject obj = new JSONObject(json);
        System.out.println(obj.toString());
        jsonFile=obj.toString();
        for (int i = 0; i < jsonFile.length(); i++) {
            if (jsonFile.charAt(i) == 'n') {
                count++;
            }
        }
        index=count;
        obj.put("UserName"+index, username);
        obj.put("Password"+index, password);
        obj.put("Role"+index, role);
        index++;

        try (FileWriter file = new FileWriter("UserData.json",false)) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(obj.toString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
        handleOnRegister(event);
    }

    public void handleOnRegister(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/login.fxml"));
        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
