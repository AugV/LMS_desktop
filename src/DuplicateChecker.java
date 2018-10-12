import java.util.ArrayList;

public class DuplicateChecker {

    public <T extends Indexable> boolean idDublicateCheck(T objectToCheck, ArrayList<T> objectArray){
        for (T object :
                objectArray) {
            if (objectToCheck.getId() == object.getId()) {
                return true;
            }
        }
        return false;
    }
}
