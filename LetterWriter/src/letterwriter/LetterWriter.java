package letterwriter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Villan
 */
public class LetterWriter extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/letterwriter/mainview/mainview.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setResizable(false);
        stage.getIcons().setAll(new Image(getClass().getResourceAsStream("/letterwriter/resources/logo.png")));
        stage.setScene(scene);
        stage.setTitle("Genuine Coder");
        stage.setOnCloseRequest(request->System.exit(0));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
