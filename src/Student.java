import java.util.ArrayList;

public class Student extends Person {

    public Student(int loc_id, String loc_name, String loc_surname){
       super(loc_id, loc_name, loc_surname);

   }

    @Override
    public String toString() {
        return "Student{" +
                "ID: " + getId() +
                ", Name: " + getName() +
                ", Surname: " + getSurname() +
                '}';
    }

}
