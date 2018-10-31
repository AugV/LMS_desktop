import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.paint.Paint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControlerForFXML extends TabPane  {

    University university;

    public void setUniversity(University university) {
        System.out.println("ayeee");
        this.university = university;
    }

    @FXML
    private Button button;

    @FXML
    private ListView teacherListView;


    public ControlerForFXML(University university) {
        this.university = university;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ApplicationInterface.fxml"));
        loader.setController(this);
        System.out.println("GOOOO");
       loader.setRoot(this);
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void initialize(){
        teacherListView.setItems(new Utility().objectListToObservableList(university.getTeacherList()));



    }
}
