package javafxcontrollercommunication.scene2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 *
 * @author Genuine Coder
 */
public class Scene2Controller implements Initializable {

    @FXML
    private TextField display;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void transferMessage(String message) {
        display.setText(message);
    }
}
