package student_screen;

import common.CustomCell;
import teacher_screen.ParentController;
import entities.Student;
import entities.University;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;

public class StudentCell extends CustomCell {
    public StudentCell(ListView listView, ParentController superControler, University university) {
        super(listView, superControler, university);
    }

    public void createSelections() {
        MenuItem deletionItem = new MenuItem();
        deletionItem.textProperty().bind(Bindings.format("Delete"));
        deletionItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                university.getSelectedStudentsGroupImpl().getGroupStudents().remove(cell.getItem());
                superControler.updateStudentListView();
            }
        });

        contextMenu.getItems().addAll(deletionItem);
    }

    @Override
    protected void cellUpdateMethodOverride() {
        cell = new ListCell<Student>() {
            @Override
            protected void updateItem(Student item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    text.setText(null);
                } else {
                    text.setText(item.getId() + ". " + item.getName() + " " + item.getSurname());
                }
            }
        };
    }
}
