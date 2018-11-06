package utilities;

import entities.University;

import java.io.*;

public class SerializeDeserialize {

    public void serialize(University university, String serializationFileName){
        try {
            FileOutputStream fileOut =
                    new FileOutputStream(serializationFileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(university);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in " + serializationFileName);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public University deserialize(String deserializationFileName) {
            University university = null;
        try {
            FileInputStream fileIn = new FileInputStream(deserializationFileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            university = (University) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Data read from " + deserializationFileName);
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
        }
        return university;
    }

    }

