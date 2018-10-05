import java.util.ArrayList;

public class Teacher extends Person {
    private ArrayList<Course> teacherCourses = new ArrayList();

    public Teacher(int loc_id, String loc_name, String loc_surname) {
        super(loc_id, loc_name, loc_surname);
    }

    public Teacher() {
        super();
    }

    public ArrayList<Course> getTeacherCourses() {
        return teacherCourses;
    }

    public void setTeacherCourses(Course course) {
        teacherCourses.add(course);
    }
    public void removeTeacherCourse(Course course){
        teacherCourses.remove(course);
    }


    @Override
    public String toString() {
        return "ID: " + this.getId() +
                ", Name: " + this.getName() +
                ", Surname: " + this.getSurname();
    }
}
