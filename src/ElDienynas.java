import javax.naming.NamingException;

public class ElDienynas {

    //private University university;

    public static void main(String[] args) {

        University university = new University();

//region
        university.setTeacherList(1, "Tadas", "jablinksis");
        university.setTeacherList(2, "Laimonas", "Stanislovsksi");

        university.addStudent(1, "studentas1", "studentopavard1");
        university.addStudent(2, "studentas2", "studentopavard2");

        university.addCourse(1,"matematika");
        university.addCourse(2,"darbaiXD");
        university.addCourse(3,"darkoks velnias");

        university.addTask(1,"primasTaskas", "ejozaselse per ezereli", "08-09", "5", university.getTeacherByID(1));
        university.addTask(2,"antrasTaskas", "ezerelis ejo per zaselse", "12-12", "1", university.getTeacherByID(1));

        university.setGroupList(1, "GRUPE1");
        university.setGroupList(2, "GRUPE2");

        university.addCompletedTask(1, "atsakymas1", "balas1", "data1", "ivertdata1", "komentaras1");
        university.addCompletedTask(2, "atsakymas2", "balas2", "data2", "ivertdata2", "komentaras2");

        //endregion
        //university.removeTeacher();
        //university.printTeacherList();
        //university.printGroupList();
        //university.getGroupList().get(0).printGroupStudents();
        //university.getGroupList().get(0).setGroupStudents(university.getStudentList().get(0));
        //university.getGroupList().get(0).printGroupStudents();
        //university.getCourseList().get(0).printCourseInfo();

        university.getCourseList().get(0).addCourseTasks(university.getTaskList().get(0));
        university.getCourseList().get(0).addCourseTasks(university.getTaskList().get(1));
        university.getCourseList().get(0).printCourseTasks();
        new BasicInterface(university).frontPageInteraction();

        /*try {
            System.out.println(getTeacherByID(14, university).getName());
        }
        catch(NullPointerException e){
            System.out.println("No such teacher, my man");
        }*/
    }
}
