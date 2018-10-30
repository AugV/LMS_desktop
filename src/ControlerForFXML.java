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

public class ControlerForFXML extends TabPane  {

    University university;

    public void setUniversity(University university) {
        this.university = university;
    }

    @FXML
    private Button button;

    @FXML
    private ListView teacherListView;


    public ControlerForFXML() {
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
        System.out.println("noway");
        ObservableList<String> items = FXCollections.observableArrayList (
                new Printer().printObjectArray(university.getTeacherList()));
        teacherListView.setItems(items);
        //TODO sukisti lista i listviewa

    }
}
