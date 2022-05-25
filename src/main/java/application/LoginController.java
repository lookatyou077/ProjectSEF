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

import java.io.IOException;

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
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/TeacherFXML.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
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


//        for (int i = 0; i <= 10 || isLoginCorrect; i++) {
//            if (username.equals(obj2.get("UserName"+i).toString()) && password.equals(obj2.get("Password"+i).toString())) {
//                loginMessage.setText("Logged in as student!");
//                isLoginCorrect = true;
//            }
//        }


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
