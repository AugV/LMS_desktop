import java.util.Scanner;

public class Input {
    Scanner scanner = new Scanner(System.in);

    public String getUserInputLine(){
        String input  = scanner.next();
        return input;
    }

    public char getUserInputchar(){
        char input  = scanner.next().charAt(0);
        return input;
    }

    public int getUserInputInt(){
        System.out.println("Enter a number:");
        int input  = scanner.nextInt();
        return input;
    }


}
