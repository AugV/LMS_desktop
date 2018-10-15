import java.util.ArrayList;

public class Task implements Indexable{

    private int taskID;
    private String name;
    private String taskCondition;
    private String deadline;
    private String points;
    private boolean allowSubmitCompletedTask = true;
    private ArrayList<CompletedTask> taskCompletedTasks = new ArrayList();

    public Task(int id, String name, String taskCondition, String deadline, String points) {
        this.taskID = id;
        this.name = name;
        this.taskCondition = taskCondition;
        this.deadline = deadline;
        this.points = points;
    }

    public int getId() {
        return taskID;
    }

    public CompletedTask getCompletedTaskById(int id){
        CompletedTask completedTaskMatch = null;
        for (CompletedTask completedTask : taskCompletedTasks) {
            if (completedTask.getId()== id) {
                completedTaskMatch = completedTask;
                break;
            }
        }
        return completedTaskMatch;
    }

    public void setAllowSubmitCompletedTask(boolean allowSubmitCompletedTask) {
        this.allowSubmitCompletedTask = allowSubmitCompletedTask;
    }

    public ArrayList<CompletedTask> getTaskCompletedTasks() {
        return taskCompletedTasks;
    }

    public void addTaskCompletedTask(CompletedTask completedTask) {
        if(allowSubmitCompletedTask && !new DuplicateChecker().idDublicateCheck(completedTask, taskCompletedTasks)){
        this.taskCompletedTasks.add(completedTask);}
        else{
            System.out.println("Sorry, task is closed or you already submited this task");
        }
    }

    public void printTaskCompletedTasks() {
        for (CompletedTask completedTask : this.taskCompletedTasks
        ) {
            System.out.println(completedTask);
        }
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", taskCondition='" + taskCondition + '\'' +
                ", deadline='" + deadline + '\'' +
                ", points='" + points + '\'' +
                '}';
    }
}
