package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class JavaFXMenuExample extends Application {
    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Choose an option from the menu.");
        MenuItem itemNew = new MenuItem("New");
        MenuItem itemOpen = new MenuItem("Open");
        Menu fileMenu = new Menu("File");
        fileMenu.getItems().addAll(itemNew,new SeparatorMenuItem(),itemOpen);
        Menu editMenu = new Menu("Edit");
        MenuItem itemCopy = new MenuItem("Copy");
        MenuItem itemPaste = new MenuItem("Paste");
        editMenu.getItems().addAll(itemCopy, itemPaste);
        Menu helpMenu = new Menu("Help");
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);
        BorderPane root = new BorderPane();
        root.setTop(menuBar);  
        root.setCenter(label); 
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Prabesh 26197");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

