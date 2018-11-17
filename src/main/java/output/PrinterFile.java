package output;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrinterFile {
    private PrintWriter printWriter;

    public PrinterFile(String fileName){
        try {
            printWriter = new PrintWriter(new FileWriter(fileName));
        } catch (IOException e) {
            System.out.println();
            System.out.println(" !Bad file name! ");;
        }
    }

    public <T> void printObjectArrayToFile(List<T> objectArray) {
        for (T object : objectArray){
            printWriter.println(object);
        }
        printWriter.close();
    }
}
