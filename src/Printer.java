public class Printer {

    public void printFrontPage(){
        System.out.println("1. Manage teachers");
        System.out.println("2. Manage students");
        System.out.println("3. Manage courses");
        System.out.println("4. Manage tasks");
        System.out.println("5. Manage completed tasks");
        System.out.println("6. Exit");
    }

    public void printTeacherPage(){
        System.out.println("1. Print teacher list");
        System.out.println("2. Add new teacher from file");
        System.out.println("3. Add new teacher from keyboard");
        System.out.println("4. Delete teacher");
        System.out.println("5. Print teacher list to file");
        System.out.println("6. Return");
        System.out.println("7. Return");
    }

    public void printStudentPage(){
        System.out.println("1. Print group list");
        System.out.println("2. Print selected group student list");
        System.out.println("3. Add new group");
        System.out.println("4. Add student in selected group");
        System.out.println("5. Return");
    }


    public void printCoursePage(){
        System.out.println("1. Print course list");
        System.out.println("2. Print selected course information");
        System.out.println("3. Create new course");
        System.out.println("4. Edit course information");
        System.out.println("5. Return");
    }

    public void printTaskPage(){
        System.out.println("1. Choose course");
        System.out.println("2. Print selected course task list");
        System.out.println("3. Add new task");
        System.out.println("4. Make task inaccessible");
        System.out.println("5. Print selected task's completed task list");
        System.out.println("6. View selected completed task information");
        System.out.println("7. Grade selected completed task");
        System.out.println("8. Return");
    }

    public void printCompletedTaskPage(){
        System.out.println("1. Print selected group task list");
        System.out.println("2. Submit completed task");
        System.out.println("3. View submitted task's grade and comment");
        System.out.println("4. Return");
    }
}
