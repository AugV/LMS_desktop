package entities;

public class StudentsGroupExcep extends Exception {
    public StudentsGroupExcep() {
        super("This is NULL object");
    }

    public StudentsGroupExcep(String message) {
        super(message);
    }
}
