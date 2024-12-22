package application;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.geometry.*;
import javafx.scene.layout.*;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        // 1. HBox Layout
        HBox hbox = new HBox(10); // Horizontal layout with spacing
        hbox.setPadding(new Insets(10));
        hbox.setStyle("-fx-border-color: black; -fx-background-color: lightblue;");
        hbox.getChildren().addAll(new Button("Button 1"), new Button("Button 2"), new Button("Button 3"));

        // 2. VBox Layout
        VBox vbox = new VBox(10); // Vertical layout with spacing
        vbox.setPadding(new Insets(10));
        vbox.setStyle("-fx-border-color: black; -fx-background-color: lightgreen;");
        vbox.getChildren().addAll(new Button("Button A"), new Button("Button B"), new Button("Button C"));

        // 3. BorderPane Layout
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10));
        borderPane.setStyle("-fx-border-color: black; -fx-background-color: lightyellow;");
        borderPane.setTop(new Button("Top"));
        borderPane.setBottom(new Button("Bottom"));
        borderPane.setLeft(new Button("Left"));
        borderPane.setRight(new Button("Right"));
        borderPane.setCenter(new Button("Center"));

        // 4. GridPane Layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setStyle("-fx-border-color: black; -fx-background-color: lightpink;");
        gridPane.add(new Button("R0C0"), 0, 0); // Row 0, Column 0
        gridPane.add(new Button("R0C1"), 1, 0); // Row 0, Column 1
        gridPane.add(new Button("R1C0"), 0, 1); // Row 1, Column 0
        gridPane.add(new Button("R1C1"), 1, 1); // Row 1, Column 1

        // 5. StackPane Layout
        StackPane stackPane = new StackPane();
        stackPane.setPadding(new Insets(10));
        stackPane.setStyle("-fx-border-color: black; -fx-background-color: lightcoral;");
        stackPane.getChildren().addAll(new Button("Bottom Layer"), new Button("Middle Layer"), new Button("Top Layer"));

        // 6. FlowPane Layout
        FlowPane flowPane = new FlowPane();
        flowPane.setPadding(new Insets(10));
        flowPane.setHgap(10);
        flowPane.setVgap(10);
        flowPane.setStyle("-fx-border-color: black; -fx-background-color: lightgray;");
        flowPane.getChildren().addAll(
                new Button("Button 1"), new Button("Button 2"), new Button("Button 3"),
                new Button("Button 4"), new Button("Button 5")
        );

        // Create a main VBox to showcase all layouts
        VBox mainLayout = new VBox(20);
        mainLayout.setPadding(new Insets(10));
        mainLayout.getChildren().addAll(hbox, vbox, borderPane, gridPane, stackPane, flowPane);

        // Create a Scene and set it on the Stage
        Scene scene = new Scene(mainLayout, 600, 800);
        primaryStage.setTitle("Prabesh 26197");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
