
public class Task {

    private int taskID;
    private String  name;
    private String  taskCondition;
    private String  deadline;
    private String  points;
    Course taskCourse;
    Teacher taskTeacher;

    public Teacher getTaskTeacher() {
        return taskTeacher;
    }

    public void setTaskTeacher(Teacher taskTeacher) {
        this.taskTeacher = taskTeacher;
    }

    public Task(int taskID, String name, String taskCondition, String deadline, String points, Teacher teacher) {
        this.taskID = taskID;
        this.name = name;
        this.taskCondition = taskCondition;
        this.deadline = deadline;
        this.points = points;
        this.taskTeacher = teacher;
    }

    public Task() {
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }
    public int getTaskID() {
        return taskID;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setTaskCondition(String taskCondition) {
        this.taskCondition = taskCondition;
    }
    public String getTaskCondition() {
        return taskCondition;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
    public String getDeadline() {
        return deadline;
    }

    public void setPoints(String points) {
        this.points = points;
    }
    public String getPoints() {
        return points;
    }

    public void setTaskCourse(Course taskCourse) {
        taskCourse.addCourseTasks(this);
        this.taskCourse = taskCourse;
    }

    public void setTaskFromTask(Course taskCourse) {
        this.taskCourse = taskCourse;
    }
    public Course getTaskCourse() {
        return taskCourse;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", taskCondition='" + taskCondition + '\'' +
                ", deadline='" + deadline + '\'' +
                ", points='" + points + '\'' +
                ", taskCourse=" + taskCourse +
                '}';
    }
}
