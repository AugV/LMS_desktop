package entities;


import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@javax.persistence.Entity
public class Group extends Entity implements Serializable {

    @OneToMany
    List<Student> groupStudents = new ArrayList();
    @OneToMany
    List<Course> groupCourses = new ArrayList();

    public Group() {
    }

    public void addGroupCourse(Course groupCourse) {
            this.groupCourses.add(groupCourse);
    }

    public Group(int id, String name) {
        super(id, name);
    }

    public List<Student> getGroupStudents() {
        return groupStudents;
    }

    public void addGroupStudents(Student student) {
        student.setStudentsGroup(this);
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
