package entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import input.InputKeyboard;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@javax.persistence.Entity
public class University extends Entity implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;

    @OneToMany(cascade= CascadeType.ALL)
    private List<Teacher> teacherList = new ArrayList();
    @OneToMany(cascade= CascadeType.ALL)
    private List<StudentsGroup> studentsGroupList = new ArrayList();
    @OneToMany(cascade= CascadeType.ALL)
    private List<Course> courseList = new ArrayList();
    @OneToOne(cascade= CascadeType.ALL)
    private StudentsGroup selectedStudentsGroup;

    public University(String name) {
        super(name);
    }

    public University() {
    }


    public void setSelectedStudentsGroup(Object selectedStudentsGroup) {
        this.selectedStudentsGroup = (StudentsGroup) selectedStudentsGroup;
    }

    public StudentsGroup getSelectedStudentsGroup() {
        return selectedStudentsGroup;
    }

    //Groups
    //region
    public List<StudentsGroup> getStudentsGroupList() {
        return studentsGroupList;
    }

    public void addGroup(StudentsGroup studentsGroup) {
            studentsGroupList.add(studentsGroup);
            }

    public void addGroup(String name) {
        StudentsGroup studentsGroup = new StudentsGroup(name);
            studentsGroupList.add(studentsGroup);
    }

    public StudentsGroup getGroupByID(int id) {
        for (StudentsGroup studentsGroup : this.getStudentsGroupList()) {
                if (studentsGroup.getId() == id) {
                    return studentsGroup;
                }
            }
        return null;
    }

    public void removeGroup(Object groupToRemove){
        studentsGroupList.remove(groupToRemove);
    }

    //endregion
    //Courses
    //region
    public List<Course> getCourseList() {
        return courseList;
    }

    public void removeCourse(Object courseToRemove){
        courseList.remove(courseToRemove);
        for(StudentsGroup studentsGroup : studentsGroupList){
            studentsGroup.getGroupCourses().remove(courseToRemove);
        }
        for(Teacher teacher: teacherList){
            teacher.getTeacherCourses().remove(courseToRemove);
        }
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
    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void addTeacher(Teacher teacher) {
        this.teacherList.add(teacher);
    }

    public void removeTeacher(Object teacherToRemove){
        System.out.println("removing");
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
            teacherList.add(teacher);
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
    public List<Student> getAllStudents(){
        List<Student> allStudents = new ArrayList<>();
        for(StudentsGroup studentsGroup : studentsGroupList){
            allStudents.addAll(studentsGroup.getGroupStudents());
        }
        return allStudents;
    }
}
