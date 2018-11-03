import java.io.Serializable;
import java.util.ArrayList;

public class University implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;

    private ArrayList<Teacher> teacherList = new ArrayList();
    private ArrayList<Group> groupList = new ArrayList();
    private ArrayList<Course> courseList = new ArrayList();

    //Groups
    //region
    public ArrayList<Group> getGroupList() {
        return groupList;
    }

    public void addGroup(Group group) {
        if (!new DuplicateChecker().isDuplicateById(group, groupList)) {
            groupList.add(group);
        } else {
            System.out.println(" !Group already exists!");
        }
    }

    public void addGroup(int id, String name) {
        Group group = new Group(id,name);
        if (!new DuplicateChecker().isDuplicateById(group, groupList)) {
            groupList.add(group);
        } else {
            System.out.println(" !Group already exists!");
        }

    }

    public Group getGroupByID(int id) {
        for (Group group : this.getGroupList()) {
                if (group.getId() == id) {
                    return group;
                }
            }
        return null;
    }

    //endregion
    //Courses
    //region
    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public void removeCourse(Object courseToRemove){
        courseList.remove(courseToRemove);
        for(Group group: groupList){
            group.getGroupCourses().remove(courseToRemove);
        }
        for(Teacher teacher: teacherList){
            teacher.getTeacherCourses().remove(courseToRemove);
        }
    }

    public void addCourse(Course course) {
        if (!new DuplicateChecker().isDuplicateById(course, courseList)) {
            courseList.add(course);
        } else {
            System.out.println(" !Course already exists!");
        }
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

    public void removeTeacher(Object teacherToRemove){
        System.out.println("remooving");
        teacherList.remove(teacherToRemove);
    }

    public Teacher getTeacherByID(int id) {
        Teacher teacherMatch = null;
               for (Teacher teacher : this.getTeacherList()) {
            if (teacher.getId() == id) {
                teacherMatch = teacher;
                return teacherMatch;
            }
        }
        //if (teacherMatch==null) throw new IllegalArgumentException(" !Teacher with this ID does not exist!");
        return null;
    }

    public void addTeacher(int id, String name, String surname) {
        Teacher teacher = new Teacher(id, name, surname);
        if (!new DuplicateChecker().isDuplicateById(teacher, teacherList)) {
            teacherList.add(teacher);
        } else {
            System.out.println(" !Teacher already exists!");
        }
    }

    public void removeTeacher() {
        System.out.println("Enter ID of the teacher you wish to remove:");
        Teacher teacherToRemove = getTeacherByID(new InputKeyboard().getUserInputInt());
        try{
            teacherList.remove(teacherList.indexOf(teacherToRemove));
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println(" !Teacher does not exist!");
        }
    }
//endregion
    //General
    public ArrayList<Student> getAllStudents(){
        ArrayList<Student> allStudents = new ArrayList<>();
        for(Group group: groupList){
            allStudents.addAll(group.getGroupStudents());
        }
        return allStudents;
    }
}
