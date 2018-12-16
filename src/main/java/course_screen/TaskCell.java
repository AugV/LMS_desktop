package course_screen;

import common.CustomCell;
import entities.Task;
import teacher_screen.ParentController;
import entities.University;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;

public class TaskCell extends CustomCell {

    public TaskCell(ListView listView, ParentController superControler, University university) {
        super(listView, superControler, university);
    }

    public void createSelections() {
        MenuItem deletionItem = new MenuItem();
        deletionItem.textProperty().bind(Bindings.format("Delete"));
        deletionItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                university.getSelectedCourse().getCourseTasks().remove(cell.getItem());
                superControler.updateTaskListView();
            }
        });

        contextMenu.getItems().addAll(deletionItem);
    }

    @Override
    protected void cellUpdateMethodOverride() {

        cell = new ListCell<Task>() {
            @Override
            protected void updateItem(Task item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    text.setText(null);
                } else {
                    text.setText(item.getId() + ". " + item.getName() + " ");
                }
            }
        };
    }
}
