package entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class Student extends Person {

    @ManyToOne
    private Group studentsGroup;


    public Student(int loc_id, String loc_name, String loc_surname) {
        super(loc_id, loc_name, loc_surname);
    }

    public Student() {
    }


    public Group getStudentsGroup() {
        return studentsGroup;
    }

    public void setStudentsGroup(Group studentsGroup) {
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
