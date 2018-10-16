import java.util.ArrayList;

public class Teacher extends Person {
    private ArrayList<Course> teacherCourses = new ArrayList();

    public Teacher(int loc_id, String loc_name, String loc_surname) {
        super(loc_id, loc_name, loc_surname);
    }

    public ArrayList<Course> getTeacherCourses() {
        return teacherCourses;
    }

    public void addTeacherCourses(Course course) {
        if (!new DuplicateChecker().isDuplicateById(course, teacherCourses)) {
            teacherCourses.add(course);
        } else {
            System.out.println(" !Student already exists!");
        }
    }


    @Override
    public String toString() {
        return "ID: " + this.getId() +
                ", Name: " + this.getName() +
                ", Surname: " + this.getSurname() +
                "Teacher{" +
                "teacherCourses=" + teacherCourses +
                '}';
    }
}
