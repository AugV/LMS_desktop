package entities;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CompletedTask implements Indexable, Serializable {
    private static DateFormat dateFormat= new SimpleDateFormat("yyyy/mm/dd");
    private static Calendar calendar = Calendar.getInstance();

    private int taskID;
    private String answer,
    grade,
    submissionDate,
    gradeDate;

    public CompletedTask(int id, String answer) {
        this.taskID = id;
        this.answer = answer;
        this.submissionDate = dateFormat.format(calendar.getTime());
    }

    public int getId() {
        return taskID;
    }

    public String getAnswer() {
        return answer;
    }


    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
        this.gradeDate =  dateFormat.format(calendar.getTime());
    }

    @Override
    public String toString() {
        return "entities.CompletedTask{" +
                "answer='" + answer + '\'' +
                ", grade='" + grade + '\'' +
                ", submissionDate='" + submissionDate + '\'' +
                ", gradeDate='" + gradeDate + '\'' +
                '}';
    }
}
