package course_screen;

import common.ViewControler;
import entities.StudentsGroup;
import entities.Teacher;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;
import teacher_screen.ParentController;
import entities.Course;
import entities.University;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import static java.lang.Integer.parseInt;

public class AddCourseController extends ViewControler {

    @FXML
    private TextField name;
    @FXML
    private ComboBox teacherBox;
    @FXML
    private ComboBox groupBox;
    @FXML
    private TextArea information;
    @FXML
    private Button btAdd;

    private Teacher selectedTeacher;
    private StudentsGroup selectedGroup;

    public AddCourseController(University university, ParentController superController, String fxmlFileName) {
        super(university, superController, fxmlFileName);
    }

    @FXML
    private void initialize(){
        initializeTeacherBox(university);

        initializeGroupBox(university);

        btAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Course course = new Course( name.getText(), information.getText());
                try {
                    selectedTeacher.addTeacherCourses(course);
                }catch (NullPointerException e) {
                    System.out.println(" !Teacher does not exist!");
                }
                try{
                    selectedGroup.addGroupCourse(course);
                }catch (NullPointerException e) {
                    System.out.println(" !StudentsGroup does not exist!");
                }
                university.addCourse(course);
                superController.updateCourseListView();
                stage.close();
            }
        });

    }

    private void initializeGroupBox(University university) {
        groupBox.getItems().addAll(university.getStudentsGroupList());
        groupBox.valueProperty().addListener(
                (observable, oldValue, newValue) -> selectedGroup = (StudentsGroup) newValue);
    }

    private void initializeTeacherBox(University university) {
        teacherBox.getItems().addAll(university.getTeacherList());
        teacherBox.valueProperty().addListener(
                (observable, oldValue, newValue) -> selectedTeacher = (Teacher) newValue);
    }

}
