
public class CompletedTask {
    private int taskID;
    private String answer,
            grade,
            submissionDate, //TODO make date type
            gradeDate,//TODO make date type
            comment;


    public CompletedTask(int id,String answer, String submissionDate) {
        this.taskID = id;
        this.answer = answer;
        this.submissionDate = submissionDate;


    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
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

    public String getSubmissionDate() {
        return submissionDate;
    }
    public void setSubmissionDate(String submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getGradeDate() {
        return gradeDate;
    }
    public void setGradeDate(String gradeDate) {
        this.gradeDate = gradeDate;
    }


    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
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
