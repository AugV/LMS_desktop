package controllers;

import entities.University;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import static java.lang.Integer.parseInt;

public class AddGroupController extends ChildControler {
    @FXML
    private TextField id;
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
                university.addGroup(Integer.parseInt(id.getText()), name.getText());
                superController.updateGroupListView();
                stage.close();
            }
        });

    }
}
