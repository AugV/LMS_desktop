package entities;

import utilities.DuplicateChecker;

import java.io.Serializable;
import java.util.ArrayList;

public class Group implements Indexable, Serializable {
    private int groupID;
    private String name;

    ArrayList<Student> groupStudents = new ArrayList();
    ArrayList<Course> groupCourses = new ArrayList();


    public void addGroupCourse(Course groupCourse) {
        if (!new DuplicateChecker().isDuplicateById(groupCourse, groupCourses)) {
            this.groupCourses.add(groupCourse);
        } else {
            System.out.println(" !entities.Course already exists!");
        }
    }

    public Group(int id, String name) {
        this.groupID = id;
        this.name = name;
    }

    public int getId() {
        return groupID;
    }

    public ArrayList<Student> getGroupStudents() {
        return groupStudents;
    }

    public void addGroupStudents(Student student) {
        if (!new DuplicateChecker().isDuplicateById(student, groupStudents)) {
            this.groupStudents.add(student);
        } else {
            System.out.println(" !entities.Student already exists!");
        }
    }

    public ArrayList<Course> getGroupCourses() {
        return groupCourses;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "entities.Group{" +
                "groupID=" + groupID +
                ", name='" + name + '\'' +
                ", groupStudents=" + groupStudents +
                '}';
    }
}
