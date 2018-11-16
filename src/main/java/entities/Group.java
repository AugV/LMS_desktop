package entities;

import utilities.DuplicateChecker;

import java.io.Serializable;
import java.util.ArrayList;


public class Group extends Entity implements Serializable {

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
        super(id, name);
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


    @Override
    public String toString() {
        return "entities.Group{" +
                "groupID=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                ", groupStudents=" + groupStudents +
                '}';
    }
}
