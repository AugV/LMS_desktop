package entities;

import javax.persistence.Entity;

@Entity
public class Student extends Person {

    public Student(String loc_name, String loc_surname){
       super(loc_name, loc_surname);

   }

    public Student() {
    }

    @Override
    public String toString() {
        return "entities.Student{" +
                "ID: " + getId() +
                ", Name: " + getName() +
                ", Surname: " + getSurname() +
                '}';
    }

}
