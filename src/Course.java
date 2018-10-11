import java.sql.SQLOutput;
import java.util.ArrayList;

public class Course {
    private int courseID;
    private String name;
    private String information;
    private ArrayList<Task> courseTasks = new ArrayList();


    public Course(int courseID, String name, String information) {
        this.courseID = courseID;
        this.name = name;
        this.information = information;
    }

    public Course(int courseID, String name, String information, Teacher teacher, Group group) {
        this.courseID = courseID;
        this.name = name;
        this.information = information;
        teacher.setTeacherCourses(this);
        group.addGroupCourse(this);
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

    public String getCourseInformation() {
        return information;
    }

    public void addCourseTask(Task task) {
        courseTasks.add(task);
    }

    public Task getCourseTaskByID(int id) {
        Task taskMatch = null;
        for (Task task : this.getCourseTasks()) {
            if (task.getTaskID() == id) {
                taskMatch = task;
                break;
            }
        }
        return taskMatch;
    }

    public ArrayList<Task> getCourseTasks() {
        return courseTasks;
    }

    public void printCourseTasks() {
        for (Task task : this.courseTasks) {
            System.out.println(task);
        }
    }


    @Override
    public String toString() {
        return this.getName();
    }
}
