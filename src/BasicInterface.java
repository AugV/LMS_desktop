public class BasicInterface {

    private static Printer printer= new Printer();
    private static Input input = new Input();

    private University university;
    boolean exit;
    boolean back;


    public BasicInterface(University university) {
        this.university = university;
    }

    public void frontPageInteraction() {
        boolean exit = false;
        while (!exit) {
            printer.printFrontPage();
            switch (input.getUserInputchar()) {
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
                    printer.printExitMessage();
            }

        }

    }

    private void teacherPageInteraction() {

        back = false;
        while (!back) {
            printer.printTeacherPage();
            switch (input.getUserInputchar()) {
                case '1':
                    printer.printObjectArray(university.getTeacherList());
                    input.pressEnterToContinue();
                    break;
                case '2':
                    //TODO add reading teacher from file
                    break;
                case '3':
                    printer.printTeacherConstructorGuide();
                    university.addTeacherKeyboard();
                    printer.printDataAdded();
                    input.pressEnterToContinue();
                    break;
                case '4':
                    university.removeTeacher();
                    printer.printDataRemoved();
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
            printer.printStudentPage();
            switch (input.getUserInputchar()) {
                case '1':
                    printer.printObjectArray(university.getGroupList());
                    input.pressEnterToContinue();
                    break;
                case '2':
                    printer.printObjectArray(university.getGroupByID(input.getUserInputGroupInt()).getGroupStudents());
                    input.pressEnterToContinue();
                    break;
                case '3':
                    printer.printGroupConstructorGuide();
                    university.addGroup(new Group(input.getUserInputInt(), input.getUserInputSingleToken()));
                    printer.printDataAdded();
                    input.pressEnterToContinue();
                    break;
                case '4':
                    printer.printStudentConstructorGuide();
                    Student newStudent = new Student(
                            input.getUserInputInt(),input.getUserInputSingleToken(), input.getUserInputSingleToken() );
                        university.getGroupByID(input.getUserInputGroupInt()).addGroupStudents(newStudent);
                        university.addStudent(newStudent);
                    printer.printDataAdded();
                    input.pressEnterToContinue();
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
            printer.printCoursePage();
            switch (input.getUserInputchar()) {
                case '1':
                    printer.printObjectArray(university.getCourseList());
                    input.pressEnterToContinue();
                    break;
                case '2':
                    printer.printSingleString(university.getCourseByID(input.getUserInputCourseInt()).getCourseInformation());
                    input.pressEnterToContinue();
                    break;
                case '3':
                    printer.printCourseConstructorGuide();
                    Course course = new Course(input.getUserInputInt(), input.getUserInputSingleToken(), input.getUserInputLine());
                        university.getTeacherByID(input.getUserInputTeacherInt()).setTeacherCourses(course);
                        university.getGroupByID(input.getUserInputGroupInt()).addGroupCourse(course);
                        university.addCourse(course);
                    printer.printDataAdded();
                    input.pressEnterToContinue();
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
            printer.printTaskPage();
            switch (input.getUserInputchar()) {
                case '1':
                    selectedCourse = university.getCourseByID(input.getUserInputCourseInt());
                    printer.printCourseSelected();
                    input.pressEnterToContinue();
                    break;
                case '2':
                    printer.printObjectArray(selectedCourse.getCourseTasks());
                    input.pressEnterToContinue();
                    break;
                case '3':
                    printer.printTaskConstructorGuide();
                    Task newTask = new Task(input.getUserInputInt(),
                            input.getUserInputSingleToken(),
                            input.getUserInputLine(),
                            input.getUserInputSingleToken(),
                            input.getUserInputSingleToken());
                    selectedCourse.addCourseTask(newTask);
                    university.addTask(newTask);
                    printer.printDataAdded();
                    input.pressEnterToContinue();
                    break;
                case '4':
                    //TODO make task inaccessible
                    break;
                case '5':
                    printer.printObjectArray(selectedCourse.getCourseTaskByID(input.getUserInputTaskInt()).getTaskCompletedTasks());
                    input.pressEnterToContinue();
                    break;
                case '6':
                    printer.printSingleString(university.getCompletedTaskByID(input.getUserInputComplTaskInt()).getAnswer());
                    input.pressEnterToContinue();
                    break;
                case '7':
                    university.getCompletedTaskByID(input.getUserInputComplTaskInt()).setGrade(input.getUserInputLine());
                    printer.printDataAdded();
                    input.pressEnterToContinue();
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
            printer.printCompletedTaskPage();
            switch (input.getUserInputchar()) {
                case '1':
                    for (Course course : university.getGroupByID(input.getUserInputGroupInt()).getGroupCourses()) {
                        printer.printObjectArray(course.getCourseTasks());
                    }
                    break;
                case '2':
                    printer.printCompletedTaskConstructorGuide();
                    CompletedTask newCompletedTask = new CompletedTask(
                            input.getUserInputInt(),
                            input.getUserInputLine());
                    university.getTaskByID(input.getUserInputTaskInt()).addTaskCompletedTask(newCompletedTask);
                    university.addCompletedTask(newCompletedTask);
                    printer.printDataAdded();
                    input.pressEnterToContinue();
                    break;
                case '3':
                    int taskSelection = input.getUserInputComplTaskInt();
                    printer.printSingleString(university.getCompletedTaskByID(taskSelection).getGrade());
                    printer.printSingleString(university.getCompletedTaskByID(taskSelection).getComment());
                    input.pressEnterToContinue();
                    break;
                default:
                    back = true;
                    break;
            }
        }
    }

}
