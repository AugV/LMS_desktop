import java.util.Scanner;

public class InputFile {
    private String fileName;
    private Scanner scanner = new Scanner(fileName);

    public InputFile(String fileName){
        this.fileName = fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Teacher getTeacherFromFile(){
        //file data format: [ID,name,surname]
        String[] teacherInfoArray = scanner.nextLine().split(",");
        return new Teacher(Integer.parseInt(teacherInfoArray[0]), teacherInfoArray[1], teacherInfoArray[2]);
    }



}
