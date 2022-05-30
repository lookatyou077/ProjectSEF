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

import java.io.IOException;

import static application.Database.readFileAsString;
import static application.ReadJSONExample.obj2;


public class LoginController {
    @FXML
    public Text loginMessage;
    @FXML
    public PasswordField passwordField;
    @FXML
    public TextField usernameField;
    @FXML
    public CheckBox isTeacher;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void handleOnSuccessfulLogin(ActionEvent event, boolean isTeacher) throws Exception {
        System.out.println("MERGE");
        if (isTeacher) {
            FXMLLoader loader =new FXMLLoader(getClass().getClassLoader().getResource("fxml/TeacherFXML.fxml"));
            Parent root = loader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            TeacherController controller = loader.getController();
            controller.init();
            stage.show();
        } else {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/StudentFXML.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void handleOnRegister(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/register.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public String EncryptPassword(String password) {
        String encryptedPassword = "";
        for (int i = password.length() - 1 ; i >= 0 ; i--) {
            encryptedPassword = encryptedPassword + password.charAt(i);
        }
        return encryptedPassword;
    }

    @FXML
    public void handleLoginButtonAction(ActionEvent event) throws Exception {
        String username = usernameField.getText();
        String password = EncryptPassword(passwordField.getText());
        boolean isLoginCorrect = false;
        boolean teacher = false;

        String jsonFileL="";
        int countL =0 ;
        String file2L = "UserData.json";
        String jsonL = readFileAsString(file2L);
        JSONObject obj = new JSONObject(jsonL);
        jsonFileL=obj.toString();
        for (int i = 1; i < jsonFileL.length()-2; i++) {
            if (jsonFileL.charAt(i-1) == ',' && jsonFileL.charAt(i) == '"' && jsonFileL.charAt(i+1) =='U' && jsonFileL.charAt(i+2) == 's') {
                countL++;
            }
        }
        System.out.println(countL);
        for (int i = 0; i <countL; i++) {
            if (username.equals(obj2.get("UserName"+i).toString()) && password.equals(obj2.get("Password"+i).toString())) {
                //loginMessage.setText("Logged in as student!");
                if(obj2.get("Role"+i).toString().equals("Teacher"))
                    teacher = true;
                isLoginCorrect = true;
            }
        }


        if (username.equals("arnold") && password.equals("321")) {
            isLoginCorrect = true;

        }
        if (username.equals("teacher") && password.equals("21") ) {
            isLoginCorrect = true;
            teacher = true;
        }


        if (isLoginCorrect) handleOnSuccessfulLogin(event, teacher);
    }
}
