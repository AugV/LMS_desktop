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
        new Printer().printStudentPage();
    }

    private void teacherPageInteraction() {
        new Printer().printTeacherPage();
        back=false;
        while(!back) {
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
                    break;
                case '5':
                    break;
                default:
                    break;
            }
        }
    }

}
