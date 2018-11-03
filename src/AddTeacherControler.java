import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddTeacherControler extends ChildControler {
    @FXML
    private TextField teacherId;
    @FXML
    private TextField teacherName;
    @FXML
    private TextField teacherSurname;
    @FXML
    private Button btTeacherAdd;

    public AddTeacherControler(University university, ParentController superController, String fxmlFileName) {
        super(university, superController, fxmlFileName);
    }

    @FXML
    private void initialize() {
        btTeacherAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                university.addTeacher(Integer.parseInt(teacherId.getText()),
                        teacherName.getText(),
                        teacherSurname.getText());
                superController.updateTeacherListView();
                stage.close();
            }
        });
    }
}
