package entities;

import java.util.List;

public interface StudentsGroup {
    void addGroupCourse(Course groupCourse);

    List<Course> getGroupCourses();

    void addGroupStudents(Student student);

    List<Student> getGroupStudents();
}
