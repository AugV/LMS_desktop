public class BasicInterface {

public void frontPageInteraction() {
    boolean exit=false;
    while(!exit){
        new Printer().printFrontPage();
        char selection= new Input().getUserInputchar();

        //TODO doesnt react to input, possibly something wrong with Input class method and getByte thang
        switch(selection ) {
            case '1':
                System.out.println("boi");
                teacherPageInteraction();

            case '2':
                studentPageInteraction();

            case '3':
                coursePageInteraction();

            case '4':
                taskPageInteraction();

            case '5':
                completedTaskPageInteraction();

            case '6':
                System.out.println("boi");
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
