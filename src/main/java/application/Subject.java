package application;

import javafx.beans.property.SimpleStringProperty;

public class Subject {
    SimpleStringProperty subject;
    SimpleStringProperty dt;

    public Subject(String subject, String dt) {
        this.subject = new SimpleStringProperty(subject);
        this.dt = new SimpleStringProperty(dt);
    }
}
