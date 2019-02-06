package database;

import entities.Entity;
import entities.University;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseManagerImpl implements DatabaseManager<Entity> {
    private static EntityManagerFactory entityManagerFactory = null;

    public DatabaseManagerImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnitHibernateH2");
    }

    @Override
    public void mergeToDatabase(Entity entityToMerge) {

    }

    @Override
    public Entity getFromDatabase(Entity objectToGet) {
        EntityManager entityManager;
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try{objectToGet = entityManager.createQuery("FROM University", University.class).getResultList().get(0);}
        catch(IndexOutOfBoundsException e){
            System.out.println(e + "out of bounds");
        }
        entityManager.close();
        return objectToGet;
    }

    @Override
    public void persistToDatabase(Entity entityToPersist) {

    }
}
