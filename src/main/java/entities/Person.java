package entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
abstract public class Person extends Entity implements Serializable {

    @Column
    private String surname;

    public Person( String loc_name, String loc_surname) {
        super(loc_name);
        this.surname = loc_surname;
    }

    public Person() {
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "entities.Person{" +
                "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
