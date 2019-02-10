package student_screen;

import common.ViewControler;
import entities.Student;
import entities.StudentsGroup;
import entities.University;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import teacher_screen.ParentController;

public class AddStudentController extends ViewControler {
    @FXML
    private TextField name;
    @FXML
    private TextField surname;
    @FXML
    private Button btAdd;

    StudentsGroup studentsGroup;

    public AddStudentController(StudentsGroup clickedGroup, ParentController superController, String fxmlFileName) {
        super(superController, fxmlFileName);
        studentsGroup = clickedGroup;
    }

    @FXML
    private void initialize() {
        btAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                studentsGroup.addGroupStudents(new Student(
                        name.getText(),
                        surname.getText()));
                superController.updateStudentListView();
                stage.close();
            }
        });
    }
}
