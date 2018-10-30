import java.io.Serializable;

abstract public class Person implements Indexable, Serializable {

    private int id;
    private String name;
    private String surname;

    public Person(int loc_id, String loc_name, String loc_surname) {
        this.id = loc_id;
        this.name = loc_name;
        this.surname = loc_surname;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
