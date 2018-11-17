package main;

import controllers.ParentController;
import entities.Teacher;
import entities.University;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utilities.SerializeDeserialize;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ElDienynas extends Application {
    private University university;


    public void init() {
       //university = new SerializeDeserialize().deserialize("universityObject.ser");
    }


    public void setUniversity( String universityName) {
        this.university = new University(universityName);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        setUniversity("VGTU");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnitHibernateH2");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(new Teacher("Mokytahanas", "Dvejerasys"));
        entityManager.persist(new Teacher("Tampys", "Uzausa"));
        entityManager.persist(new Teacher("Letena", "Skrebys"));
        entityManager.getTransaction().commit();
        entityManager.close();

        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        String text = entityManager.createQuery("from Teacher", Teacher.class).getResultList().get(0).getName();
        System.out.println("SOMETHING:   "+text);
        entityManager.close();

        //TODO uncomment XD
//        ParentController parentController = new ParentController(university, primaryStage);
//        primaryStage.setScene(new Scene(parentController));
//        primaryStage.show();
//region

/*
        university.addTeacher(1,"Tadas", "jablinksis");
        university.addTeacher(2,"Laimonas", "Stanislovsksi");

        university.addGroup(1,"GRUPE1");
        university.addGroup(2,"GRUPE2");

        university.getGroupByID(1).addGroupStudents(new entities.Student(1, "Petras", "Studentauskas"));
        university.getGroupByID(2).addGroupStudents(new entities.Student(2, "Studenis", "Studavicius"));

        university.addCourse(new entities.Course(
                1,"matematika", "Matematikos kursas", university.getTeacherByID(1), university.getGroupByID(2)));
        university.addCourse(new entities.Course(
                2,"darbaiXD", "Darbuko salalai", university.getTeacherByID(2), university.getGroupByID(1)));
        university.addCourse(new entities.Course(
                3,"darkoks velnias", "dar vienas niekam nereikalingas kursas", university.getTeacherByID(1), university.getGroupByID(2)));

        entities.Task task1 = new entities.Task(1,"primasTaskas", "ejozaselse per ezereli", "08-09", "5" );
        university.getCourseByID(1).addCourseTask(task1);

        entities.Task task2 = new entities.Task(2,"antrasTaskas", "ezerelis ejo per zaselse", "12-12", "1");
        university.getCourseByID(2).addCourseTask(task2);


        university.getCourseByID(1).getCourseTaskByID(1).addTaskCompletedTask(new entities.CompletedTask(
                1, "teisingas atsakymas, kolegos"));
        university.getCourseByID(2).getCourseTaskByID(2).addTaskCompletedTask(new entities.CompletedTask(
                2, "neteisingas atsakymas, biciuli"));
*/

        //endregion

        //new commands.BasicInterface(university).frontPageInteraction();

    }

    public void stop() {
        //new SerializeDeserialize().serialize(university, "universityObject.ser");
    }

    public static void main(String[] args) {
        launch(args);

    }
}
