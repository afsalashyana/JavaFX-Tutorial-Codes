package com.genuinecoder.javafxcircularscenetransition.scene1;

import com.genuinecoder.javafxcircularscenetransition.HelloApplication;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Scene1Controller {

  @FXML
  public StackPane rootContainer;
  @FXML
  public VBox contentContainer;

  public void loadScene2(ActionEvent actionEvent) {
    try {
      FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("scene2/scene2.fxml"));
      Pane pane = fxmlLoader.load();
      rootContainer.getChildren().add(pane);

      Circle circle = new Circle(50);
      pane.setShape(circle);
      circle.radiusProperty().addListener((observable, oldValue, newValue) -> {
        double size = newValue.doubleValue() * 2;
        pane.setMinSize(size, size);
        pane.setPrefSize(size, size);
        pane.setMaxSize(size, size);
      });

      Timeline timeline = new Timeline();
      KeyValue keyValue = new KeyValue(circle.radiusProperty(), 400, Interpolator.EASE_OUT);
      KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.5), keyValue);
      timeline.getKeyFrames().add(keyFrame);
      timeline.play();
      timeline.setOnFinished(event -> {
        rootContainer.getChildren().remove(contentContainer);
        pane.setShape(null);
      });

    } catch (Exception exp) {
      exp.printStackTrace();
    }
  }
}