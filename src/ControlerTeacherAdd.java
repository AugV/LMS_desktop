import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ControlerTeacherAdd extends AnchorPane {
    University university;
    ControlerTeachersWindow superController;
    Stage stage;

    @FXML
    private TextField teacherId;
    @FXML
    private TextField teacherName;
    @FXML
    private TextField teacherSurname;
    @FXML
    private Button btTeacherAdd;

    public ControlerTeacherAdd(University university, ControlerTeachersWindow superController){
        this.superController = superController;
        this.university = university;
        setUpTheLoader();
        stage = new Stage();
        stage.setScene(new Scene(this, 450, 450));
        stage.show();
    }

    private void setUpTheLoader() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TeacherAddWindow.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void initialize() {
        btTeacherAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                university.addTeacher(  Integer.parseInt(teacherId.getText()),
                                        teacherName.getText(),
                                        teacherSurname.getText());
                superController.updateListView();
                stage.close();
            }

        });
    }
}
