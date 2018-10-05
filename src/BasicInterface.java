public class BasicInterface {

public void frontPageInteraction() {
    boolean exit=false;
    while(!exit){
        new Printer().printFrontPage();


        switch(new Input().getUserInputchar()) {
            case '1':

                break;
            case '2':

                break;
            case '3':

                break;
            case '4':

                break;
            case '5':

                break;
            default:
                exit= true;
        }

    }

}

}
