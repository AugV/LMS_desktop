package utilities;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListConverter {

    public <T> List<String> objectListToStringList(List<T> objectList) {
        List<String> stringList = new ArrayList<>();
        for (T obj :
                objectList) {
            stringList.add(obj.toString());
            System.out.println(obj);
        }
        return stringList;
    }


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
