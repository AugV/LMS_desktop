import java.util.Scanner;

public class Input {
    Scanner scanner = new Scanner(System.in);

    public String getUserInputLine(){
        String input  = scanner.nextLine();
        return input;
    }

    public char getUserInputchar(){
        char input  = scanner.next().charAt(0);
        return input;
    }


}
