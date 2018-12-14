package entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Student extends Person {

    @ManyToOne
    private StudentsGroup studentsGroup;


    public Student(String loc_name, String loc_surname) {
        super(loc_name, loc_surname);
    }

    public Student() {
    }


    public StudentsGroup getStudentsGroup() {
        return studentsGroup;
    }

    public void setStudentsGroup(StudentsGroup studentsGroup) {
        this.studentsGroup = studentsGroup;
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
