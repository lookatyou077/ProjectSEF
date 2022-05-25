package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

public class TeacherController {
    @FXML
    public TextField subjectField;
    @FXML
    public TextField DayAndTimeField;
    @FXML
    public ListView ListVieww;
    public void handleAddButtonAction() {

        String subjects = subjectField.getText();
        String DT = DayAndTimeField.getText();

        Subject s=new Subject();
        s.subject=subjects;
        s.dt=DT;

        ListVieww.getItems().add("Item 1");
        ListVieww.getItems().add("Item 2");
        ListVieww.getItems().add("Item 3");
        ListVieww.refresh();
        //HBox hbox = new HBox(ListVieww);

        //Person person = new Person("John", "Doe");
        //tab.getItems().add(person);
    }
}
