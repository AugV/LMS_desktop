import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
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

    @FXML
    private void initialize() {
        teacherListView.getItems().addAll(university.getTeacherList());

        teacherListView.setCellFactory(lv -> {
            Cell cell = new Cell(teacherListView, this, university);
            cell.makeOptionDeleteFrom();
            return cell.getCell();
        });

        btAddTeacher.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                createNewController();
            }
        });
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
        addTeacherControler teacherWindow = new addTeacherControler(university, this);

    }

    public void updateListView() {
        teacherListView.setItems(new Utility().objectListToObservableList(university.getTeacherList()));
        System.out.println("TeacherList updated");
    }

}
