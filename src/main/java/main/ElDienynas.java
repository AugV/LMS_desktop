package main;

import controllers.ParentController;
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
       // setUniversity("VGTU");
        //entityInstantiation();
        //persistUniversityToDB();
        //university= null;
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
        try{university = entityManager.createQuery("FROM University ", University.class).getResultList().get(1);}
        catch(IndexOutOfBoundsException e){
            System.out.println("out of bouds");
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

    private void entityInstantiation() {
        university.addTeacher("Tadas", "jablinksis");
        university.addTeacher("Laimonas", "Stanislovsksi");

        university.addGroup("GRUPE1");
        university.addGroup("GRUPE2");

        university.getStudentsGroupList().get(0).addGroupStudents(new entities.Student("Petras", "Studentauskas"));
        university.getStudentsGroupList().get(1).addGroupStudents(new entities.Student("Studenis", "Studavicius"));

        university.addCourse(new entities.Course(
                "matematika", "Matematikos kursas", university.getTeacherList().get(0), university.getStudentsGroupList().get(0)));
        university.addCourse(new entities.Course(
                "darbaiXD", "Darbuko salalai", university.getTeacherList().get(1), university.getStudentsGroupList().get(1)));
        university.addCourse(new entities.Course(
                "darkoks velnias", "dar vienas niekam nereikalingas kursas", university.getTeacherList().get(1), university.getStudentsGroupList().get(1)));

        entities.Task task1 = new entities.Task("primasTaskas", "ejozaselse per ezereli", "08-09", "5" );
        university.getCourseList().get(0).addCourseTask(task1);

        entities.Task task2 = new entities.Task("antrasTaskas", "ezerelis ejo per zaselse", "12-12", "1");
        university.getCourseList().get(1).addCourseTask(task2);

        university.getCourseList().get(0).getCourseTasks().get(0).addTaskCompletedTask(new entities.CompletedTask(
                 "teisingas atsakymas, kolegos"));
        university.getCourseList().get(1).getCourseTasks().get(0).addTaskCompletedTask(new entities.CompletedTask(
                 "neteisingas atsakymas, biciuli"));
    }

    public void stop() {
        mergeUniversityToDB();
        //new SerializeDeserialize().serialize(university, "universityObject.ser");
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
