
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TabPane;

import java.io.IOException;


public class ControlerTeachersWindow extends TabPane {
    University university;

    @FXML
    private Button btAddTeacher;
    @FXML
    private Button btSave;
    @FXML
    private ListView teacherListView;


    public ControlerTeachersWindow(University university) {
        this.university = university;
        setUpTheLoader();
    }

    public void localInitialize(){
        teacherListView.setItems(new Utility().objectListToObservableList(university.getTeacherList()));

        btAddTeacher.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                createNewController();
            }});
    }

    @FXML
    private void initialize() {
        /*teacherListView.setItems(new Utility().objectListToObservableList(university.getTeacherList()));

        btAddTeacher.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                createNewController();
            }});*/
        }

    private void setUpTheLoader() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ApplicationInterface.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void createNewController() {
        ControlerTeacherAdd addWindowController = new ControlerTeacherAdd(university,this);
    }

    public void updateListView(){
        teacherListView.setItems(new Utility().objectListToObservableList(university.getTeacherList()));
        System.out.println("TeacherList updated");
    }

    }
