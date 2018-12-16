package teacher_screen;

import common.CustomCell;
import entities.Teacher;
import entities.University;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import utilities.Toast;

public class TeacherCell extends CustomCell {


    public TeacherCell(ListView listView, ParentController superControler, University university) {
        super(listView, superControler, university);
    }

    public void makeDeleteOption() {
        MenuItem item = new MenuItem();
        item.textProperty().bind(Bindings.format("Delete"));
        item.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               university.removeTeacher(cell.getItem());
                superControler.updateTeacherListView();
                Toast.makeText(superControler.primaryStage, "entities.Teacher removed", 800,200,600);
            }
        });
        contextMenu.getItems().addAll(item);
    }

    @Override
    protected void cellUpdateMethodOverride() {
        //super.cellUpdateMethodOverride();
        cell = new ListCell<Teacher>() {
            @Override
            protected void updateItem(Teacher item, boolean empty) {
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
