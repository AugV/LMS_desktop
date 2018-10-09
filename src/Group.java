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

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        student.setGroupFromGroup(this);
        this.groupStudents.add(student);
    }

    public void printGroupCourse() {
        for (Course course :
                groupCourses) {
            System.out.println(course);
        }
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupID=" + groupID +
                ", name='" + name + '\'' +
                ", groupStudents=" + groupStudents +
                '}';
    }

    public void setStudentsFromStudents(Student student) {
        this.groupStudents.add(student);
    }
}
