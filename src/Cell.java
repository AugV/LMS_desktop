import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class Cell {
    private ListView listView;
    private ListCell<Teacher> cell;
    private ContextMenu contextMenu;
    private MenuItem item;
    private Text text;
    private ControlerTeachersWindow superControler;
    University university;

    public Cell(ListView listView, ControlerTeachersWindow superControler, University university) {
        this.superControler = superControler;
        this.university = university;
        this.listView = listView;
        cellUpdateMethodOverride();
        contextMenu = new ContextMenu();
        item = new MenuItem();
        text = new Text();
        setTextToCell();
        setContextMenuToCell();
    }

    public void setContextMenuToCell() {
        cell.emptyProperty().addListener((obs, wasEmpty, isNowEmpty) -> {
            if (isNowEmpty) {
                cell.setContextMenu(contextMenu);
            } else {
                cell.setContextMenu(contextMenu);
            }
        });
    }

    public void setTextToCell() {
        cell.setGraphic(text);
        //bindToCell();
    }

    private void cellUpdateMethodOverride() {
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

    public void makeOptionDeleteFrom() {
        item.textProperty().bind(Bindings.format("Delete"));
        item.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                university.removeTeacher(cell.getItem());
                superControler.updateListView();
            }
        });
        contextMenu.getItems().addAll(item);
    }

    public ListCell<Teacher> getCell() {
        return cell;
    }
}
