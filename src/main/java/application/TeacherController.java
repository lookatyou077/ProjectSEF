package application;

import com.sun.xml.internal.fastinfoset.tools.FI_StAX_SAX_Or_XML_SAX_SAXEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class TeacherController {
    @FXML
    public TextField subjectField;
    @FXML
    public TextField DayAndTimeField;
    @FXML
    public TableView<Subject> TableVieww;
    @FXML
    public TableColumn<Subject,String> Sub;
    @FXML
    public TableColumn<Subject,String> DayTime;

    public void initTable()
    {
        Subject s=new Subject("subject1","dayt");
        Subject s2=new Subject("dummy","dummytime");
        ObservableList<Subject> list= FXCollections.observableArrayList();
        list.add(s);
        list.add(s2);
        TableVieww.setEditable(true);
        Sub.setCellValueFactory(new PropertyValueFactory<Subject,String>("Sub"));
        DayTime.setCellValueFactory(new PropertyValueFactory<Subject,String>("DayTime"));
        TableVieww.setItems(list);
    }
    public void init()
    {
        Subject s=new Subject("subject1","dayt");
        Subject s2=new Subject("dummy","dummytime");
        ObservableList<Subject> list= FXCollections.observableArrayList();
        list.add(s);
        list.add(s2);
        TableVieww.setEditable(true);
        Sub.setCellValueFactory(new PropertyValueFactory<Subject,String>("Sub"));
        DayTime.setCellValueFactory(new PropertyValueFactory<Subject,String>("DayTime"));
        TableVieww.setItems(list);
    }
    public void handleAddButtonAction() throws IOException {

        String subjects = subjectField.getText();
        String DT = DayAndTimeField.getText();

        Subject s=new Subject(subjects,DT);
        Subject s2=new Subject("dummy","dummytime");
        TableVieww.setEditable(true);
        Sub.setCellValueFactory(new PropertyValueFactory<Subject,String>("Sub"));
        DayTime.setCellValueFactory(new PropertyValueFactory<Subject,String>("DayTime"));
        ObservableList<Subject> list= FXCollections.observableArrayList();
        list.add(s);
        list.add(s2);
        TableVieww.setItems(list);


        //Person person = new Person("John", "Doe");
        //tab.getItems().add(person);
    }
}
