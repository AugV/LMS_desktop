import java.sql.SQLOutput;
import java.util.ArrayList;

public class Course {
    private int courseID;
    private String name;
    private ArrayList<Teacher> courseTeachers = new ArrayList();
    private ArrayList<Task> courseTasks = new ArrayList();
    private ArrayList<Group> courseGroups = new ArrayList();

    public Course(int courseID, String name) {
        this.courseID = courseID;
        this.name = name;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addCourseTeachers(Teacher teacher) {
        teacher.setTeacherCourses(this);
        courseTeachers.add(teacher);
    }

    public ArrayList<Teacher> getCourseTeachers() {
        return courseTeachers;
    }

    public void removeCourseTeacher(Teacher teacherToRemove) {
        courseTeachers.remove(teacherToRemove);
        teacherToRemove.removeTeacherCourse(this);
    }


    public void addCourseTasks(Task task) {
        task.setTaskFromTask(this);
        courseTasks.add(task);
    }

    public ArrayList<Task> getCourseTasks() {
        return courseTasks;
    }

    public void printCourseTasks() {
        for (Task task : this.courseTasks) {
            System.out.println(task);
        }
    }

    public ArrayList<Group> getCourseGroups() {
        return courseGroups;
    }

    public void removeCourseGroup(Group group) {
        courseGroups.remove(group);
    }

    public void setCourseGroups(Group group) {
        this.courseGroups.add(group);
    }

    public void printCourseInfo() {
        System.out.println("ID: " + courseID);
        System.out.println("Name: " + name);
        System.out.println("Teachers List: ");
        for (Teacher teacher : courseTeachers) {
            System.out.println(teacher);
        }
        System.out.println("Group List: ");
        for (Group group : courseGroups) {
            System.out.println(group);
        }
        System.out.println("Task List: ");
        for (Task task : courseTasks) {
            System.out.println(task);
        }
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
