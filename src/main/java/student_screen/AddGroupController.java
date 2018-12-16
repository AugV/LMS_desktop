package student_screen;

import common.ViewControler;
import entities.University;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import teacher_screen.ParentController;


public class AddGroupController extends ViewControler {
    @FXML
    private TextField name;
    @FXML
    private Button btAdd;

    public AddGroupController(University university, ParentController superController, String fxmlFileName) {
        super(university, superController, fxmlFileName);
    }

    @FXML
    private void initialize(){
        btAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                university.addGroup(name.getText());
                superController.updateGroupListView();
                stage.close();
            }
        });

    }
}
