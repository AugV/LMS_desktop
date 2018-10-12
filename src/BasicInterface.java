public class BasicInterface {

    private static Printer printer= new Printer();
    private static InputKeyboard inputKeyboard = new InputKeyboard();

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
            switch (inputKeyboard.getUserInputchar()) {
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
            switch (inputKeyboard.getUserInputchar()) {
                case '1':
                    printer.printObjectArray(university.getTeacherList());
                    inputKeyboard.pressEnterToContinue();
                    break;
                case '2':
                    printer.printEnterFileName();
                    university.addTeacher(new InputFile(inputKeyboard.getUserInputLine()).getTeacherFromFile());
                    printer.printDataAdded();
                    inputKeyboard.pressEnterToContinue();
                    break;
                case '3':
                    printer.printTeacherConstructorGuide();
                    university.addTeacher(inputKeyboard.getUserInputInt(),inputKeyboard.getUserInputLine(), inputKeyboard.getUserInputLine());
                    printer.printDataAdded();
                    inputKeyboard.pressEnterToContinue();
                    break;
                case '4':
                    university.removeTeacher();
                    printer.printDataRemoved();
                    inputKeyboard.pressEnterToContinue();
                    break;
                case '5':
                    printer.printEnterFileName();
                    new PrinterFile(inputKeyboard.getUserInputLine()).printObjectArrayToFile(university.getTeacherList());
                    printer.printDataAddedToFile();
                    printer.printEnterFileName();
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
            switch (inputKeyboard.getUserInputchar()) {
                case '1':
                    printer.printObjectArray(university.getGroupList());
                    inputKeyboard.pressEnterToContinue();
                    break;
                case '2':
                    printer.printObjectArray(university.getGroupByID(inputKeyboard.getUserInputGroupInt()).getGroupStudents());
                    inputKeyboard.pressEnterToContinue();
                    break;
                case '3':
                    printer.printGroupConstructorGuide();
                    university.addGroup(new Group(inputKeyboard.getUserInputInt(), inputKeyboard.getUserInputLine()));
                    printer.printDataAdded();
                    inputKeyboard.pressEnterToContinue();
                    break;
                case '4':
                    printer.printStudentConstructorGuide();
                    Student newStudent = new Student(
                            inputKeyboard.getUserInputInt(), inputKeyboard.getUserInputLine(), inputKeyboard.getUserInputLine() );
                        university.getGroupByID(inputKeyboard.getUserInputGroupInt()).addGroupStudents(newStudent);
                        university.addStudent(newStudent);
                    printer.printDataAdded();
                    inputKeyboard.pressEnterToContinue();
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
            switch (inputKeyboard.getUserInputchar()) {
                case '1':
                    printer.printObjectArray(university.getCourseList());
                    inputKeyboard.pressEnterToContinue();
                    break;
                case '2':
                    printer.printSingleString(university.getCourseByID(inputKeyboard.getUserInputCourseInt()).getCourseInformation());
                    inputKeyboard.pressEnterToContinue();
                    break;
                case '3':
                    printer.printCourseConstructorGuide();
                    Course course = new Course(inputKeyboard.getUserInputInt(), inputKeyboard.getUserInputLine(), inputKeyboard.getUserInputLine());
                        university.getTeacherByID(inputKeyboard.getUserInputTeacherInt()).setTeacherCourses(course);
                        university.getGroupByID(inputKeyboard.getUserInputGroupInt()).addGroupCourse(course);
                        university.addCourse(course);
                    printer.printDataAdded();
                    inputKeyboard.pressEnterToContinue();
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
            switch (inputKeyboard.getUserInputchar()) {
                case '1':
                    selectedCourse = university.getCourseByID(inputKeyboard.getUserInputCourseInt());
                    printer.printCourseSelected();
                    inputKeyboard.pressEnterToContinue();
                    break;
                case '2':
                    printer.printObjectArray(selectedCourse.getCourseTasks());
                    inputKeyboard.pressEnterToContinue();
                    break;
                case '3':
                    printer.printTaskConstructorGuide();
                    Task newTask = new Task(inputKeyboard.getUserInputInt(),
                            inputKeyboard.getUserInputLine(),
                            inputKeyboard.getUserInputLine(),
                            inputKeyboard.getUserInputLine(),
                            inputKeyboard.getUserInputLine());
                    selectedCourse.addCourseTask(newTask);
                    university.addTask(newTask);
                    printer.printDataAdded();
                    inputKeyboard.pressEnterToContinue();
                    break;
                case '4':
                    //TODO make task inaccessible
                    break;
                case '5':
                    printer.printObjectArray(selectedCourse.getCourseTaskByID(inputKeyboard.getUserInputTaskInt()).getTaskCompletedTasks());
                    inputKeyboard.pressEnterToContinue();
                    break;
                case '6':
                    printer.printSingleString(university.getCompletedTaskByID(inputKeyboard.getUserInputComplTaskInt()).getAnswer());
                    inputKeyboard.pressEnterToContinue();
                    break;
                case '7':
                    university.getCompletedTaskByID(inputKeyboard.getUserInputComplTaskInt()).setGrade(inputKeyboard.getUserInputLine());
                    printer.printDataAdded();
                    inputKeyboard.pressEnterToContinue();
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
            switch (inputKeyboard.getUserInputchar()) {
                case '1':
                    for (Course course : university.getGroupByID(inputKeyboard.getUserInputGroupInt()).getGroupCourses()) {
                        printer.printObjectArray(course.getCourseTasks());
                    }
                    break;
                case '2':
                    printer.printCompletedTaskConstructorGuide();
                    CompletedTask newCompletedTask = new CompletedTask(
                            inputKeyboard.getUserInputInt(),
                            inputKeyboard.getUserInputLine());
                    university.getTaskByID(inputKeyboard.getUserInputTaskInt()).addTaskCompletedTask(newCompletedTask);
                    university.addCompletedTask(newCompletedTask);
                    printer.printDataAdded();
                    inputKeyboard.pressEnterToContinue();
                    break;
                case '3':
                    int taskSelection = inputKeyboard.getUserInputComplTaskInt();
                    printer.printSingleString(university.getCompletedTaskByID(taskSelection).getGrade());
                    printer.printSingleString(university.getCompletedTaskByID(taskSelection).getComment());
                    inputKeyboard.pressEnterToContinue();
                    break;
                default:
                    back = true;
                    break;
            }
        }
    }

}
