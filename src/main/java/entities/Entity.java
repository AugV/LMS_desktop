package entities;

import javax.persistence.*;

@MappedSuperclass
public abstract class Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private int id;
    @Column
    private String name;

    public Entity() {
    }

    Entity(String name){
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
