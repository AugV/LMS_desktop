package database;

import entities.Entity;
import entities.University;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseManagerImpl implements DatabaseManager<Entity> {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnitHibernateH2");
    private EntityManager entityManager;

    public DatabaseManagerImpl() {
    }

    @Override
    public void mergeToDatabase(Entity entityToMerge) {
        startTransaction();
        entityManager.merge(entityToMerge);
        commitTransaction();
        closeTransaction();
    }

    @Override
    public Entity getFromDatabase(Entity objectToGet) {
        startTransaction();
        objectToGet = queryObject(objectToGet);
        closeTransaction();
        return objectToGet;
    }

    private Entity queryObject(Entity objectToGet) {
        try{
            objectToGet = entityManager.createQuery("FROM University", University.class).getResultList().get(0);}
        catch(IndexOutOfBoundsException e){
            System.out.println(e + "Could not find in Database");
        }
        return objectToGet;
    }

    @Override
    public void persistToDatabase(Entity entityToPersist) {
        startTransaction();
        entityManager.persist(entityToPersist);
        commitTransaction();
        closeTransaction();
    }

    private void startTransaction() {
         this.entityManager = entityManagerFactory.createEntityManager();
         this.entityManager.getTransaction().begin();
    }

    private void commitTransaction() {
        entityManager.getTransaction().commit();
    }

    private void closeTransaction() {
        entityManager.close();
    }

}
