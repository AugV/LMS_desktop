
import javafx.beans.binding.Bindings;
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

        teacherListView.setCellFactory(lv->{
            ListCell<Teacher> cell = new ListCell<>();
            ContextMenu contextMenu = new ContextMenu();

            MenuItem deleteItem = new MenuItem();

            deleteItem.textProperty().bind(Bindings.format("Delete"));
            deleteItem.setOnAction(event -> teacherListView.getItems().remove(cell.getItem()));
            contextMenu.getItems().addAll(deleteItem);

            cell.textProperty().bind(cell.itemProperty().asString());
            cell.emptyProperty().addListener((obs, wasEmpty, isNowEmpty) -> {
                if (isNowEmpty) {
                    cell.setContextMenu(null);
                } else {
                    cell.setContextMenu(contextMenu);
                }
            });
            return cell ;

        });


        btAddTeacher.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                createNewController();
            }});
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
