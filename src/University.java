import java.util.ArrayList;
import java.util.Scanner;

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


    public void setGroupList(int id, String name) {
        this.groupList.add(new Group(id, name));
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

    public void addCourse(int id, String name, String information) {
        Course course = new Course(id, name, information);
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
    public void addTask(int taskID, String name, String taskCondition, String deadline, String points, Teacher teacher) {
        Task task = new Task(taskID, name, taskCondition, deadline, points, teacher);
        taskList.add(task);
    }

    public void addCompletedTask(int id, String answer, String grade, String submissionDate, String gradeDate, String comment) {
        CompletedTask completedTask = new CompletedTask(id, answer, grade, submissionDate, gradeDate, comment);
        completedTaskList.add(completedTask);
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public void addTask(Task task) {
        this.taskList.add(task);
    }

    public Task getNsetTask(int taskID, String name, String taskCondition, String deadline, String points, Teacher teacher){
        Task task = new Task(taskID, name, taskCondition, deadline, points, teacher);
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
        Scanner sc = new Scanner(System.in);
        System.out.println("ID   Name    Surname");
        setTeacherList(sc.nextInt(), sc.next(), sc.next());
    }

    public void printTeacherList() {
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
    }

    public void removeTeacher() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID of the teacher you wish to remove:");
        Teacher teacherToRemove = getTeacherByID(sc.nextInt());
        for (int i = 0; i < completedTaskList.size(); i++) {
            if (completedTaskList.get(i).teacher.equals(teacherToRemove)) {
                completedTaskList.get(i).setTeacher(null);
            }
        }
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseTeachers().contains(teacherToRemove)) {
                courseList.get(i).removeCourseTeacher(teacherToRemove);
            }
        }
        teacherList.remove(teacherList.indexOf(teacherToRemove));
    }
//endregion
    //Students
    //region
    public void addStudent(int id, String name, String surname) {
        Student student = new Student(id, name, surname);
        setStudentList(student);
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(Student student) {
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
