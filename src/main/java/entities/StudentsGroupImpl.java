package entities;


import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@javax.persistence.Entity
@Table
public class StudentsGroupImpl extends Entity implements Serializable, StudentsGroup {

    @OneToMany(cascade= CascadeType.ALL, fetch = FetchType.LAZY)
    List<Student> groupStudents = new ArrayList();
    @OneToMany(cascade= CascadeType.MERGE, fetch = FetchType.EAGER)
    List<Course> groupCourses = new ArrayList();

    public StudentsGroupImpl() {
    }

    public StudentsGroupImpl(String name) {
        super(name);
    }

    @Override
    public void addGroupCourse(Course groupCourse)  {
            this.groupCourses.add(groupCourse);
    }

    @Override
    public List<Student> getGroupStudents() {
        return groupStudents;
    }

    @Override
    public void addGroupStudents(Student student) {
        student.setStudentsGroupImpl(this);
        this.groupStudents.add(student);
    }

    @Override
    public List<Course> getGroupCourses() {
        return groupCourses;
    }

    @Override
    public String toString() {
        return "groupID=" + this.getId() +
                ", name='" + this.getName();
    }
}
