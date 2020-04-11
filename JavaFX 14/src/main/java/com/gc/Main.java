package com.gc;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        String javaVersion = System.getProperty("java.version");
        String javaFxVersion = System.getProperty("javafx.version");
        String labelValue = String.format("Hello, JavaFX %s is running on top of Java %s", javaFxVersion, javaVersion);

        Scene scene = new Scene(new StackPane(new Label(labelValue)), 640, 480);
        stage.setScene(scene);
        stage.show();
    }
}
