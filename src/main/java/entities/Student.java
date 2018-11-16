package entities;

public class Student extends Person {

    public Student(int loc_id, String loc_name, String loc_surname){
       super(loc_id, loc_name, loc_surname);

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
