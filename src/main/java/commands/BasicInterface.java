package commands;

import entities.*;
import input.InputFile;
import input.InputKeyboard;
import output.Printer;
import output.PrinterFile;

public class BasicInterface {

    private static Printer printer = new Printer();
    private static InputKeyboard inputKeyboard = new InputKeyboard();

    private University university;
    boolean exit;
    boolean back;

    public BasicInterface(University university) {
        this.university = university;
    }

    public void frontPageInteraction() {
        exit = false;
        while (!exit) {
            printer.printFrontPage();
            switch (inputKeyboard.getUserInputchar()) {
                case '1':
                    teacherPageInteraction();
                    break;
                case '2':
                    studentPageInteraction();
                    break;
                case '3':
                    coursePageInteraction();
                    break;
                case '4':
                    taskPageInteraction();
                    break;
                case '5':
                    completedTaskPageInteraction();
                    break;
                default:
                    exit = true;
                    printer.printExitMessage();
            }

        }

    }

    private void teacherPageInteraction() {

        back = false;
        while (!back) {
            printer.printTeacherPage();
            switch (inputKeyboard.getUserInputchar()) {
                case '1':
                    printer.printObjectArray(university.getTeacherList());
                    inputKeyboard.pressEnterToContinue();
                    break;
                case '2':
                    printer.printEnterFileName();
                    //university.addTeacher(new InputFile(inputKeyboard.getUserInputLine()).getTeacherFromFile());
                    printer.printDataAdded();
                    inputKeyboard.pressEnterToContinue();
                    break;
                case '3':
                    printer.printTeacherConstructorGuide();
                    university.addTeacher(inputKeyboard.getUserInputLine(), inputKeyboard.getUserInputLine());
                    printer.printDataAdded();
                    inputKeyboard.pressEnterToContinue();
                    break;
                case '4':
                    university.removeTeacher();
                    printer.printDataRemoved();
                    inputKeyboard.pressEnterToContinue();
                    break;
                case '5':
                    printer.printEnterFileName();
                    new PrinterFile(inputKeyboard.getUserInputLine()).printObjectArrayToFile(university.getTeacherList());
                    printer.printDataAddedToFile();
                    printer.printEnterFileName();
                    break;
                default:
                    back = true;
                    break;
            }
        }
    }

    private void studentPageInteraction() {
        back = false;
        while (!back) {
            printer.printStudentPage();
            switch (inputKeyboard.getUserInputchar()) {
                case '1':
                    printer.printObjectArray(university.getGroupList());
                    inputKeyboard.pressEnterToContinue();
                    break;
                case '2':
                    try{
                        printer.printObjectArray(university.getGroupByID(inputKeyboard.getUserInputGroupInt()).getGroupStudents());}
                    catch (NullPointerException e){
                        System.out.println(" !entities.Group with this ID does not exist!");
                    }
                    inputKeyboard.pressEnterToContinue();
                    break;
                case '3':
                    printer.printGroupConstructorGuide();
                    university.addGroup(new Group(inputKeyboard.getUserInputInt(), inputKeyboard.getUserInputLine()));
                    printer.printDataAdded();
                    inputKeyboard.pressEnterToContinue();
                    break;
                case '4':
                    printer.printStudentConstructorGuide();
                    Student newStudent = new Student(
                             inputKeyboard.getUserInputLine(), inputKeyboard.getUserInputLine());
                    try{university.getGroupByID(inputKeyboard.getUserInputGroupInt()).addGroupStudents(newStudent);}
                    catch(NullPointerException e){
                        System.out.println(" !entities.Group with this ID does not exist!");
                    }
                    //printer.printDataAdded();
                    inputKeyboard.pressEnterToContinue();
                    break;
                default:
                    back = true;
                    break;
            }
        }
    }

    private void coursePageInteraction() {

        back = false;
        while (!back) {
            printer.printCoursePage();
            switch (inputKeyboard.getUserInputchar()) {
                case '1':
                    printer.printObjectArray(university.getCourseList());
                    inputKeyboard.pressEnterToContinue();
                    break;
                case '2':
                    try{printer.printSingleString(university.getCourseByID(inputKeyboard.getUserInputCourseInt()).getCourseInformation());}
                    catch(NullPointerException e){
                        System.out.println(" !entities.Course with this ID does not exist!");
                    }
                    inputKeyboard.pressEnterToContinue();
                    break;
                case '3':
                    printer.printCourseConstructorGuide();
                    Course course = new Course(inputKeyboard.getUserInputInt(), inputKeyboard.getUserInputLine(), inputKeyboard.getUserInputLine());
                    try {
                        university.getTeacherByID(inputKeyboard.getUserInputTeacherInt()).addTeacherCourses(course);
                    }catch (NullPointerException e) {
                        System.out.println(" !entities.Teacher with this ID does not exist!");
                    }
                    try{
                        university.getGroupByID(inputKeyboard.getUserInputGroupInt()).addGroupCourse(course);
                    }catch (NullPointerException e) {
                        System.out.println(" !entities.Group with this ID does not exist!");
                    }
                    university.addCourse(course);
                    printer.printDataAdded();
                    inputKeyboard.pressEnterToContinue();
                    break;
                case '4':
                        courseEditPageInteraction(university.getCourseByID(inputKeyboard.getUserInputTaskInt()));
                    break;
                default:
                    back = true;
                    break;
            }
        }
    }

    private void taskPageInteraction(){
        back = false;
        Course selectedCourse = null;
        while (!back) {
            printer.printTaskPage();
            switch (inputKeyboard.getUserInputchar()) {
                case '1':
                    selectedCourse = university.getCourseByID(inputKeyboard.getUserInputCourseInt());
                    if(selectedCourse==null){
                        System.out.println(" !entities.Course with this ID does not exist!");
                    }
                    else{
                    printer.printCourseSelected();}
                    inputKeyboard.pressEnterToContinue();
                    break;
                case '2':
                    try {
                        printer.printObjectArray(selectedCourse.getCourseTasks());
                    }
                    catch(NullPointerException e){
                        System.out.println(" !No entities.Course selected!");
                    }
                    inputKeyboard.pressEnterToContinue();
                    break;
                case '3':
                    if (selectedCourse == null) {
                        System.out.println( "!No entities.Course selected!");
                    }else{
                    printer.printTaskConstructorGuide();
                    Task newTask = new Task(inputKeyboard.getUserInputInt(),
                            inputKeyboard.getUserInputLine(),
                            inputKeyboard.getUserInputLine(),
                            inputKeyboard.getUserInputLine(),
                            inputKeyboard.getUserInputLine());
                    selectedCourse.addCourseTask(newTask);
                    printer.printDataAdded();}
                    inputKeyboard.pressEnterToContinue();
                    break;
                case '4':

                    try{
                        selectedCourse.getCourseTaskByID(inputKeyboard.getUserInputTaskInt()).setAllowSubmitCompletedTask(false);
                    }
                    catch(NullPointerException e){
                        System.out.println(" !No entities.Course selected Or bad entities.Task ID!");
                    }
                    break;
                case '5':
                    try{
                        printer.printObjectArray(selectedCourse.getCourseTaskByID(inputKeyboard.getUserInputTaskInt()).getTaskCompletedTasks());
                    }catch(NullPointerException e){
                        System.out.println(" !No entities.Course selected Or bad entities.Task ID!");
                    }
                    inputKeyboard.pressEnterToContinue();
                    break;
                case '6':
                    try{
                        printer.printSingleString(selectedCourse.getCourseTaskByID(inputKeyboard.getUserInputTaskInt())
                                .getCompletedTaskById(inputKeyboard.getUserInputComplTaskInt()).getAnswer());
                    }catch(NullPointerException e){
                        System.out.println(" !No entities.Course selected Or bad entities.Task ID!");
                    }
                    inputKeyboard.pressEnterToContinue();
                    break;
                case '7':
                    try{
                        selectedCourse.getCourseTaskByID(inputKeyboard.getUserInputTaskInt()).getCompletedTaskById(inputKeyboard.getUserInputComplTaskInt())
                                .setGrade(inputKeyboard.getUserInputGrade());
                    }catch(NullPointerException e){
                        System.out.println(" !No entities.Course selected Or bad Completed entities.Task ID!");
                    }
                    //printer.printDataAdded();
                    inputKeyboard.pressEnterToContinue();
                    break;
                default:
                    back = true;
                    break;
            }
        }
    }

    private void completedTaskPageInteraction() {
        back = false;
        while (!back) {
            printer.printCompletedTaskPage();
            switch (inputKeyboard.getUserInputchar()) {
                case '1':
                    try{
                        for (Course course : university.getGroupByID(inputKeyboard.getUserInputGroupInt()).getGroupCourses()) {
                            printer.printObjectArray(course.getCourseTasks());
                        }
                    }catch(NullPointerException e){
                        System.out.println(" !entities.Group with this ID does not exist!");
                    }
                    inputKeyboard.pressEnterToContinue();
                    break;
                case '2':
                    printer.printCompletedTaskConstructorGuide();
                    CompletedTask newCompletedTask = new CompletedTask(

                            inputKeyboard.getUserInputLine());
                    int taskId= inputKeyboard.getUserInputTaskInt();

                    for (Course course : university.getCourseList()) {
                        course.addCompletedTaskToCourseTaskById(taskId, newCompletedTask);
                    }
                    printer.printDataAdded();
                    inputKeyboard.pressEnterToContinue();
                    break;
                case '3':
                    int taskSelection = inputKeyboard.getUserInputComplTaskInt();
                    CompletedTask completedTask = null;
                    for (Course course :university.getCourseList()) {
                        completedTask = course.getCompletedTaskById(taskSelection);
                        if (completedTask!=null){break;}
                        }
                        try {
                            printer.printSingleString(completedTask.getGrade());
                        } catch(NullPointerException e){
                            System.out.println(" !Complete task with this ID does not exist!");
                        }
                        inputKeyboard.pressEnterToContinue();
                    break;
                default:
                    back = true;
                    break;
            }
        }
    }

    private void courseEditPageInteraction(Course course) {
        back = false;
        while (!back) {
            printer.printCourseEditPage();
            switch (inputKeyboard.getUserInputchar()) {
                case '1':
                    try{
                        university.getTeacherByID(inputKeyboard.getUserInputTeacherInt()).addTeacherCourses(course);
                    }catch (NullPointerException e){
                        System.out.println("Wrong entities.Course or entities.Teacher ID");
                    }
                    printer.printDataAdded();
                    break;
                case '2':
                    try{
                        university.getGroupByID(inputKeyboard.getUserInputGroupInt()).addGroupCourse(course);
                    }catch(NullPointerException e){
                        System.out.println("Wrong entities.Course or entities.Group ID");
                    }
                    printer.printDataAdded();
                    break;
                default:
                    back = true;
                    break;
            }
        }
    }
}
