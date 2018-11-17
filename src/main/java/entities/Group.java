package entities;

import utilities.DuplicateChecker;

import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@javax.persistence.Entity
public class Group extends Entity implements Serializable {
    @OneToMany
    List<Student> groupStudents = new ArrayList();
    @ManyToMany
    List<Course> groupCourses = new ArrayList();

    //TODO change ArrayList<> to List<> in ALL THE PROJECT
    public Group() {
    }


    public void addGroupCourse(Course groupCourse) {
//        if (!new DuplicateChecker().isDuplicateById(groupCourse, groupCourses)) {
//            this.groupCourses.add(groupCourse);
//        } else {
//            System.out.println(" !entities.Course already exists!");
//        }
    }

    public Group(int id, String name) {
        super(name);
    }

    public List<Student> getGroupStudents() {
        return groupStudents;
    }

    public void addGroupStudents(Student student) {
            this.groupStudents.add(student);
    }

    public List<Course> getGroupCourses() {
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
