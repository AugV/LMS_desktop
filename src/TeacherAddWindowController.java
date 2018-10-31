import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class TeacherAddWindowController extends AnchorPane {
    University university;


    @FXML
    private TextField teacherId;
    @FXML
    private TextField teacherName;
    @FXML
    private TextField teacherSurname;
    @FXML
    private Button btTeacherAdd;

    public TeacherAddWindowController(University university){
        this.university = university;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TeacherAddWindow.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //root = FXMLLoader.load(getClass().getResource("TeacherAddWindow.fxml"));
    }

    public void initialize() {
        btTeacherAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                university.addTeacher(Integer.parseInt(teacherId.getText()), teacherName.getText(), teacherSurname.getText());
            }

        });
    }
}
