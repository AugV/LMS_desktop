package entities;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Entity {

    @Id
    private int id;

    @Column
    private String name;

    public Entity() {
    }

    Entity(int id, String name){
        this.id = id;
        this.name = name;
    }
    Entity(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    };

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
