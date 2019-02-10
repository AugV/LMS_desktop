package course_screen;

import common.CustomCell;
import entities.StudentsGroupNull;
import teacher_screen.ParentController;
import entities.Course;
import entities.University;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import utilities.Toast;

public class CourseCell extends CustomCell {
    public CourseCell(ListView listView, ParentController superControler, University university) {
        super(listView, superControler, university);
    }

    public void createSelections() {
        MenuItem deletionItem = new MenuItem();
        deletionItem.textProperty().bind(Bindings.format("Delete"));
        deletionItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                university.removeCourse(cell.getItem());
                superControler.updateCourseListView();
                Toast.makeText(superControler.primaryStage, "Course removed", 800,200,600);
            }
        });

        MenuItem addTask = new MenuItem();
        addTask.textProperty().bind(Bindings.format("Add Task"));
        addTask.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                superControler.createTaskAddWindowController(cell.getItem());
            }
        });

        MenuItem infoItem = new MenuItem();
        infoItem.textProperty().bind(Bindings.format("get information"));
        infoItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                final Stage dialog = new Stage();
                dialog.initModality(Modality.APPLICATION_MODAL);
                VBox dialogVbox = new VBox(20);
                Course course= (Course)cell.getItem();
                dialogVbox.getChildren().add(new Text(course.getCourseInformation()));
                Scene dialogScene = new Scene(dialogVbox, 300, 200);
                dialog.setScene(dialogScene);
                dialog.show();
            }
        });

        MenuItem selectGroup = new MenuItem();
        selectGroup.textProperty().bind(Bindings.format("select"));
        selectGroup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                university.setSelectedCourse(cell.getItem());
                superControler.updateTaskListView();
                Toast.makeText(superControler.primaryStage, "Course selected", 700,200,400);

            }
        });
        contextMenu.getItems().addAll(addTask, deletionItem, infoItem, selectGroup);
    }

    @Override
    protected void cellUpdateMethodOverride() {
        //super.cellUpdateMethodOverride();
        cell = new ListCell<Course>() {
            @Override
            protected void updateItem(Course item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    text.setText(null);
                } else {
                    text.setText(item.getId() + ". " + item.getName());
                }
            }
        };
    }
}
