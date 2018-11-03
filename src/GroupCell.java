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
            }
        });

        MenuItem addStudent = new MenuItem();
        addStudent.textProperty().bind(Bindings.format("add Student"));
        addStudent.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //university.removeGroup(cell.getItem());
                //superControler.updateGroupListView();
            }
        });

        MenuItem selectGroup = new MenuItem();
        selectGroup.textProperty().bind(Bindings.format("select"));
        selectGroup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                university.setSelectedGroup(cell.getItem());
                superControler.updateStudentListView();
            }
        });

        contextMenu.getItems().addAll(deletionItem, addStudent, selectGroup);
    }

    @Override
    protected void cellUpdateMethodOverride() {
        //super.cellUpdateMethodOverride();
        cell = new ListCell<Group>() {
            @Override
            protected void updateItem(Group item, boolean empty) {
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
