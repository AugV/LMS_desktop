import java.sql.SQLOutput;
import java.util.ArrayList;

public class Course {
    private int courseID;
    private String name;
    private String information;
    private ArrayList<Task> courseTasks = new ArrayList();

    public String getCourseInformation() {
        return information;
    }

    public Course(int courseID, String name, String information) {
        this.courseID = courseID;
        this.name = name;
        this.information = information;
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


    public void printCourseInfo() {
        System.out.println("ID: " + courseID);
        System.out.println("Name: " + name);
        System.out.println("Teachers List: ");
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
