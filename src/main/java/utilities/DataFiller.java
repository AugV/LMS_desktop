package utilities;

import entities.Course;
import entities.University;

public class DataFiller {

    public DataFiller() { }

    public void fillDataOf(University university){
        university.addTeacher("Tadas", "jablinksis");
        university.addTeacher("Laimonas", "Stanislovsksi");

        university.addGroup("GRUPE1");
        university.addGroup("GRUPE2");

        university.getStudentsGroupImplList().get(0).addGroupStudents(new entities.Student("Petras", "Studentauskas"));
        university.getStudentsGroupImplList().get(1).addGroupStudents(new entities.Student("Studenis", "Studavicius"));

        university.addCourse(new Course(
                "matematika", "Matematikos kursas", university.getTeacherList().get(0), university.getStudentsGroupImplList().get(0)));
        university.addCourse(new Course(
                "darbaiXD", "Darbuko salalai", university.getTeacherList().get(1), university.getStudentsGroupImplList().get(1)));
        university.addCourse(new Course(
                "darkoks velnias", "dar vienas niekam nereikalingas kursas", university.getTeacherList().get(1), university.getStudentsGroupImplList().get(1)));

        entities.Task task1 = new entities.Task("primasTaskas", "ejozaselse per ezereli", "08-09", "5" );
        university.getCourseList().get(0).addCourseTask(task1);

        entities.Task task2 = new entities.Task("antrasTaskas", "ezerelis ejo per zaselse", "12-12", "1");
        university.getCourseList().get(1).addCourseTask(task2);
    }
}
