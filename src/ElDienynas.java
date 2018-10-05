public class ElDienynas {




    public static void main(String[] args){


        University VGTU = new University();
//region
        VGTU.setTeacherList(1, "Tadas", "jablinksis");
        VGTU.setTeacherList(2, "Laimonas", "Stanislovsksi");

        VGTU.addStudent(1, "studentas1", "studentopavard1");
        VGTU.addStudent(2, "studentas2", "studentopavard2");

        VGTU.addCourse(1,"matematika");
        VGTU.addCourse(2,"darbaiXD");
        VGTU.addCourse(3,"darkoks velnias");

        VGTU.addTask(1,"primasTaskas", "ejozaselse per ezereli", "08-09", "5");
        VGTU.addTask(2,"antrasTaskas", "ezerelis ejo per zaselse", "12-12", "1");

        VGTU.setGroupList(1, "GRUPE1");
        VGTU.setGroupList(2, "GRUPE2");

        VGTU.addCompletedTask(1, "atsakymas1", "balas1", "data1", "ivertdata1", "komentaras1");
        VGTU.addCompletedTask(2, "atsakymas2", "balas2", "data2", "ivertdata2", "komentaras2");

        //endregion
        //VGTU.removeTeacher();
        //VGTU.printTeacherList();
        //VGTU.printGroupList();
        //VGTU.getGroupList().get(0).printGroupStudents();
        //VGTU.getGroupList().get(0).setGroupStudents(VGTU.getStudentList().get(0));
        //VGTU.getGroupList().get(0).printGroupStudents();
        //VGTU.getCourseList().get(0).printCourseInfo();

        VGTU.getCourseList().get(0).addCourseTasks(VGTU.getTaskList().get(0));
        VGTU.getCourseList().get(0).addCourseTasks(VGTU.getTaskList().get(1));
        VGTU.getCourseList().get(0).printCourseTasks();
        /*try {
            System.out.println(getTeacherByID(14, VGTU).getName());
        }
        catch(NullPointerException e){
            System.out.println("No such teacher, my man");
        }*/
    }
}
