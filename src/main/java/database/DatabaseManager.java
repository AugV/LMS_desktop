package database;

import entities.Entity;

public interface DatabaseManager<T> {
    void mergeToDatabase(T objectToMerge);
    T getFromDatabase(T objectToget);
    void persistToDatabase(T objectToPersist);
}
