public class BasicInterface {

public void frontPageInteraction() {
    boolean exit=false;
    while(!exit){
        new Printer().printFrontPage();
        char selection= new Input().getUserInputchar();

        //TODO doesnt react to input, possibly something wrong with Input class method and getByte thang
        switch(selection ) {
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

        }

    }

}

    private void completedTaskPageInteraction() {
    }

    private void taskPageInteraction() {
    }

    private void coursePageInteraction() {
    }

    private void studentPageInteraction() {
    }

    private void teacherPageInteraction() {
    }

}
