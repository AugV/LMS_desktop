public class BasicInterface {
    private University university;
    boolean exit;
    boolean back;


    public BasicInterface(University university) {
        this.university = university;
    }

    public void frontPageInteraction() {
        boolean exit = false;
        while (!exit) {
            new Printer().printFrontPage();

            switch (new Input().getUserInputchar()) {
                case '1':
                    teacherPageInteraction();
                    break;
                case '2':
                    studentPageInteraction();
                    break;
                case '3':
                    coursePageInteraction();
                    break;
                case '4':
                    taskPageInteraction();
                    break;
                case '5':
                    completedTaskPageInteraction();
                    break;
                default:
                    exit = true;
                    new Printer().printExitMessage();
            }

        }

    }

    private void teacherPageInteraction() {

        back = false;
        while (!back) {
            new Printer().printTeacherPage();
            switch (new Input().getUserInputchar()) {
                case '1':
                    university.printTeacherList();
                    new Input().pressEnterToContinue();
                    break;
                case '2':
                    //TODO add reading teacher from file
                    break;
                case '3':
                    university.addTeacherKeyboard();
                    new Printer().printDataAdded();
                    new Input().pressEnterToContinue();
                    break;
                case '4':
                    university.removeTeacher();
                    new Printer().printDataRemoved();
                    break;
                case '5':
                    //TODO print to file
                    break;
                default:
                    back = true;
                    break;
            }
        }
    }

    private void studentPageInteraction() {
        back = false;
        while (!back) {
            new Printer().printStudentPage();
            switch (new Input().getUserInputchar()) {
                case '1':
                    university.printGroupList();
                    new Input().pressEnterToContinue();
                    break;
                case '2':
                    university.getGroupByID(new Input().getUserInputGroupInt()).printGroupStudents();
                    new Input().pressEnterToContinue();
                    break;
                case '3':
                    university.addGroup(new Group(new Input().getUserInputInt(), new Input().getUserInputSingleToken()));
                    new Printer().printDataAdded();
                    new Input().pressEnterToContinue();
                    break;
                case '4':
                    new Printer().printStudentConstructorGuide();
                    Student newStudent = new Student(
                            new Input().getUserInputInt(),new Input().getUserInputSingleToken(), new Input().getUserInputSingleToken() );
                    university.getGroupByID(new Input().getUserInputGroupInt()).addGroupStudents(newStudent);
                    university.addStudent(newStudent);
                    new Printer().printDataAdded();
                    new Input().pressEnterToContinue();
                    break;
                default:
                    back = true;
                    break;
            }
        }
    }

    private void coursePageInteraction() {

        back = false;
        while (!back) {
            new Printer().printCoursePage();
            switch (new Input().getUserInputchar()) {
                case '1':
                    university.printCourseList();
                    new Input().pressEnterToContinue();
                    break;
                case '2':
                    university.getCourseByID(new Input().getUserInputCourseInt()).printCourseInformation();
                    new Input().pressEnterToContinue();
                    break;
                case '3':
                    Course course = new Course(new Input().getUserInputInt(), new Input().getUserInputSingleToken(), new Input().getUserInputLine());
                    university.getTeacherByID(new Input().getUserInputTeacherInt()).setTeacherCourses(course);
                    university.getGroupByID(new Input().getUserInputGroupInt()).addGroupCourse(course);
                    university.addCourse(course);
                    new Printer().printDataAdded();
                    new Input().pressEnterToContinue();
                    break;
                case '4':
                    //TODO new window for Course group and teacher deletion/adding
                    break;
                default:
                    back = true;
                    break;
            }
        }
    }

    private void taskPageInteraction () {
        back = false;
        Course selectedCourse = null;
        while (!back) {
            new Printer().printTaskPage();
            switch (new Input().getUserInputchar()) {
                case '1':
                    selectedCourse = university.getCourseByID(new Input().getUserInputCourseInt());
                    new Printer().printCourseSelected();
                    new Input().pressEnterToContinue();
                    break;
                case '2':
                    selectedCourse.printCourseTasks();
                    new Input().pressEnterToContinue();
                    break;
                case '3':
                    Task newTask = new Task(new Input().getUserInputInt(),
                            new Input().getUserInputSingleToken(),
                            new Input().getUserInputLine(),
                            new Input().getUserInputSingleToken(),
                            new Input().getUserInputSingleToken());
                    selectedCourse.addCourseTask(newTask);
                    university.addTask(newTask);
                    new Printer().printDataAdded();
                    new Input().pressEnterToContinue();
                    break;
                case '4':
                    //TODO make task inaccessible
                    break;
                case '5':
                    selectedCourse.getCourseTaskByID(new Input().getUserInputTaskInt()).printTaskCompletedTasks();
                    new Input().pressEnterToContinue();
                    break;
                case '6':
                    university.getCompletedTaskByID(new Input().getUserInputComplTaskInt()).getAnswer();
                    new Input().pressEnterToContinue();
                    break;
                case '7':
                    university.getCompletedTaskByID(new Input().getUserInputComplTaskInt()).setGrade(new Input().getUserInputLine());
                    new Printer().printDataAdded();
                    new Input().pressEnterToContinue();
                    break;
                default:
                    back = true;
                    break;
            }
        }
    }

    private void completedTaskPageInteraction() {
        back = false;
        while (!back) {
            new Printer().printCompletedTaskPage();
            switch (new Input().getUserInputchar()) {
                case '1':
                    for (Course course : university.getGroupByID(new Input().getUserInputGroupInt()).getGroupCourses()) {
                        course.printCourseTasks();
                    }
                    break;
                case '2':
                    CompletedTask newCompletedTask = new CompletedTask(
                            new Input().getUserInputInt(),
                            new Input().getUserInputLine());
                    university.getTaskByID(new Input().getUserInputTaskInt()).addTaskCompletedTask(newCompletedTask);
                    university.addCompletedTask(newCompletedTask);
                    new Printer().printDataAdded();
                    new Input().pressEnterToContinue();
                    break;
                case '3':
                    int taskSelection = new Input().getUserInputComplTaskInt();
                    university.getCompletedTaskByID(taskSelection).printGrade();
                    university.getCompletedTaskByID(taskSelection).printComment();
                    new Input().pressEnterToContinue();
                    break;
                default:
                    back = true;
                    break;
            }
        }
    }

}
