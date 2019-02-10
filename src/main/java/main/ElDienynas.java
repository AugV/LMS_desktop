package main;

import database.DatabaseManager;
import database.DatabaseManagerImpl;
import entities.University;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import teacher_screen.ParentController;

public class ElDienynas extends Application {
    private University university;
    public DatabaseManager dataBaseManager = new DatabaseManagerImpl();

    public void init() {
        university = (University) dataBaseManager.getFromDatabase(university);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ParentController parentController = new ParentController(university, primaryStage);
        primaryStage.setScene(new Scene(parentController));
        primaryStage.show();
    }

    public void stop() {
       dataBaseManager.mergeToDatabase(university);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
