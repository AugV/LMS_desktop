import java.util.ArrayList;

public class University {
    private ArrayList<Teacher> teacherList = new ArrayList();
    private ArrayList<Student> studentList = new ArrayList();
    private ArrayList<Group> groupList = new ArrayList();
    private ArrayList<Course> courseList = new ArrayList();
    private ArrayList<Task> taskList = new ArrayList();
    private ArrayList<CompletedTask> completedTaskList = new ArrayList();

    //Groups
    //region
    public ArrayList<Group> getGroupList() {
        return groupList;
    }

    public void addGroup(Group group) {
        this.groupList.add(group);
    }

    public void addGroup(int id, String name) {
        this.groupList.add(new Group(id,name));
    }

    public Group getGroupByID(int id) {
        Group groupMatch = null;
        for (Group group : this.getGroupList()) {
            if (group.getGroupID()== id) {
                groupMatch = group;
                break;
            }
        }
        return groupMatch;
    }

    public void printGroupList(){
        for (Group group : groupList) {
            System.out.println(group);
        }
    }
    //endregion
    //Courses
    //region
    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(Course course) {
        this.courseList.add(course);
    }

    public void addCourse(Course course) {
        courseList.add(course);
    }

    public void printCourseList(){
        for (Course course : courseList) {
            System.out.println(course);
        }
    }

    public Course getCourseByID(int id) {
        Course courseMatch = null;
        for (Course course : this.getCourseList()) {
            if (course.getCourseID() == id) {
                courseMatch = course;
                break;
            }
        }
        return courseMatch;
    }
    //endregion
    //Tasks
    //region
    public void addTask(int taskID, String name, String taskCondition, String deadline, String points) {
        Task task = new Task(taskID, name, taskCondition, deadline, points);
        taskList.add(task);
    }

    public void addCompletedTask(int id, String answer, String submissionDate) {
        CompletedTask completedTask = new CompletedTask(id, answer, submissionDate);
        completedTaskList.add(completedTask);
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public void addTask(Task task) {
        this.taskList.add(task);
    }

    public Task getNsetTask(int taskID, String name, String taskCondition, String deadline, String points){
        Task task = new Task(taskID, name, taskCondition, deadline, points);
        taskList.add(task);
        return task;
    }

    public Task getTaskByID(int id) {
        Task taskMatch = null;
        for (Task task : this.getTaskList()) {
            if (task.getTaskID() == id) {
                taskMatch = task;
                break;
            }
        }
        return taskMatch;
    }

    public ArrayList<CompletedTask> getCompletedTaskList() {
        return completedTaskList;
    }

    public void setCompletedTaskList(CompletedTask completedTask) {
        this.completedTaskList.add(completedTask);
    }

    public CompletedTask getCompletedTaskByID(int id) {
        CompletedTask completedTaskMatch = null;
        for (CompletedTask completedTask : this.getCompletedTaskList()) {
            if (completedTask.getTaskID() == id) {
                completedTaskMatch = completedTask;
                break;
            }
        }
        return completedTaskMatch;
    }
//endregion
    //Teachers
    // region
    public ArrayList<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(Teacher teacher) {
        this.teacherList.add(teacher);
    }

    public Teacher getTeacherByID(int id) {
        Teacher teacherMatch = null;
        for (Teacher teacher : this.getTeacherList()) {
            if (teacher.getId() == id) {
                teacherMatch = teacher;
                break;
            }
        }
        return teacherMatch;
    }

    public void setTeacherList(int id, String name, String surname) {
        Teacher teacher = new Teacher(id, name, surname);
        this.teacherList.add(teacher);
    }

    public void addTeacherKeyboard() {
        System.out.println("ID Name    Surname");
        setTeacherList(new Input().getUserInputInt(), new Input().getUserInputSingleToken(), new Input().getUserInputSingleToken());
    }

    public void printTeacherList() {
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
    }

    public void removeTeacher() {
        System.out.println("Enter ID of the teacher you wish to remove:");
        Teacher teacherToRemove = getTeacherByID(new Input().getUserInputInt());
        teacherList.remove(teacherList.indexOf(teacherToRemove));
    }
//endregion
    //Students
    //region
    public void addStudent(int id, String name, String surname) {
        Student student = new Student(id, name, surname);
        addStudent(student);
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void addStudent(Student student) {
        this.studentList.add(student);
    }

    public Student getStudentByID(int id) {
        Student studentMatch = null;
        for (Student student : this.getStudentList()) {
            if (student.getId() == id) {
                studentMatch = student;
                break;
            }
        }
        return studentMatch;
    }
//endregion






}
