import java.util.ArrayList;

public class Group {
    private int groupID;
    private String name;

    ArrayList<Student> groupStudents = new ArrayList();
    ArrayList<Course> groupCourses = new ArrayList();


    public void addGroupCourse(Course groupCourse) {
        this.groupCourses.add(groupCourse);
    }

    public Group(int id, String name) {
        this.groupID = id;
        this.name = name;
    }

    public int getGroupID() {
        return groupID;
    }

    public ArrayList<Student> getGroupStudents() {
        return groupStudents;
    }

    public void printGroupStudents() {
        for (Student student : groupStudents) {
            System.out.println(student);
        }
    }

    public void addGroupStudents(Student student) {
        this.groupStudents.add(student);
    }

    public void printGroupCourses() {
        for (Course course :
                groupCourses) {
            System.out.println(course);
        }
    }

    public ArrayList<Course> getGroupCourses() {
        return groupCourses;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupID=" + groupID +
                ", name='" + name + '\'' +
                ", groupStudents=" + groupStudents +
                '}';
    }
}
