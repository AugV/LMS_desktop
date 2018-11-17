package entities;

import java.util.ArrayList;
import java.util.List;

import utilities.DuplicateChecker;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Teacher extends Person {
    @OneToMany
    private List<Course> teacherCourses = new ArrayList();

    public Teacher(String loc_name, String loc_surname) {
        super(loc_name, loc_surname);
    }

    public Teacher() {
    }

    public List<Course> getTeacherCourses() {
        return teacherCourses;
    }

    public void addTeacherCourses(Course course) {
            teacherCourses.add(course);
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
