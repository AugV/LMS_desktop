import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Utility {

    public <T> ArrayList<String> objectListToStringList(ArrayList<T> objectList) {
        ArrayList<String> stringList = new ArrayList<>();
        for (T obj :
                objectList) {
            stringList.add(obj.toString());
            System.out.println(obj);
        }
        return stringList;
    }


    public <T> ObservableList<T> objectListToObservableList(ArrayList<T> objectList) {
        ObservableList<T> observableList = FXCollections.observableArrayList();
        for (T obj :
                objectList) {
            observableList.add(obj);
        }
        return observableList;
    }

}
