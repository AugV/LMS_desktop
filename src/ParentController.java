import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import java.io.IOException;

public class ParentController extends TabPane {
    private University university;
    private String addTeacherFXML = "TeacherAddWindow.fxml";
    private String saveTeacherFXML = "saveTeacherWindow.fxml";
    private String addCourseFXML = "courseAddWindow.fxml";

    @FXML
    private Button btAddTeacher;
    @FXML
    private Button btSave;
    @FXML
    private ListView teacherListView;

    @FXML
    private ListView courseListView;
    @FXML
    private Button btAddCourse;


    public ParentController(University university) {
        this.university = university;
        setUpTheLoader();
    }

    @FXML
    private void initialize() {
        teacherListView.getItems().addAll(university.getTeacherList());
        teacherListView.setCellFactory(lv -> {
            TeacherCell cell = new TeacherCell(teacherListView, this, university);
            cell.makeDeleteOption();
            return cell.getCell();
        });
        btAddTeacher.setOnAction(event -> { createTeacherAddWindowController();}
        );
        btSave.setOnAction(event -> {createTeacherSaveWindowController();});

        courseListView.getItems().addAll(university.getCourseList());
//        courseListView.setCellFactory(lv -> {
//            CustomCell cell = new CustomCell(teacherListView, this, university);
//            cell.makeDeleteOption();
//            return cell.getCell();
//        });
        btAddCourse.setOnAction(event -> createCourseAddWindowController());
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

    private void createCourseAddWindowController() {
        new AddCourseController(university,this, addCourseFXML);
    }
    private void createTeacherSaveWindowController() {
            new SaveTeachersController(university, this, saveTeacherFXML);
    }

    private void createTeacherAddWindowController() {
     new AddTeacherControler(university, this, addTeacherFXML);

    }

    public void updateTeacherListView() {
        teacherListView.setItems(new Utility().objectListToObservableList(university.getTeacherList()));
        System.out.println("TeacherList updated");
    }

    public void updateCourseListView() {
        teacherListView.setItems(new Utility().objectListToObservableList(university.getCourseList()));
        System.out.println("CourseList updated");
    }

}
