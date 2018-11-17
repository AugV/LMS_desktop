package controllers;

import entities.Student;
import entities.University;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddStudentControler extends ChildControler {
    @FXML
    private TextField Id;
    @FXML
    private TextField name;
    @FXML
    private TextField surname;
    @FXML
    private Button btAdd;

    public AddStudentControler(University university, ParentController superController, String fxmlFileName) {
        super(university, superController, fxmlFileName);
    }

    @FXML
    private void initialize() {
        btAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                university.getSelectedStudentsGroup().addGroupStudents(new Student(
                        name.getText(),
                        surname.getText()));
                superController.updateStudentListView();
                stage.close();
            }
        });
    }
}
