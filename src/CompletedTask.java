
public class CompletedTask {
    private int taskID;
    private String answer,
            grade,
            submissionDate, //TODO make date type
            gradeDate,//TODO make date type
            comment;
    Task task = new Task();
    Teacher teacher;
    Student student;

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


    public Task getTask() {
        return task;
    }
    public void setTask(Task task) {
        this.task = task;
    }

    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        student.setStudentCompletedTasks(this);
        this.student = student;
    }

    @Override
    public String toString() {
        return "CompletedTask{" +
                "answer='" + answer + '\'' +
                ", grade='" + grade + '\'' +
                ", submissionDate='" + submissionDate + '\'' +
                ", gradeDate='" + gradeDate + '\'' +
                ", comment='" + comment + '\'' +
                ", task=" + task.getName() +
                ", teacher=" + teacher.getName() +
                ", student=" + student.getName() +
                '}';
    }
}
