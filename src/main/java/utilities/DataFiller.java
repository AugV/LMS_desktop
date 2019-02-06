package utilities;

import entities.University;

public class DataFiller {

    public DataFiller() { }

    public void fillDataOf(University university){
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
    }
}
