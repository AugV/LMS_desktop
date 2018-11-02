import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ElDienynas extends Application {
    University university = new University();

    public void init() {
        university = new SerializeDeserialize().deserialize("universityObject.ser");
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        ControlerTeachersWindow controlerTeachersWindow = new ControlerTeachersWindow(university);
        primaryStage.setScene(new Scene(controlerTeachersWindow, 600, 800));
        primaryStage.show();
//region

/*
        university.addTeacher(1,"Tadas", "jablinksis");
        university.addTeacher(2,"Laimonas", "Stanislovsksi");

        university.addGroup(1,"GRUPE1");
        university.addGroup(2,"GRUPE2");

        university.getGroupByID(1).addGroupStudents(new Student(1, "Petras", "Studentauskas"));
        university.getGroupByID(2).addGroupStudents(new Student(2, "Studenis", "Studavicius"));

        university.addCourse(new Course(
                1,"matematika", "Matematikos kursas", university.getTeacherByID(1), university.getGroupByID(2)));
        university.addCourse(new Course(
                2,"darbaiXD", "Darbuko salalai", university.getTeacherByID(2), university.getGroupByID(1)));
        university.addCourse(new Course(
                3,"darkoks velnias", "dar vienas niekam nereikalingas kursas", university.getTeacherByID(1), university.getGroupByID(2)));

        Task task1 = new Task(1,"primasTaskas", "ejozaselse per ezereli", "08-09", "5" );
        university.getCourseByID(1).addCourseTask(task1);

        Task task2 = new Task(2,"antrasTaskas", "ezerelis ejo per zaselse", "12-12", "1");
        university.getCourseByID(2).addCourseTask(task2);


        university.getCourseByID(1).getCourseTaskByID(1).addTaskCompletedTask(new CompletedTask(
                1, "teisingas atsakymas, kolegos"));
        university.getCourseByID(2).getCourseTaskByID(2).addTaskCompletedTask(new CompletedTask(
                2, "neteisingas atsakymas, biciuli"));
*/

        //endregion

        //new BasicInterface(university).frontPageInteraction();

    }

    public void stop() {
        new SerializeDeserialize().serialize(university, "universityObject.ser");
    }

    public static void main(String[] args) {
        launch(args);

    }
}
