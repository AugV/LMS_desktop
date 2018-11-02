import javafx.beans.binding.Bindings;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class Cell {
    private ListView listView;
    private ListCell<Teacher> cell;
    private ContextMenu contextMenu;
    private MenuItem item;
    private Text text;

    public Cell(ListView listView) {
        this.listView = listView;
        cell = new ListCell<>();
        contextMenu = new ContextMenu();
        item = new MenuItem();
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
        text = new Text();
        cell.setGraphic(text);
        bindToCell();
    }

    public void bindToCell() {

        text.textProperty().bind(Bindings.createStringBinding(() -> {
            if (cell.isEmpty()) {
              return null;
             } else {
           return cell.getItem().toString();
             }
        }, cell.emptyProperty(), cell.itemProperty()));

    }

    public void makeOptionDeleteFrom() {
        item.textProperty().bind(Bindings.format("Delete"));
        item.setOnAction(event -> listView.getItems().remove(cell.getItem()));
        contextMenu.getItems().addAll(item);
    }

    public ListCell<Teacher> getCell() {
        return cell;
    }
}
