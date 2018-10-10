import java.util.Scanner;

public class Input {
    Scanner scanner = new Scanner(System.in);

    public String getUserInputSingleToken() {
        String input = scanner.next();
        return input;
    }

    public String getUserInputLine() {
        String input = scanner.nextLine();
        return input;
    }

    public char getUserInputchar() {
        char input = scanner.next().charAt(0);
        return input;
    }

    public int getUserInputInt() {
        System.out.println("Enter a number:");
        int input = scanner.nextInt();
        return input;
    }

    public int getUserInputTeacherInt() {
        System.out.println("Enter teacher ID:");
        int input = scanner.nextInt();
        return input;
    }

    public int getUserInputGroupInt() {
        System.out.println("Enter group ID:");
        int input = scanner.nextInt();
        return input;
    }

    public int getUserInputCourseInt() {
        System.out.println("Enter course ID:");
        int input = scanner.nextInt();
        return input;
    }

    public int getUserInputTaskInt() {
        System.out.println("Enter tasl ID:");
        int input = scanner.nextInt();
        return input;
    }

    public int getUserInputComplTaskInt() {
        System.out.println("Enter completed task ID:");
        int input = scanner.nextInt();
        return input;
    }
}
