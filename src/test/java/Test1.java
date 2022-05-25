import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.*;

import application.LoginController;

import javax.swing.*;
import java.io.IOException;

public class Test1 {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void handleOnRegister(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/register.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @BeforeClass
    public static void setUp() {

    }
    @AfterClass
    public static void finished() {

    }
//    @Test
////    public void testStageNotFullScreen(ActionEvent event) throws IOException {
////        handleOnRegister(event);
////        Assert.assertFalse(stage.isFullScreen());
////    }
//





}
