package controllers;

import entities.Course;
import entities.University;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import static java.lang.Integer.parseInt;

public class AddCourseController extends ChildControler {
    @FXML
    private TextField id;
    @FXML
    private TextField name;
    @FXML
    private TextField teacherId;
    @FXML
    private TextField groupId;
    @FXML
    private TextArea information;
    @FXML
    private Button btAdd;

    public AddCourseController(University university, ParentController superController, String fxmlFileName) {
        super(university, superController, fxmlFileName);
    }

    @FXML
    private void initialize(){
        btAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Course course = new Course( name.getText(), information.getText());
                try {
                    university.getTeacherByID(parseInt(teacherId.getText())).addTeacherCourses(course);
                }catch (NullPointerException e) {
                    System.out.println(" !entities.Teacher with this ID does not exist!");
                }
                try{
                    university.getGroupByID(parseInt(groupId.getText())).addGroupCourse(course);
                }catch (NullPointerException e) {
                    System.out.println(" !entities.StudentsGroup with this ID does not exist!");
                }
                university.addCourse(course);
                superController.updateCourseListView();
                stage.close();
            }
        });

    }
}
