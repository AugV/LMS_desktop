import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

abstract class ChildControler extends AnchorPane {
    University university;
    ParentController superController;
    Stage stage;
    String fxmlFileName;

    public ChildControler(University university, ParentController superController, String fxmlFileName){
        this.superController = superController;
        this.university = university;
        this.fxmlFileName = fxmlFileName;
        setUpTheLoader();
        setUpStage();
    }

    private void setUpStage() {
        stage = new Stage();
        stage.setScene(new Scene(this));
        stage.show();
    }

    private void setUpTheLoader() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
        loader.setController(this);
        loader.setRoot(this);
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
