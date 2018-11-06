package controllers;

import controllers.ChildControler;
import controllers.ParentController;
import entities.University;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import output.PrinterFile;

public class SaveTeachersController extends ChildControler {
    @FXML
    private Button btSave;
    @FXML
    private TextField fileNameText;

    public SaveTeachersController(University university, ParentController superController, String fxmlFileName) {
        super(university, superController, fxmlFileName);
    }

    @FXML
    private void initialize(){
        btSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                new PrinterFile(fileNameText.getText()).printObjectArrayToFile(university.getTeacherList());
                stage.close();
            }
        });
    }

}
