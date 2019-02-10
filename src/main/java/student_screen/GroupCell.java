package student_screen;

import common.CustomCell;
import entities.StudentsGroupNull;
import teacher_screen.ParentController;
import entities.StudentsGroup;
import entities.University;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import utilities.Toast;

public class GroupCell extends CustomCell {
    public GroupCell(ListView listView, ParentController superControler, University university) {
        super(listView, superControler, university);
    }

    public void createSelections() {
        MenuItem deletionItem = new MenuItem();
        deletionItem.textProperty().bind(Bindings.format("Delete"));
        deletionItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                university.removeGroup(cell.getItem());
                superControler.updateGroupListView();
                Toast.makeText(superControler.primaryStage, "StudentsGroup removed", 800,200,600);
            }
        });

        MenuItem addStudent = new MenuItem();
        addStudent.textProperty().bind(Bindings.format("Add Student"));
        addStudent.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                university.setSelectedStudentsGroup(cell.getItem());
                superControler.updateStudentListView();
                superControler.createStudentAddWindowController();
                university.setSelectedStudentsGroup(new StudentsGroupNull());
            }
        });

        MenuItem selectGroup = new MenuItem();
        selectGroup.textProperty().bind(Bindings.format("Select"));
        selectGroup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                university.setSelectedStudentsGroup(cell.getItem());
                superControler.updateStudentListView();
                Toast.makeText(superControler.primaryStage, "Group selected", 700,200,400);

            }
        });

        contextMenu.getItems().addAll(deletionItem, addStudent, selectGroup);
    }

    @Override
    protected void cellUpdateMethodOverride() {
        cell = new ListCell<StudentsGroup>() {
            @Override
            protected void updateItem(StudentsGroup item, boolean empty) {
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
