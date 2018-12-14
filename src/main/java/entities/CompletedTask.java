package entities;

import javax.persistence.Column;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
@javax.persistence.Entity
public class CompletedTask extends Entity implements Serializable  {
    private static DateFormat dateFormat= new SimpleDateFormat("yyyy/mm/dd");
    private static Calendar calendar = Calendar.getInstance();

    @Column
    private String answer;
    private String grade;
    private String submissionDate;
    private String gradeDate;

    public CompletedTask(String answer) {
        super();
        this.answer = answer;
        this.submissionDate = dateFormat.format(calendar.getTime());
    }

    public CompletedTask() {
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
