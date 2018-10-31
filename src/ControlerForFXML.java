
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TabPane;

import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;


public class ControlerForFXML extends TabPane {
    University university;

    @FXML
    private Button btAddTeacher;
    @FXML
    private Button btSave;

    @FXML
    private ListView teacherListView;


    public ControlerForFXML(University university) {
        this.university = university;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ApplicationInterface.fxml"));
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
        teacherListView.setItems(new Utility().objectListToObservableList(university.getTeacherList()));

        btAddTeacher.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                TeacherAddWindowController addWindowController = new TeacherAddWindowController(university);
                Stage stage = new Stage();
                stage.setScene(new Scene(addWindowController, 450, 450));
                stage.show();
            }});
        }

    }
