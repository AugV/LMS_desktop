package entities;
import utilities.DuplicateChecker;
import java.io.Serializable;
import java.util.ArrayList;
import input.InputKeyboard;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@javax.persistence.Entity
public class University extends Entity implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;

    @OneToMany
    private ArrayList<Teacher> teacherList = new ArrayList();
    @OneToMany
    private ArrayList<Group> groupList = new ArrayList();
    @OneToMany
    private ArrayList<Course> courseList = new ArrayList();
    @OneToOne
    private Group selectedGroup;

    public University(String name) {
        super(name);
    }

    public University() {
    }


    public void setSelectedGroup(Object selectedGroup) {
        this.selectedGroup = (Group) selectedGroup;
    }

    public Group getSelectedGroup() {
        return selectedGroup;
    }

    //Groups
    //region
    public ArrayList<Group> getGroupList() {
        return groupList;
    }

    public void addGroup(Group group) {
        if (!new DuplicateChecker().isDuplicateById(group, groupList)) {
            groupList.add(group);
        } else {
            System.out.println(" !entities.Group already exists!");
        }
    }

    public void addGroup(int id, String name) {
        Group group = new Group(id,name);
        if (!new DuplicateChecker().isDuplicateById(group, groupList)) {
            groupList.add(group);
        } else {
            System.out.println(" !entities.Group already exists!");
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

    public void removeGroup(Object groupToRemove){
        groupList.remove(groupToRemove);
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
            System.out.println(" !entities.Course already exists!");
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
        //if (teacherMatch==null) throw new IllegalArgumentException(" !entities.Teacher with this ID does not exist!");
        return null;
    }

    public void addTeacher(String name, String surname) {
        Teacher teacher = new Teacher(name, surname);
        if (!new DuplicateChecker().isDuplicateById(teacher, teacherList)) {
            teacherList.add(teacher);
        } else {
            System.out.println(" !entities.Teacher already exists!");
        }
    }

    public void removeTeacher() {
        System.out.println("Enter ID of the teacher you wish to remove:");
        Teacher teacherToRemove = getTeacherByID(new InputKeyboard().getUserInputInt());
        try{
            teacherList.remove(teacherList.indexOf(teacherToRemove));
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println(" !entities.Teacher does not exist!");
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
