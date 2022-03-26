package com.genuinecoder.javafxtask;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class HelloController implements Initializable {

  private CounterTask counterTask;

  @FXML
  public TextField textFieldInput;
  @FXML
  public Label labelDisplay;
  @FXML
  public ProgressBar progressBar;

  @Override
  public void initialize(URL location, ResourceBundle resources) {

  }

  @FXML
  public void handleButtonStartAction(ActionEvent actionEvent) {
    invokeCounterTask();
  }

  private void invokeCounterTask() {
    String inputString = textFieldInput.getText();
    inputString = inputString.replaceAll(",", "");
    long input = Long.parseLong(inputString);

    if (counterTask != null && counterTask.isRunning()) {
      counterTask.cancel();
    }
    counterTask = new CounterTask(input);
    counterTask.valueProperty().addListener((observable, oldValue, newValue) -> labelDisplay.setText(String.valueOf(newValue)));
    progressBar.progressProperty().bind(counterTask.progressProperty());

    Thread th = new Thread(counterTask);
    th.setDaemon(true);
    th.start();
  }

  private void calculate() {
    String inputString = textFieldInput.getText();
    inputString = inputString.replaceAll(",", "");
    long input = Long.parseLong(inputString);
    long sum = 0;
    for (int i = 0; i < input; i++) {
      sum = sum + i;
      labelDisplay.setText(String.valueOf(sum));
    }
  }
}