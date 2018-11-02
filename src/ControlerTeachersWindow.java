
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.io.IOException;


public class ControlerTeachersWindow extends TabPane {
    University university;

    @FXML
    private Button btAddTeacher;
    @FXML
    private Button btSave;
    @FXML
    private ListView teacherListView;


    public ControlerTeachersWindow(University university) {
        this.university = university;
        setUpTheLoader();
    }


    @FXML
    private void initialize() {
        teacherListView.getItems().addAll(university.getTeacherList());

        teacherListView.setCellFactory(lv -> {
//            Cell cell = new Cell((ListView) lv);
//            cell.makeOptionDeleteFrom();
//            return cell.getCell();

            /*ListCell<Teacher> cell = new ListCell<>();
            Text text = new Text();
            cell.setGraphic(text);
            text.setTextAlignment(TextAlignment.CENTER);
            text.setStyle("-fx-fill: -fx-text-background-color;");
            text.setFontSmoothingType(FontSmoothingType.LCD);
            text.textProperty().bind(Bindings.createStringBinding(() -> {
                if (cell.isEmpty()) {
                    return null ;
                } else {
                    return cell.getItem().toString();
                }
            }, cell.emptyProperty(), cell.itemProperty()));
            return cell;*/

            ListCell<Teacher> cell = new ListCell<Teacher>() {
                private Text text = new Text();
                {
                    this.setGraphic(text);
                    text.setTextAlignment(TextAlignment.CENTER);
                    text.setStyle("-fx-fill: -fx-text-background-color;");
                    text.setFontSmoothingType(FontSmoothingType.LCD);

                    //this.textProperty().bind(Bindings.format("Delete"));
                    //this.textProperty().bind(Bindings.format("Delete"));
                    //TODO https://stackoverflow.com/questions/46671643/javafx-tableview-displays-null-values

                    ContextMenu contextMenu = new ContextMenu();
                    MenuItem item = new MenuItem();
                    item.textProperty().bind(Bindings.format("Delete"));
                    contextMenu.getItems().addAll(item);


                    this.emptyProperty().addListener((obs, wasEmpty, isNowEmpty) -> {
                        if (isNowEmpty) {
                            this.setContextMenu(contextMenu);
                        } else {
                            this.setContextMenu(contextMenu);
                        }
                    });
                }

                @Override
                protected void updateItem(Teacher item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        text.setText(null);
                    } else {
                        text.setText(item.getId() + ". " +item.getName() + " "+ item.getSurname());
                    }
                }

            };
            return cell;


        });

        btAddTeacher.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                createNewController();
            }
        });

//        btSave.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//
//            }
//        });
    }

    private void setUpTheLoader() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ApplicationInterface.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createNewController() {
        ControlerTeacherAdd addWindowController = new ControlerTeacherAdd(university, this);
    }

    public void updateListView() {
        teacherListView.setItems(new Utility().objectListToObservableList(university.getTeacherList()));
        System.out.println("TeacherList updated");
    }

}
