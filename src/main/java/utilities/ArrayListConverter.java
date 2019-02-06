package utilities;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListConverter {


    public <T> ObservableList<T> objectListToObservableList(List<T> objectList) {
        ObservableList<T> observableList = FXCollections.observableArrayList();
        try{
        for (T obj :
                objectList) {
            observableList.add(obj);
        }
        return observableList;}
        catch (NullPointerException e){
            throw  new NullPointerException();
        }
    }

}
