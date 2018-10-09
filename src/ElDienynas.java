public class ElDienynas {

    //private University university;

    public static void main(String[] args) {

        University university = new University();

//region
        university.setTeacherList(1,"Tadas", "jablinksis");
        university.setTeacherList(2,"Laimonas", "Stanislovsksi");

        university.addGroup(1,"GRUPE1");
        university.addGroup(2,"GRUPE2");

        university.getGroupByID(1).addGroupStudents(new Student(1, "Petras", "Studentauskas"));
        university.getGroupByID(2).addGroupStudents(new Student(2, "Studenis", "Studavicius"));



        university.addCourse(1,"matematika", "Matematikos kursas");
        university.addCourse(2,"darbaiXD", "Darbuko salalai");
        university.addCourse(3,"darkoks velnias", "dar vienas niekam nereikalingas kursas");

        university.getCourseByID(1).addCourseTask(university.getNsetTask(1,"primasTaskas", "ejozaselse per ezereli", "08-09", "5", university.getTeacherByID(1)));
        university.getCourseByID(2).addCourseTask(university.getNsetTask(2,"antrasTaskas", "ezerelis ejo per zaselse", "12-12", "1", university.getTeacherByID(1)));

        //university.addTask(1,"primasTaskas", "ejozaselse per ezereli", "08-09", "5", university.getTeacherByID(1), university.getCourseByID(2));
        //university.addTask(2,"antrasTaskas", "ezerelis ejo per zaselse", "12-12", "1", university.getTeacherByID(1), university.getCourseByID(3));

        //university.addCompletedTask(1, "atsakymas1", "balas1", "data1", "ivertdata1", "komentaras1");
        //university.addCompletedTask(2, "atsakymas2", "balas2", "data2", "ivertdata2", "komentaras2");

        university.getGroupByID(1).addGroupStudents(university.getStudentByID(1));

        //endregion
        //university.removeTeacher();
        //university.printTeacherList();
        //university.printGroupList();
        //university.getGroupList().get(0).printGroupStudents();
        //university.getGroupList().get(0).addGroupStudents(university.getStudentList().get(0));
        //university.getGroupList().get(0).printGroupStudents();
        //university.getCourseList().get(0).printCourseInfo();


        new BasicInterface(university).frontPageInteraction();

        /*try {
            System.out.println(getTeacherByID(14, university).getName());
        }
        catch(NullPointerException e){
            System.out.println("No such teacher, my man");
        }*/
    }
}
