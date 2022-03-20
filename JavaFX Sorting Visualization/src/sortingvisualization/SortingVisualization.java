package sortingvisualization;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 *
 * @author Villan
 */
public class SortingVisualization extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent parent = FXMLLoader.load(SortingVisualization.class.getResource("/sortingvisualization/ui/graphview.fxml"));

        Scene scene = new Scene(parent);
        primaryStage.setTitle("Sorting Visualization");
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.getIcons().add(new Image(SortingVisualization.class.getResourceAsStream("/sortingvisualization/assets/genuine_coder_logo.png")));

        primaryStage.addEventFilter(KeyEvent.KEY_RELEASED, (KeyEvent event) -> {
            if (event.getCode() == KeyCode.F12) {
                boolean newValue = !primaryStage.isFullScreen();
                primaryStage.setAlwaysOnTop(newValue);
                primaryStage.setFullScreenExitKeyCombination(new KeyCodeCombination(KeyCode.E));
                primaryStage.setFullScreen(newValue);
            }
        });
        primaryStage.setOnCloseRequest((event) -> {
            System.exit(0);
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
