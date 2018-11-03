import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

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
