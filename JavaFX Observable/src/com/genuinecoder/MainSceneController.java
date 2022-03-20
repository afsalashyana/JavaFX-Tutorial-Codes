package com.genuinecoder;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * @author Genuine Coder
 */
public class MainSceneController implements Initializable {

    private final SimpleStringProperty stringProperty = new SimpleStringProperty("A");
    @FXML
    private Text textField;
    @FXML
    private TextField tf1;
    @FXML
    private TextField tf2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SimpleIntegerProperty a = new SimpleIntegerProperty(5);
        SimpleIntegerProperty b = new SimpleIntegerProperty(10);
        NumberBinding sum = a.add(b);
        System.out.println(sum.getValue());
        a.set(20);
        System.out.println(sum.getValue());

        textField.textProperty().bind(stringProperty);
        MyTask myTask = new MyTask();
        textField.setOnMouseClicked(event -> {
            Timer timer = new Timer(true);
            timer.scheduleAtFixedRate(myTask, 0, 1 * 1000);
        });

        tf1.textProperty().bindBidirectional(tf2.textProperty());
    }

    class MyTask extends TimerTask {

        @Override
        public void run() {
            int ch = stringProperty.get().charAt(0);
            ch++;
            stringProperty.set(String.valueOf((char) ch));
        }
    }

    private void sumNonObservable() {
        int a = 10;
        int b = 10;
        int sum = a + b;
        System.out.println(sum); //20
        a = 20;
        System.out.println(sum); //20
    }

    private void sumObservable() {
        SimpleIntegerProperty a = new SimpleIntegerProperty(10);
        SimpleIntegerProperty b = new SimpleIntegerProperty(10);
        NumberBinding sum = a.add(b);
        System.out.println(sum.getValue());
        a.set(20);
        System.out.println(sum.getValue());
    }
}
