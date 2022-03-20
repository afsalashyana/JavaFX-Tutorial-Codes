package javafxcontrollercommunication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Genuine Coder
 * www.genuinecoder.com 
 */
public class JavaFXControllerCommunication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/javafxcontrollercommunication/scene1/scene1.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("First Window");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
