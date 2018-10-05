import java.util.ArrayList;

public class Student extends Person {
    private Group group;
    private ArrayList<Course> studentCourses = new ArrayList();
    private ArrayList<CompletedTask> studentCompletedTasks = new ArrayList();

    public Student(int loc_id, String loc_name, String loc_surname){
       super(loc_id, loc_name, loc_surname);

   }

    public Group getGroup() {
        return group;
    }
    public void setGroup(Group group) {
        group.setStudentsFromStudents(this);
        this.group = group;
    }

    public ArrayList<Course> getStudentCourses() {
        return studentCourses;
    }
    public void setStudentCourses(Course course){
        studentCourses.add(course);
    }

    public ArrayList<CompletedTask> getStudentCompletedTasks() {
        return studentCompletedTasks;
    }
    public void setStudentCompletedTasks(CompletedTask completedTask){
        completedTask.setStudent(this);
        studentCompletedTasks.add(completedTask);
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID: " + getId() +
                ", Name: " + getName() +
                ", Surname: " + getSurname() +
                ", studentCourses=" + studentCourses +
                ", studentCompletedTasks=" + studentCompletedTasks +
                '}';
    }

    public void setGroupFromGroup(Group group) {
        this.group = group;
    }
}
