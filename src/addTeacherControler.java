import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class addTeacherControler extends ChildControler {
    @FXML
    private TextField teacherId;
    @FXML
    private TextField teacherName;
    @FXML
    private TextField teacherSurname;
    @FXML
    private Button btTeacherAdd;

    public addTeacherControler(University university, ParentController superController, String fxmlFileName) {
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
                superController.updateListView();
                stage.close();
            }
        });
    }
}
