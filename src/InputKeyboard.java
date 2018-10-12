import java.util.Scanner;

public class InputKeyboard {
    Scanner scanner = new Scanner(System.in);

    public String getUserInputSingleToken() {
        String input = scanner.next();
        return input;
    }

    public String getUserInputLine() {
        String input = scanner.nextLine();
        return input;
    }

    public void pressEnterToContinue() {
        System.out.println();
        System.out.println("Press ENTER to continue.");
        System.out.println();
        scanner.nextLine();
    }

    public char getUserInputchar() {
        char input = scanner.next().charAt(0);
        scanner.nextLine();
        return input;
    }

    public int getUserInputInt() {
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    public int getUserInputTeacherInt() {
        System.out.println("Enter teacher ID:");
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    public int getUserInputGroupInt() {
        System.out.println("Enter group ID:");
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    public int getUserInputCourseInt() {
        System.out.println("Enter course ID:");
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    public int getUserInputTaskInt() {
        System.out.println("Enter task ID:");
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    public int getUserInputComplTaskInt() {
        System.out.println("Enter completed task ID:");
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

}
