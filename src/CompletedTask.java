import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CompletedTask {
    private int taskID;
    private String answer,
            grade,
            submissionDate, //TODO make date type
            gradeDate,//TODO make date type
            comment;
    DateFormat dateFormat= new SimpleDateFormat("yyyy/mm/dd");
    Calendar calendar = Calendar.getInstance();

    public CompletedTask(int id, String answer) {
        this.taskID = id;
        this.answer = answer;
        this.submissionDate = dateFormat.format(calendar.getTime());
    }

    public int getTaskID() {
        return taskID;
    }

    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public void printGrade() {
        System.out.println(grade);;
    }

    public void printComment() {
        System.out.println(comment);;
    }

    @Override
    public String toString() {
        return "CompletedTask{" +
                "answer='" + answer + '\'' +
                ", grade='" + grade + '\'' +
                ", submissionDate='" + submissionDate + '\'' +
                ", gradeDate='" + gradeDate + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
