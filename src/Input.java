import java.util.Scanner;

public class Input {
    Scanner scanner = new Scanner(System.in);

    public String getUserInputLine(){
        String input  = scanner.nextLine();
        return input;
    }

    public char getUserInputchar(){
        char input  =(char) scanner.nextByte();
        return input;
    }


}
