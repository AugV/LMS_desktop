package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@javax.persistence.Entity
public class CompletedTask extends Entity implements Serializable  {
    private static DateFormat dateFormat= new SimpleDateFormat("yyyy/mm/dd");
    private static Calendar calendar = Calendar.getInstance();

    @ManyToOne
    private Student owner;

    @Column
    private String answer;
    @Column
    private String grade;
    @Column
    private String submissionDate;
    @Column
    private String gradeDate;


    public CompletedTask(String answer, Student owner) {
        super();
        this.answer = answer;
        this.submissionDate = dateFormat.format(calendar.getTime());
        this.owner = owner;
    }

    public CompletedTask() {
    }

    public String getAnswer() {
        return answer;
    }

    public Student getOwner() {
        return owner;
    }

    public String getSubmissionDate() {
        return submissionDate;
    }

    public String getGradeDate() {
        return gradeDate;
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
