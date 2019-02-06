package main;

import teacher_screen.ParentController;
import entities.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ElDienynas extends Application {
    private University university;
    private static final EntityManagerFactory entityManagerFactory;
    static{entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnitHibernateH2");}

    public void init() {
        getUniversityFromDB();

    }

    public void setUniversity( String universityName) {
        this.university = new University(universityName);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ParentController parentController = new ParentController(university, primaryStage);
        primaryStage.setScene(new Scene(parentController));
        primaryStage.show();
    }

    private void getUniversityFromDB() {
        EntityManager entityManager;
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try{university = entityManager.createQuery("FROM University ", University.class).getResultList().get(0);}
        catch(IndexOutOfBoundsException e){
            System.out.println(e + "out of bounds");
        }
        entityManager.close();
    }

    private void persistUniversityToDB() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(university);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void stop() {
       mergeUniversityToDB();
    }

    private void mergeUniversityToDB() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(university);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static void main(String[] args) {
        launch(args);

    }
}
