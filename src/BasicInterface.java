public class BasicInterface {
    private University university;
    boolean exit;
    boolean back;


    public BasicInterface(University university) {
        this.university = university;
    }

    public void frontPageInteraction() {
    boolean exit=false;
    while(!exit){
        new Printer().printFrontPage();

        switch(new Input().getUserInputchar()) {
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
                exit= true;
                new Printer().printExitMessage();
        }

    }

}

    private void completedTaskPageInteraction() {
    new Printer().printCompletedTaskPage();
    }

    private void taskPageInteraction() {
        new Printer().printTaskPage();
    }

    private void coursePageInteraction() {
        new Printer().printCoursePage();
    }

    private void studentPageInteraction() {
        back=false;
        while(!back) {
            new Printer().printStudentPage();
            switch (new Input().getUserInputchar()) {
                case '1':
                    university.printGroupList();
                    break;
                case '2':
                    university.getGroupByID(new Input().getUserInputInt()).printGroupStudents();
                    break;
                case '3':
                    university.addGroup(new Group(new Input().getUserInputInt(),new Input().getUserInputLine() ));
                    break;
                case '4':
                    //university.removeTeacher();
                    break;
                default:
                    back = true;
                    break;
            }
        }
    }

    private void teacherPageInteraction() {

        back=false;
        while(!back) {
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
