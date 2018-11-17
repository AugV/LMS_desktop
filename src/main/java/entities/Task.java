package entities;

import utilities.DuplicateChecker;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@javax.persistence.Entity
public class Task extends Entity implements Serializable {

    @Column
    private String taskCondition;
    private String deadline;
    private String points;
    private boolean allowSubmitCompletedTask = true;
    @OneToMany(cascade= CascadeType.ALL)
    private List<CompletedTask> taskCompletedTasks = new ArrayList();

    public Task(String name, String taskCondition, String deadline, String points) {
        super(name);
        this.taskCondition = taskCondition;
        this.deadline = deadline;
        this.points = points;
    }

    public Task() {
    }

    public CompletedTask getCompletedTaskById(int id) {
        CompletedTask completedTaskMatch = null;
        for (CompletedTask completedTask : taskCompletedTasks) {
            if (completedTask.getId() == id) {
                completedTaskMatch = completedTask;
                break;
            }
        }
        return completedTaskMatch;
    }

    public void setAllowSubmitCompletedTask(boolean allowSubmitCompletedTask) {
        this.allowSubmitCompletedTask = allowSubmitCompletedTask;
    }

    public List<CompletedTask> getTaskCompletedTasks() {
        return taskCompletedTasks;
    }

    public void addTaskCompletedTask(CompletedTask completedTask) {
        if (allowSubmitCompletedTask) {
            this.taskCompletedTasks.add(completedTask);
        } else {
            System.out.println("Sorry, task is closed");
        }
    }

    @Override
    public String toString() {
        return "entities.Task{" +
                "name='" + this.getName() + '\'' +
                ", taskCondition='" + taskCondition + '\'' +
                ", deadline='" + deadline + '\'' +
                ", points='" + points + '\'' +
                '}';
    }
}
