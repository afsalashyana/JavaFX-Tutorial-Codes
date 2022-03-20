package custombuttons;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point3D;
import javafx.scene.shape.Arc;
import javafx.util.Duration;

/**
 * FXML Controller class
 * @author Villan
 */
public class FXMLController implements Initializable {

    @FXML
    private Arc arc1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        RotateTransition transition = new RotateTransition(Duration.seconds(5), arc1);
        transition.setAxis(new Point3D(50, 50, 0));
        transition.setByAngle(200);
        transition.play();
    }    
    
}
