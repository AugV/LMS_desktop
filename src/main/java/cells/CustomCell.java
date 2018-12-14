package cells;

import controllers.ParentController;
import entities.Teacher;
import entities.University;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class CustomCell {
    private ListView listView;
    protected ListCell cell;
    protected ContextMenu contextMenu;
    protected Text text;
    protected ParentController superControler;
    protected University university;

    public CustomCell(ListView listView, ParentController superControler, University university) {
        this.superControler = superControler;
        this.university = university;
        this.listView = listView;
        cellUpdateMethodOverride();
        contextMenu = new ContextMenu();
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
    }

    protected void cellUpdateMethodOverride() {
        cell = new ListCell<Teacher>() {
            @Override
            protected void updateItem(Teacher item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    text.setText(null);
                } else {
                    text.setText(String.valueOf(item.getId()));
                }
            }
        };
    }


    public ListCell<Teacher> getCell() {
        return cell;
    }
}
