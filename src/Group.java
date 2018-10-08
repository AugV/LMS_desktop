import java.util.ArrayList;

public class Group {
    private int groupID;
    private String name;

    ArrayList<Student> groupStudents = new ArrayList();
    ArrayList<Task> groupTasks = new ArrayList();


    public void addGroupTask(Task groupTask) {
        this.groupTasks.add(groupTask);
    }

    public Group(int groupID, String name) {
        this.groupID = groupID;
        this.name = name;
    }

    public int getGroupID() {
        return groupID;
    }
    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Student> getGroupStudents() {
        return groupStudents;
    }
    public void printGroupStudents(){
        for (Student student : groupStudents) {
            System.out.println(student);
        }
    }
    public void addGroupStudents(Student student) {
        student.setGroupFromGroup(this);
        this.groupStudents.add(student);
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupID=" + groupID +
                ", name='" + name + '\'' +
                ", groupStudents=" + groupStudents +
                '}';
    }

    public void setStudentsFromStudents(Student student) {
        this.groupStudents.add(student);
    }
}
