package main;

import entities.*;
import javafx.application.Application;
import javafx.stage.Stage;

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

        entityInstantiation();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnitHibernateH2");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(university);
        entityManager.getTransaction().commit();
        entityManager.close();

        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        StudentsGroup stdGrp = entityManager.createQuery("FROM StudentsGroup ", StudentsGroup.class).getResultList().get(0);
        //CompletedTask crs = entityManager.createQuery("FROM CompletedTask ", CompletedTask.class).getResultList().get(0);
        System.out.println(stdGrp.getGroupStudents().get(0).getName());
        entityManager.close();

        //TODO uncomment XD
//        ParentController parentController = new ParentController(university, primaryStage);
//        primaryStage.setScene(new Scene(parentController));
//        primaryStage.show();


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
        //new SerializeDeserialize().serialize(university, "universityObject.ser");
    }

    public static void main(String[] args) {
        launch(args);

    }
}
