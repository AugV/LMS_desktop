package course_screen;

import common.ViewControler;
import entities.Course;
import entities.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import teacher_screen.ParentController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddTaskController extends ViewControler {

    @FXML
    private TextField taskName;
    @FXML
    private TextField taskCondition;
    @FXML
    private TextField taskPoints;
    @FXML
    private DatePicker taskDeadline;
    @FXML
    private CheckBox taskAllowSubmit;
    @FXML
    private Button btTaskAdd;

    private Course course;

    public AddTaskController(Course clickedCourse, ParentController superController, String fxmlFileName) {
        super(superController, fxmlFileName);
        course = clickedCourse;
        System.out.println(course.getName());

        taskDeadline.setConverter(new StringConverter<LocalDate>() {
            String pattern = "yyyy-MM-dd";
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);
            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        });
    }

    @FXML
    private void initialize() {
        btTaskAdd.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println(course.getName());
                course.addCourseTask(new Task(
                        taskName.getText(),
                        taskCondition.getText(),
                        taskDeadline.getValue().toString(),
                        taskPoints.getText(),
                        taskAllowSubmit.isSelected()
                ));
                superController.updateTaskListView();
                stage.close();
            }
        });
    }
}
