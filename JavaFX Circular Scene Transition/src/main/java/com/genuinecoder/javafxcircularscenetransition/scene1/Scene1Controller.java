package com.genuinecoder.javafxcircularscenetransition.scene1;

import com.genuinecoder.javafxcircularscenetransition.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Scene1Controller {

  @FXML
  public StackPane rootContainer;
  @FXML
  public VBox contentContainer;

  public void loadScene2(ActionEvent actionEvent) {
    try {
      FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("scene2/scene2.fxml"));
      rootContainer.getScene().setRoot(fxmlLoader.load());
    } catch (Exception exp) {
      exp.printStackTrace();
    }
  }
}