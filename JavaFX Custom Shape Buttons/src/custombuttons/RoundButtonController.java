package custombuttons;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class RoundButtonController implements Initializable {

    @FXML
    private JFXButton btn1;
    @FXML
    private JFXButton btn2;
    @FXML
    private JFXButton btn3;
    @FXML
    private JFXButton btn4;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btn1.setText("Button 1");
        btn2.setText("Button 2");
        btn3.setText("Button 3");
        btn4.setText("Button 4");
    }

}
