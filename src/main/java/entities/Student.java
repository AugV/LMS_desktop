package entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Student extends Person {

    @ManyToOne
    private StudentsGroupImpl studentsGroupImpl;


    public Student(String loc_name, String loc_surname) {
        super(loc_name, loc_surname);
    }

    public Student() {
    }


    public StudentsGroupImpl getStudentsGroupImpl() {
        return studentsGroupImpl;
    }

    public void setStudentsGroupImpl(StudentsGroupImpl studentsGroupImpl) {
        this.studentsGroupImpl = studentsGroupImpl;
    }

    @Override
    public String toString() {
        return " Student{" +
                "ID: " + getId() +
                ", Name: " + getName() +
                ", Surname: " + getSurname() +
                '}';
    }

}
