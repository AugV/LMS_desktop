package entities;

import java.util.ArrayList;
import utilities.DuplicateChecker;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Teacher extends Person {
    @OneToMany
    private ArrayList<Course> teacherCourses = new ArrayList();

    public Teacher(String loc_name, String loc_surname) {
        super(loc_name, loc_surname);
    }

    public Teacher() {
    }

    public ArrayList<Course> getTeacherCourses() {
        return teacherCourses;
    }

    public void addTeacherCourses(Course course) {
        if (!new DuplicateChecker().isDuplicateById(course, teacherCourses)) {
            teacherCourses.add(course);
        } else {
            System.out.println(" !entities.Student already exists!");
        }
    }


    @Override
    public String toString() {
        return "ID: " + this.getId() +
                ", Name: " + this.getName() +
                ", Surname: " + this.getSurname() +
                " entities.Teacher{" +
                " teacherCourses= " + teacherCourses +
                '}';
    }
}
