import java.util.ArrayList;

public class University {
    private ArrayList<Teacher> teacherList = new ArrayList();
    private ArrayList<Group> groupList = new ArrayList();
    private ArrayList<Course> courseList = new ArrayList();


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
            if (group.getId()== id) {
                groupMatch = group;
                break;
            }
        }
        return groupMatch;
    }

    //endregion
    //Courses
    //region
    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public void addCourse(Course course) {
        courseList.add(course);
    }

    public Course getCourseByID(int id) {
        Course courseMatch = null;
        for (Course course : this.getCourseList()) {
            if (course.getId() == id) {
                courseMatch = course;
                break;
            }
        }
        return courseMatch;
    }
    //endregion
    //Teachers
    // region
    public ArrayList<Teacher> getTeacherList() {
        return teacherList;
    }

    public void addTeacher(Teacher teacher) {
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

    public void addTeacher(int id, String name, String surname) {
        Teacher teacher = new Teacher(id, name, surname);
        this.teacherList.add(teacher);
    }

    public void removeTeacher() {
        System.out.println("Enter ID of the teacher you wish to remove:");
        Teacher teacherToRemove = getTeacherByID(new InputKeyboard().getUserInputInt());
        teacherList.remove(teacherList.indexOf(teacherToRemove));
    }
//endregion





}
