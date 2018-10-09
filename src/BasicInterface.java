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

    private void completedTaskPageInteraction() {
        new Printer().printCompletedTaskPage();

        back = false;
        while (!back) {
            new Printer().printCompletedTaskPage();
            switch (new Input().getUserInputchar()) {
                case '1':
                    for (Course course : university.getGroupByID(new Input().getUserInputInt()).getGroupCourses()) {
                        course.printCourseTasks();
                    }
                    break;
                case '2':
                    university.getTaskByID(new Input().getUserInputInt()).addTaskCompletedTask(new CompletedTask(
                            new Input().getUserInputInt(),
                            new Input().getUserInputLine(),
                            new Input().getUserInputLine()));
                    break;
                case '3':
                    int taskSelection = new Input().getUserInputInt();
                    university.getCompletedTaskByID(taskSelection).printGrade();
                    university.getCompletedTaskByID(taskSelection).printComment();
                    break;
                default:
                    back = true;
                    break;
            }
        }
    }

    private void taskPageInteraction() {
        back = false;
        Course selectedCourse = null;
        while (!back) {
            new Printer().printTaskPage();
            switch (new Input().getUserInputchar()) {
                case '1':
                    selectedCourse = university.getCourseByID(new Input().getUserInputInt());
                    break;
                case '2':
                    selectedCourse.printCourseTasks();
                    break;
                case '3':
                    selectedCourse.addCourseTask(university.getNsetTask(
                            new Input().getUserInputInt(),
                            new Input().getUserInputSingleToken(),
                            new Input().getUserInputLine(),
                            new Input().getUserInputSingleToken(),
                            new Input().getUserInputSingleToken(),
                            university.getTeacherByID(new Input().getUserInputInt())));
                    break;
                case '4':
                    //TODO make task inaccessible
                    break;
                case '5':
                    selectedCourse.getCourseTaskByID(new Input().getUserInputInt()).printTaskCompletedTasks();
                    break;
                case '6':
                    university.getCompletedTaskByID(new Input().getUserInputInt()).getAnswer();
                    break;
                case '7':
                    university.getCompletedTaskByID(new Input().getUserInputInt()).setGrade(new Input().getUserInputLine());
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
                    break;
                case '2':
                    university.getCourseByID(new Input().getUserInputInt()).getCourseInformation();
                    break;
                case '3':
                    university.addCourse(new Input().getUserInputInt(), new Input().getUserInputSingleToken(), new Input().getUserInputLine());
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

    private void studentPageInteraction() {
        back = false;
        while (!back) {
            new Printer().printStudentPage();
            switch (new Input().getUserInputchar()) {
                case '1':
                    university.printGroupList();
                    break;
                case '2':
                    university.getGroupByID(new Input().getUserInputInt()).printGroupStudents();
                    break;
                case '3':
                    university.addGroup(new Group(new Input().getUserInputInt(), new Input().getUserInputSingleToken()));
                    break;
                case '4':
                    university.getGroupByID(new Input().getUserInputInt()).addGroupStudents(university.getStudentByID(new Input().getUserInputInt()));
                    break;
                default:
                    back = true;
                    break;
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
                    break;
                case '2':
                    //TODO add reading teacher from file
                    break;
                case '3':
                    university.addTeacherKeyboard();
                    break;
                case '4':
                    university.removeTeacher();
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

}
