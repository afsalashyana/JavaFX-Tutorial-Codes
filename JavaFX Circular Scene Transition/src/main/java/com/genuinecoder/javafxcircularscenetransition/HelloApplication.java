package com.genuinecoder.javafxcircularscenetransition;

import java.util.Objects;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("scene1/scene1.fxml"));
    Scene scene = new Scene(fxmlLoader.load(), 800, 800);
    stage.getIcons().add(new Image(Objects.requireNonNull(HelloApplication.class.getResourceAsStream("/logo.png"))));
    stage.setTitle("Genuine Coder - Circular Transition");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    System.setProperty("prism.lcdtext", "false");
    launch();
  }
}